package com.example.worldskittles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.worldskittles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding:ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        val navController = navHostFragment!!.findNavController()

        binding.bottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> navController.navigate(R.id.homeFragment)
                R.id.rating -> navController.navigate(R.id.ratingFragment)
                R.id.profile -> navController.navigate(R.id.profileFragment)
            }
            true
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.signInFragment) {
                binding.bottomNavigationBar.visibility = View.GONE
            } else {
                binding.bottomNavigationBar.visibility = View.VISIBLE
            }
        }
    }
}