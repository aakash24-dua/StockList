package com.et.stocklist.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.et.stocklist.R
import com.et.stocklist.domain.entity.Searchresult
import java.util.*
import kotlin.collections.ArrayList

class ContentListAdapter(private val data: ArrayList<Searchresult>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {
    var searchData: MutableList<Searchresult> = mutableListOf()
    init {
        searchData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ContentItemViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return searchData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ContentItemViewHolder) {
            (holder).bind(searchData[position])
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                val resultList = ArrayList<Searchresult>()
                for (row in data) {
                    row.companyShortName?.let {
                        if (it.toLowerCase(Locale.getDefault())
                                .contains(charSearch.toLowerCase(Locale.getDefault()))
                        ) {
                            resultList.add(row)
                        }
                    }
                }
                searchData = resultList
                val filterResults = FilterResults()
                filterResults.values = searchData
                return filterResults
            }
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                searchData = results?.values as MutableList<Searchresult>
                notifyDataSetChanged()
            }

        }
    }

}


