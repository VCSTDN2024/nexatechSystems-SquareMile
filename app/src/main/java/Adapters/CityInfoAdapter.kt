package Adapters

import Models.CityInfoResponse
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.squaremilev1.R

class CityInfoAdapter(
    private val hotels: List<CityInfoResponse.Hotel>,
    private val restaurants: List<CityInfoResponse.Restaurant>,
    private val pois: List<CityInfoResponse.Poi>
) : RecyclerView.Adapter<CityInfoAdapter.CityInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city_info, parent, false)
        return CityInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityInfoViewHolder, position: Int) {
        if (position < hotels.size) {
            holder.title.text = hotels[position].hotel_name
            holder.address.text = hotels[position].address
        } else if (position < hotels.size + restaurants.size) {
            val restaurantIndex = position - hotels.size
            holder.title.text = restaurants[restaurantIndex].name
            holder.address.text = restaurants[restaurantIndex].address
        } else {
            val poiIndex = position - hotels.size - restaurants.size
            holder.title.text = pois[poiIndex].name
            holder.address.text = pois[poiIndex].address
        }
    }

    override fun getItemCount(): Int {
        return hotels.size + restaurants.size + pois.size
    }

    class CityInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textViewTitle)
        val address: TextView = itemView.findViewById(R.id.textViewAddress)
    }
}
