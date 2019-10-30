package com.mdrew.quakeviewer.model

import com.mdrew.quakeviewer.rest.QuakeService
import io.reactivex.Observable

class MockQuakeService(private val mockGetQuakesReturn:Observable<QuakeResponse>):QuakeService{
    var lastFormatted:Boolean? = null
    var lastNorth:Double? = null
    var lastSouth:Double? = null
    var lastEast:Double? = null
    var lastWest:Double? = null
    var lastUsername:String? = null
    var getQuakesCounter = 0

    override fun getQuakes(
        formatted: Boolean,
        north: Double,
        south: Double,
        east: Double,
        west: Double,
        username: String
    ): Observable<QuakeResponse> {
        getQuakesCounter++
        lastFormatted = formatted
        lastNorth = north
        lastSouth = south
        lastEast = east
        lastWest = west
        lastUsername = username
        return mockGetQuakesReturn
    }

}