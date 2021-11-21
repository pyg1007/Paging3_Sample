package kr.ryan.paging_sample.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Paging-Sample
 * Class: PagingSampleApplication
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
@HiltAndroidApp
class PagingSampleApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}