package com.mdrew.quakeviewer

import com.mdrew.quakeviewer.model.*
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Test
import java.util.*

class ListPresenterTest {

    companion object {
        fun generateQuake(): Quake{
            return Quake(
                datetime = UUID.randomUUID().toString(),
                depth = Random().nextDouble(),
                lng = Random().nextDouble(),
                src = UUID.randomUUID().toString(),
                eqid = UUID.randomUUID().toString(),
                magnitude = Random().nextDouble(),
                lat = Random().nextDouble())
        }

        fun generateQuakeResponse(): QuakeResponse{
            var list = ArrayList<Quake>(3)
            for(i in 0..3){
                list.add(generateQuake())
            }
            return QuakeResponse(list)
        }
    }

@Test
fun listPresenterCallsQuakeServiceAndDisplaysResult(){
    val mockQuakeResponse = generateQuakeResponse()
    val mockQuakeService = MockQuakeService(Observable.just(mockQuakeResponse))
    val mockListView = MockListView()
    val mockScheduler = MockSchedulerProvider()
    val listPresenter = ListPresenter(mockQuakeService, mockScheduler)
    listPresenter.setView(mockListView)

    listPresenter.getQuakes()

    Assert.assertEquals(1, mockQuakeService.getQuakesCounter)
    Assert.assertEquals(1, mockListView.displayQuakesCounter)
    Assert.assertEquals(mockListView.lastQuakeResponse!!, mockQuakeResponse)

}


}