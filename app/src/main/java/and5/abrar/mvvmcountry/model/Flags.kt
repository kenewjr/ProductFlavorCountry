package and5.abrar.mvvmcountry.model


import com.google.gson.annotations.SerializedName

data class Flags(
    @SerializedName("png")
    val png: String,
    @SerializedName("svg")
    val svg: String
)