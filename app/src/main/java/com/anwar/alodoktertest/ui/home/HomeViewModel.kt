package com.anwar.alodoktertest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.anwar.alodoktertest.data.StaticRepository
import com.anwar.alodoktertest.domain.Hero

class HomeViewModel(repo: StaticRepository) : ViewModel() {

    val heroList: MutableLiveData<List<Hero>> = repo.getHeroes()

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}