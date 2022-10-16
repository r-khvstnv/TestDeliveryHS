package com.rkhvstnv.testdeliveryhs.presentation.menu

import android.util.Log
import androidx.lifecycle.*
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsCategoryParam
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsParam
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsParamState
import com.rkhvstnv.testdeliveryhs.domain.models.PromoBannerParam
import com.rkhvstnv.testdeliveryhs.domain.usecases.GetAllGoodsCategoriesUseCase
import com.rkhvstnv.testdeliveryhs.domain.usecases.GetGoodsByTypeUseCase
import com.rkhvstnv.testdeliveryhs.domain.usecases.GetPromoBannersUseCase
import com.rkhvstnv.testdeliveryhs.utils.coroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class MenuViewModel (
    private val getPromoBannersUseCase: GetPromoBannersUseCase,
    private val getAllGoodsCategoriesUseCase: GetAllGoodsCategoriesUseCase,
    private val getGoodsByTypeUseCase: GetGoodsByTypeUseCase
) : ViewModel() {

    class Factory @Inject constructor(
        private val getPromoBannersUseCase: Provider<GetPromoBannersUseCase>,
        private val getAllGoodsCategoriesUseCase: Provider<GetAllGoodsCategoriesUseCase>,
        private val getGoodsByTypeUseCase: Provider<GetGoodsByTypeUseCase>
    ): ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MenuViewModel(
                getPromoBannersUseCase = getPromoBannersUseCase.get(),
                getAllGoodsCategoriesUseCase = getAllGoodsCategoriesUseCase.get(),
                getGoodsByTypeUseCase = getGoodsByTypeUseCase.get()
            ) as T
        }
    }




    val banners = MutableLiveData<List<PromoBannerParam>>()
    val categories = MutableLiveData<List<GoodsCategoryParam>>()
    val goodsState = MutableLiveData<GoodsParamState>()

    init {
        fetchData()
    }

    private fun fetchData(){
        banners.postValue(getPromoBannersUseCase.execute())
        val cat = getAllGoodsCategoriesUseCase.execute()
        cat[0].isChecked = true
        categories.postValue(cat)

        /*viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler){
            val gds = getGoodsByTypeUseCase.execute(cat[0])
            goodsState.postValue(gds)
        }*/
    }


    fun requestGoodsByType(goodsCategoryParam: GoodsCategoryParam){
        categories.value?.let {
            list ->
            list.map {
                if (it.isChecked && it != goodsCategoryParam) it.isChecked = false

                if (it == goodsCategoryParam) goodsCategoryParam.isChecked = true
            }
            categories.postValue(list)
        }

        /*viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler){
            val gds = getGoodsByTypeUseCase.execute(goodsCategoryParam)
            goodsState.postValue(gds)
        }*/
    }


}