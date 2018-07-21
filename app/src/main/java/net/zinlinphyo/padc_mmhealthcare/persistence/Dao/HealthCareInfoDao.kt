package net.zinlinphyo.padc_mmhealthcare.persistence.Dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import net.zinlinphyo.padc_mmhealthcare.data.vos.HealthCareInfoVO

@Dao
interface HealthCareInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(data: List<HealthCareInfoVO>)

    @Query("select * from health_care_info")
    fun retrieveAllData(): LiveData<List<HealthCareInfoVO>>

}