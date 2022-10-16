package com.rkhvstnv.testdeliveryhs.presentation.menu.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rkhvstnv.testdeliveryhs.R
import com.rkhvstnv.testdeliveryhs.databinding.ItemGoodsBinding
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsParam
import com.rkhvstnv.testdeliveryhs.utils.loadImage

/** Adapter for Goods RecyclerView*/
class GoodsAdapter(private val context: Context):
    ListAdapter<GoodsParam, GoodsAdapter.ViewHolder>(GoodsCallback()){
    class ViewHolder(val binding: ItemGoodsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGoodsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding = binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val goods = getItem(position)

        with(holder.binding){
            ivItemGoodsPreview.loadImage(goods.preview)
            tvItemGoodsTitle.text = goods.title
            tvItemGoodsIngredients.text = goods.ingredients
            btnItemGoodsCost.text = context.getString(R.string.hint_from) + Char(32) + goods.cost + context.getString(R.string.currency_ruble)

        }
    }
}

private class GoodsCallback: DiffUtil.ItemCallback<GoodsParam>(){
    override fun areItemsTheSame(oldItem: GoodsParam, newItem: GoodsParam): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GoodsParam, newItem: GoodsParam): Boolean {
        return oldItem.id == newItem.id && oldItem.title == newItem.title
    }

}