package com.rkhvstnv.testdeliveryhs.presentation.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rkhvstnv.testdeliveryhs.domain.PromoBannersTest

class MenuViewModel : ViewModel() {
    val banners = MutableLiveData(PromoBannersTest.getPromoBannersParam())
}