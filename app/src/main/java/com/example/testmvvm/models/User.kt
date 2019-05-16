package com.example.testmvvm.models

import androidx.databinding.BaseObservable

data class User(
        var id: String,
        var name: String,
        var age: Int
): BaseObservable()