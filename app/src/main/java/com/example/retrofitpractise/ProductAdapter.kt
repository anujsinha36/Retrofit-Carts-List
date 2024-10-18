package com.example.retrofitpractise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitpractise.data.Product
import de.hdodenhof.circleimageview.CircleImageView

class ProductAdapter(
    private val productsList: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(
        view : View
    ) : RecyclerView.ViewHolder(view){
        val productID : TextView = view.findViewById(R.id.pd_txt1)
        val productTitle : TextView = view.findViewById(R.id.pd_txt2)
        val productThumbnail : CircleImageView = view.findViewById(R.id.pd_txt3)
        val productPrice: TextView = view.findViewById(R.id.pd_txt4)
        val productQuantity : TextView = view.findViewById(R.id.pd_txt5)
        val productTotal : TextView = view.findViewById(R.id.pd_txt6)
        val productDiscountedTotal : TextView = view.findViewById(R.id.pd_txt7)
        val productDiscountPercentage : TextView = view.findViewById(R.id.pd_txt8)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.products_list, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productItems = productsList[position]
        holder.productID.text = "Product ID: ${productItems.id}"
        holder.productTitle.text = "Title: ${productItems.title}"
        holder.productQuantity.text = "Quantity: ${productItems.quantity}"
        holder.productPrice.text = "Price: ${productItems.price}"
        holder.productTotal.text = "Total: ${productItems.total}"
        holder.productDiscountedTotal.text = "Discounted Total: ${productItems.discountedTotal}"
        holder.productDiscountPercentage.text = "Discounted Percentage: ${productItems.discountPercentage}"

        Glide.with(holder.itemView.context).load(productItems.thumbnail).into(holder.productThumbnail)


    }
}