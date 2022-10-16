package com.rkhvstnv.testdeliveryhs.domain.usecases

import com.rkhvstnv.testdeliveryhs.domain.models.GoodsCategoryParam
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsParamState
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsParam
import com.rkhvstnv.testdeliveryhs.domain.repository.Repository
import com.rkhvstnv.testdeliveryhs.domain.utils.CategoryResolver
import javax.inject.Inject

class GetGoodsByTypeUseCase @Inject constructor(private val repository: Repository) {
    suspend fun execute(goodsCategoryParam: GoodsCategoryParam): GoodsParamState{
        val endpoint = CategoryResolver.getEndPointById(goodsCategoryParam.id)
        val response = repository.getGoodsByType(endpoint)
        return if (response.isSuccessful){
            val body = response.body()

            if (body != null){
                val goods = body.results.map { GoodsParam.fromGoodsDto(it) }
                GoodsParamState.Success(goodsParamList = goods)
            } else{
                GoodsParamState.Error(response.message())
            }
        } else{
            GoodsParamState.Error(response.message() + Char(32) + response.errorBody().toString())
        }
    }
}