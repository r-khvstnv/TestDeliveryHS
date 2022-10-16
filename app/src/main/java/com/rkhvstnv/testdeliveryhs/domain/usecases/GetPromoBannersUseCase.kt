package com.rkhvstnv.testdeliveryhs.domain.usecases

import com.rkhvstnv.testdeliveryhs.domain.repository.Repository
import com.rkhvstnv.testdeliveryhs.domain.models.PromoBannerParam
import javax.inject.Inject

class GetPromoBannersUseCase @Inject constructor(private val repository: Repository) {
    fun execute(): List<PromoBannerParam>{
        return repository.getPromoBanners().map {
            PromoBannerParam.fromPromoBanner(it)
        }
    }
}