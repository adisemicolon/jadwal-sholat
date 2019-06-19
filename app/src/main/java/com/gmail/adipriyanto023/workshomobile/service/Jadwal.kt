package com.gmail.adipriyanto023.workshomobile.service

import com.gmail.adipriyanto023.workshomobile.model.Jadwal
import com.gmail.adipriyanto023.workshomobile.model.Result
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Jadwal {
    @GET("indonesia.json")
    fun getJadwal(@Query("key") key: String): Observable<Result>
}