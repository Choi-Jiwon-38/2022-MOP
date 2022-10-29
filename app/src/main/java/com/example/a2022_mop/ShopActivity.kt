package com.example.a2022_mop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a2022_mop.databinding.ActivityShopBinding


class ShopActivity: AppCompatActivity() {
    private val binding by lazy { ActivityShopBinding.inflate(layoutInflater) }
    private var recyclerAdapter: ShopAdapter? = null

    var dataSet = arrayOf(
        Item(R.drawable.red_portion, "빨간 포션", "붉은 약초로 만든 물약이다."),
        Item(R.drawable.orange_portion, "주황 포션", "붉은 약초의 농축 물약이다."),
        Item(R.drawable.white_portion, "하얀 포션", "붉은 약초의 고농축 물약이다."),
        Item(R.drawable.squid, "마른 오징어", "잘 구워진 마른 오징어다."),
        Item(R.drawable.meat, "짐승의 고기", "먹음직한 짐승의 고기이다.")
    )

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        recyclerAdapter = ShopAdapter(dataSet)
        binding.rvShop.adapter = recyclerAdapter
    }

}