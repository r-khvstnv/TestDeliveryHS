package com.rkhvstnv.testdeliveryhs.di

import com.rkhvstnv.testdeliveryhs.data.repository.RepositoryImpl
import com.rkhvstnv.testdeliveryhs.data.source.remote.SpoonacularApi
import com.rkhvstnv.testdeliveryhs.data.utils.EndPoint
import com.rkhvstnv.testdeliveryhs.domain.repository.Repository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @[Singleton Provides]
    fun providesSpoonacularApi(): SpoonacularApi{
        return Retrofit
            .Builder()
            .baseUrl(EndPoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(SpoonacularApi::class.java)
    }

    @[Singleton Provides]
    fun providesRepository(spoonacularApi: SpoonacularApi): Repository = RepositoryImpl(spoonacularApi)
}