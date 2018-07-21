package net.zinlinphyo.padc_mmhealthcare.data.models

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import net.zinlinphyo.padc_mmhealthcare.network.MMHealthCareAPI
import net.zinlinphyo.padc_mmhealthcare.persistence.AppDatabase
import net.zinlinphyo.padc_mmhealthcare.utils.AppConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseModel(context: Context) {
    protected var mApiService: MMHealthCareAPI? = null
    protected var mAppDatabase: AppDatabase? = null

    init {
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.base_url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        mApiService = retrofit.create(MMHealthCareAPI::class.java)
        mAppDatabase = AppDatabase.getInstance(context)
    }
}