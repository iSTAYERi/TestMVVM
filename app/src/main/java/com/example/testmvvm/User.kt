package com.example.testmvvm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

data class User(
        private var _id: String,
        private var _name: String,
        private var _age: Int
): BaseObservable() {

    val id: String
    get() = _id

    var name: String
        @Bindable get() = _name
        set(value) {
            _name = value
            notifyPropertyChanged(BR.name)
        }

    var age: Int
        @Bindable get() = _age
        set(value) {
            _age = value
            notifyPropertyChanged(BR.age)
        }
}