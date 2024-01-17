package com.example.dnevnik.ui.fragments.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dnevnik.data.models.NewsItem
import com.example.dnevnik.databinding.NewsItemBinding
import com.squareup.picasso.Picasso

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var list = arrayListOf<NewsItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(news: List<NewsItem>) {
        list = news as ArrayList<NewsItem>
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsItem) {
            binding.apply {
                tvTitle.text = news.tittle
                tvDesc.text = news.message

                Picasso.get()
                    .load(news.image)
                    .into(image)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}