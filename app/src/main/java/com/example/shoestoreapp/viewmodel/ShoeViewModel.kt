package com.example.shoestoreapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreapp.model.Shoe

class ShoeViewModel  : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList


    var name = ""
    var size = ""
    var company = ""
    var desciption = ""

    init {
        _shoeList.value = mutableListOf()
    }


    fun addShoe(): Boolean {

        if (!chackAllField()) return false

        addShoe(
            name,
            size.toDouble(),
            company,
            desciption
        )

        return true
    }



    private fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)
        _shoeList.value!!.add(shoe)
    }

    private fun chackAllField(): Boolean {

        if (name.isEmpty() ||
            company.isEmpty() ||
            size.isEmpty()  ||
            desciption.isEmpty()) {
            return false
        }
        return true
    }
}