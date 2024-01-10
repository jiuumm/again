package com.example.again

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.again.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val REQUEST_FOR_NICKNAME=1005
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener{
        val myIntent2 = Intent(this, OtherActivity::class.java)
            startActivity(myIntent2)
        finish()//지금 화면을 꺼주세요 ->이전화면으로 가게된다.
        }
        binding.sendMessageBtn.setOnClickListener{
            //입력한 내용을 변수에 저장
            val inputMessage = binding.messageEdt.text.toString()
            val myIntent3 = Intent(this, MessageActivity::class.java)
            myIntent3.putExtra("message",inputMessage)
            startActivity(myIntent3)

        }

        binding.editNicknameBtn.setOnClickListener{
            val myIntent = Intent(this, EditNicknameActivity::class.java)
            startActivityForResult(myIntent,REQUEST_FOR_NICKNAME)

        }
        binding.dialBtn.setOnClickListener{
            //phoneNumEdt에 입력한 전화번호를 받아서=>해당 번호에 전화연결

            val inputPhoneNum = binding.phoneNumEdt.text.toString()
            val myURI = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myURI)
            startActivity(myIntent)
        }

        binding.msgBtn.setOnClickListener{
            val inputPhoneNum = binding.phoneNumEdt.text.toString()
            val smsContent = binding.smsContent.text.toString()
            val myURI = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myURI)
            myIntent.putExtra("sms_body", smsContent)
            startActivity(myIntent)

        }
        binding.naverWebBtn.setOnClickListener{
            val myURI = Uri.parse("https://naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myURI)
            startActivity(myIntent)
        }
        binding.kakaoStoreBtn.setOnClickListener{

            val myURI = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myURI)
            startActivity(myIntent)
        }
    }
//오버라이딩
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //돌아온 이유가 닉네임을 받으러 다녀온게 맞는지?
        if (requestCode== REQUEST_FOR_NICKNAME){

        //추가질문: 확인을 눌러서 돌아온게 맞는가?
            if(resultCode== Activity.RESULT_OK){
                val newNickname = data?.getStringExtra("nickname")
                binding.nicknameTxt.text= newNickname
            }
        }

    }

    //Dial 액션 예
}