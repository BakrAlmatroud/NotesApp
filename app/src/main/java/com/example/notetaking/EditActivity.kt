package com.example.notetaking

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.notetaking.databinding.ActivityAddEditBinding
import kotlin.math.log

private lateinit var binding: ActivityAddEditBinding
private const val TAG = "EditActivity"

class EditActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val noteTitle = intent.getStringExtra("noteTitle")
        val noteText = intent.getStringExtra("noteText")

        if (noteTitle != null) {
            var titleEdtText = binding.titleEdtTxt.text.toString()
            titleEdtText = noteTitle
        }

    }
}