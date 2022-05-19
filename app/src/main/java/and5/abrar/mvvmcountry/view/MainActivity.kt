package and5.abrar.mvvmcountry.view

import and5.abrar.mvvmcountry.R
import and5.abrar.mvvmcountry.data.datastore.DataStoreManager
import and5.abrar.mvvmcountry.viewmodel.ViewModelCountry
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.free.activity_main.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.Switcher
import kotlinx.android.synthetic.main.activity_main.rvCountry
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel : ViewModelCountry by viewModels()
    private lateinit var dataStoreManager: DataStoreManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataStoreManager = DataStoreManager(this)
        dataStoreManager.boolean.asLiveData().observe(this){
            Switcher.isChecked = it
            viewModel.getApiCountry()
            if (it){
                viewModel.liveDataCountry.observe(this){ data ->
                    rvCountry.layoutManager = LinearLayoutManager(this)
                    rvCountry.adapter = AdapterCountry(data!!)
                }
            }else{
                viewModel.liveDataCountry.observe(this){ data ->
                    rvCountry.layoutManager = GridLayoutManager(this, 2)
                    rvCountry.adapter = AdapterCountryGrid(data!!)
                }
            }

            Switcher.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    GlobalScope.launch {
                        dataStoreManager.saveData(true)
                    }
                } else {
                    GlobalScope.launch {
                        dataStoreManager.saveData(false)
                    }
                }
            }
            btn_fav.setOnClickListener {
                startActivity(Intent(this, FavoriteAcitivity::class.java))
                finish()
            }
        }

    }
}