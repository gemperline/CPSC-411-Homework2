package com.example.hwk2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double.parseDouble

class MainActivity : AppCompatActivity() {
    var cService : ClaimService = ClaimService(this)

    @SuppressLint("SetTextI18n")
    fun statusSuccess() {
        val titleView = findViewById<EditText>(R.id.claim_title)
        val dateView  = findViewById<EditText>(R.id.claim_date)
        val title = titleView.text.toString()

        val sView : TextView = findViewById(R.id.status_msg)
        sView.text = "The Claim was added to DB."

        titleView.text.clear()
        dateView.text.clear()
    }

    @SuppressLint("SetTextI18n")
    fun statusFail() {
        val titleView = findViewById<EditText>(R.id.claim_title)
        val dateView  = findViewById<EditText>(R.id.claim_date)
        val title = titleView.text.toString()
        val sView : TextView = findViewById(R.id.status_msg)
        sView.text = " Error: could not add claim to DB."

        titleView.text.clear()
        dateView.text.clear()
    }

    fun isValidDate (date : String) : Boolean {
        lateinit var sub : String
        if (date.length != 10)
            return false
        try {
            sub = date.substring(0, 4)
        } catch (e: StringIndexOutOfBoundsException) {
            return false
        }
        try {
            val num = parseDouble(sub)
        } catch (e: NumberFormatException) {
            return false
        }
        try {
            sub = date[4].toString()
        } catch (e: StringIndexOutOfBoundsException) {
            return false
        }
        if (sub != " ")
            return false
        try {
            sub = date.substring(5, 7)
        } catch (e: StringIndexOutOfBoundsException) {
            return false
        }
        try {
            val num = parseDouble(sub)
        } catch (e: NumberFormatException) {
            return false
        }
        try {
            sub = date[7].toString()
        } catch (e: StringIndexOutOfBoundsException) {
            return false
        }
        if (sub != "-")
            return false
        try {
            sub = date.substring(8)
        } catch (e: StringIndexOutOfBoundsException) {
            return false
        }
        try {
            val num = parseDouble(sub)
        } catch (e: NumberFormatException) {
            return false
        }

        return true
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val createRow = ObjDetailScreenGenerator(this)
        val colView = createRow.generate()
        setContentView(colView)
        val bView : Button = findViewById(R.id.add_btn)
        bView.setOnClickListener {
            val nameView = findViewById<EditText>(R.id.claim_title)
            val dateView  = findViewById<EditText>(R.id.claim_date)
            val claimName = nameView.text.toString()
            val date = dateView.text.toString()
            val statusTxt : TextView = findViewById(R.id.status_msg)

            if (claimName == "" && date == "")
                statusTxt.text = "Please complete the form."
            else if (claimName == "")
                statusTxt.text = "Insert claim name."
            else if (date == "")
                statusTxt.text = "Insert the date properly"
            else if (!isValidDate(date))
                statusTxt.text = "Date format is YYY MM-DD"
            else {
                cService.addClaim(Claim(claimName, date))
            }
        }
    }
}