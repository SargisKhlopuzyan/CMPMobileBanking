package com.sargis.khlopuzyan.cmpmobilebanking

import android.app.Application
import android.util.Log
import com.sargis.khlopuzyan.cmpmobilebanking.di.initKoin
import org.koin.android.ext.koin.androidContext

class MobileBankingApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Log.e("LOG_TAG", "MobileBankingApp onCreate: ")
        //initKoin()
        initKoin {
            androidContext(this@MobileBankingApp)
        }
    }
}