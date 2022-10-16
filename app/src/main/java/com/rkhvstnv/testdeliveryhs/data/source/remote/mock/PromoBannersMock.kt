package com.rkhvstnv.testdeliveryhs.data.source.remote.mock

import com.rkhvstnv.testdeliveryhs.R
import com.rkhvstnv.testdeliveryhs.data.models.PromoBanner


/** Mock data that is simulate PromoBanner source*/
object PromoBannersMock {
    fun getPromoBanners(): List<PromoBanner>{
        return listOf(
            PromoBanner(1, R.drawable.promo2),
            PromoBanner(2, R.drawable.promo2),
            PromoBanner(3, R.drawable.promo3),
            PromoBanner(4, R.drawable.promo4),
            PromoBanner(5, R.drawable.promo5),
        )
    }
}