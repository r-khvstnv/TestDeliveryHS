package com.rkhvstnv.testdeliveryhs.domain.models

import com.rkhvstnv.testdeliveryhs.data.models.GoodsCategory

data class GoodsCategoryParam(
    val id: Int,
    val name: String,
    /** State that helps to determine the active category*/
    var isChecked: Boolean = false
){
    companion object{

        /** Method transform [GoodsCategory] to [GoodsCategoryParam]*/
        fun fromGoodsCategory(goodsCategory: GoodsCategory): GoodsCategoryParam{
            return GoodsCategoryParam(
                id = goodsCategory.id,
                name = goodsCategory.name
            )
        }
    }
}