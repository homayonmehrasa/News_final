package com.example.news

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val items: ArrayList<Mysources>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    private var clickListener: ClickListener? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewitems , parent, false))
    }


    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("CheckResult", "SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val titletext = items[position].title


        val context = holder.image.context
        Glide.with(context).load(items[position].urlToImage).into(holder.image)
        holder.desctv.text = items[position].description
        holder.titletv.text =titletext
        holder.datetv.text = items[position].getstringdate().toString()
        holder.itemView.setOnClickListener(holder)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.image.transitionName = items[position].urlToImage
        }


    }



    interface ClickListener {
        fun onItemClick(v: View,position: Int)
    }

    fun setOnItemClickListener(clickListener: ClickListener) {

        this.clickListener = clickListener

    }


   inner  class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener {
        val desctv = view.findViewById<TextView>(R.id.DescTextView)
        val titletv = view.findViewById<TextView>(R.id.TitleTextView)
        val datetv = view.findViewById<TextView>(R.id.DateTextview)
        val image = view.findViewById<ImageView>(R.id.newsimageView)


    override fun onClick(v: View?) {
        if (v != null) {
            clickListener?.onItemClick(v, adapterPosition)


        }

    }
}
}
