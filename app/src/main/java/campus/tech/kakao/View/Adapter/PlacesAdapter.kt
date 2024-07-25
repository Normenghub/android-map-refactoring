package campus.tech.kakao.View.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import campus.tech.kakao.Model.Place
import campus.tech.kakao.View.Utils.CategoryGroupCode
import campus.tech.kakao.map.R

class PlacesAdapter(private var places: List<Place>, private val onItemClick: (Place) -> Unit) : RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder>() {

    private val categoryGroupCode = CategoryGroupCode()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        return PlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]
        holder.nameTextView.text = place.placeName
        holder.addressTextView.text = place.roadAddressName
        holder.categoryTextView.text = categoryGroupCode.CodeToCategory[place.categoryName] ?: ""
        holder.itemView.setOnClickListener {
            onItemClick(place)
        }
    }

    override fun getItemCount(): Int {
        return places.size
    }

    fun updateData(newPlaces: List<Place>) {
        places = newPlaces
        notifyDataSetChanged()
    }

    class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val addressTextView: TextView = itemView.findViewById(R.id.addressTextView)
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
    }
}