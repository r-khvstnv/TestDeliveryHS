package com.rkhvstnv.testdeliveryhs.domain.repository

import com.rkhvstnv.testdeliveryhs.data.models.GoodsCategory
import com.rkhvstnv.testdeliveryhs.data.models.GoodsDto
import com.rkhvstnv.testdeliveryhs.data.models.PromoBanner
import retrofit2.Response

interface Repository {
    fun getAllGoodsCategories(): List<GoodsCategory>
    suspend fun getGoodsByType(param: String): Response<GoodsDto>
    fun getPromoBanners(): List<PromoBanner>
}