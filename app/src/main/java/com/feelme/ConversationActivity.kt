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
//import com.pusher.client.Pusher;
//import com.pusher.client.channel.Channel;
//import com.pusher.client.channel.SubscriptionEventListener;
//import com.pusher.client.PusherOptions
import ai.api.android.AIConfiguration
import ai.api.AIDataService
import ai.api.AIListener
import ai.api.AIServiceContextBuilder
import ai.api.android.AIService
import ai.api.model.AIError
import ai.api.model.AIRequest
import ai.api.model.AIResponse
import com.google.gson.JsonElement


import kotlinx.android.synthetic.main.activity_conversation.*



class ConversationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        val btnSend = findViewById(R.id.btnSend) as Button
        val btnSpeak = findViewById(R.id.btnSpeak) as Button
        val txtMessage = findViewById(R.id.txtMessage) as EditText
        val message = txtMessage.text.toString()
        val REQUEST_INTERNET: Int = 200
        val aiService: AIService
//        val config: AIConfiguration = AIConfiguration("055722382ba048799a104a3cf2d2137c",
//            ai.api.AIConfiguration.SupportedLanguages.fromLanguageTag("ENGLISH"),
//            AIConfiguration.RecognitionEngine.System)
//            aiService = AIService.getService(this,config)
//            aiService.setListener(this)


//        val options = PusherOptions()
//        options.setCluster("eu")
//        val pusher = Pusher("28b88b9f769727f3bf35", options)

//        val channel = pusher.subscribe("my-channel")


        if(isNetworkAvailable()) {
            Toast.makeText(this,R.string.message_connexion,Toast.LENGTH_LONG).show()
//          User interface management
//            Communication vocale
            btnSpeak.setOnClickListener(){
                Toast.makeText(this,R.string.MessageVocalGuide, Context.MODE_PRIVATE).show()
            }
            btnSend.setOnClickListener(){
                if(!txtMessage.text.isEmpty() && txtMessage.text != null){
                    Toast.makeText(this,txtMessage.text.toString(), Context.MODE_PRIVATE).show()
//          Pusher connexion for dialogflow
//                channel.bind(
//                    "my-event"
//                ) { channelName, eventName, data -> println(data) }
//                pusher.connect()
                    txtMessage.setText("")
                }

            }



        } else{
            Toast.makeText(this, R.string.message_no_connexion, Toast.LENGTH_LONG).show()
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
