package com.rkhvstnv.testdeliveryhs.domain.models

import com.rkhvstnv.testdeliveryhs.data.models.Result

data class GoodsParam(
    val id: Int,
    val preview: String,
    val title: String,
    /** At the current realization ingredients list is represented as a [String]*/
    val ingredients: String,
    val cost: Int
){
    companion object{

        /** Method transforms part of data from [GoodsDto] ([Result]) to [GoodsParam]
         *
         * Note: The main purpose of Spoonacular Api is providing recipes. For these reason,
         * [GoodsParam.cost] calculated randomly*/
        fun fromGoodsDto(result: Result): GoodsParam{
            var ingredients = ""
            for (item in result.missedIngredients){
                ingredients += "${item.name}, "
            }

            return GoodsParam(
                id = result.id,
                preview = result.image,
                title = result.title,
                ingredients = ingredients,
                cost = (50..1000).random()
            )
        }
    }
}