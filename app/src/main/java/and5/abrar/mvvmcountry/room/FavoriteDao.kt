package and5.abrar.mvvmcountry.room

import androidx.room.*

@Dao
interface FavoriteDao {
    @Insert fun insertFavorite(Favorite: Favorite):Long
    @Query("SELECT * FROM Favorite ") fun getAllFavorite() : List<Favorite>
    @Delete fun deleteFavorite(Favorite: Favorite): Int
    @Update fun updateFavorite(Favorite: Favorite): Int
}