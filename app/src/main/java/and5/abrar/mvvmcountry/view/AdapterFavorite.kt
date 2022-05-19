package and5.abrar.mvvmcountry.view

import and5.abrar.mvvmcountry.R
import and5.abrar.mvvmcountry.room.Favorite
import and5.abrar.mvvmcountry.room.FavoriteDb
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_country.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AdapterFavorite(private val listCountry: List<Favorite>):RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country,parent, false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listCountry[position]
        holder.itemView.namaNegara.text = listCountry[position].name
        Glide.with(holder.itemView.context)
            .load(listCountry[position].flag)
            .into(holder.itemView.gambarNegara)
        holder.itemView.timezone.text = "waktu : " + listCountry[position].timezones.toString()
        holder.itemView.populasi.text = "populasi : " + listCountry[position].population.toString()
        holder.itemView.capital.text = "Capital : " + listCountry[position].capital
        holder.itemView.region.text = "Region : " + listCountry[position].region
        holder.itemView.btn_fav.setOnClickListener {
            val mDb = FavoriteDb.getInstance(it.context)
            GlobalScope.async {
                val result = mDb?.favoriteDao()?.deleteFavorite(data)
                (holder.itemView.context as FavoriteAcitivity).runOnUiThread {
                    if (result != 0){
                        holder.itemView.btn_fav.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
                        Toast.makeText(it.context,"Removed from Favorite", Toast.LENGTH_SHORT).show()
                        (holder.itemView.context as FavoriteAcitivity).fetchData()
                    }else{
                        Toast.makeText(it.context,"Failed to Remove", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return listCountry.size
    }
}