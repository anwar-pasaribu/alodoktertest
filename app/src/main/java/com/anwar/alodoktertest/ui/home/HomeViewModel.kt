package com.anwar.alodoktertest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.anwar.alodoktertest.domain.Hero

class HomeViewModel : ViewModel() {

    val heroList: LiveData<MutableList<Hero>> = MutableLiveData<Hero>().apply {
        val heroList = MutableList<Hero>
        heroList.add(listOf<>())
        value = heroList
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}