package com.example.environmental_codefest.ui.main

import android.os.Bundle
import android.text.InputType
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.environmental_codefest.MainActivity
import com.example.environmental_codefest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IssueCreateFragment : Fragment() {
    companion object {
        val TAG = "IssueCreateFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // not sure if this is the best way to set title
        (requireActivity() as MainActivity).supportActionBar?.title =
            resources.getString(R.string.create_issue)
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.issue_create_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // feels kinda hacky but I couldn't find another way (within a quick google search lol)
        // to suppress the return key and have multi-lines
        view.findViewById<EditText>(R.id.add_title_input).apply {
            imeOptions = EditorInfo.IME_ACTION_NEXT
            setRawInputType(InputType.TYPE_CLASS_TEXT)
        }

        view.findViewById<EditText>(R.id.add_preview_input).apply {
            imeOptions = EditorInfo.IME_ACTION_NEXT
            setRawInputType(InputType.TYPE_CLASS_TEXT)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.publish_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // todo fill this out for upload button
        return super.onOptionsItemSelected(item)
    }
}
