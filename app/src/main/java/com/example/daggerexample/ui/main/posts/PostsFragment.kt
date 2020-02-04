package com.example.daggerexample.ui.main.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerexample.R
import com.example.daggerexample.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * @author Daniil Pavlenko on 04.02.20.
 */
class PostsFragment : DaggerFragment() {

    companion object {
        private const val TAG = "PostsFragment"
    }

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var viewModel: PostsViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recyclerViewPosts)
        viewModel = ViewModelProvider(this, providerFactory)
            .get(PostsViewModel::class.java)
    }
}