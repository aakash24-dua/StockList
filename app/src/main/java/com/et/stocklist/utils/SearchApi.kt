package com.et.stocklist.utils

import android.graphics.Movie
import com.et.stocklist.domain.entity.StockList
import retrofit2.http.GET

internal interface SearchApi {

    @GET("/ET_Community/Gain?pagesize=100")
     suspend fun getList(
    ): StockList


}
