package com.mdrew.quakeviewer.model

import com.mdrew.quakeviewer.ISchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class MockSchedulerProvider: ISchedulerProvider{
    override fun newThread(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun mainThread(): Scheduler {
        return Schedulers.trampoline()
    }

}