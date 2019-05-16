package com.example.testmvvm.game

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.ViewModel
import com.example.testmvvm.models.Cell
import com.example.testmvvm.models.Game


class GameViewModel : ViewModel() {

    lateinit var cells: ObservableArrayMap<String, String>
    private lateinit var game: Game

    fun init(playerOneName: String, playerTwoName: String) {
        game = Game(playerOneName, playerTwoName)
        cells = ObservableArrayMap()
    }

    fun getWinner() = game.winner

    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column].isEmpty()) {
            game.cells[row][column] = Cell(game.currentPlayer)
            cells[stringFromNumbers(row, column)] = game.currentPlayer.value
            if (game.hasGameEnded()) {
                game.reset()
            } else {
                game.switchPlayer()
            }
        }
    }

    private fun stringFromNumbers(vararg numbers: Int): String {
        val sNumbers = StringBuilder()
        for (number in numbers)
            sNumbers.append(number)
        return sNumbers.toString()
    }

}