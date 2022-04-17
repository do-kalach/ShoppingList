package com.agening.shoppinglist.domain

interface ShopListRepository {

    fun addShopItemUseCase(shopItem: ShopItem)

    fun deleteShopItemUseCase(shopItem: ShopItem)

    fun editShopItemUseCase(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    fun getShopList(): List<ShopItem>

}