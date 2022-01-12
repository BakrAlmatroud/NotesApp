package com.example.notetaking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notetaking.dataSource.DataSource
import com.example.notetaking.databinding.ActivityAddEditBinding
import com.example.notetaking.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddEditActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAddEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val notes = DataSource.dataSource

        binding.doneBtn.setOnClickListener{
            val noteTitle = binding.titleEdtTxt.text.toString()
            val noteText = binding.noteEdtTxt.text.toString()
            notes.add(0, Note(noteTitle, noteText))
            notesAdapter.notifyDataSetChanged()
            finish()
        }
    }
}