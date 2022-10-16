package com.rkhvstnv.testdeliveryhs.data.repository

import com.rkhvstnv.testdeliveryhs.Key
import com.rkhvstnv.testdeliveryhs.data.models.GoodsCategory
import com.rkhvstnv.testdeliveryhs.data.models.GoodsDto
import com.rkhvstnv.testdeliveryhs.data.models.PromoBanner
import com.rkhvstnv.testdeliveryhs.data.source.remote.SpoonacularApi
import com.rkhvstnv.testdeliveryhs.data.source.remote.mock.GoodsCategoriesMock
import com.rkhvstnv.testdeliveryhs.data.source.remote.mock.PromoBannersMock
import com.rkhvstnv.testdeliveryhs.data.utils.EndPoint
import com.rkhvstnv.testdeliveryhs.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val spoonacularApi: SpoonacularApi
): Repository {

    override fun getAllGoodsCategories(): List<GoodsCategory> = GoodsCategoriesMock.getAllGoodsCategories()

    override fun getPromoBanners(): List<PromoBanner> = PromoBannersMock.getPromoBanners()

    override suspend fun getGoodsByType(param: String): Response<GoodsDto> {
        return spoonacularApi.getGoodsByType(
            apiKey = Key.SPOONACULAR_API_KEY,
            type = param,
            fillIngredients = true,
            amount = 5,
        )
    }


}