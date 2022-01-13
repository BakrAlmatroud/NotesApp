package com.example.notetaking

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notetaking.dataSource.DataSource.dataSource
import com.example.notetaking.databinding.ActivityAddEditBinding
import com.example.notetaking.model.Note


class AddActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAddEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val notes = dataSource

        binding.doneBtn.setOnClickListener{
            val noteTitle = binding.titleEdtTxt.text.toString()
            val noteText = binding.noteEdtTxt.text.toString()
            if (noteTitle.trim().isNotEmpty() || noteText.trim().isNotEmpty()) {
                notes.add(notes.size, Note(noteTitle, noteText))
                notesAdapter.notifyItemChanged(notes.size)
                finish()
            }
            else{
                Toast.makeText(this, "Add Some Text", Toast.LENGTH_SHORT).show()
            }
        }
    }
}