package com.example.bathandbodyandbeyondinterview.breed_search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bathandbodyandbeyondinterview.R

class SearchAdapter(val routeToDetails: (String) -> Unit) : RecyclerView.Adapter<SearchAdapter.DataViewHolder>() {
    val data = mutableListOf<String>()

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_breed).text = data[position]
        }
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_breed).setOnClickListener {

                routeToDetails((it as TextView).text.toString())
            }
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(category: List<String>) {
        this.data.apply {
            clear()
            addAll(category)
            notifyDataSetChanged()
        }
    }
}