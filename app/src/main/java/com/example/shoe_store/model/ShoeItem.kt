package com.example.shoe_store.model

class ShoeItem(shoeName: String = "", companyName: String = "", shoeSize: String = "", describtion: String = "") {

    var shoeName : String = ""
    var companyName:String =""
    var shoeSize:String =""
    var describtion:String =""
    // initializer block
    init {
        this.shoeName = shoeName
        this.companyName = companyName
        this.shoeSize = shoeSize
        this.describtion = describtion
    }
}