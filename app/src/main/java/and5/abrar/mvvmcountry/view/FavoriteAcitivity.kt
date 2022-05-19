package and5.abrar.mvvmcountry.view

import and5.abrar.mvvmcountry.R
import and5.abrar.mvvmcountry.room.FavoriteDb
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_favorite_acitivity.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoriteAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_acitivity)
        fetchData()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }
    fun fetchData() {
        val mDb = FavoriteDb.getInstance(this)
        GlobalScope.launch {
            val result = mDb!!.favoriteDao().getAllFavorite()
            runOnUiThread {
                if (result != null){
                    rv_country.layoutManager = LinearLayoutManager(this@FavoriteAcitivity)
                    rv_country.adapter = AdapterFavorite(result)
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        fetchData()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}