package com.rkhvstnv.testdeliveryhs.domain.models

sealed class GoodsParamState {
    data class Success(val goodsParamList: List<GoodsParam>): GoodsParamState()
    data class Error(val message: String): GoodsParamState()
}