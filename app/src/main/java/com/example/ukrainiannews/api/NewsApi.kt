package com.example.ukrainiannews.api

import com.example.ukrainiannews.BuildConfig

interface NewsApi {

    companion object{
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API = BuildConfig.API_KEY
    }


}