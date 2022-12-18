package com.example.shoe_store.ui.AddShoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.shoe_store.R
import com.example.shoe_store.SharedShoeListViewModel
import com.example.shoe_store.databinding.FragmentAddShoeBinding



class AddShoeFragment : Fragment() {

    private var _binding: FragmentAddShoeBinding? = null //
     private val sharedShoeListViewModel : SharedShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var text : String
        _binding = FragmentAddShoeBinding.inflate(inflater, container, false)

        _binding!!.lifecycleOwner = this

        _binding!!.cancelButton.setOnClickListener { view->
            view.findNavController().navigate(R.id.shoeListFragment)
        }
        _binding!!.shoeListViewModel = sharedShoeListViewModel
        _binding!!.view = _binding!!.root

        return _binding!!.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}