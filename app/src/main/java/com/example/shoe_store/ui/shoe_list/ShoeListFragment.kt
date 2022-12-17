package com.example.shoe_store.ui.shoe_list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import androidx.fragment.app.activityViewModels

import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoe_store.R
import com.example.shoe_store.SharedShoeListViewModel
import com.example.shoe_store.databinding.CardViewBinding


import com.example.shoe_store.databinding.FragmentShoeListBinding



class ShoeListFragment : Fragment() {

    private var _binding: FragmentShoeListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val sharedShoeListViewModel : SharedShoeListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentShoeListBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
            // this to show the predefined shoe items
        sharedShoeListViewModel.shoeList.value?.forEach { shoeItem ->
            val cardBinder =  CardViewBinding.inflate(inflater, container, false)
            cardBinder.shoeItem = shoeItem
            binding.customLayout.addView(cardBinder.root)
        }
        // this to add navigation to floating action button
        binding.addItem.setOnClickListener{view->
            view.findNavController().navigate(R.id.addShoe)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.bottom_nav_menu , menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        requireView().findNavController().navigate(R.id.loginFragment)
        return NavigationUI.onNavDestinationSelected(item ,requireView().findNavController() )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


