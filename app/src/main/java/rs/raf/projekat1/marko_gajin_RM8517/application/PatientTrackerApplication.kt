package rs.raf.projekat1.marko_gajin_RM8517.application

import android.app.Application
import timber.log.Timber

class PatientTrackerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

}