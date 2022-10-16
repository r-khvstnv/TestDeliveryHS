package com.rkhvstnv.testdeliveryhs.domain.repository

import com.rkhvstnv.testdeliveryhs.data.models.GoodsCategory
import com.rkhvstnv.testdeliveryhs.data.models.GoodsDto
import com.rkhvstnv.testdeliveryhs.data.models.PromoBanner
import retrofit2.Response

interface Repository {
    /** Method provides all available categories
     *
     * Note: Simulation method with mock data*/
    fun getAllGoodsCategories(): List<GoodsCategory>

    /** Method provides all available promo banners
     *
     * Note: Simulation method with mock data*/
    fun getPromoBanners(): List<PromoBanner>

    /** Method provides goods by requested type*/
    suspend fun getGoodsByType(type: String): Response<GoodsDto>
}