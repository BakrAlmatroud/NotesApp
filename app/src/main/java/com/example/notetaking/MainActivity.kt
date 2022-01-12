package com.example.notetaking

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notetaking.adapter.NotesAdapter
import com.example.notetaking.dataSource.DataSource
import com.example.notetaking.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
@SuppressLint("StaticFieldLeak")
lateinit var notesAdapter: NotesAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting data for recycler view
        val notes = DataSource.dataSource
        // initializing recycler view
        val notesRV = binding.notesRecyclerView
        // setting recyclerView adapter
        notesAdapter = NotesAdapter(this, notes)
        notesRV.adapter = notesAdapter
        // setting layout manager for the recycler view
        notesRV.layoutManager = LinearLayoutManager(this)

        // setting on click listener to add note
        binding.addBtn.setOnClickListener{
            Intent(this, AddEditActivity::class.java).also {
                startActivity(it)
            }
        }

        // setting on click listener to edit note
        notesAdapter.setOnItemClickListener(object: NotesAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val currentNote = notes[position]
                Intent(this@MainActivity, EditActivity::class.java).also {
                    it.putExtra("noteTitle", currentNote.title)
                    it.putExtra("noteText", currentNote.note)
                    startActivity(it)
                }
            }
        })
    }
}