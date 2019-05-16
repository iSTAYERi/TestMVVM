package com.example.testmvvm.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.testmvvm.models.Game.Companion.BOARD_SIZE

class Game(playerOneName: String, playerTwoName: String) {

    companion object {
        const val TAG = "game"
        const val BOARD_SIZE = 3
    }

    var player1: Player
    var player2: Player
    var currentPlayer: Player
    var cells: Array<Array<Cell>>
    var winner = MutableLiveData<Player?>()

    init {
        cells = Array(BOARD_SIZE) { Array(BOARD_SIZE) { Cell() } }
        player1 = Player(playerOneName, "x")
        player2 = Player(playerTwoName, "o")
        currentPlayer = player1
    }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer == player1) {
            player2
        } else {
            player1
        }
    }

    fun hasGameEnded() = if (hasThreeSameHorizontalCells()
            || hasThreeSameVerticalCells()
            || hasThreeSameDiagonalCells()) {
        winner.value = currentPlayer
        true
    } else if (isBoardFull()) {
        winner.value = null
        true
    } else {
        false
    }

    fun hasThreeSameHorizontalCells(): Boolean {
        try {
            for (i in 0 until BOARD_SIZE)
                if (areEqual(cells[i][0], cells[i][1], cells[i][2]))
                    return true

            return false
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message)
            return false
        }

    }

    fun hasThreeSameVerticalCells(): Boolean {
        try {
            for (i in 0 until BOARD_SIZE)
                if (areEqual(cells[0][i], cells[1][i], cells[2][i]))
                    return true
            return false
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message)
            return false
        }

    }

    fun hasThreeSameDiagonalCells(): Boolean {
        try {
            return areEqual(cells[0][0], cells[1][1], cells[2][2]) || areEqual(cells[0][2], cells[1][1], cells[2][0])
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message)
            return false
        }

    }


    fun isBoardFull(): Boolean {
        for (row in cells)
            for (cell in row)
                if (cell == null || cell.isEmpty())
                    return false
        return true
    }

    private fun areEqual(vararg cells: Cell): Boolean {
        if (cells == null || cells.size == 0)
            return false

        for (cell in cells)
            if (cell == null || cell.player!!.value == null || cell.player!!.value.length == 0)
                return false

        val comparisonBase = cells[0]
        for (i in 1 until cells.size)
            if (comparisonBase.player!!.value != cells[i].player!!.value)
                return false

        return true
    }

    fun reset() {
        player1 = Player("", "x")
        player2 = Player("", "o")
        currentPlayer = player1
        cells = arrayOf()
    }

}