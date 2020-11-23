package com.example.environmental_codefest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.environmental_codefest.MainActivity
import com.example.environmental_codefest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IssueDetailFragment : Fragment() {
    companion object {
        const val TAG = "IssueDetailFragment"
    }

    private val viewModel: IssuesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).supportActionBar?.title =
            resources.getString(R.string.issue_details)

        return inflater.inflate(R.layout.issue_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.title).text =
            viewModel.getIssue(this.requireArguments()["KEY"] as Int).title
        view.findViewById<TextView>(R.id.preview).text =
            viewModel.getIssue(this.requireArguments()["KEY"] as Int).preview
        view.findViewById<TextView>(R.id.message).text =
            viewModel.getIssue(this.requireArguments()["KEY"] as Int).message
        view.findViewById<TextView>(R.id.sources).text =
            viewModel.getIssue(this.requireArguments()["KEY"] as Int).sources
    }
}
