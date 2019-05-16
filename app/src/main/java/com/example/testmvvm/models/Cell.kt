package com.example.testmvvm.models

class Cell(var player: Player? = null) {

    fun isEmpty() = if (player != null) {
        player!!.value.isEmpty()
    } else {
        true
    }
}