package com.example.recyclerviewsuperheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsuperheroes.adapter.SuperHeroeAdapter
import com.example.recyclerviewsuperheroes.data.Datasource
import com.example.recyclerviewsuperheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize data.
        val myDataset = Datasource().loadHeroes()
        val manager = LinearLayoutManager(this)


        binding.recyclerViewHeroes.adapter = SuperHeroeAdapter(myDataset)

        // initRecyclerView()
    }

    //fun initRecyclerView() {

    //}
}