package com.example.shoe_store.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.shoe_store.R
import com.example.shoe_store.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        _binding!!.signIn.setOnClickListener {  view ->
            view.findNavController().navigate(R.id.fragmentWelcome)
        }
        _binding!!.signupTextView.setOnClickListener {  view ->
            view.findNavController().navigate(R.id.fragmentWelcome)
        }

        return _binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}