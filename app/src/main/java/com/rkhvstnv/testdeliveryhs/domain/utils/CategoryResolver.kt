package com.rkhvstnv.testdeliveryhs.domain.utils

import com.rkhvstnv.testdeliveryhs.data.source.remote.mock.GoodsCategoryId
import com.rkhvstnv.testdeliveryhs.data.utils.EndPoint


object CategoryResolver {
    /** Based on Id of GoodsCategory, method will be returned corresponding Endpoint*/
    fun getEndPointById(id: Int): String{
        return when(id){
            GoodsCategoryId.MAIN_COURSE -> EndPoint.MAIN_COURSE
            GoodsCategoryId.DESSERT -> EndPoint.DESSERT
            GoodsCategoryId.SALAD -> EndPoint.SALAD
            GoodsCategoryId.BREAKFAST -> EndPoint.BREAKFAST
            GoodsCategoryId.SOUP -> EndPoint.SOUP
            GoodsCategoryId.SAUCE -> EndPoint.SAUCE
            GoodsCategoryId.DRINK -> EndPoint.DRINK
            else -> ""
        }
    }
}