package com.feelme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitle(null)
        toolbar.setLogo(R.drawable.logox4x)
        setSupportActionBar(toolbar)

        startFeel.setOnClickListener(){
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent);
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.layout, menu)
        return true
    }

    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.parameter -> {
            val intent = Intent(this, ParamsActivity::class.java)
            startActivity(intent);
            true
        }
        R.id.lang -> {
            msgShow("Lang")
            val intent = Intent(this, ParamsActivity::class.java)
            startActivity(intent);
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun msgShow(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
