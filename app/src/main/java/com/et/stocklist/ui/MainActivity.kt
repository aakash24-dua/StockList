package com.et.stocklist.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.et.stocklist.R
import com.et.stocklist.domain.entity.Searchresult
import com.et.stocklist.ui.fragment.SortOptionDialogFragment
import com.et.stocklist.utils.gone
import com.et.stocklist.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(),
    SearchView.OnQueryTextListener {

    private val viewmodel: MainViewmodel by viewModel()
    lateinit var recyclerViewAdapter: ContentListAdapter
    private var response: ArrayList<Searchresult> = ArrayList()
    private var selectedSort = Sort.CURRENT_HIGH

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.stock_list)
        recycler_view.layoutManager =
            LinearLayoutManager(this)
        progress_bar.visible()
        viewmodel.getStockList()

        sort.setOnClickListener {
            val dialog = SortOptionDialogFragment().newInstance(selectedSort)
            dialog.show(supportFragmentManager, "DIALOG")
        }
        filter.setOnClickListener {
            searchView.requestFocus()
            searchView.isIconified = false
        }

        viewmodel.publishObject.subscribe {
            progress_bar.gone()
            response = it
            //setAdapter(response)
            setSortOption(selectedSort)

        }

    }

    private lateinit var searchView : SearchView
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        searchView =
            menu?.findItem(R.id.action_search)?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return true
    }


    private fun clearSearch(){
        searchView.setQuery("",false)
        searchView.clearFocus()
        searchView.isIconified = true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
       if (::recyclerViewAdapter.isInitialized) recyclerViewAdapter.filter.filter(newText)
        return true
    }


    private fun setAdapter(response: ArrayList<Searchresult>) {
        progress_bar.gone()
        recycler_view.visible()
        recyclerViewAdapter =
            ContentListAdapter(response)
        recycler_view.adapter = recyclerViewAdapter
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun setSortOption(option: Sort) {
        selectedSort = option
        clearSearch()
        response = viewmodel.sortListBy(selectedSort,response)
        setAdapter(response)
    }

    override fun onBackPressed() {
        if (!searchView.isIconified) {
            searchView.isIconified = true
        } else {
            super.onBackPressed()
        }
    }

}

enum class Sort {
    CURRENT_HIGH, CURRENT_LOW, CHANGE_HIGH, CHANGE_LOW
}
