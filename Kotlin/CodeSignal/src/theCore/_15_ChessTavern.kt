package theCore

import kotlin.math.abs

object _15_ChessTavern {
    fun run() {
        println("122) Bishop and Pawn\n" +
                "      input: bishop = a1, pawn = c3\n" +
                "      result: ${_15_ChessTavern.solution122("a1", "c3")}\n")
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
}