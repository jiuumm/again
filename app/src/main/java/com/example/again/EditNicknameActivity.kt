package com.example.again
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.again.databinding.ActivityEditNicknameBinding
class EditNicknameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditNicknameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditNicknameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//이 화면에 들어올떄 첨부된 데이터를 텍스트 뷰에 반영.



    binding.okBtn.setOnClickListener{
        val inputNewNickname = binding.newNicknameEdt.text.toString()
        //데이터를 들고서 메인화면으로 복귀
        //입력 닉네임을 담아주기 위한 용도로만 사용하는 Intent
        val resultIntent = Intent()
        resultIntent.putExtra("nickname",inputNewNickname)
        setResult(RESULT_OK,resultIntent)
        finish()

    }

    }
}