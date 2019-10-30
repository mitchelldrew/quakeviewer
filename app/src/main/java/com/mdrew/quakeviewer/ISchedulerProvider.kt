package com.mdrew.quakeviewer

import io.reactivex.Scheduler

interface ISchedulerProvider {
    fun newThread():Scheduler
    fun mainThread():Scheduler
}