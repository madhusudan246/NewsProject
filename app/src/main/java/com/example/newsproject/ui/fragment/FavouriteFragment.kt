package com.example.newsproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsproject.R
import com.example.newsproject.ui.NewsActivity
import com.example.newsproject.ui.NewsViewModel

class FavouriteFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = (activity as NewsActivity).viewModel
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

}