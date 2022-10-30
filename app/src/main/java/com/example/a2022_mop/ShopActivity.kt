package com.example.a2022_mop


import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.a2022_mop.databinding.ActivityShopBinding
import org.json.JSONObject



class ShopActivity: AppCompatActivity() {
    private val binding by lazy { ActivityShopBinding.inflate(layoutInflater) }
    private var recyclerAdapter: ShopAdapter? = null

    var dataSet = arrayListOf(
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

        binding.registration.isEnabled = intent.hasExtra("user info") // 데이터 유무에 따라 버튼 활성화, 비활성화

        recyclerAdapter = ShopAdapter(dataSet)
        binding.rvShop.adapter = recyclerAdapter

        binding.viewInfo.setOnClickListener {
            if (intent.hasExtra("user info")) {
                var info = JSONObject(intent.getStringExtra("user info"))
                var userName: String = info.getString("name")
                var userAddress: String = info.getString("address")
                var userPhone: String = info.getString("phone")

                AlertDialog.Builder(this)
                    .setTitle("회원 정보")
                    .setMessage("이름: $userName\n주소: $userAddress\n휴대전화: $userPhone\n")
                    .setNegativeButton("확인") { dialog, _ -> dialog.dismiss() }
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("비회원인가요?")
                    .setMessage("물품 등록은 회원 전용 기능입니다.\n회원가입 하시겠습니까?\n")
                    .setPositiveButton("네", null)
                    .setNegativeButton("아니오") { dialog, _ -> dialog.dismiss() }
                    .show()
            }

            binding.registration.setOnClickListener {
                dataSet.add(Item(R.drawable.red_portion, "아무거나", "아무거나 추가된 아이템이다"))
                recyclerAdapter!!.notifyDataSetChanged()
            }

        }
    }

}