package com.feelme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class ParamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_params)

        val setImage = findViewById(R.id.setImage) as ImageView
        val feelMeImage = findViewById(R.id.feelMeImage) as ImageView
        val notifImage = findViewById(R.id.notifImage) as ImageView
        val userImage = findViewById(R.id.userImage) as ImageView

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitle(null)
        setSupportActionBar(toolbar)

        setImage.setOnClickListener {
            val intent = Intent(this, PreferenceActivity::class.java)
            startActivity(intent);

        }
        feelMeImage.setOnClickListener {
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent);
        }
        notifImage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);

        }
        userImage.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
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
            val intent = Intent(this, ParamsActivity::class.java)
            startActivity(intent);
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
