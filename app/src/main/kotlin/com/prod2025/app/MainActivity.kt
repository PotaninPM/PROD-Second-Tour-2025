package com.prod2025.app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.prod.core.impl.databinding.ActivityMainBinding
import com.prod.core.impl.ui.goods.goodsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentContainer.id, goodsFragment())
            .commit()
    }
}
