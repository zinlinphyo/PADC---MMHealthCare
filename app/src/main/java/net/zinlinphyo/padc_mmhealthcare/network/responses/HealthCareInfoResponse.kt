package net.zinlinphyo.padc_mmhealthcare.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import net.zinlinphyo.padc_mmhealthcare.data.vos.HealthCareInfoVO

class HealthCareInfoResponse {
    @SerializedName("code")
    var code: Int? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("healthcare-info")
    var healthCareInfoList: List<HealthCareInfoVO>? = null
}