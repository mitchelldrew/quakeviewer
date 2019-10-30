package com.mdrew.quakeviewer.model

import com.mdrew.quakeviewer.IListView

class MockListView(): IListView {
    var displayQuakesCounter = 0
    var lastQuakeResponse:QuakeResponse? = null

    override fun displayQuakes(response: QuakeResponse) {
        displayQuakesCounter++
        lastQuakeResponse = response
    }

}