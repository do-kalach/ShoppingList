package com.agening.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agening.shoppinglist.databinding.ItemShopDisabledBinding
import com.agening.shoppinglist.databinding.ItemShopEnabledBinding
import com.agening.shoppinglist.domain.ShopItem

class ShopListAdapter:RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    val list = listOf<ShopItem>()

    private lateinit var enBinding:ItemShopEnabledBinding
    private lateinit var diBinding:ItemShopDisabledBinding

    inner class ShopItemViewHolder(val binding: ItemShopEnabledBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        enBinding = ItemShopEnabledBinding.inflate(inflater, parent, false)
        return ShopItemViewHolder(enBinding)

    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = list[position]
        holder.binding.tvName.text = shopItem.name
        holder.binding.tvCount.text = shopItem.count
        holder.binding.root.setOnLongClickListener {
            true
        }
    }

    override fun getItemCount(): Int = list.size
}