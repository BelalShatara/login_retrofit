package com.belalshatara.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import z.belalshatara.myapplication.post

class MainActivity : AppCompatActivity() {


    private lateinit var btn : Button
    private lateinit var student_number : TextInputEditText
    private lateinit var password : TextInputEditText
    var mAPIService: post? = null



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

                    if (response.isSuccessful ) {
                        Toast.makeText(this@MainActivity , "Login Success" , Toast.LENGTH_LONG).show()

                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@MainActivity ,  t.message , Toast.LENGTH_LONG).show()
                }
            })
        })

    }
}