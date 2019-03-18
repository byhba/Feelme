package com.feelme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_main.*
//import android.view.toolbar

class MainActivity : AppCompatActivity() {

    var Toolbar toolbar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar = (toolbar) findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}
