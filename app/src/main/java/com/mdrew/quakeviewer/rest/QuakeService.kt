package com.mdrew.quakeviewer.rest

import com.mdrew.quakeviewer.model.QuakeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface QuakeService{
    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("earthquakesJSON")
    fun getQuakes(@Query("formatted") formatted:Boolean,
                  @Query("north") north:Double,
                  @Query("south") south:Double,
                  @Query("east") east:Double,
                  @Query("west") west:Double,
                  @Query("username") username:String): Observable<QuakeResponse>
}