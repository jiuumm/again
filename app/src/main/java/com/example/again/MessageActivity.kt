package com.example.again
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.again.databinding.ActivityMessageBinding
class MessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//이 화면에 들어올떄 첨부된 데이터를 텍스트 뷰에 반영.
        val intentMessage = intent.getStringExtra("message")
        binding.receivedMessage.text = intentMessage

    }
}