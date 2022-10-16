package com.rkhvstnv.testdeliveryhs.domain.models

import androidx.annotation.DrawableRes
import com.rkhvstnv.testdeliveryhs.data.models.PromoBanner

data class PromoBannerParam(
    @DrawableRes
    val drawable: Int
){
    companion object{

        /** Method transform [PromoBanner] to [PromoBannerParam]*/
        fun fromPromoBanner(promoBanner: PromoBanner): PromoBannerParam{
            return PromoBannerParam(drawable = promoBanner.drawable)
        }
    }
}