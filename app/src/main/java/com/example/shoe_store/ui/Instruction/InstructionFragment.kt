package com.example.shoe_store.ui.Instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shoe_store.R
import com.example.shoe_store.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
    private var _binding: FragmentInstructionBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInstructionBinding.inflate(inflater, container, false)
        binding.navigaorButton.setOnClickListener {
            view-> view.findNavController().navigate(R.id.shoeListFragment)
        }
        return binding.root
    }


}