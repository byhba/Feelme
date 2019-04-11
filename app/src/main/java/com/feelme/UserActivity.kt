package com.feelme

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class UserActivity : AppCompatActivity() {


    lateinit var sex : Spinner
    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return

        name = findViewById(R.id.name) as EditText
        age = findViewById(R.id.age) as EditText
        email = findViewById(R.id.email) as EditText
        sex = findViewById(R.id.sex) as Spinner
        val cancelInfo = findViewById(R.id.cancelInfo) as Button
        val saveInfo = findViewById(R.id.saveInfo) as Button

        val listSex = arrayOf("Male","Female")

        sex.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listSex)

        sex.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            var ssex = ""
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                ssex = listSex.get(position)
            }
        }

        cancelInfo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this, "Canceled.", Toast.LENGTH_SHORT).show()
        }

        saveInfo.setOnClickListener {
            with(sharedPref.edit()) {
                putString("name", name.text.toString())
                putString("age", age.text.toString())
                putString("email", email.text.toString())
                commit()
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }

        fun saveInfo() {
            // Toast.makeText(this, "$aff", Toast.LENGTH_LONG).show()
            val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
            with(sharedPref.edit()) {
                putString("name", name.text.toString())
                putString("age", age.text.toString())
                putString("email", email.text.toString())
                commit()
            }
        }
    }
}
