package net.zinlinphyo.padc_mmhealthcare.data.vos

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

@Entity(tableName = "health_care_info")
open class HealthCareInfoVO(infoId: Double,
                            title: String = "",
                            image: String = "",
                            description: String = "",
                            publishedDate: String = "",
                            url: String = "") {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    open var infoId = infoId

    @SerializedName("title")
    var title = title

    @SerializedName("image")
    var image = image

    @SerializedName("short-description")
    var description = description

    @SerializedName("published-date")
    var publishedDate = publishedDate

    @SerializedName("complete-url")
    var url = url
}
