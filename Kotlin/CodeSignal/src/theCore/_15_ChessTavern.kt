package theCore

import kotlin.math.abs

object _15_ChessTavern {
    fun run() {
        println("122) Bishop and Pawn\n" +
                "      input: bishop = a1, pawn = c3\n" +
                "      result: ${_15_ChessTavern.solution122("a1", "c3")}\n")
        println("123) Chess Knight Moves\n" +
                "      input: cell = \"a1\"\n" +
                "      result: ${_15_ChessTavern.solution123("a1")}\n")
    }

    /**
     * Bishop and Pawn
     * @see "https://app.codesignal.com/arcade/code-arcade/chess-tavern/6M57rMTFB9MeDeSWo"
     * @return Bishop and Pawn
     * * @sample Given the positions of a white bishop and a black pawn on the standard chess board, determine whether the bishop can capture the pawn in one move.

    The bishop has no restrictions in distance for each move, but is limited to diagonal movement. Check out the example below to see how it can move:

    Example

    For bishop = "a1" and pawn = "c3", the output should be
    solution(bishop, pawn) = true.

    For bishop = "h1" and pawn = "h3", the output should be
    solution(bishop, pawn) = false.*/
    fun solution122(bishop: String, pawn: String) = abs(pawn[0].code - bishop[0].code) == abs(pawn[1].code - bishop[1].code)

    /**
     * Chess Knight Moves
     * @see "https://app.codesignal.com/arcade/code-arcade/chess-tavern/zqDuSLMHhAknqnLtA"
     * @return Chess Knight Moves
     * * @sample Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.

    The knight can move to a square that is two squares horizontally and one square vertically, or two squares vertically and one square horizontally away from it. The complete move therefore looks like the letter L. Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.



    Example

    For cell = "a1", the output should be
    solution(cell) = 2.



    For cell = "c2", the output should be
    solution(cell) = 6.

     */
    fun solution123(cell: String): Int {
        var count = 0
        var symbol = cell[0].code + 3  // Преобразуем символ в число
        var digit = cell[1].digitToInt()  // Получаем число из строки
        for (i in 1 until 12) {
            symbol += Math.pow((-1).toDouble(), (((i - 1) / 6) + 1).toDouble()).toInt()
            digit += Math.pow((-1).toDouble(), (((i + 2) / 6) + 1).toDouble()).toInt()
            if (i % 3 != 0 && isInsideBoard(symbol, digit)) {
                count++
            }
        }
        return count
    }

    private fun isInsideBoard(symbol: Int, digit: Int): Boolean {
        return symbol in 'a'.code..'h'.code && digit in 1..8
    }


}