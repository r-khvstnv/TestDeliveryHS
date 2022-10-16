package com.rkhvstnv.testdeliveryhs.presentation.menu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.R
import com.rkhvstnv.testdeliveryhs.databinding.ItemGoodsCategoryBinding
import com.rkhvstnv.testdeliveryhs.domain.models.GoodsCategoryParam
import com.rkhvstnv.testdeliveryhs.utils.getAttrColor

/** Adapter for GoodsCategories RecyclerView*/
class GoodsCategoriesAdapter(
    private val context: Context,
    private val categoriesCallback: CategoriesCallback
): ListAdapter<GoodsCategoryParam, GoodsCategoriesAdapter.ViewHolder>(GoodsCategoriesItemCallback()){
    class ViewHolder(val binding: ItemGoodsCategoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGoodsCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = getItem(position)


        holder.binding.btnGoodsCategory.apply {
            text = category.name

            /* Based on category state, will be selected corresponding background and text colors*/
            if (category.isChecked){
                setBackgroundColor(context.getAttrColor(R.attr.colorPrimaryContainer))
                setTextColor(context.getAttrColor(R.attr.colorOnPrimaryContainer))
            } else{
                setBackgroundColor(context.getAttrColor(R.attr.colorSurfaceVariant))
                setTextColor(context.getAttrColor(R.attr.colorOnSurfaceVariant))
            }
        }

        holder.itemView.setOnClickListener {
            categoriesCallback.onItemClick(category)
        }
    }
}

private class GoodsCategoriesItemCallback: DiffUtil.ItemCallback<GoodsCategoryParam>(){
    override fun areItemsTheSame(oldItem: GoodsCategoryParam, newItem: GoodsCategoryParam): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GoodsCategoryParam, newItem: GoodsCategoryParam): Boolean {
        return oldItem.name == newItem.name && oldItem.isChecked == newItem.isChecked
    }
}

interface CategoriesCallback{
    fun onItemClick(goodsCategoryParam: GoodsCategoryParam)
}