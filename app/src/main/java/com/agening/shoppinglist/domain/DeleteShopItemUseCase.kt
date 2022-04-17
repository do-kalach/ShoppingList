package com.agening.shoppinglist.domain

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItemUseCase(shopItem: ShopItem) {
        shopListRepository.deleteShopItemUseCase(shopItem)
    }
}