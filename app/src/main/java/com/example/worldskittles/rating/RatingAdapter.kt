package com.example.worldskittles.rating

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.worldskittles.common.dto.Rating
import com.example.worldskittles.databinding.RatingItemBinding

class RatingAdapter(private val ratings: List<Rating>) : RecyclerView.Adapter<RatingAdapter.RatingViewHolder>() {
    inner class RatingViewHolder(val binding: RatingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Rating, index: Int) {
            binding.textView7.text = index.toString()
            binding.textView8.text = item.userNickname
            binding.textView9.text = item.points.toString() + 'k'
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        var binding = RatingItemBinding.inflate(LayoutInflater.from(parent.context))
        return RatingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        holder.bind(ratings[position], position + 1)
    }

    override fun getItemCount(): Int = ratings.size
}