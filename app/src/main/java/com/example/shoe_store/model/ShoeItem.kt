package com.example.shoe_store.model

class ShoeItem(shoeName: String = "", companyName: String = "", shoeSize: String = "", description: String = "") {

    var shoeName : String = ""
    var companyName:String =""
    var shoeSize:String =""
    var description:String =""
    // initializer block
    init {
        this.shoeName = shoeName
        this.companyName = companyName
        this.shoeSize = shoeSize
        this.description = description
    }
}