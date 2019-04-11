package com.feelme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
//import android.view.toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preference = findViewById(R.id.preference) as Button
        val conversation = findViewById(R.id.conversation) as Button
        val user = findViewById(R.id.user) as Button
        val lang = findViewById(R.id.lang) as Button
        val params = findViewById(R.id.params) as Button

        preference.setOnClickListener {
            val intent = Intent(this, PreferenceActivity::class.java)
            startActivity(intent);
//            Toast.makeText(this@MainActivity, "You clicked on preference.", Toast.LENGTH_SHORT).show()

        }
        conversation.setOnClickListener {
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent);
//            Toast.makeText(this@MainActivity, "You clicked on preference.", Toast.LENGTH_SHORT).show()

        }
        params.setOnClickListener {
            val intent = Intent(this, ParamsActivity::class.java)
            startActivity(intent);
//            Toast.makeText(this@MainActivity, "You clicked on preference.", Toast.LENGTH_SHORT).show()

        }
        lang.setOnClickListener {
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent);
//            Toast.makeText(this@MainActivity, "You clicked on preference.", Toast.LENGTH_SHORT).show()

        }
        user.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent);
//            Toast.makeText(this@MainActivity, "You clicked on preference.", Toast.LENGTH_SHORT).show()

        }
    }
}
