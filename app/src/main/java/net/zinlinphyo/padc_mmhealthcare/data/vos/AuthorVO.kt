package net.zinlinphyo.padc_mmhealthcare.data.vos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthorVO() {

    @SerializedName("author-id")
    var authorId: Int? = null

    @SerializedName("author-name")
    var authorName: String? = null

    @SerializedName("author-picture")
    var authorPicture: String? = null
}