package and5.abrar.mvvmcountry.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favorite::class], version = 1)
abstract class FavoriteDb : RoomDatabase() {
    abstract fun favoriteDao():FavoriteDao
    companion object{
        private var INSTANCE : FavoriteDb? = null
        fun getInstance(context : Context):FavoriteDb? {
            if (INSTANCE == null){
                synchronized(FavoriteDb::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        FavoriteDb::class.java,"User.db").build()
                }
            }
            return INSTANCE
        }
    }

}