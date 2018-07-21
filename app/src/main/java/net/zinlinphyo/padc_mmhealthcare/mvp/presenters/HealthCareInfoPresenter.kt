package net.zinlinphyo.padc_mmhealthcare.mvp.presenters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import net.zinlinphyo.padc_mmhealthcare.data.models.HealthCareInfoModel
import net.zinlinphyo.padc_mmhealthcare.data.vos.HealthCareInfoVO
import net.zinlinphyo.padc_mmhealthcare.mvp.views.HealthCareInfoView

class HealthCareInfoPresenter(view: HealthCareInfoView) : BasePresenter<HealthCareInfoView>(view) {
    private var mHealthCareInfoModel : HealthCareInfoModel? = null

    init {
        mHealthCareInfoModel = HealthCareInfoModel.getInstance()
        loadHealthCareInfoData()
    }

    private fun loadHealthCareInfoData(){
        mHealthCareInfoModel!!.loadHealthCareInfo(mErrorLiveData)
    }

    fun getAllHealthCareInfo(): LiveData<List<HealthCareInfoVO>>{
        return mHealthCareInfoModel!!.retrieveHealthCareInfo()
    }

    fun getErrorMessage(): MutableLiveData<String>{
        return mErrorLiveData!!
    }
}