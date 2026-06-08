package com.example.appointmentbookingapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class BookAppointmentActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText
    private lateinit var spinnerType: Spinner
    private lateinit var tvSelectedDate: TextView
    private lateinit var tvSelectedTime: TextView
    private lateinit var rgGender: RadioGroup
    private lateinit var cbTerms: CheckBox
    private lateinit var btnConfirm: Button
    private lateinit var btnPickDate: Button
    private lateinit var btnPickTime: Button

    private var selectedDate = ""
    private var selectedTime = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        etFullName = findViewById(R.id.et_full_name)
        etPhone = findViewById(R.id.et_phone)
        etEmail = findViewById(R.id.et_email)
        spinnerType = findViewById(R.id.spinner_appointment_type)
        tvSelectedDate = findViewById(R.id.tv_selected_date)
        tvSelectedTime = findViewById(R.id.tv_selected_time)
        rgGender = findViewById(R.id.rg_gender)
        cbTerms = findViewById(R.id.cb_terms)
        btnConfirm = findViewById(R.id.btn_confirm_booking)
        btnPickDate = findViewById(R.id.btn_pick_date)
        btnPickTime = findViewById(R.id.btn_pick_time)

        // Setup Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.appointment_types,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerType.adapter = adapter

        // Date Picker
        btnPickDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, y, m, d ->
                selectedDate = "$d/${m + 1}/$y"
                tvSelectedDate.text = selectedDate
            }, year, month, day).show()
        }

        // Time Picker
        btnPickTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            TimePickerDialog(this, { _, h, min ->
                selectedTime = String.format(Locale.getDefault(), "%02d:%02d", h, min)
                tvSelectedTime.text = selectedTime
            }, hour, minute, true).show()
        }

        btnConfirm.setOnClickListener {
            if (validateInputs()) {
                navigateToConfirmation()
            }
        }
    }

    private fun validateInputs(): Boolean {
        if (etFullName.text.toString().trim().isEmpty()) {
            etFullName.error = "Name must not be empty"
            return false
        }
        if (etPhone.text.toString().trim().isEmpty()) {
            etPhone.error = "Phone number must not be empty"
            return false
        }
        if (etEmail.text.toString().trim().isEmpty()) {
            etEmail.error = "Email must not be empty"
            return false
        }
        if (spinnerType.selectedItemPosition == 0) {
            Toast.makeText(this, "Please select an appointment type", Toast.LENGTH_SHORT).show()
            return false
        }
        if (selectedDate.isEmpty()) {
            Toast.makeText(this, "Please select a date", Toast.LENGTH_SHORT).show()
            return false
        }
        if (selectedTime.isEmpty()) {
            Toast.makeText(this, "Please select a time", Toast.LENGTH_SHORT).show()
            return false
        }
        if (rgGender.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!cbTerms.isChecked) {
            Toast.makeText(this, "Please accept Terms and Conditions", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun navigateToConfirmation() {
        val intent = Intent(this, ConfirmationActivity::class.java)
        intent.putExtra("NAME", etFullName.text.toString())
        intent.putExtra("PHONE", etPhone.text.toString())
        intent.putExtra("EMAIL", etEmail.text.toString())
        intent.putExtra("TYPE", spinnerType.selectedItem.toString())
        intent.putExtra("DATE", selectedDate)
        intent.putExtra("TIME", selectedTime)
        val genderId = rgGender.checkedRadioButtonId
        val gender = findViewById<RadioButton>(genderId).text.toString()
        intent.putExtra("GENDER", gender)
        startActivity(intent)
    }
}