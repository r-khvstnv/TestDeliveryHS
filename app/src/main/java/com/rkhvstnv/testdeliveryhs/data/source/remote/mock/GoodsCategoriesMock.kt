package com.rkhvstnv.testdeliveryhs.data.source.remote.mock

import com.rkhvstnv.testdeliveryhs.data.models.GoodsCategory

/** Mock data that is simulate GoodsCategory source*/
object GoodsCategoriesMock {
    private val mainCourse = GoodsCategory(GoodsCategoryId.MAIN_COURSE,"Курс I")
    private val dessert = GoodsCategory(GoodsCategoryId.DESSERT,"Дессерты")
    private val salad = GoodsCategory(GoodsCategoryId.SALAD,"Салаты")
    private val breakfast = GoodsCategory(GoodsCategoryId.BREAKFAST,"Завтраки")
    private val soup = GoodsCategory(GoodsCategoryId.SOUP,"Супы")
    private val sauce = GoodsCategory(GoodsCategoryId.SAUCE,"Соусы")
    private val drink = GoodsCategory(GoodsCategoryId.DRINK,"Напитки")

    fun getAllGoodsCategories(): List<GoodsCategory>{
        return listOf(mainCourse, dessert, salad, breakfast, soup, sauce, drink)
    }
}

/** Mock goods categories IDs
 *  Object helps to match goods category to the endpoint*/
object GoodsCategoryId{
    const val MAIN_COURSE = 101
    const val DESSERT = 103
    const val SALAD = 104
    const val BREAKFAST = 105
    const val SOUP = 106
    const val SAUCE = 107
    const val DRINK = 108
}