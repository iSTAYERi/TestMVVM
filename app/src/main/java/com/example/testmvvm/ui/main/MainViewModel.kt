package com.example.testmvvm.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.testmvvm.User

class MainViewModel : ViewModel() {
    var user = ObservableField<User>()

    fun init(userId: String) {
        user.set(User(userId, "Ivan", 15))
    }
}
