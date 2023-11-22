package com.example.bathandbodyandbeyondinterview.breed_search_result

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bathandbodyandbeyondinterview.R

class DogImagesAdapter : RecyclerView.Adapter<DogImagesAdapter.DataViewHolder>() {
    val data = mutableListOf<String>()

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SuspiciousIndentation")
        fun bind(url: String) {
            if (url.isBlank()) {
                itemView.apply {
                    Glide.with(context)
                        .load(R.drawable.image_not_found)
                        .into(findViewById(R.id.ivImage))
                }
            }
            //Display error image
            else
                itemView.apply {
                    Glide.with(context)
                        .load(url)
                        .into(findViewById(R.id.ivImage))
                }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.itemView.apply {
            holder.bind(data[position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun displayImage(category: Collection<String>) {
        data.clear()
        data.addAll(category)
        notifyDataSetChanged()
    }
}
