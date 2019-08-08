package com.anwar.alodoktertest.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anwar.alodoktertest.R
import com.anwar.alodoktertest.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel = ViewModelProviders.of(this)
            .get(ProfileViewModel::class.java)

        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.viewModel = profileViewModel
        return binding.root
    }
}