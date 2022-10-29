package com.example.a2022_mop

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class LoginActivity: AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var btnTextSignUp: TextView
    private lateinit var inputID: TextView
    private lateinit var inputPW: TextView

    override fun onCreate(savedInstantState: Bundle?) {
        super.onCreate(savedInstantState)
        setContentView(R.layout.activity_login)

        val prefs: SharedPreferences = getSharedPreferences("member_info", 0)

        btnLogin = findViewById(R.id.buttonLogin)
        btnTextSignUp = findViewById(R.id.toSignUp)
        inputID = findViewById(R.id.textID)
        inputPW = findViewById(R.id.textPW)

        btnTextSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        btnLogin.setOnClickListener {
            if ( inputID.text.isNotEmpty() && inputPW.text.isNotEmpty() ) {
                var userInfo = prefs.getString(inputID.text.toString(), "none")

                if (userInfo != "none") {
                    var userInfo_json = JSONObject(userInfo)
                    if (inputPW.text.toString() != userInfo_json.getString("password")) {
                        Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        startActivity(Intent(this, ShopActivity::class.java))
                    }
                } else {
                    Toast.makeText(this, "아이디가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }


}