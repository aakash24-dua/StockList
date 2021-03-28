package com.et.stocklist.ui

import android.graphics.Color
import android.os.Build
import android.text.SpannableString
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.et.stocklist.R
import com.et.stocklist.domain.entity.Searchresult


class ContentItemViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
    val low: TextView = root.findViewById(R.id.low)
    val high: TextView = root.findViewById(R.id.high)
    val stockName: TextView = root.findViewById(R.id.stock_name)
    val price: TextView = root.findViewById(R.id.price)
    val change: TextView = root.findViewById(R.id.change)
    val changeText: TextView = root.findViewById(R.id.change_txt)
    val seekBar: SeekBar = root.findViewById(R.id.seekbar)

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(response: Searchresult?) {
        low.text = response?.low
        high.text = response?.high
        stockName.text = response?.companyShortName
        price.text = response?.current
        if (response?.openPrice?.toDouble()!! > response?.current?.toDouble()!!){
            changeText.setCompoundDrawablesWithIntrinsicBounds(null,null,root.context.getDrawable(R.drawable.ic_down_arrow_16),null)
            change.text = response?.absolutechange.plus(" (-").plus(response?.percentagechange).plus("%)")
        }
        else{
            changeText.setCompoundDrawablesWithIntrinsicBounds(null,null,root.context.getDrawable(R.drawable.ic_up_arrow_16),null)
            change.text = response?.absolutechange.plus(" (+").plus(response?.percentagechange).plus("%)")
        }
        seekBar.isEnabled = false
        response?.high?.toDouble()?.times(100)
        seekBar.max = response?.high?.toDouble()?.times(100)?.toInt()?:0
        seekBar.min = response?.low?.toDouble()?.times(100)?.toInt()?:0
        seekBar.progress = response?.current?.toDouble()?.times(100)?.toInt()?:0

    }


}