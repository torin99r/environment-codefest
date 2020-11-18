package com.example.environmental_codefest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.environmental_codefest.R
import com.example.environmental_codefest.models.Issue

class IssuesAdapter(private val issues: List<Issue>, private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<IssuesAdapter.IssueViewHolder>() {
    //todo make recycler view dynamic
    //todo icons using constants that are ints and refs to the drawables

    class IssueViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout) {
        val title: TextView = layout.findViewById<TextView>(R.id.title)
        val preview: TextView = layout.findViewById<TextView>(R.id.preview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.issue_preview_card,
            parent,
            false
        )
        return IssueViewHolder(
            layout = layout as ConstraintLayout
        )
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.title.text = issues[position].title
        holder.preview.text = issues[position].preview
        holder.itemView.setOnClickListener {
            onClickListener.onClick(position)
        }
    }

    override fun getItemCount() = issues.size

    class OnClickListener(val clickListener: (position: Int) -> Unit) {
        fun onClick(position: Int) = clickListener(position)
    }
}
