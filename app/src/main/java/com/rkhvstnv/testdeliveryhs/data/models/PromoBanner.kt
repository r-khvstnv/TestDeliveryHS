package com.rkhvstnv.testdeliveryhs.data.models

import androidx.annotation.DrawableRes

/** Model for hardcoded banner*/
data class PromoBanner(
    val id: Int,
    @DrawableRes val drawable: Int
)