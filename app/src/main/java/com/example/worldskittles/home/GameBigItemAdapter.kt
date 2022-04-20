package com.example.worldskittles.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.worldskittles.common.dto.Game
import com.example.worldskittles.databinding.GameBigItemBinding
import com.squareup.picasso.Picasso

class GameBigItemAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GameBigItemAdapter.GameBigItemViewHolder>() {
    inner class GameBigItemViewHolder(private val binding: GameBigItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Game) {
            binding.textView4.text = item.title
            Picasso.get().load(item.previewUrl).into(binding.imageView2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameBigItemViewHolder {
        val binding = GameBigItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameBigItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameBigItemViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size
}