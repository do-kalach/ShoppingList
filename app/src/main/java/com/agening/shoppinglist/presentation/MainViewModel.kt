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

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

}