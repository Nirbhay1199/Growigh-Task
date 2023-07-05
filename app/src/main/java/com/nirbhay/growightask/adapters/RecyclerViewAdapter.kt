package com.nirbhay.growightask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nirbhay.growightask.R
import kotlin.random.Random

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageFeed)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item2, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val url = "https://random.imagecdn.app/500/150"

        Glide.with(holder.itemView)
            .load(url+"?rand="+ Random.nextInt(100,10000))
            .timeout(20000)
            .placeholder(R.drawable.ic_launcher_foreground)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder.image)

    }

    fun onButtonClick() {
        for (i in 0..10) {
            notifyItemChanged(i)
        }
    }

}