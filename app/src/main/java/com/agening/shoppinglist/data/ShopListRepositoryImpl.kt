package com.agening.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.agening.shoppinglist.domain.ShopItem
import com.agening.shoppinglist.domain.ShopListRepository
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = sortedSetOf<ShopItem>({ o1, o2 ->
        o1.id.compareTo(o2.id)
    })
    private var autoIncrementId = 0
    private val shopListLD = MutableLiveData<List<ShopItem>>()


    init {
        for (i in 0 until 100) {
            val shopItem = ShopItem("Hello $i", i.toString(), Random.nextBoolean())
            addShopItem(shopItem)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        shopList.add(shopItem)
        updateList()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("Element with id $shopItemId not found.")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    fun updateList() {
        shopListLD.value = shopList.toList()
    }
}