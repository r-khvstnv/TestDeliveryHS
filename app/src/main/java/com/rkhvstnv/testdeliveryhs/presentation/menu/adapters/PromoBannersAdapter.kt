package com.rkhvstnv.testdeliveryhs.presentation.menu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.rkhvstnv.testdeliveryhs.databinding.ItemBannerBinding
import com.rkhvstnv.testdeliveryhs.domain.models.PromoBannerParam
import com.rkhvstnv.testdeliveryhs.utils.loadImage

/** Adapter for PromoBanners RecyclerView*/
class PromoBannersAdapter(private val context: Context):
    ListAdapter<PromoBannerParam, PromoBannersAdapter.ViewHolder>(PromoBannersCallback()){

    class ViewHolder(val binding: ItemBannerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val banner = getItem(position)
        holder.binding.ivBannerImage.loadImage(banner.drawable)
    }
}

private class PromoBannersCallback: DiffUtil.ItemCallback<PromoBannerParam>(){
    override fun areItemsTheSame(oldItem: PromoBannerParam, newItem: PromoBannerParam): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PromoBannerParam, newItem: PromoBannerParam): Boolean {
        return oldItem.drawable == newItem.drawable
    }

}