package net.zinlinphyo.padc_mmhealthcare.mvp.views

import net.zinlinphyo.padc_mmhealthcare.data.vos.HealthCareInfoVO

interface HealthCareInfoView : BaseView {
    fun displayHealthInfoList(data: List<HealthCareInfoVO>)
}