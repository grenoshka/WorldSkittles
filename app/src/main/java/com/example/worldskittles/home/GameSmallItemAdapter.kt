package com.example.worldskittles.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.worldskittles.common.dto.Game
import com.example.worldskittles.databinding.GameSmallWidgetBinding
import com.squareup.picasso.Picasso

class GameSmallItemAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GameSmallItemAdapter.GameSmallItemViewHolder>() {
    inner class GameSmallItemViewHolder(private val binding: GameSmallWidgetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Game) {
            binding.textView4.text = item.title
            Picasso.get().load(item.previewUrl).into(binding.imageView2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameSmallItemViewHolder {
        val binding =
            GameSmallWidgetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameSmallItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameSmallItemViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size
}