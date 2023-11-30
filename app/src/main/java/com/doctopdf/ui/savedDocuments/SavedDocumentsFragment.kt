package com.doctopdf.ui.savedDocuments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.doctopdf.databinding.FragmentSavedDocumentsBinding

class SavedDocumentsFragment : Fragment() {

    private var _binding: FragmentSavedDocumentsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val savedDocumentsViewModel =
            ViewModelProvider(this).get(SavedDocumentsViewModel::class.java)

        _binding = FragmentSavedDocumentsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSavedDocuments
        savedDocumentsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}