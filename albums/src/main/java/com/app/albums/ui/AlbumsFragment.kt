package com.app.albums.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.albums.R
import com.app.network.cache.albums.Album
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_albums.*
import javax.inject.Inject

/**
 * Created by Alireza Rafeezadeh on 5/15/2019.
 */
class AlbumsFragment : DaggerFragment() {


    lateinit var adapter: AlbumsRVAdapter

    private lateinit var albumsViewModel: AlbumsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initObservers()
        getData()

    }


    private fun getData() {
        albumsViewModel.getAlbums().observe(this, Observer {
            initRecyclerView(it)
        })
    }


    private fun initViewModel() {
        albumsViewModel = ViewModelProviders.of(this, viewModelFactory)[AlbumsViewModel::class.java]
    }



    private fun initObservers() {

        albumsViewModel.albumsLiveData.observe(this, Observer {
            if (it.isNotEmpty())
                initRecyclerView(it)
        })

    }

    private fun initRecyclerView(albums: List<Album>) {
        adapter = AlbumsRVAdapter(albums)
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        albumsRecyclerView.layoutManager = layoutManager
        albumsRecyclerView.adapter = adapter
    }
}