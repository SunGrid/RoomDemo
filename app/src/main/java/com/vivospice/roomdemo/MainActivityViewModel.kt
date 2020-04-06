package com.vivospice.roomdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import java.util.*


private const val TAG = "MainActivityViewMod"

class MainActivityViewModel : ViewModel() {

    private lateinit var myRandomNumber: MutableLiveData<String>

    fun getNumber(): MutableLiveData<String> { //which way is better??? fun getNumber(): LiveData<String> {
        Log.i(TAG, "Get number")

        if(!::myRandomNumber.isInitialized) {
            myRandomNumber = MutableLiveData()
            this.createNumber()
        }

        //return MutableLiveData<String>(myRandomNumber)
        return myRandomNumber
    }

  fun createNumber(){
        Log.i(TAG, "Create new number")

        val random = Random()
        //myRandomNumber = "Number: ${random.nextInt(10 - 1 ) }"
        myRandomNumber.value = "Number: ${random.nextInt(10 - 1 ) }"
    }
}