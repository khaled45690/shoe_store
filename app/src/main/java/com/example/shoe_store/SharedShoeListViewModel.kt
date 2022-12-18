package com.example.shoe_store





import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.shoe_store.model.ShoeItem
import com.google.android.material.snackbar.Snackbar

// this is a shared model through out the activity
// to maintaine data through out fragment easier
class SharedShoeListViewModel : ViewModel() {
    private val shoe1: ShoeItem = ShoeItem("adidas27", "adidas", "44", "adidas shoeses")
    private val shoe2: ShoeItem = ShoeItem("adidas57", "adidas", "48", "adidas shoeses")
    private val shoe3: ShoeItem = ShoeItem("nike88263", "nike", "41", "nike shoeses")
    var text: String = "saad"
    var newItem: ShoeItem = ShoeItem()
    private val _shoeList = MutableLiveData<List<ShoeItem>>().apply {
        value = listOf(shoe1, shoe2, shoe3)
    }
    var shoeList: LiveData<List<ShoeItem>> = _shoeList


    fun addItem(view: View) {
        if (newItem.shoeName.isNullOrBlank() || newItem.shoeSize.isNullOrBlank() || newItem.companyName.isNullOrBlank() || newItem.description.isNullOrBlank()) {
            Snackbar.make(
                view,
                "please make sure you full fill all text fields",
                Snackbar.LENGTH_LONG
            )
                .setAction("CLOSE") { }
                .setActionTextColor(view.context.resources.getColor(android.R.color.holo_red_light))
                .show()
        } else {
            _shoeList.apply {
                value = shoeList.value?.plus(newItem)
            }
            view.findNavController().navigate(R.id.shoeListFragment)
            newItem = ShoeItem()
        }

    }

    /*
        cancel function should be in addShoe viewModel not activityViewModel
        But there is no need to create View model for just one function
     */
    fun cancelButtonFunc(view: View) {
            view.findNavController().navigate(R.id.shoeListFragment)
        }

}
