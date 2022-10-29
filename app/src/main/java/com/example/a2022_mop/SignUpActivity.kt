package com.example.a2022_mop

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class SignUpActivity: AppCompatActivity() {
    private lateinit var mEditID: EditText
    private lateinit var mEditPW: EditText
    private lateinit var mEditName: EditText
    private lateinit var mEditAddress: EditText
    private lateinit var mEditPhone: EditText
    private lateinit var mRadioAgree: RadioButton

    private lateinit var btnCheck: Button   // 중복체크 버튼
    private lateinit var btnSignUp: Button  // 회원가입 버튼

    private var availableID: String = "" // 중복체크를 거친 아이디 (사용 가능한 아이디)

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
        mRadioAgree = findViewById(R.id.radioChecked)

        btnSignUp = findViewById(R.id.buttonSignUp)
        btnCheck = findViewById(R.id.buttonCheck)

        val prefs: SharedPreferences = getSharedPreferences("member_info", 0)
        val editor: SharedPreferences.Editor = prefs.edit()

        // 프리퍼런스를 이용하여 데이터 작성하기
        btnSignUp.setOnClickListener {
            val isAgree = mRadioAgree.isChecked
            newID = mEditID.text.toString()
            newPW = mEditPW.text.toString()
            userName= mEditName.text.toString()
            userAddress = mEditAddress.text.toString()
            userPhone = mEditPhone.text.toString()

            if (
                isAgree
                && (newID == availableID)
                && newPW.isNotEmpty()
                && userName.isNotEmpty()
                && userAddress.isNotEmpty()
                && userPhone.isNotEmpty()
            ) {
                val info_json = JSONObject()
                info_json.put("password", newPW)
                info_json.put("name", userName)
                info_json.put("address", userAddress)
                info_json.put("phone", userPhone)

                val info_string = info_json.toString()

                editor.putString(newID, info_string)
                editor.apply()

                Toast.makeText(this, "회원가입이 완료되었습니다!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))

            } else {
                if (!isAgree && (newID != availableID)) { // 중복체크 X / 개인정보 수집 동의 X
                    Toast.makeText(this, "개인정보 수집 동의 및 아이디 중복체크를 해주세요.", Toast.LENGTH_SHORT).show()
                } else if (!isAgree) {
                    Toast.makeText(this, "개인정보 수집에 동의해주세요.", Toast.LENGTH_SHORT).show()
                } else if (newID != availableID) {
                    Toast.makeText(this, "아이디 중복체크를 해주세요.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "모든 정보를 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
            }

        }

        btnCheck.setOnClickListener {
            newID = mEditID.text.toString()

            val check: String? = prefs.getString(newID, "none")

            if (check == "none") {
                Toast.makeText(this, "사용 가능한 아이디입니다!", Toast.LENGTH_SHORT).show()
                availableID = newID
            } else {
                Toast.makeText(this, "이미 존재하는 아이디입니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @Override
    override fun onDestroy() {
        super.onDestroy()
    }
}
