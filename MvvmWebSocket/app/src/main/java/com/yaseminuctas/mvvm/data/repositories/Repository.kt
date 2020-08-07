package com.yaseminuctas.mvvm.data.repositories

import com.yaseminuctas.mvvm.data.network.Api

class Repository(
    private val api: Api
) : SafeApiRequest() {

 //   suspend fun getMockData(): List<Datum> = apiRequest { api.getMockData() }




}