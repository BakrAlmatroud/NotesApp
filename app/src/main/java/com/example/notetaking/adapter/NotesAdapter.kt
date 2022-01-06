package com.example.notetaking.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notetaking.R
import com.example.notetaking.model.Note

private lateinit var mListener: NotesAdapter.OnItemClickListener

class NotesAdapter(
    val context: Context?,
    private val data: MutableList<Note>
): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    interface OnItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    class NotesViewHolder(itemView: View, listener: OnItemClickListener): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.note_title)
        val deleteBtn: ImageButton = itemView.findViewById(R.id.delete_btn)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.note_list_item, parent, false)

        return NotesViewHolder(layout, mListener)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val item = data[position]

        holder.title.text = item.title
        holder.deleteBtn.setOnClickListener {
            data.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }

    }
    override fun getItemCount(): Int = data.size
}