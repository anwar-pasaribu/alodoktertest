package com.anwar.alodoktertest.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anwar.alodoktertest.R
import com.anwar.alodoktertest.utils.InjectorUtils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this, InjectorUtils.provideHomeViewModelFactory()).get(HomeViewModel::class.java)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHomeList()
    }

    private fun setupHomeList() {

        val adapter = HeroListAdapter()
        rv_fragment_home.adapter = adapter

        homeViewModel.heroList.observe(this, Observer {
            it?.let {
                heroList ->
                Log.i("BLB", "List size: ${heroList.size}")
                adapter.submitList(heroList)
            }
        })

    }
}