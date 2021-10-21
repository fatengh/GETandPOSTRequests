package com.example.getandpostrequests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddName : AppCompatActivity() {
    private lateinit var ed: EditText
    private lateinit var btn: Button
    val apiInterface=APIClient().getClient()?.create(APIInterface::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_name)
        ed = findViewById(R.id.ed)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            val newName=DataItem(ed.text.toString())
            if (apiInterface!=null){
                apiInterface.addName(newName).enqueue(object : Callback<DataItem?> {
                    override fun onResponse(call: Call<DataItem?>, response: Response<DataItem?>) {
                        ed.setText("")
                        Toast.makeText(applicationContext, "user added", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<DataItem?>, t: Throwable) {
                        Toast.makeText(applicationContext, "Error ", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }}}