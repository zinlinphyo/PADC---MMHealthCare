package net.zinlinphyo.padc_mmhealthcare.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import net.zinlinphyo.padc_mmhealthcare.data.vos.HealthCareInfoVO
import net.zinlinphyo.padc_mmhealthcare.persistence.Dao.HealthCareInfoDao

@Database(entities = arrayOf(HealthCareInfoVO::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun healthCareInfoDao(): HealthCareInfoDao

    companion object {
        private val DB_NAME = "MMHealthCare.DB"
        var INSATNCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSATNCE == null) {
                INSATNCE = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            val i = INSATNCE
            return i!!
        }
    }
}