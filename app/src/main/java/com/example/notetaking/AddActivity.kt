package com.example.notetaking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notetaking.dataSource.DataSource
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
            notes.add(notes.size, Note(noteTitle, noteText))
            notesAdapter.notifyItemChanged(notes.size)
            finish()
        }
    }
}