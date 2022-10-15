package com.rkhvstnv.testdeliveryhs.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rkhvstnv.testdeliveryhs.databinding.FragmentMenuBinding
import com.rkhvstnv.testdeliveryhs.presentation.menu.adapters.GoodsAdapter
import com.rkhvstnv.testdeliveryhs.presentation.menu.adapters.GoodsCategoriesAdapter
import com.rkhvstnv.testdeliveryhs.presentation.menu.adapters.PromoBannersAdapter

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MenuViewModel>()
    private val adapterPromoBanners by lazy { PromoBannersAdapter(requireContext()) }
    private val adapterGoodsCategories by lazy { GoodsCategoriesAdapter(requireContext()) }
    private val adapterGoods by lazy { GoodsAdapter(requireContext()) }

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

        setupPromoBannersRecyclerView()
        setupGoodsCategoriesRecyclerView()
        setupGoodsRecyclerView()

        viewModel.banners.observe(viewLifecycleOwner){
            list ->
            if (!list.isNullOrEmpty())
                adapterPromoBanners.submitList(list)
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