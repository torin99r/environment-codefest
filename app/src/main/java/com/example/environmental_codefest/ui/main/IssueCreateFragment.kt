package com.example.environmental_codefest.ui.main

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
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
        return inflater.inflate(R.layout.issue_create_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // feels kinda hacky but I couldn't find another way to suppress the return key and have
        // multi-lines
        view.findViewById<EditText>(R.id.add_title_input).apply {
            imeOptions = EditorInfo.IME_ACTION_NEXT
            setRawInputType(InputType.TYPE_CLASS_TEXT)
        }

        view.findViewById<EditText>(R.id.add_preview_input).apply {
            imeOptions = EditorInfo.IME_ACTION_NEXT
            setRawInputType(InputType.TYPE_CLASS_TEXT)
        }
    }

}