package com.example.testmvvm.main

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.testmvvm.models.User

class MainViewModel : ViewModel() {
    var user = ObservableField<User>()

    fun init(userId: String) {
        user.set(User(userId, "Ivan", 15))
    }
}
