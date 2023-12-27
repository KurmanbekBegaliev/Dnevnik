package com.example.dnevnik.ui.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.dnevnik.databinding.NewsItemBinding
import com.squareup.picasso.Picasso

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val list = arrayListOf(
        News(
            "Бразилец в команде ОшГУ",
            "https://www.oshsu.kg/storage/uploads/zUinvnSKGDXCyXTtSh7YoYkUDmnfaC2lCEJ5vcX5.jpeg",
            "Команда ОшГУ по мини футболу с 16 очками после первого круга Суперлиги вышел во второй круг.  Завтра, 28 декабря команда \"Университе..."
        ),
        News(
            "Зимние каникулы для студентов",
            "https://www.oshsu.kg/storage/uploads/pXBLWwWb2hEXWVn5DnD1p7gTJKUMdsw9penZWU1h.jpeg",
            "Студенты бакалавриата отдохнут с 1 по 7 января 2024 года. С 8 по 20 января будут сдавать зимнюю сессию, а с 22 по 28 января - дни отдыха. Весенний семестр начнется с 29 января согласно расписания.\n" +
                    "Студенты колледжей(кроме узгенского медколледжа) отдыхают с 1 по 14 января 2024 года. "
        ),
        News(
            "Состоялся научно-методический семинар",
            "https://www.oshsu.kg/storage/uploads/5aMEso3ziWvVvdre4cBVO6UOb5vXQL0NEiGO7pZm.jpeg",
            "В ОшГУ прошел семинар \"Источники финансирования научных исследований в Европе и Германии\"(на примере использования в жизни нанотехнологий). Спикером выступил научный координатор научного центра нанотехнологий в Германии, доктор технических наук, профессор Талант Рыспаев."
        )
    )

    inner class ViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.apply {
                tvTitle.text = news.title
                tvDesc.text = news.desc

                Picasso.get()
                    .load(news.img)
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