package com.example.retrofitpractise

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitpractise.data.Cart
import com.example.retrofitpractise.data.Product
import kotlinx.coroutines.withContext

class CartAdapter(
    private val listOfCart: List<Cart>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(
        view : View
    ) : RecyclerView.ViewHolder(view){
        val cartDiscountedTotal : TextView = view.findViewById(R.id.txt6)
        val productsRV : RecyclerView = view.findViewById(R.id.second_list)
        val cartID : TextView = view.findViewById(R.id.txt1)
        val cartTotal : TextView = view.findViewById(R.id.txt5)
        val cartTotalProducts : TextView = view.findViewById(R.id.txt3)
        val cartTotalQuantity : TextView = view.findViewById(R.id.txt4)
        val cartUserID : TextView = view.findViewById(R.id.txt2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_items, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfCart.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        var cartList = listOfCart[position]

        holder.cartID.text = "Cart ID: ${cartList.id}"
        holder.cartUserID.text = "User ID: ${cartList.userId}"
        holder.cartTotal.text = "Total: ${cartList.total}"
        holder.cartDiscountedTotal.text = "Discounted Total: ${cartList.discountedTotal}"
        holder.cartTotalProducts.text = "Total Products: ${cartList.totalProducts}"
        holder.cartTotalQuantity.text = "Total Quantity: ${cartList.totalQuantity}"


        holder.productsRV.layoutManager = LinearLayoutManager(holder.itemView.context)
        val productAdapter = ProductAdapter(cartList.products)
        holder.productsRV.adapter = productAdapter




    }
}