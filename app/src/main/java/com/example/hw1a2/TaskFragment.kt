package com.example.hw1a2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw1a2.databinding.FragmentSecondBinding

class TaskFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireContext()),container,false)
        return binding.root

        // This property is only valid between onCreateView and
        // onDestroyView.

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnsave.setOnClickListener {
            save()
        }
        rename()
    }
        private fun rename() {
            val editText = arguments?.getString("key1")
            binding.edit.setText(editText)
    }

    private fun save() {

        val text = binding.edit.text.toString()
        if (text.isEmpty()) {
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        } else {
            val news = News(0, text, System.currentTimeMillis())
            App.dataBase.newsDao().insert(news)
            val bundle = bundleOf("news" to news)
            parentFragmentManager.setFragmentResult("rk_news", bundle)
            findNavController().navigateUp()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        var _binding = null
    }
}

