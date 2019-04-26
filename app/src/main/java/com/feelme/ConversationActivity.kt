package com.feelme

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.PusherOptions
import kotlinx.android.synthetic.main.activity_conversation.*


class ConversationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        val btnSend = findViewById(R.id.btnSend) as Button
        val txtMessage = findViewById(R.id.txtMessage) as EditText
        val message = txtMessage.text.toString()

        val options = PusherOptions()
        options.setCluster("eu")
        val pusher = Pusher("28b88b9f769727f3bf35", options)

        val channel = pusher.subscribe("my-channel")


        if(isNetworkAvailable()) {
            Toast.makeText(this,"Connexion available",Toast.LENGTH_LONG).show()

//          Pusher connexion for dialogflow
            channel.bind(
                "my-event"
            ) { channelName, eventName, data -> println(data) }
            pusher.connect()

//          User interface management
            btnSend.setOnClickListener(){
                Toast.makeText(this,txtMessage.text.toString(), Context.MODE_PRIVATE).show()
            }



        } else{
            Toast.makeText(this, "Pas de connexion internet", Toast.LENGTH_LONG).show()
        }
    }
    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }
}
