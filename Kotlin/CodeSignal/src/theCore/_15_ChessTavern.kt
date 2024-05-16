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
        println("126) Chess Bishop Dream\n" +
                "      input: boardSize = [3, 7], initPosition = [1, 2], initDirection = [-1, 1], k = 13\n" +
                "      result: ${_15_ChessTavern.solution126(mutableListOf(3, 7), mutableListOf(1, 2), mutableListOf(-1, 1), 13)}\n")
        println("127) Chess Chess Triangle\n" +
                "      input: n = 2 and m = 3\n" +
                "      result: ${_15_ChessTavern.solution127(2,3)}\n")
        println("128) Amazon Checkmate\n" +
                "      input: king = \"a3\" and amazon = \"e4\"\n" +
                "      result: ${_15_ChessTavern.solution128(king = "a3", amazon = "e4")}\n")
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

    /**
     * Chess Bishop Dream
     * @see "https://app.codesignal.com/arcade/code-arcade/chess-tavern/FfjPkYvo9ah6wgXem"
     * @return Chess Bishop Dream
     * * @sample In ChessLand there is a small but proud chess bishop with a recurring dream. In the dream the bishop finds itself on an n × m chessboard with mirrors along each edge, and it is not a bishop but a ray of light. This ray of light moves only along diagonals (the bishop can't imagine any other types of moves even in its dreams), it never stops, and once it reaches an edge or a corner of the chessboard it reflects from it and moves on.

    Given the initial position and the direction of the ray, find its position after k steps where a step means either moving from one cell to the neighboring one or reflecting from a corner of the board.

    Example

    For boardSize = [3, 7], initPosition = [1, 2],
    initDirection = [-1, 1], and k = 13, the output should be
    solution(boardSize, initPosition, initDirection, k) = [0, 1].

    Here is the bishop's path:

    [1, 2] -> [0, 3] -(reflection from the top edge)-> [0, 4] ->
    [1, 5] -> [2, 6] -(reflection from the bottom right corner)-> [2, 6] ->
    [1, 5] -> [0, 4] -(reflection from the top edge)-> [0, 3] ->
    [1, 2] -> [2, 1] -(reflection from the bottom edge)-> [2, 0] -(reflection from the left edge)->
    [1, 0] -> [0, 1]
     */
    fun solution126(boardSize: MutableList<Int>, initPosition: MutableList<Int>, initDirection: MutableList<Int>, k: Int): MutableList<Int> {
        val verticalSteps = (if (initDirection[0] == 1) initPosition[0] else boardSize[0] - initPosition[0] - 1) + k
        val horizontalSteps = (if (initDirection[1] == 1) initPosition[1] else boardSize[1] - initPosition[1] - 1) + k

        var verticalReflections = verticalSteps / boardSize[0] % 2
        var horizontalReflections = horizontalSteps / boardSize[1] % 2

        verticalReflections = (verticalReflections + if (initDirection[0] == -1) 1 else 0) % 2
        horizontalReflections = (horizontalReflections + if (initDirection[1] == -1) 1 else 0) % 2

        val finalPosition = mutableListOf(verticalSteps % boardSize[0], horizontalSteps % boardSize[1])

        if (verticalReflections == 1) {
            finalPosition[0] = boardSize[0] - finalPosition[0] - 1
        }
        if (horizontalReflections == 1) {
            finalPosition[1] = boardSize[1] - finalPosition[1] - 1
        }

        return finalPosition
    }

    /**
     * Chess Triangle
     * @see "https://app.codesignal.com/arcade/code-arcade/chess-tavern/NhRZQrrMqeWYL9L9Z"
     * @return Chess Triangle
     * * @sample Consider a bishop, a knight and a rook on an n × m chessboard. They are said to form a triangle if each piece attacks exactly one other piece and is attacked by exactly one piece. Calculate the number of ways to choose positions of the pieces to form a triangle.

    Note that the bishop attacks pieces sharing the common diagonal with it; the rook attacks in horizontal and vertical directions; and, finally, the knight attacks squares which are two squares horizontally and one square vertically, or two squares vertically and one square horizontally away from its position.

    Example

    For n = 2 and m = 3, the output should be
    solution(n, m) = 8.

     */
    fun solution127(n: Int, m: Int): Int  = (ways(n, m, 2, 3) + ways(n, m, 3, 3) + ways(n, m, 2, 4) + ways(n, m, 3, 4)) * 8

    private fun ways(n: Int, m: Int, x: Int, y: Int): Int {
        var result = 0
        if (n >= x && m >= y) result += (n - x + 1) * (m - y + 1)
        if (m >= x && n >= y) result += (m - x + 1) * (n - y + 1)
        return result
    }

    /**
     * Amazon Checkmate
     * @see "https://app.codesignal.com/arcade/code-arcade/chess-tavern/3hvEEqS7wuoEMZJJC"
     * @return Amazon Checkmate
     * * @sample An amazon (also known as a queen + knight compound) is an imaginary chess piece that can move like a queen or a knight (or, equivalently, like a rook, bishop, or knight). The diagram below shows all squares which the amazon can attack from e4 (circles represent knight-like moves while crosses correspond to queen-like moves).



    Recently, you've come across a diagram with only three pieces left on the board: a white amazon, the white king, and the black king. It's black's move. You don't have time to determine whether the game is over or not, but you'd like to figure it out in your head. Unfortunately, the diagram is smudged and you can't see the position of the black king, so you'll need to consider all possible positions.

    Given the positions of the white pieces on a standard chessboard (using algebraic notation), your task is to determine the number of possible black king's positions such that:

    it's checkmate (i.e. black's king is under the amazon's attack and it cannot make a valid move);
    it's check (i.e. black's king is under the amazon's attack but it can reach a safe square in one move);
    it's stalemate (i.e. black's king is on a safe square but it cannot make a valid move);
    black's king is on a safe square and it can make a valid move.
    Note that two kings cannot be placed on two adjacent squares (including two diagonally adjacent ones).

    Example

    For king = "d3" and amazon = "e4", the output should be
    solution(king, amazon) = [5, 21, 0, 29].

    Red crosses correspond to the checkmate positions, orange pluses refer to check positions, and green circles denote safe squares.

    For king = "a1" and amazon = "g5", the output should be
    solution(king, amazon) = [0, 29, 1, 29].

    The stalemate position is marked by a blue square.*/
    fun solution128(king: String, amazon: String): MutableList<Int> {
        val chessBoard = List(8){ MutableList(8){'o'} }
        val pointKing =  Pair(7 - (king[1].code - '1'.code), king[0].code - 'a'.code)
        val pointAmazon = Pair(7 - (amazon[1].code - '1'.code), amazon[0].code - 'a'.code)
        area(chessBoard,pointAmazon,2,'+')
        for (direction in listOf(Pair(-1, 0), Pair(0, -1), Pair(1, 0), Pair(0, 1), Pair(1, 1), Pair(1, -1), Pair(-1, 1), Pair(-1, -1))) {
            var i = 0
            while (pointAmazon.first + i * direction.first in 0..7 && pointAmazon.second + i * direction.second in 0..7) {
                if (pointAmazon.first + i * direction.first == pointKing.first && pointAmazon.second + i * direction.second == pointKing.second)
                    break
                chessBoard[pointAmazon.first + i * direction.first][pointAmazon.second + i * direction.second] = '+'
                i++
            }
        }

        if (Math.abs(pointAmazon.first - pointKing.first) <= 1 && Math.abs(pointAmazon.second - pointKing.second) <= 1)
            area(chessBoard,pointAmazon,1,'x')

        area(chessBoard,pointKing,1,' ')

        chessBoard[pointKing.first][pointKing.second] = 'К'
        chessBoard[pointAmazon.first][pointAmazon.second] = 'F'

        for (i in 0 .. 7) {
            for (j in 0 .. 7) {
                if (chessBoard[i][j] == '+')
                    checkmate(chessBoard, i, j)
            }
        }

        for (i in 1 .. 7) {
            if (chessBoard[0][i] == 'o')
                checkStalemate(chessBoard,0,i)
            if (chessBoard[7][i - 1] == 'o')
                checkStalemate(chessBoard,7, i - 1)
            if (chessBoard[i - 1][0] == 'o')
                checkStalemate(chessBoard,i - 1, 0)
            if (chessBoard[i][7] == 'o')
                checkStalemate(chessBoard,i,7)
        }

        printBoard(chessBoard)
        val result = mutableListOf(0,0,0,0)
        chessBoard.forEach { it.forEach{ item ->
                when(item){
                    'x' -> result[0]++
                    '+' -> result[1]++
                    'p' -> result[2]++
                    'o' -> result[3]++
                }
            }
        }
        return result
    }

    private fun area(board: List<MutableList<Char>>,figure: Pair<Int,Int>, size: Int, char: Char) {
        for (i in figure.first - size .. figure.first + size)
            for (j in figure.second - size .. figure.second + size)
                if (i in 0..7 && j in 0..7)
                    board[i][j] = char
    }

    private fun checkStalemate(board: List<MutableList<Char>>, y:Int, x:Int) {
        for (i in y - 1 .. y + 1)
            for (j in x - 1 .. x + 1)
                if (i in 0..7 && j in 0..7 && board[i][j] == 'o' && !(i == y && j == x))
                    return
        board[y][x] = 'p'
    }

    private fun checkmate(board: List<MutableList<Char>>, y:Int, x:Int) {
        for (i in y - 1 .. y + 1)
            for (j in x - 1 .. x + 1)
                if (i in 0..7 && j in 0..7 && (board[i][j] == 'o' || board[i][j] == 'F'))
                    return
        board[y][x] = 'x'
    }

    private fun printBoard(board: List<List<Char>>) {
        board.forEach { println("             $it") }
    }

}