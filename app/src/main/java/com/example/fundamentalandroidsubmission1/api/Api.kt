package com.example.fundamentalandroidsubmission1.api

import com.example.fundamentalandroidsubmission1.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization : token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>
}