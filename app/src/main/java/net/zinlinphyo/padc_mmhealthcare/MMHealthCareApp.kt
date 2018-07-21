package net.zinlinphyo.padc_mmhealthcare

import android.app.Application
import net.zinlinphyo.padc_mmhealthcare.data.models.HealthCareInfoModel

class MMHealthCareApp : Application() {
    override fun onCreate() {
        super.onCreate()
        HealthCareInfoModel.initHealthCareInfoModel(applicationContext)
    }
}