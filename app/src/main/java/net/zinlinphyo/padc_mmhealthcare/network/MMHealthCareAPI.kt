package net.zinlinphyo.padc_mmhealthcare.network

import io.reactivex.Observable
import net.zinlinphyo.padc_mmhealthcare.network.responses.HealthCareInfoResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MMHealthCareAPI {

    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun getHealthCareInfo(@Field("access_token") accessToken: String): Observable<HealthCareInfoResponse>
}