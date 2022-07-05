package com.hrishikesh.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NewsAdapter(private val context: Context, private val itemList: ArrayList<NewsModel>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textTime:TextView = view.findViewById(R.id.timeTv)
        val textSource:TextView = view.findViewById(R.id.sourceTv)
        val textHeading: TextView = view.findViewById(R.id.headingTv)
        val textContent:TextView = view.findViewById(R.id.contentTv)
        val newsImage : ImageView = view.findViewById(R.id.imgNews)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_view, parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
      val news = itemList[position]
        holder.textTime.text = news.publishedAt
        holder.textSource.text = news.source.name
        holder.textHeading.text = news.newsTitle
        holder.textContent.text = news.newsDescription
        Picasso.get().load(news.newsImage).error(R.drawable.ic_launcher_foreground)
            .into(holder.newsImage)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}