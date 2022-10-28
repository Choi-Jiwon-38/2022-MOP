package com.example.a2022_mop

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity: AppCompatActivity() {
    private lateinit var mEditID: EditText
    private lateinit var mEditPW: EditText
    private lateinit var mEditName: EditText
    private lateinit var mEditAddress: EditText
    private lateinit var mEditPhone: EditText

    private lateinit var btnSignUp: Button

    // 회원 가입 시 사용될 정보
    private lateinit var newID: String
    private lateinit var newPW: String
    private lateinit var userName: String
    private lateinit var userAddress: String
    private lateinit var userPhone: String

    override fun onCreate(savedInstantState: Bundle?) {
        super.onCreate(savedInstantState)
        setContentView(R.layout.activity_signup)

        mEditID = findViewById(R.id.info_id)
        mEditPW = findViewById(R.id.info_pw)
        mEditName = findViewById(R.id.info_name)
        mEditAddress = findViewById(R.id.info_address)
        mEditPhone = findViewById(R.id.info_phone)
        btnSignUp = findViewById(R.id.buttonSignUp)

        val prefs: SharedPreferences = getSharedPreferences("member_info", 0)
        val editor: SharedPreferences.Editor = prefs.edit()

        // 프리퍼런스를 이용하여 데이터 작성하기
        btnSignUp.setOnClickListener {

            newID = mEditID.text.toString()
            newPW = mEditPW.text.toString()
            userName= mEditName.text.toString()
            userAddress = mEditAddress.text.toString()
            userPhone = mEditPhone.text.toString()

            val info = setOf(newPW, userName, userAddress, userPhone) // 데이터는 'StringSet' 의 형태로 저장

            editor.putStringSet(newID, info)
            editor.apply()

        }
    }

    @Override
    override fun onDestroy() {
        super.onDestroy()
    }
}
