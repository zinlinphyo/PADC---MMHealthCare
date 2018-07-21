package net.zinlinphyo.padc_mmhealthcare.mvp.presenters

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import net.zinlinphyo.padc_mmhealthcare.mvp.views.BaseView

open class BasePresenter<V : BaseView>(view: V) : ViewModel() {

    protected var mView: V? = view
    protected var mErrorLiveData: MutableLiveData<String>? = null

    init {
        mErrorLiveData = MutableLiveData()
    }
}