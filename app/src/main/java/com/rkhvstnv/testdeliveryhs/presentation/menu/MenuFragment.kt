package com.rkhvstnv.testdeliveryhs.presentation.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rkhvstnv.testdeliveryhs.TestDeliveryHsApplication
import com.rkhvstnv.testdeliveryhs.databinding.FragmentMenuBinding
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsCategoryParam
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsParamState
import com.rkhvstnv.testdeliveryhs.presentation.menu.adapters.CategoriesCallback
import com.rkhvstnv.testdeliveryhs.presentation.menu.adapters.GoodsAdapter
import com.rkhvstnv.testdeliveryhs.presentation.menu.adapters.GoodsCategoriesAdapter
import com.rkhvstnv.testdeliveryhs.presentation.menu.adapters.PromoBannersAdapter
import javax.inject.Inject

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    @Inject
    internal lateinit var menuViewModelFactory: dagger.Lazy<MenuViewModel.Factory>

    private val viewModel by viewModels<MenuViewModel>{ menuViewModelFactory.get() }
    private val adapterPromoBanners by lazy { PromoBannersAdapter(requireContext()) }
    private lateinit var adapterGoodsCategories: GoodsCategoriesAdapter
    private val adapterGoods by lazy { GoodsAdapter(requireContext()) }

    override fun onAttach(context: Context) {
        (requireActivity().applicationContext as TestDeliveryHsApplication)
            .appComponent
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "Developed by Ruslan Khvastunov", Toast.LENGTH_SHORT).show()

        setupPromoBannersRecyclerView()
        setupGoodsCategoriesRecyclerView()
        setupGoodsRecyclerView()

        viewModel.promoBanners.observe(viewLifecycleOwner){
                list ->
            if (!list.isNullOrEmpty())
                adapterPromoBanners.submitList(list)
        }
        viewModel.goodsCategories.observe(viewLifecycleOwner){
                list ->
            list?.let {
                if (it.isNotEmpty()){
                    adapterGoodsCategories.submitList(null)
                    adapterGoodsCategories.submitList(list)
                }
            }
        }
        viewModel.goodsState.observe(viewLifecycleOwner){
                state ->
            when(state){
                is GoodsParamState.Success -> {
                    adapterGoods.submitList(state.goodsParamList)
                }
                is GoodsParamState.Error -> Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupPromoBannersRecyclerView(){
        binding.rvBanners.apply {
            adapter = adapterPromoBanners
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
    }

    private fun setupGoodsCategoriesRecyclerView(){
        adapterGoodsCategories = GoodsCategoriesAdapter(
            requireContext(),
            object : CategoriesCallback{
                override fun onItemClick(goodsCategoryParam: GoodsCategoryParam) {
                    viewModel.requestGoodsByType(goodsCategoryParam = goodsCategoryParam)
                }

            }
        )


        binding.rvGoodsCategories.apply {
            adapter = adapterGoodsCategories
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
    }

    private fun setupGoodsRecyclerView(){
        binding.rvGoods.apply {
            adapter = adapterGoods
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}