package com.example.recyclerviewsuperheroes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsuperheroes.R
import com.example.recyclerviewsuperheroes.data.Datasource
import com.example.recyclerviewsuperheroes.databinding.ItemHeroeBinding
import com.example.recyclerviewsuperheroes.model.Heroe

class SuperHeroeAdapter(private val Dataset: List<Heroe>) :
    RecyclerView.Adapter<SuperHeroeAdapter.SuperViewHolder>() {

    private val data = Datasource().loadHeroes()

    class SuperViewHolder(private val view: View?) : RecyclerView.ViewHolder(view!!) {
        val photo: ImageView = view!!.findViewById(R.id.ivSuperHero)
        val hero: TextView = view!!.findViewById(R.id.tvHero)
        val name: TextView = view!!.findViewById(R.id.tvRealName)
        val publisher: TextView = view!!.findViewById(R.id.tvPublisher)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_heroe, parent, false)

        return SuperViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: SuperViewHolder, position: Int) {
        val item = Dataset[position]
        //holder.photo.setImageResource(item.photo)
        holder.hero.setText(item.Heroe)
        holder.name.setText(item.realName)
        holder.publisher.setText(item.publisher)
        Glide.with(holder.photo.context).load(item.photo).into(holder.photo)
        holder.photo.setOnClickListener {
            Toast.makeText(
                holder.photo.context,
                item.realName,
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount(): Int {
        return Dataset.size
    }


}