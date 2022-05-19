package and5.abrar.mvvmcountry.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Favorite(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "name_country") var name: String?,
    @ColumnInfo(name = "timezones") var timezones: String?,
    @ColumnInfo(name = "capital") var capital: String?,
    @ColumnInfo(name = "population") var population: Int?,
    @ColumnInfo(name = "flag") var flag: String?,
    @ColumnInfo(name = "region") var region:String?
):Parcelable
