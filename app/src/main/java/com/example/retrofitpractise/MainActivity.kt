package com.example.retrofitpractise

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitpractise.data.Cart
import com.example.retrofitpractise.data.JsonData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var retrofitServices: RetrofitServices
    private lateinit var builder: Builder
    private lateinit var cartsViewModel: CartsViewModel
    private lateinit var cartsViewModelFactory: CartsViewModelFactory
    private lateinit var repo: Repo
    private lateinit var rv1 : RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        repo = Repo(Builder.getInstance())

        // builder = Builder()
        cartsViewModelFactory = CartsViewModelFactory(repo)
        rv1 = findViewById(R.id.list1)
        progressBar = findViewById(R.id.pb1)


        cartsViewModel = ViewModelProvider(this, cartsViewModelFactory).get(CartsViewModel::class.java)
        cartsViewModel.carts.observe(this){
            cartAdapter = CartAdapter(it.carts)
            rv1.layoutManager = LinearLayoutManager(this)
            rv1.adapter = cartAdapter
        }

        cartsViewModel.isLoading.observe(this){
            if (it){
                progressBar.visibility = View.VISIBLE
            }
            else{
                progressBar.visibility = View.GONE
            }
        }


    }
}