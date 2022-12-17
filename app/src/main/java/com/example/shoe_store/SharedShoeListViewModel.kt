package com.example.shoe_store





import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoe_store.model.ShoeItem


class SharedShoeListViewModel : ViewModel() {
    private val shoe1 : ShoeItem = ShoeItem("adidas27" , "adidas" , "44" , "adidas shoeses")
    private val shoe2 : ShoeItem = ShoeItem("adidas57" , "adidas" , "48" , "adidas shoeses")
    private val shoe3 : ShoeItem = ShoeItem("nike88263" , "nike" , "41" , "nike shoeses")

    private val _shoeList = MutableLiveData<List<ShoeItem>>().apply {
       value = listOf(shoe1 , shoe2 ,  shoe3)
    }
    var shoeList: LiveData<List<ShoeItem>> = _shoeList
    var newItem = MutableLiveData<ShoeItem>()



    fun addItem(shoeName: String , companyName: String , shoeSize: String , describtion: String) {

        val shoeItem : ShoeItem = ShoeItem(shoeName , companyName, shoeSize , describtion)
//        _shoeList.value?.plus(shoeItem)
        _shoeList.apply {
            value = shoeList.value?.plus(shoeItem)
            println(value!!.size)
        }
        println(_shoeList.value!!.size)
    }


}
