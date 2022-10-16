package com.rkhvstnv.testdeliveryhs.data.models

/** Data Access Object for Spoonacular Api*/
data class GoodsDto(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)

data class Result(
    val id: Int,
    val image: String,
    val imageType: String,
    val likes: Int,
    val missedIngredientCount: Int,
    val missedIngredients: List<MissedIngredient>,
    val title: String,
    val unusedIngredients: List<Any>,
    val usedIngredientCount: Int,
    val usedIngredients: List<Any>
)

data class MissedIngredient(
    val aisle: String,
    val amount: Double,
    val extendedName: String,
    val id: Int,
    val image: String,
    val meta: List<String>,
    val name: String,
    val original: String,
    val originalName: String,
    val unit: String,
    val unitLong: String,
    val unitShort: String
)