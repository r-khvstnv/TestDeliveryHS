package com.rkhvstnv.testdeliveryhs.domain.models

import com.rkhvstnv.testdeliveryhs.data.models.GoodsCategory

data class GoodsCategoryParam(
    val id: Int,
    val name: String,
    var isChecked: Boolean = false
){
    companion object{
        fun fromGoodsCategory(goodsCategory: GoodsCategory): GoodsCategoryParam{
            return GoodsCategoryParam(
                id = goodsCategory.id,
                name = goodsCategory.name
            )
        }
    }
}