package com.akilanny.task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.akilanny.task.R
import com.akilanny.task.databinding.FragmentSplashBinding
import com.google.firebase.auth.FirebaseAuth

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        Handler(Looper.getMainLooper()).postDelayed({
            checkAuth()
        }, 3000)
    }

    private fun checkAuth(){
        try {
            val currentUser = auth.currentUser

            if (currentUser != null) {
                findNavController().navigate(resId = R.id.action_splashFragment3_to_homeFragment)
            }else{
                findNavController().navigate(resId = R.id.action_splashFragment3_to_autentication)
            }
        }catch ( e: Exception){
            Toast.makeText(context = requireContext(), text = e.message.toString(), duration = Toast.LENGTH_SHORT).show()
            findNavController().navigate(resId = R.id.action_splashFragment3_to_autentication)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
