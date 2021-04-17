package com.belalshatara.login.Activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.belalshatara.login.ApiUtils
import com.belalshatara.login.HomePage
import com.belalshatara.login.R
import com.belalshatara.login.User
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import z.belalshatara.myapplication.RequestDeclare

class LoginPage : AppCompatActivity() {


    private lateinit var btn : Button
    private lateinit var student_number : TextInputEditText
    private lateinit var password : TextInputEditText
    var mAPIService: RequestDeclare? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = this.findViewById(R.id.login)
        student_number = findViewById(R.id.student_number)
        password = findViewById(R.id.password)
        mAPIService = ApiUtils.apiService

        btn.setOnClickListener(View.OnClickListener {

            mAPIService!!.login(student_number.text.toString() , password.text.toString())
                    .enqueue(object :  Callback<User> {

                override fun onResponse(call: Call<User>, response: Response<User>) {

                        val i = Intent(this@LoginPage , HomePage::class.java)
                        startActivity(i)
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    val i = Intent(this@LoginPage , HomePage::class.java)
                    startActivity(i)
                }
            })
        })

    }
}