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
        println("124) Bishop Diagonal\n" +
                "      input: bishop1 = \"d7\" and bishop2 = \"f5\"\n" +
                "      result: ${_15_ChessTavern.solution124("d7", "f5")}\n")
        println("125) Whose Turn?\n" +
                "      input: p = \"b1;g1;b8;g8\"\n" +
                "      result: ${_15_ChessTavern.solution125("b1;g1;b8;g8")}\n")
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

    /**
     * Bishop Diagonal
     * @see "https://app.codesignal.com/arcade/code-arcade/chess-tavern/zqDuSLMHhAknqnLtA"
     * @return Bishop Diagonal
     * * @sample In the Land Of Chess, bishops don't really like each other. In fact, when two bishops happen to stand on the same diagonal, they immediately rush towards the opposite ends of that same diagonal.

    Given the initial positions (in chess notation) of two bishops, bishop1 and bishop2, calculate their future positions. Keep in mind that bishops won't move unless they see each other along the same diagonal.

    Example

    For bishop1 = "d7" and bishop2 = "f5", the output should be
    solution(bishop1, bishop2) = ["c8", "h3"].



    For bishop1 = "d8" and bishop2 = "b5", the output should be
    solution(bishop1, bishop2) = ["b5", "d8"].

    The bishops don't belong to the same diagonal, so they don't move.

     */
    fun solution124(bishop1: String, bishop2: String): MutableList<String> {
        val result = mutableListOf(bishop1, bishop2)
        result.sort()
        if(Math.abs(result[0][0].code - result[1][0].code) == Math.abs(result[0][1].code - result[1][1].code)) {
            val sign = if(result[0][1].code < result[1][1].code) 1 else -1
            val min1 = Math.min(result[0][0].code - 'a'.code, if(result[0][1].code < result[1][1].code) result[0][1].digitToInt() - 1 else 8 - result[0][1].digitToInt())
            val min2 = Math.min('h'.code - result[1][0].code, if(result[0][1].code < result[1][1].code) 8 - result[1][1].digitToInt() else result[1][1].digitToInt() - 1)
            result[0] = ((result[0][0].code - min1).toChar().toString() + (result[0][1].digitToInt() - (min1 * sign)))
            result[1] = ((result[1][0].code + min2).toChar().toString() + (result[1][1].digitToInt() + (min2 * sign)))
        }
        return result
    }

    /**
     * Whose Turn?
     * @see "https://app.codesignal.com/arcade/code-arcade/chess-tavern/SJRNgqggTaktuCJGj"
     * @return Whose Turn?
     * * @sample Imagine a standard chess board with only two white and two black knights placed in their standard starting positions: the white knights on b1 and g1; the black knights on b8 and g8.

    There are two players: one plays for white, the other for black. During each move, the player picks one of his knights and moves it to an unoccupied square according to standard chess rules. Thus, a knight on d5 can move to any of the following squares: b6, c7, e7, f6, f4, e3, c3, and b4, as long as it is not occupied by either a friendly or an enemy knight.

    The players take turns in making moves, starting with the white player. Given the configuration p of the knights after an unspecified number of moves, determine whose turn it is.

    Example

    For p = "b1;g1;b8;g8", the output should be
    solution(p) = true.

    The configuration corresponds to the initial state of the game. Thus, it's white's turn.*/
    fun solution125(p: String): Boolean {
        //0 1 2 3 4 5 6 7 8 9 10
        //b 1 ; g 1 ; b 8 ; g 8
        return (p[0].code + p[1].code + p[3].code + p[4].code + p[6].code + p[7].code + p[9].code + p[10].code) % 2 == 0
    }
}