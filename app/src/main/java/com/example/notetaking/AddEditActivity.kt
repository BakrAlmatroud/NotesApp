package com.example.notetaking

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.notetaking.dataSource.DataSource
import com.example.notetaking.databinding.ActivityAddEditBinding
import com.example.notetaking.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddEditActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAddEditBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val notes = DataSource.dataSource
        val doneBtn: FloatingActionButton = binding.doneBtn
        doneBtn.setOnClickListener{
            val title = binding.titleEdtTxt.text.toString()
            val note = binding.noteEdtTxt.text.toString()
            notes.add(0, Note(title, note))
            notesAdapter.notifyDataSetChanged()

            finish()
        }
    }
}