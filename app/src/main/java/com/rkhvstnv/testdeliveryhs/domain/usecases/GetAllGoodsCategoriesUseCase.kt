package com.rkhvstnv.testdeliveryhs.domain.usecases

import com.rkhvstnv.testdeliveryhs.domain.repository.Repository
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsCategoryParam
import javax.inject.Inject

/** UseCase for obtaining goods categories. Data will be automatically mapped*/
class GetAllGoodsCategoriesUseCase @Inject constructor(private val repository: Repository) {
    fun execute(): List<GoodsCategoryParam>{
        return repository.getAllGoodsCategories().map {
            GoodsCategoryParam.fromGoodsCategory(it)
        }
    }
}