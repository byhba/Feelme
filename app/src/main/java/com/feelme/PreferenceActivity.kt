package com.feelme

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class PreferenceActivity : AppCompatActivity() {

    lateinit var pref1 : Spinner
    lateinit var pref2 : Spinner
    lateinit var pref3 : Spinner
    lateinit var pref4 : Spinner
    lateinit var pref5 : Spinner
    lateinit var pref6 : Spinner
    lateinit var sex : Spinner
    lateinit var spinresult: TextView
    lateinit var name: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        name = findViewById(R.id.name) as EditText
        sex = findViewById(R.id.sex) as Spinner
        pref1 = findViewById(R.id.pref1) as Spinner
        pref2 = findViewById(R.id.pref2) as Spinner
        pref3 = findViewById(R.id.pref3) as Spinner
        pref4 = findViewById(R.id.pref4) as Spinner
        pref5 = findViewById(R.id.pref5) as Spinner
        pref6 = findViewById(R.id.pref6) as Spinner
        spinresult = findViewById(R.id.spinresult) as TextView
        val cancelPref = findViewById(R.id.cancelPref) as Button
        val savePrefs = findViewById(R.id.savePrefs) as Button


        val listPref1 = arrayOf("Soft","Walking","Sleeping","Singing","Reading","Watching TV","Go to beach")
        val listPref2 = arrayOf("Hard outside","Running","Playing Basket","Playing Foot","Playing Hockey","Swimming")
        val listPref3 = arrayOf("Hard inside","Walking","Sleeping","Singing")
        val listPref4 = arrayOf("Mental","Playing game","Reading")
        val listPref5 = arrayOf("Old","None if you are not old","listen to music","reading","walking")
        val listPref6 = arrayOf("At work","Take a break","Drink water","Drink coffee")
        val listSex = arrayOf("Sex","Male","Female")


        pref1.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listPref1)
        pref2.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listPref2)
        pref3.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listPref3)
        pref4.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listPref4)
        pref5.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listPref5)
        pref6.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listPref6)

        sex.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listSex)



        pref1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            var spref1 = ""
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinresult.text = ""
        }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinresult.text = listPref1.get(position)
                spref1 = listPref1.get(position)
            }
        }

        pref2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            var spref2 = ""
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinresult.text = ""
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinresult.text = listPref2.get(position)
                spref2 = listPref2.get(position)
            }
        }

        pref3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            var spref3 = ""
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinresult.text = ""
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinresult.text = listPref3.get(position)
                spref3 = listPref3.get(position)
            }
        }

        pref4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            var spref4 = ""
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinresult.text = ""
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinresult.text = listPref4.get(position)
                spref4 = listPref4.get(position)
            }
        }

        pref5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            var spref5 = ""
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinresult.text = ""
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinresult.text = listPref5.get(position)
                spref5 = listPref5.get(position)
            }
        }

        pref6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            var spref6 = ""
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinresult.text = ""
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinresult.text = listPref6.get(position)
                spref6 = listPref6.get(position)
            }
        }

        sex.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            var ssex = ""
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinresult.text = ""
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinresult.text = listSex.get(position)
                ssex = listSex.get(position)
            }
        }

        cancelPref.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
//            Toast.makeText(this@MainActivity, "Cancel.", Toast.LENGTH_SHORT).show()
        }

        savePrefs.setOnClickListener {
//            saveData
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
//            Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_SHORT).show()
        }

        //saving data
        fun saveData(view: View) {
            val aff = name.text.toString()
            Toast.makeText(this, "$aff", Toast.LENGTH_LONG).show()
            val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
            with(sharedPref.edit()) {
                putString("name", name.text.toString())
//                putString("sex", ssex.toString())
//                putString("pref1", spref1.toString())
//                putString("pref2", name.text.toString())
//                putString("pref3", name.text.toString())
//                putString("pref4", name.text.toString())
//                putString("pref5", name.text.toString())
//                putString("pref6", name.text.toString())
                commit()
            }
        }

        fun getData(view: View) {
            val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
            val str_name = sharedPref.getString("name", "")
            Toast.makeText(this, "$str_name", Toast.LENGTH_LONG).show()

        }
    }
}
