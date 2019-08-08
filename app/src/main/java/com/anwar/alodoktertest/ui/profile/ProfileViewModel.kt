package com.anwar.alodoktertest.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    val avatarUrl = MutableLiveData<String>().apply {
        value = "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Favatar%2Favatar-anwar.png?alt=media&token=b32a914a-a728-424b-9e24-22fb52fe61b7"
    }

    val fullName = MutableLiveData<String>().apply {
        value = "Anwar Pasaribu"
    }

    val gender = MutableLiveData<String>().apply {
        value = "Male"
    }

    val phoneNumber = MutableLiveData<String>().apply {
        value = "+62 878 8415 5479"
    }
}