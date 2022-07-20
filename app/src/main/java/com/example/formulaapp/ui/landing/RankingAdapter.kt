package com.example.formulaapp.ui.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.formulaapp.R
import com.example.formulaapp.model.Driver
import kotlinx.android.synthetic.main.item_ranking.view.*

class RankingAdapter : RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {

    private var drivers: List<Driver> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        return RankingViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        val driver = drivers[position]
        holder.bind(driver)
    }

    override fun getItemCount(): Int = drivers.size

    fun setDrivers(drivers: List<Driver>){
        this.drivers = drivers
        notifyDataSetChanged()
    }

    class RankingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(driver: Driver) {
            itemView.apply {
                Glide.with(driverPhoto)
                    .load("https://picsum.photos/200/300")
                    .into(driverPhoto)
                driverName.text = driver.driverName
                driverTeamName.text = driver.teamName
                driverNationality.text = driver.nationality
                driverPosition.text = driver.position.toString()
                driverPoints.text = driver.points
            }
        }

        companion object{
            fun from(parent: ViewGroup): RankingViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val itemView = inflater.inflate(R.layout.item_ranking, parent, false)
                return RankingViewHolder(itemView)
            }
        }
    }
}