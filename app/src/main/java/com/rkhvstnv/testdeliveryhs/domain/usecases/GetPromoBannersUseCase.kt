package com.rkhvstnv.testdeliveryhs.domain.usecases

import com.rkhvstnv.testdeliveryhs.domain.repository.Repository
import com.rkhvstnv.testdeliveryhs.domain.models.PromoBannerParam
import javax.inject.Inject

/** UseCase for obtaining promo banners. Data will be automatically mapped*/
class GetPromoBannersUseCase @Inject constructor(private val repository: Repository) {
    fun execute(): List<PromoBannerParam>{
        return repository.getPromoBanners().map {
            PromoBannerParam.fromPromoBanner(it)
        }
    }
}