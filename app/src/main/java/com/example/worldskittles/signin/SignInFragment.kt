package com.example.worldskittles.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.SnackbarDuration
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.worldskittles.R
import com.example.worldskittles.common.Network
import com.example.worldskittles.common.Token
import com.example.worldskittles.common.dto.LoginBody
import com.example.worldskittles.databinding.FragmentSignInBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null;
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            val text = binding.textInputLayout.editText?.text
            if (text?.isNotBlank() == true) {
                lifecycleScope.launch {
                    try {
                        val result = Network.apiService.login(LoginBody(text.toString()))
                        Token.accessToken = result.accessToken.token
                        Token.refreshToken = result.refreshToken.token
                        findNavController().navigate(R.id.homeFragment)
                    } catch (e: Throwable) {
                        Snackbar.make(binding.root, "Ошибка ${e.cause}", Snackbar.LENGTH_SHORT).show()
                    }
                }
            } else {
                Snackbar.make(binding.root, "Напишите свой никнейм", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}