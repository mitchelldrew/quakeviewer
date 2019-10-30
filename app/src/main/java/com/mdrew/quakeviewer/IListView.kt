package com.mdrew.quakeviewer

import com.mdrew.quakeviewer.model.QuakeResponse

interface IListView {
fun displayQuakes(response:QuakeResponse)
}