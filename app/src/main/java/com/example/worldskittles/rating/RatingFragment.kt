package com.example.worldskittles.rating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.worldskittles.R
import com.example.worldskittles.common.dto.Rating
import com.example.worldskittles.databinding.FragmentRatingBinding

class RatingFragment : Fragment() {
    private var _binding: FragmentRatingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRatingBinding.inflate(layoutInflater, container, false)

        binding.rv.layoutManager = LinearLayoutManager(context)
        binding.rv.adapter = RatingAdapter(
            buildList {
                add(Rating("", userNickname = "Abrakadabra", points = 500))
            }
        )

        return binding.root
    }
}