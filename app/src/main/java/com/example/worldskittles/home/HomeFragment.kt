package com.example.worldskittles.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.worldskittles.R
import com.example.worldskittles.common.Network
import com.example.worldskittles.common.dto.Game
import com.example.worldskittles.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var games: List<Game>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.biggamesrv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.smallitemrv.layoutManager = LinearLayoutManager(context)
        lifecycleScope.launch {
            games = Network.apiService.getGames()
            binding.biggamesrv.adapter = GameBigItemAdapter(games)
            binding.smallitemrv.adapter = GameSmallItemAdapter(games)
        }

        return binding.root
    }
}