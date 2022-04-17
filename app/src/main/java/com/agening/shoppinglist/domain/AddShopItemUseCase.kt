package com.agening.shoppinglist.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItemUseCase(shopItem: ShopItem) {
        shopListRepository.addShopItemUseCase(shopItem)
    }
}