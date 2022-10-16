package com.rkhvstnv.testdeliveryhs.data.source.remote.mock


import com.rkhvstnv.testdeliveryhs.data.models.GoodsCategory

object GoodsCategoriesMock {
    val mainCourse = GoodsCategory(GoodsCategoryId.MAIN_COURSE,"Main Course")
    val dessert = GoodsCategory(GoodsCategoryId.DESSERT,"Dessert")
    val salad = GoodsCategory(GoodsCategoryId.SALAD,"Salad")
    val breakfast = GoodsCategory(GoodsCategoryId.BREAKFAST,"Breakfast")
    val soup = GoodsCategory(GoodsCategoryId.SOUP,"Soup")
    val sauce = GoodsCategory(GoodsCategoryId.SAUCE,"Sauce")
    val drink = GoodsCategory(GoodsCategoryId.DRINK,"Drink")

    fun getAllGoodsCategories(): List<GoodsCategory>{
        return listOf(mainCourse, dessert, salad, breakfast, soup, sauce, drink)
    }
}

object GoodsCategoryId{
    const val MAIN_COURSE = 101
    const val DESSERT = 103
    const val SALAD = 104
    const val BREAKFAST = 105
    const val SOUP = 106
    const val SAUCE = 107
    const val DRINK = 108
}