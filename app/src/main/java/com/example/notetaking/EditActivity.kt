package com.example.notetaking

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.notetaking.dataSource.DataSource
import com.example.notetaking.dataSource.DataSource.dataSource
import com.example.notetaking.databinding.ActivityAddEditBinding

private lateinit var binding: ActivityAddEditBinding
private const val TAG = "EditActivity"

class EditActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val notes = dataSource

        val noteTitle = intent.getStringExtra("noteTitle")
        val noteText = intent.getStringExtra("noteText")
        if (noteTitle != null && noteText != null){
            (binding.titleEdtTxt as TextView).text = noteTitle
            (binding.noteEdtTxt as TextView).text = noteText
        }

        binding.doneBtn.setOnClickListener{
            val position = intent.getIntExtra("position", 0)
            val currentNote = notes[position]
            currentNote.title = binding.titleEdtTxt.text.toString()
            currentNote.note = binding.noteEdtTxt.text.toString()
            notesAdapter.notifyItemChanged(position)
            finish()
        }

    }
}