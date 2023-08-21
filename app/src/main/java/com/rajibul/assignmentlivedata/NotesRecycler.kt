package com.rajibul.assignmentlivedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajibul.assignmentlivedata.liveroom.NotesEntity

class NotesRecycler(var notes: MutableList<NotesEntity>): RecyclerView.Adapter<NotesRecycler.ViewHolder>() {
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle =view.findViewById<TextView>(R.id.tvTitle)
        var tvDescription =view.findViewById<TextView>(R.id.tvDescription)
        var tvTime =view.findViewById<TextView>(R.id.tvTime)
        var tvId =view.findViewById<TextView>(R.id.tvId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.setText(notes[position].title)
        holder.tvDescription.setText(notes[position].description)
        holder.tvTime.setText(notes[position].time)
        holder.tvId.setText("" + notes[position].id)
       // holder.tvId.setText(String.valueOf(notes[position].id))
    }
}