package com.rkhvstnv.testdeliveryhs.presentation.menu

import androidx.lifecycle.*
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsCategoryParam
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsParamState
import com.rkhvstnv.testdeliveryhs.domain.models.PromoBannerParam
import com.rkhvstnv.testdeliveryhs.domain.usecases.GetAllGoodsCategoriesUseCase
import com.rkhvstnv.testdeliveryhs.domain.usecases.GetGoodsByTypeUseCase
import com.rkhvstnv.testdeliveryhs.domain.usecases.GetPromoBannersUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class MenuViewModel (
    private val getPromoBannersUseCase: GetPromoBannersUseCase,
    private val getAllGoodsCategoriesUseCase: GetAllGoodsCategoriesUseCase,
    private val getGoodsByTypeUseCase: GetGoodsByTypeUseCase
) : ViewModel() {

    /** In this sample, ViewModel Factory suitable only for this class is used.
     * In other cases, a more unified Factory with availability through DI will be implemented*/
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



    private var _promoBanners = MutableLiveData<List<PromoBannerParam>>()
    private var _goodsCategories = MutableLiveData<List<GoodsCategoryParam>>()
    private var _goodsState = MutableLiveData<GoodsParamState>()

    val promoBanners: LiveData<List<PromoBannerParam>> get() = _promoBanners
    val goodsCategories: LiveData<List<GoodsCategoryParam>> get() = _goodsCategories
    val goodsState: LiveData<GoodsParamState> get() = _goodsState

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    init {
        fetchData()
    }

    /** Method requests all required data*/
    private fun fetchData(){
        _promoBanners.postValue(getPromoBannersUseCase.execute())
        val categories = getAllGoodsCategoriesUseCase.execute()
        categories[0].isChecked = true
        _goodsCategories.postValue(categories)

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler){
            val gdsState = getGoodsByTypeUseCase.execute(categories[0])
            _goodsState.postValue(gdsState)
        }
    }


    /** Method requests list of goods by selected category*/
    fun requestGoodsByType(goodsCategoryParam: GoodsCategoryParam){
        _goodsCategories.value?.let {
            list ->
            list.map {
                if (it.isChecked && it != goodsCategoryParam) it.isChecked = false

                if (it == goodsCategoryParam) goodsCategoryParam.isChecked = true
            }
            _goodsCategories.postValue(list)
        }

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler){
            val gdsState = getGoodsByTypeUseCase.execute(goodsCategoryParam)
            _goodsState.postValue(gdsState)
        }
    }


}