package com.agening.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agening.shoppinglist.data.ShopListRepositoryImpl
import com.agening.shoppinglist.domain.DeleteShopItemUseCase
import com.agening.shoppinglist.domain.EditShopItemUseCase
import com.agening.shoppinglist.domain.GetShopListUseCase
import com.agening.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItemUseCase(shopItem)
    }

    fun changeEnableState(shopItem:ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItemUseCase(newItem)
    }

}