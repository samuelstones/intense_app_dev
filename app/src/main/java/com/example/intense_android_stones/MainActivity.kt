package com.example.intense_android_stones

import android.content.Intent
import android.graphics.Camera
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Website
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnSms:Button
    lateinit var btnEmail:Button
    lateinit var btnCamera:Button
    lateinit var btnShare:Button
    lateinit var btnMpesa:Button
    lateinit var btnCall:Button
    lateinit var btnWebsite:Button
    lateinit var btnMap:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btnSms = findViewById(R.id.smsbtn1)
       btnEmail = findViewById(R.id.emailbtn2)
       btnCamera = findViewById(R.id.cambtn3)
       btnShare = findViewById(R.id.sharebtn4)
       btnMpesa = findViewById(R.id.mpesabtn5)
       btnCall = findViewById(R.id.callbtn6)
       btnWebsite = findViewById(R.id.webbtn7)
       btnMap = findViewById(R.id.mapbtn8)

        btnSms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0773570102")
            val intent = Intent(Intent.ACTION_SENDTO, uri )
            intent.putExtra("sms_body", "Good afternoon")
            startActivity(intent)
        }

        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "samuelkimanikahiga@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Sir am writing to in request of applying for the advertised HR position, below i have attached my CV. Regard Samuel.")
            startActivity(Intent.createChooser(emailIntent, "send email...."))

        }

        btnCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent,1)
        }

        btnCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.setData(Uri.parse("tel:"+254773570102))
            val intent = Intent(Intent.ACTION_CALL,  )
            startActivity(callIntent)
        }

        btnMpesa.setOnClickListener {
            val simTOOLKitIntent = applicationContext.packageManager.getLaunchIntentForPackage(".com.android.stk")
            simTOOLKitIntent?.let { startActivity(it) }
            startActivity(intent)
        }
















    }
}