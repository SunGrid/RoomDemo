package com.vivospice.ViewModelDemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG =  "MainActivity"

class MainActivity : AppCompatActivity() {

    //lateinit var  data: MainActivityDataGenerator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //model = MainActivityDataGenerator()
        // model = ViewModelProvider.of(this).get(MainActivityDataGenerator::class.java) deprecated???


        val viewModel: MainActivityViewModel by viewModels()

        val myRandomNumber = viewModel.getNumber()

        myRandomNumber.observe(this, Observer<String>{ number ->
            tvNumber.text = number
            Log.i(TAG, "Random Number Set")
        })

        bRandom.setOnClickListener{ viewModel.createNumber()}
    }

}
