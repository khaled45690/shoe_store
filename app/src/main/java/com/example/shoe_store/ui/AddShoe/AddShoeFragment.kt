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

import com.google.android.material.snackbar.Snackbar


class AddShoeFragment : Fragment() {

    private var _binding: FragmentAddShoeBinding? = null //
     private val sharedShoeListViewModel : SharedShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddShoeBinding.inflate(inflater, container, false)
        _binding!!.lifecycleOwner = this

        _binding!!.cancelButton.setOnClickListener { view->
            view.findNavController().navigate(R.id.shoeListFragment)
        }

        _binding!!.addButton.setOnClickListener { view->
            val shoeName : String = _binding!!.shoeNameTextField.text.toString()
            val shoeSize : String = _binding!!.shoeSizetextField.text.toString()
            val companyName : String = _binding!!.companyNameTextField.text.toString()
            val describtion : String = _binding!!.descriptionTextField.text.toString()
            if(shoeName.isNullOrBlank() ||shoeSize.isNullOrBlank() || companyName.isNullOrBlank() || describtion.isNullOrBlank()) {
                Snackbar.make(
                    view,
                    "please make sure you full fill all text fields",
                    Snackbar.LENGTH_LONG
                )
                    .setAction("CLOSE") { }
                    .setActionTextColor(resources.getColor(android.R.color.holo_red_light))
                    .show()
            }else{
                sharedShoeListViewModel.addItem(shoeName , companyName , shoeSize , describtion)
                _binding!!.invalidateAll()
                view.findNavController().navigate(R.id.shoeListFragment)
            }


        }

        return _binding!!.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}