package z.belalshatara.myapplication

import com.belalshatara.login.User
import retrofit2.Call
import retrofit2.http.*

interface post {

    @POST("login")
    fun login(@Query("student_number") student_number: String,
                         @Query("password") password: String): Call<User>
}

