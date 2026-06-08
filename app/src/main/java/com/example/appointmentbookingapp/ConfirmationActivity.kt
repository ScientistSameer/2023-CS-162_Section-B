package com.example.appointmentbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val tvName: TextView = findViewById(R.id.tv_summary_name)
        val tvPhone: TextView = findViewById(R.id.tv_summary_phone)
        val tvEmail: TextView = findViewById(R.id.tv_summary_email)
        val tvType: TextView = findViewById(R.id.tv_summary_type)
        val tvDate: TextView = findViewById(R.id.tv_summary_date)
        val tvTime: TextView = findViewById(R.id.tv_summary_time)
        val tvGender: TextView = findViewById(R.id.tv_summary_gender)
        val btnHome: Button = findViewById(R.id.btn_home)

        tvName.text = getString(R.string.summary_name, intent.getStringExtra("NAME"))
        tvPhone.text = getString(R.string.summary_phone, intent.getStringExtra("PHONE"))
        tvEmail.text = getString(R.string.summary_email, intent.getStringExtra("EMAIL"))
        tvType.text = getString(R.string.summary_type, intent.getStringExtra("TYPE"))
        tvDate.text = getString(R.string.summary_date, intent.getStringExtra("DATE"))
        tvTime.text = getString(R.string.summary_time, intent.getStringExtra("TIME"))
        tvGender.text = getString(R.string.summary_gender, intent.getStringExtra("GENDER"))

        btnHome.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(homeIntent)
            finish()
        }
    }
}