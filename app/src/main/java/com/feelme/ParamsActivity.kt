package com.feelme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ParamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_params)

        val setImage = findViewById(R.id.setImage) as ImageView
        val feelMeImage = findViewById(R.id.feelMeImage) as ImageView
        val notifImage = findViewById(R.id.notifImage) as ImageView
        val userImage = findViewById(R.id.userImage) as ImageView

        setImage.setOnClickListener {
            val intent = Intent(this, PreferenceActivity::class.java)
            startActivity(intent);
            Toast.makeText(this, "Setting clicked.", Toast.LENGTH_SHORT).show()

        }
        feelMeImage.setOnClickListener {
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent);
            Toast.makeText(this, "Setting clicked.", Toast.LENGTH_SHORT).show()

        }
        notifImage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
            Toast.makeText(this, "Notif clicked.", Toast.LENGTH_SHORT).show()

        }
        userImage.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent);
            Toast.makeText(this, "User clicked.", Toast.LENGTH_SHORT).show()

        }
    }
}
