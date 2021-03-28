package com.et.stocklist.domain.entity


import com.google.gson.annotations.SerializedName

data class Searchresult(
    @SerializedName("absChange")
    val absChange: String? = "",
    @SerializedName("absolutechange")
    val absolutechange: String? = "",
    @SerializedName("asiancercticker")
    val asiancercticker: String? = "",
    @SerializedName("bargraphvalue")
    val bargraphvalue: String? = "",
    @SerializedName("bestBuyPrice")
    val bestBuyPrice: String? = "",
    @SerializedName("bestBuyQty")
    val bestBuyQty: Int? = 0,
    @SerializedName("bestSellPrice")
    val bestSellPrice: String? = "",
    @SerializedName("bestSellQty")
    val bestSellQty: Int? = 0,
    @SerializedName("compIdForValidation")
    val compIdForValidation: String? = "",
    @SerializedName("companyName2")
    val companyName2: String? = "",
    @SerializedName("companyShortName")
    val companyShortName: String? = "",
    @SerializedName("companyid")
    val companyid: String? = "",
    @SerializedName("companyname")
    val companyname: String? = "",
    @SerializedName("companytype")
    val companytype: String? = "",
    @SerializedName("comparedPrice")
    val comparedPrice: String? = "",
    @SerializedName("comparedPriceDate")
    val comparedPriceDate: String? = "",
    @SerializedName("current")
    val current: String? = "",
    @SerializedName("eventCount")
    val eventCount: Int? = 0,
    @SerializedName("exchangeID")
    val exchangeID: String? = "",
    @SerializedName("fiftyTwoWeekHighPrice")
    val fiftyTwoWeekHighPrice: String? = "",
    @SerializedName("fiftyTwoWeekLowPrice")
    val fiftyTwoWeekLowPrice: String? = "",
    @SerializedName("high")
    val high: String? = "",
    @SerializedName("listingExchange")
    val listingExchange: String? = "",
    @SerializedName("low")
    val low: String? = "",
    @SerializedName("marketCap")
    val marketCap: String? = "",
    @SerializedName("nsescripcode")
    val nsescripcode: String? = "",
    @SerializedName("openPrice")
    val openPrice: String? = "",
    @SerializedName("percentChange")
    val percentChange: String? = "",
    @SerializedName("percentagechange")
    val percentagechange: String? = "",
    @SerializedName("prevFiftyTwoWeekHighDateTime")
    val prevFiftyTwoWeekHighDateTime: String? = "",
    @SerializedName("prevFiftyTwoWeekHighPrice")
    val prevFiftyTwoWeekHighPrice: String? = "",
    @SerializedName("prevFiftyTwoWeekLowDateTime")
    val prevFiftyTwoWeekLowDateTime: String? = "",
    @SerializedName("prevFiftyTwoWeekLowPrice")
    val prevFiftyTwoWeekLowPrice: String? = "",
    @SerializedName("previousclose")
    val previousclose: String? = "",
    @SerializedName("scripCode")
    val scripCode: String? = "",
    @SerializedName("sectorId")
    val sectorId: String? = "",
    @SerializedName("sectorName")
    val sectorName: String? = "",
    @SerializedName("segment")
    val segment: String? = "",
    @SerializedName("seoname")
    val seoname: String? = "",
    @SerializedName("sparklineURL")
    val sparklineURL: String? = "",
    @SerializedName("ticker")
    val ticker: String? = "",
    @SerializedName("updateddatetime")
    val updateddatetime: String? = "",
    @SerializedName("value")
    val value: String? = "",
    @SerializedName("volume")
    val volume: Int? = 0,
    @SerializedName("volumeInThousand")
    val volumeInThousand: String? = ""
)