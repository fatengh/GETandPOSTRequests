package com.example.getandpostrequests

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
    private lateinit var btnAdd: Button
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)
        btnAdd = findViewById(R.id.btnAdd)
        if (apiInterface != null) {
            apiInterface.getName().enqueue(object : Callback<Data?> {
                override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                    val names = response.body()!!
                    var text = ""
                    for (name in names) {
                        text += " ${name.pk}\n ${name.name}\n\n"
                    }
                    tv.text = text
                }

                override fun onFailure(call: Call<Data?>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error ", Toast.LENGTH_SHORT).show()

                }
            })
        }
        btnAdd.setOnClickListener {
            startActivity(Intent(applicationContext, AddName::class.java))
        }
    }


}