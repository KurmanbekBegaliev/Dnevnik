package com.example.dnevnik.ui.fragments.schedule.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dnevnik.databinding.ScheduleItemBinding

class ScheduleExploreAdapter : RecyclerView.Adapter<ScheduleExploreAdapter.ViewHolder>() {

    private var list = arrayListOf(
        Schedule("Русский язык", "8:00-8:45", "Упражнения 135, 137", "Кабинет 204", "1 урок"),
        Schedule("Литература", "8:55-9:40", " Читать поэму Н.Некрасова \n\"Кому на руси жить хорошо\"", "Кабинет 213", "2 урок"),
        Schedule("Алгебра", "9:50-10:35", "Решить №234, №236, №237", "Кабинет 202", "3 урок"),
        Schedule("Общесвознание", "10:55-11:40", "Доманшее задание не задано", "Кабинет 209", "4 урок"),
        Schedule("История", "11:50-12:35", "Первая мировая", "Кабинет 206", "5 урок"),
    )

    inner class ViewHolder(private val binding: ScheduleItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(schedule: Schedule) {
            with(binding){
                tvLessonTitle.text = schedule.title
                tvHomework.text = schedule.homework
                tvLessonTime.text = schedule.time
                tvLessonRoom.text = schedule.room
                tvLessonNumber.text = schedule.lessonNumber
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ScheduleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}