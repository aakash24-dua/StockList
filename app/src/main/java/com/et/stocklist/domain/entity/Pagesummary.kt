package com.et.stocklist.domain.entity


import com.google.gson.annotations.SerializedName

data class Pagesummary(
    @SerializedName("exchange")
    val exchange: String? = "",
    @SerializedName("indexvalue")
    val indexvalue: String? = "",
    @SerializedName("lasttradeddate")
    val lasttradeddate: String? = "",
    @SerializedName("pageno")
    val pageno: Int? = 0,
    @SerializedName("pagesize")
    val pagesize: Int? = 0,
    @SerializedName("stattype")
    val stattype: String? = "",
    @SerializedName("tooltiptext")
    val tooltiptext: String? = "",
    @SerializedName("totalRecords")
    val totalRecords: Int? = 0,
    @SerializedName("totalpages")
    val totalpages: Int? = 0
)