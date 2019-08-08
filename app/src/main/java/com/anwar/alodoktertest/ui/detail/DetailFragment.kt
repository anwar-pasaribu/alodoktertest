package com.anwar.alodoktertest.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.anwar.alodoktertest.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private lateinit var homeViewModel: DetailViewModel

    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(DetailViewModel::class.java)
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDetailView()

    }

    private fun setupDetailView() {

        val indicators = listOf<View>(
            view_fragment_detail_indicator1,
            view_fragment_detail_indicator2,
            view_fragment_detail_indicator3,
            view_fragment_detail_indicator4
        )

        val heroImageList = args.heroItem.images
        val adapter = HeroDetailAdapter()
        adapter.submitList(heroImageList)
        vp2_fragment_detail.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        vp2_fragment_detail.adapter = adapter

        vp2_fragment_detail.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                Log.i("BUBU", "Selected $position")
                for (view in indicators) {
                    view.alpha = 0.5f
                }

                indicators[position].alpha = 1f
            }
        })

    }

}