package com.example.newsproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.RelativeLayout
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.newsproject.R
import com.example.newsproject.databinding.FragmentArticleBinding
import com.example.newsproject.databinding.FragmentHomeBinding
import com.example.newsproject.ui.NewsActivity
import com.example.newsproject.ui.NewsViewModel
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment() {

    private var _binding: FragmentArticleBinding?=null
    private val binding get() = _binding
    private lateinit var viewModel: NewsViewModel
    private lateinit var bottomBar: RelativeLayout
    private val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        val view = binding?.root

        val activity = activity
        if(activity!=null){
            bottomBar = activity.findViewById(R.id.relativeLayout)
            bottomBar.visibility = View.GONE
        }

        viewModel = (activity as NewsActivity).viewModel
        val article = args.article

        binding?.webView?.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        binding?.fab?.setOnClickListener {
            viewModel.saveArticle(article)
            view?.let { it1 -> Snackbar.make(it1, "Article saved successfully", Snackbar.LENGTH_SHORT).show() }
        }

        return view
    }

}