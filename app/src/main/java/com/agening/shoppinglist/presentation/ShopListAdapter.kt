package com.agening.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.agening.shoppinglist.databinding.ItemShopDisabledBinding
import com.agening.shoppinglist.databinding.ItemShopEnabledBinding
import com.agening.shoppinglist.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    companion object {
        const val VIEW_TYPE_ENABLED = 1234
        const val VIEW_TYPE_DISABLED = 4321
    }

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    private lateinit var enBinding: ItemShopEnabledBinding
    private lateinit var diBinding: ItemShopDisabledBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = if (viewType == VIEW_TYPE_ENABLED) {
            ItemShopEnabledBinding.inflate(inflater, parent, false)
        } else {
            ItemShopDisabledBinding.inflate(inflater, parent, false)
        }
        return ShopItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        if (shopItem.enabled) {
            with(holder.binding as ItemShopEnabledBinding) {
                tvName.text = shopItem.name
                tvCount.text = shopItem.count
            }
        } else {
            with(holder.binding as ItemShopDisabledBinding) {
                tvName.text = shopItem.name
                tvCount.text = shopItem.count
            }
        }
        holder.binding.root.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }

        holder.binding.root.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled)
            VIEW_TYPE_ENABLED
        else VIEW_TYPE_DISABLED
    }
}