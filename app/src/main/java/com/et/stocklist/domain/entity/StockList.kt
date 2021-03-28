package com.et.stocklist.domain.entity


import com.google.gson.annotations.SerializedName

data class StockList(
    @SerializedName("pagesummary")
    val pagesummary: Pagesummary? = Pagesummary(),
    @SerializedName("searchresult")
    val searchresult: List<Searchresult>? = listOf()
)