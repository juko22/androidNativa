package com.example.nativeapplication.ui.notesFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nativeapplication.databinding.NoteItemBinding
import com.example.nativeapplication.ui.notesFragment.models.NoteModel
import kotlin.properties.Delegates

class NotesAdapter(private val onDeleteClick: (noteItem: NoteModel) -> Unit) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    var notes: List<NoteModel> by Delegates.observable(emptyList()) { _, old, new ->
        DiffUtil.calculateDiff(DifferenceUtil(old, new)).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        NoteItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = notes[position]
        holder.binding.delete.tag = item
        holder.binding.item = item

        holder.binding.delete.setOnClickListener { cardView ->
            onDeleteClick(cardView.tag as NoteModel)
        }
    }

    override fun getItemCount() = notes.size

    inner class ViewHolder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)

    inner class DifferenceUtil(private val old: List<NoteModel>, private val new: List<NoteModel>) : DiffUtil.Callback() {
        override fun getOldListSize() = old.size

        override fun getNewListSize() = new.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            old[oldItemPosition].id == new[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            old[oldItemPosition] == new[newItemPosition]
    }
}
