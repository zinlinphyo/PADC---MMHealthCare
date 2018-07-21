package net.zinlinphyo.padc_mmhealthcare.data.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import net.zinlinphyo.padc_mmhealthcare.data.vos.HealthCareInfoVO
import net.zinlinphyo.padc_mmhealthcare.network.responses.HealthCareInfoResponse
import net.zinlinphyo.padc_mmhealthcare.utils.AppConstants

class HealthCareInfoModel(context: Context) : BaseModel(context) {

    companion object {
        private var objInstance: HealthCareInfoModel? = null

        fun initHealthCareInfoModel(context: Context) {
            objInstance = HealthCareInfoModel(context)
        }

        fun getInstance(): HealthCareInfoModel {
            if (objInstance == null) {
                throw RuntimeException("NewsModel is being invoked before initializing.")
            }
            val i = objInstance
            return i!!
        }
    }

    private var mInfoData: HashMap<Double, HealthCareInfoVO> = HashMap()

    fun loadHealthCareInfo(mErrorLiveData: MutableLiveData<String>?) {
        mApiService!!.getHealthCareInfo(AppConstants.access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<HealthCareInfoResponse> {
                    override fun onComplete() {

                    }

                    override fun onNext(response: HealthCareInfoResponse) {
                        if (response.healthCareInfoList != null && response.healthCareInfoList!!.isNotEmpty())
                            insertToDB(response.healthCareInfoList)
                            for (info: HealthCareInfoVO in response.healthCareInfoList!!){
                                mInfoData[info.infoId] = info
                            }
                    }

                    override fun onError(e: Throwable) {
                        mErrorLiveData!!.value = e.message
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                })
    }

    private fun insertToDB(data: List<HealthCareInfoVO>?){
        mAppDatabase!!.healthCareInfoDao().insertAll(data!!)
    }

    fun retrieveHealthCareInfo(): LiveData<List<HealthCareInfoVO>>{
        return mAppDatabase!!.healthCareInfoDao().retrieveAllData()
    }

}