package com.doctopdf.ui.nearbyShare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.doctopdf.databinding.FragmentNearbyShareBinding

class NearbyShareFragment : Fragment() {
    private var _binding: FragmentNearbyShareBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val nearbyShareViewModel =
            ViewModelProvider(this).get(NearbyShareViewModel::class.java)

        _binding = FragmentNearbyShareBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNearbyShare
        nearbyShareViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}