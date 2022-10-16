package com.rkhvstnv.testdeliveryhs.data.source.remote

import com.rkhvstnv.testdeliveryhs.data.models.GoodsDto
import com.rkhvstnv.testdeliveryhs.data.utils.EndPoint
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularApi {
    /** NOTE: ApiKey is NOT available on Github*/
    @GET(EndPoint.COMPLEX_SEARCH)
    suspend fun getGoodsByType(
        @Query(EndPoint.API_KEY) apiKey: String,
        @Query(EndPoint.TYPE) type: String,
        @Query(EndPoint.FILL_INGREDIENTS) fillIngredients: Boolean,
        @Query(EndPoint.AMOUNT) amount: Int,
    ): Response<GoodsDto>
}