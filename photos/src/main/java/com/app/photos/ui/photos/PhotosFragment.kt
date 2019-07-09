package com.app.photos.ui.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.network.cache.photos.Photo
import com.app.photos.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_photos.*
import javax.inject.Inject

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */

class PhotosFragment : DaggerFragment() {

    private lateinit var photosViewModel: PhotosViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var adapter: PhotosRVAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        getData()
        initObservers()
    }

    private fun initObservers() {
        photosViewModel.photosLiveData.observe(this, Observer {
            initRecyclerView(photos = it)
        })
    }

    private fun getData() {
        photosViewModel.getPhotos().observe(this, Observer {
            initRecyclerView(photos = it)
        })
    }

    private fun initViewModel() {
        photosViewModel = ViewModelProviders.of(this, viewModelFactory)[PhotosViewModel::class.java]
    }


    fun initRecyclerView(photos: List<Photo>) {
        adapter = PhotosRVAdapter(photos)
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        photosRecyclerView.layoutManager = layoutManager
        photosRecyclerView.adapter = adapter
    }
}