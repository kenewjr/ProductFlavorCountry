package and5.abrar.mvvmcountry.data.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(context: Context) {
    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "user_prefs")

    suspend fun saveData(boolean: Boolean){
        dataStore.edit {
            it[BOOL] = boolean
        }
    }

    val boolean : Flow<Boolean> = dataStore.data.map {
        it[BOOL] ?: false
    }

    companion object{
        val BOOL = preferencesKey<Boolean>("USER_NAME")
    }
}