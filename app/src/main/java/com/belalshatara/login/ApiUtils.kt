package com.belalshatara.login

import z.belalshatara.myapplication.RetrofitClient
import z.belalshatara.myapplication.post

object ApiUtils {

    private const val BASE_URL = "http://192.168.3.26:3000"

    val apiService: post = RetrofitClient.getClient(BASE_URL)!!.create(post::class.java)
}



