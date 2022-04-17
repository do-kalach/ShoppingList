package com.agening.shoppinglist.data

import com.agening.shoppinglist.domain.ShopItem
import com.agening.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopItemUseCase(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItemUseCase(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItemUseCase(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        shopList.add(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("Element with id $shopItemId not found.")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}