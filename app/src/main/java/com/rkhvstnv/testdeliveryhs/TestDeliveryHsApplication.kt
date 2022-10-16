package com.rkhvstnv.testdeliveryhs

import android.app.Application
import com.rkhvstnv.testdeliveryhs.di.AppComponent
import com.rkhvstnv.testdeliveryhs.di.DaggerAppComponent

class TestDeliveryHsApplication: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().build()
    }
}