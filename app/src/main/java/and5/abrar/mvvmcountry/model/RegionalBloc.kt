package and5.abrar.mvvmcountry.model


import com.google.gson.annotations.SerializedName

data class RegionalBloc(
    @SerializedName("acronym")
    val acronym: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("otherNames")
    val otherNames: List<String>
)