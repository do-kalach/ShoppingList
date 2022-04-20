package com.agening.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.agening.shoppinglist.R
import com.agening.shoppinglist.databinding.ActivityShopItemBinding

class ShopItemActivity : AppCompatActivity() {

    private lateinit var binding:ActivityShopItemBinding
    private lateinit var viewModel: ShopItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopItemBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        viewModel = ViewModelProvider(this)[ShopItemViewModel::class.java]

    }
}