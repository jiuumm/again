package com.example.again

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.again.databinding.ActivityMainBinding
import com.example.again.databinding.ActivityOtherBinding

class OtherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btn2.setOnClickListener{
            val myIntent2 = Intent(this, MainActivity::class.java)
            startActivity(myIntent2)

        }
    }
}