package theCore

object _12_ListBackwoods {
    fun run() {
        println("98) Extract Matrix Column\n" +
                "      input: matrix = \n" +
                "             [1, 1, 1, 2]\n" +
                "             [0, 5, 0, 4]\n" +
                "             [2, 1, 3, 6]\n" +
                "      result: ${solution98(mutableListOf(
                            mutableListOf(1, 1, 1, 2),
                            mutableListOf(0, 5, 0, 4),
                            mutableListOf(2, 1, 3, 6)
                        ), column = 2)}\n")
        println("99) Are Isomorphic?\n" +
                "      input: array1 = \n" +
                "             [1, 1, 1]\n" +
                "             [0, 0]\n" +
                "             array2 = \n" +
                "             [2, 1, 1]\n" +
                "             [2, 1]\n" +
                "      result: ${solution99(
                        mutableListOf(mutableListOf(1, 1, 1), mutableListOf(0, 0)),
                        mutableListOf(mutableListOf(2, 1, 1), mutableListOf(2, 1))
                    )}\n" )
        println("100) Christmas Tree\n" +
                "      input: matrix = \n" +
                "             ${mutableListOf(43,45,32,10)} \n" +
                "             ${mutableListOf(10,98,28,98)} \n" +
                "             ${mutableListOf(30,21,53,64)} \n" +
                "             ${mutableListOf(21,22,35,71)} \n" +
                "      result:")
        solution100(
            mutableListOf(
                mutableListOf(43, 45, 32, 10),
                mutableListOf(10, 98, 28, 98),
                mutableListOf(30, 21, 53, 64),
                mutableListOf(21, 22, 35, 71)
            )
        ).forEach { println("             $it") }
        println()
        println("101) Swap Diagonals\n" +
                "      input: matrix = \n" +
                "             ${mutableListOf(43,45,32,10)} \n" +
                "             ${mutableListOf(10,98,28,98)} \n" +
                "             ${mutableListOf(30,21,53,64)} \n" +
                "             ${mutableListOf(21,22,35,71)} \n" +
                "      result:")
        solution101(mutableListOf(
            mutableListOf(43,45,32,10),
            mutableListOf(10,98,28,98),
            mutableListOf(30,21,53,64),
            mutableListOf(21,22,35,71)
        )).forEach { println("             $it") }
        println()
        println("102) Crossing Sum\n" +
                "      input: matrix = \n" +
                "             ${mutableListOf(1, 1, 1, 1)} \n" +
                "             ${mutableListOf(2, 2, 2, 2)} \n" +
                "             ${mutableListOf(3, 3, 3, 3)} \n" +
                "             a = 1, b = 3\n" +
                "      result: ${
                    solution102(
                        mutableListOf(
                            mutableListOf(1, 1, 1, 1),
                            mutableListOf(2, 2, 2, 2),
                            mutableListOf(3, 3, 3, 3)
                        ), 1, 3
                    )
                }")
        println("103) Draw Rectangle\n" +
                "      input: canvas = \n" +
                "             [a, a, a, a, a, a, a, a]\n" +
                "             [a, a, a, a, a, a, a, a]\n" +
                "             [a, a, a, a, a, a, a, a]\n" +
                "             [b, b, b, b, b, b, b, b]\n" +
                "             [b, b, b, b, b, b, b, b]\n" +
                "             rectangle = [1, 1, 4, 3] \n" +
                "      result:")
        solution103(
            mutableListOf(
                mutableListOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
                mutableListOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
                mutableListOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
                mutableListOf('b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'),
                mutableListOf('b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')
            ), mutableListOf(1, 1, 4, 3)
        ).forEach { println("             $it") }
        println()
        println("104) Volleyball Positions\n" +
                "      input: formation = \n" +
                "             [empty, Alice, empty]\n" +
                "             [Bob,   empty, Charlie]\n" +
                "             [empty, Dave,  empty]\n" +
                "             [Eve,   empty, Frank]\n" +
                "             k = 3\n" +
                "      result:")
        solution104(
            mutableListOf(
                mutableListOf("empty", "Alice", "empty"),
                mutableListOf("Bob", "empty", "Charlie"),
                mutableListOf("empty", "Dave", "empty"),
                mutableListOf("Eve", "empty", "Frank")
            ), k = 3
        ).forEach { println("             $it") }
        println()
        println("105) Star Rotation\n" +
                "      input: formation = \n" +
                "             [1, 0, 0, 2, 0, 0, 3]\n" +
                "             [0, 1, 0, 2, 0, 3, 0]\n" +
                "             [0, 0, 1, 2, 3, 0, 0]\n" +
                "             [8, 8, 8, 9, 4, 4, 4]\n" +
                "             [0, 0, 7, 6, 5, 0, 0]\n" +
                "             [0, 7, 0, 6, 0, 5, 0]\n" +
                "             [7, 0, 0, 6, 0, 0, 5]\n" +
                "             width = 3, center = [3, 3], t = 1\n" +
                "      result:")
        solution105(
            mutableListOf(
                mutableListOf(1, 0, 0, 2, 0, 0, 3),
                mutableListOf(0, 1, 0, 2, 0, 3, 0),
                mutableListOf(0, 0, 1, 2, 3, 0, 0),
                mutableListOf(8, 8, 8, 9, 4, 4, 4),
                mutableListOf(0, 0, 7, 6, 5, 0, 0),
                mutableListOf(0, 7, 0, 6, 0, 5, 0),
                mutableListOf(7, 0, 0, 6, 0, 0, 5),
            ), width = 7, mutableListOf(3, 3), t = 7
        ).forEach { println("             $it") }
        println()
    }

    /**
     * Extract Matrix Column
     * @see "https://app.codesignal.com/arcade/code-arcade/list-backwoods/zwXiykHLor6eKHaLY"
     * @return Extract Matrix Column
     * * @sample Given a rectangular matrix and an integer column, return an array containing the elements of the columnth column of the given matrix (the leftmost column is the 0th one).

    Example

    For

    matrix = [[1, 1, 1, 2],
    [0, 5, 0, 4],
    [2, 1, 3, 6]]
    and column = 2, the output should be
    solution(matrix, column) = [1, 0, 3]. */
    fun solution98(matrix: MutableList<MutableList<Int>>, column: Int): MutableList<Int> {
        val result = mutableListOf<Int>()
        for(i in 0 until matrix.count()) {
            result.add(matrix[i][column])
        }
        return result
    }

    /**
     * Are Isomorphic?
     * @see "https://app.codesignal.com/arcade/code-arcade/list-backwoods/xKYm98etd9JRsTcZY"
     * @return Are Isomorphic?
     * * @sample Two two-dimensional arrays are isomorphic if they have the same number of rows and each pair of respective rows contains the same number of elements.

    Given two two-dimensional arrays, check if they are isomorphic.

    Example

    For

    array1 = [[1, 1, 1],
    [0, 0]]
    and

    array2 = [[2, 1, 1],
    [2, 1]]
    the output should be
    solution(array1, array2) = true;

    For

    array1 = [[2],
    []]
    and

    array2 = [[2]]
    the output should be
    solution(array1, array2) = false. */
    fun solution99(array1: MutableList<MutableList<Int>>, array2: MutableList<MutableList<Int>>): Boolean {
        if(array1.size != array2.size)
            return false

        for (i in 0 until array1.size) {
            if(array1[i].size != array2[i].size)
                return false
        }
        return true
    }

    /**
     * Reverse On Diagonals
     * @see "https://app.codesignal.com/arcade/code-arcade/list-backwoods/Akspcu9ewiYapWkrp"
     * @return Reverse On Diagonals
     * * @sample The longest diagonals of a square matrix are defined as follows:

    the first longest diagonal goes from the top left corner to the bottom right one;
    the second longest diagonal goes from the top right corner to the bottom left one.
    Given a square matrix, your task is to reverse the order of elements on both of its longest diagonals.

    Example

    For

    matrix = [[1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]]
    the output should be

    solution(matrix) = [[9, 2, 7],
    [4, 5, 6],
    [3, 8, 1]] */
    fun solution100(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        val size = matrix.size - 1
        for(i in 0 until matrix.size/2) {
            var tmp = matrix[i][i]
            matrix[i][i] = matrix[size - i][size - i]
            matrix[size - i][size - i] = tmp

            tmp = matrix[size - i][i]
            matrix[size - i][i] = matrix[i][size - i]
            matrix[i][size - i] = tmp
        }
        return matrix
    }

    /**
     * Swap Diagonals
     * @see "https://app.codesignal.com/arcade/code-arcade/list-backwoods/kfwTN8pdx9uP8bcHS"
     * @return Swap Diagonals
     * * @sample The longest diagonals of a square matrix are defined as follows:

    the first longest diagonal goes from the top left corner to the bottom right one;
    the second longest diagonal goes from the top right corner to the bottom left one.
    Given a square matrix, your task is to swap its longest diagonals by exchanging their elements at the corresponding positions.

    Example

    For

    matrix = [[1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]]
    the output should be

    solution(matrix) = [[3, 2, 1],
    [4, 5, 6],
    [9, 8, 7]] */
    fun solution101(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        val size = matrix.size - 1
        for(i in 0 until matrix.size) {
            val tmp = matrix[i][i]
            matrix[i][i] = matrix[i][size - i]
            matrix[i][size - i] = tmp
        }
        return matrix
    }

    /**
     * Crossing Sum
     * @see "https://app.codesignal.com/arcade/code-arcade/list-backwoods/Nh48Nqxb2zGx2NvYK"
     * @return Crossing Sum
     * * @sample Given a rectangular matrix and integers a and b, consider the union of the ath row and the bth (both 0-based) column of the matrix (i.e. all cells that belong either to the ath row or to the bth column, or to both). Return sum of all elements of that union.

    Example

    For

    matrix = [[1, 1, 1, 1],
    [2, 2, 2, 2],
    [3, 3, 3, 3]]
    a = 1, and b = 3, the output should be
    solution(matrix, a, b) = 12.

    Here (2 + 2 + 2 + 2) + (1 + 3) = 12.*/
    fun solution102(matrix: MutableList<MutableList<Int>>, a: Int, b: Int): Int {
        var result = -matrix[a][b]
        result += matrix[a].sum()
        for (i in 0 until matrix.size)
            result += matrix[i][b]

        return result
    }

    /**
     * Draw Rectangle
     * @see "https://app.codesignal.com/arcade/code-arcade/list-backwoods/uFQEiM4trARdm2z46"
     * @return Draw Rectangle
     * * @sample You are implementing a command-line version of the Paint app. Since the command line doesn't support colors, you are using different characters to represent pixels. Your current goal is to support rectangle x1 y1 x2 y2 operation, which draws a rectangle that has an upper left corner at (x1, y1) and a lower right corner at (x2, y2). Here the x-axis points from left to right, and the y-axis points from top to bottom.

    Given the initial canvas state and the array that represents the coordinates of the two corners, return the canvas state after the operation is applied. For the details about how rectangles are painted, see the example.

    Example

    For

    canvas =
    [['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
    ['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
    ['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'],
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b']]
    and rectangle = [1, 1, 4, 3], the output should be

    solution(canvas, rectangle) =
    [['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
    ['a', '*', '-', '-', '*', 'a', 'a', 'a'],
    ['a', '|', 'a', 'a', '|', 'a', 'a', 'a'],
    ['b', '*', '-', '-', '*', 'b', 'b', 'b'],
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b']]
    Here is the rectangle, colored for illustration:


    [['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
    ['a', '*', '-', '-', '*', 'a', 'a', 'a'],
    ['a', '|', 'a', 'a', '|', 'a', 'a', 'a'],
    ['b', '*', '-', '-', '*', 'b', 'b', 'b'],
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b']]
    Note that rectangle sides are depicted as -s and |s, asterisks (*) stand for its corners and all of the other "pixels" remain the same.*/
    fun solution103(canvas: MutableList<MutableList<Char>>, rectangle: MutableList<Int>): MutableList<MutableList<Char>> {
        val x1 = rectangle[0]
        val y1 = rectangle[1]
        val x2 = rectangle[2]
        val y2 = rectangle[3]
        for (i in x1 + 1 until x2) {
            canvas[y1][i] = '-'
            canvas[y2][i] = '-'
        }
        for (i in y1 + 1 until y2) {
            canvas[i][x1] = '|'
            canvas[i][x2] = '|'
        }
        canvas[y1][x1] = '*'
        canvas[y2][x2] = '*'
        canvas[y1][x2] = '*'
        canvas[y2][x1] = '*'

        return canvas
    }

    /**
     * Volleyball Positions
     * @see "https://app.codesignal.com/arcade/code-arcade/list-backwoods/fmYdsYcGfaTu4yTQt"
     * @return Volleyball Positions
     * * @sample You are watching a volleyball tournament, but you missed the beginning of the very first game of your favorite team. Now you're curious about how the coach arranged the players on the field at the start of the game.

    The team you favor plays in the following formation:

    0 3 0
    4 0 2
    0 6 0
    5 0 1
    where positive numbers represent positions occupied by players. After the team gains the serve, its members rotate one position in a clockwise direction, so the player in position 2 moves to position 1, the player in position 3 moves to position 2, and so on, with the player in position 1 moving to position 6.

    Here's how the players change their positions:



    Given the current formation of the team and the number of times k it gained the serve, find the initial position of each player in it.

    Example

    For

    formation =
    [["empty",   "Player5", "empty"],
    ["Player4", "empty",   "Player2"],
    ["empty",   "Player3", "empty"],
    ["Player6", "empty",   "Player1"]]
    and k = 2, the output should be

    solution(formation, k) =
    [["empty",   "Player1", "empty"],
    ["Player2", "empty",   "Player3"],
    ["empty",   "Player4", "empty"],
    ["Player5", "empty",   "Player6"]]
    For

    formation =
    [["empty", "Alice", "empty"],
    ["Bob",   "empty", "Charlie"],
    ["empty", "Dave",  "empty"],
    ["Eve",   "empty", "Frank"]]
    and k = 6, the output should be

    solution(formation, k) =
    [["empty", "Alice", "empty"],
    ["Bob",   "empty", "Charlie"],
    ["empty", "Dave",  "empty"],
    ["Eve",   "empty", "Frank"]]*/
    fun solution104(formation: MutableList<MutableList<String>>, k: Int): MutableList<MutableList<String>> {
        val k1 = k % 6

        if(k1 == 0)
            return formation

        val players = mutableListOf(formation[3][2], formation[1][2], formation[0][1], formation[1][0], formation[3][0], formation[2][1])

        formation[3][2] = players[6 - k1]
        formation[1][2] = players[(7 - k1) % 6]
        formation[0][1] = players[(8 - k1) % 6]
        formation[1][0] = players[(9 - k1) % 6]
        formation[3][0] = players[(10 - k1) % 6]
        formation[2][1] = players[(11 - k1) % 6]

        return formation
    }

    /**
     * Star Rotation
     * @see "https://app.codesignal.com/arcade/code-arcade/list-backwoods/A5meC5REAcDfHeuFf"
     * @return Star Rotation
     * * @sample Consider a (2k+1) × (2k+1) square subarray of an integer integers matrix. Let's call the union of the square's two longest diagonals, middle column and middle row a star. Given the coordinates of the star's center in the matrix and its width, rotate it 45 · t degrees clockwise preserving position of all matrix elements that do not belong to the star.

    Example

    For

    matrix =
    [[1, 0, 0, 2, 0, 0, 3],
    [0, 1, 0, 2, 0, 3, 0],
    [0, 0, 1, 2, 3, 0, 0],
    [8, 8, 8, 9, 4, 4, 4],
    [0, 0, 7, 6, 5, 0, 0],
    [0, 7, 0, 6, 0, 5, 0],
    [7, 0, 0, 6, 0, 0, 5]]
    width = 7, center = [3, 3], and t = 1, the output should be

    solution(matrix, width, center, t) =
    [[8, 0, 0, 1, 0, 0, 2],
    [0, 8, 0, 1, 0, 2, 0],
    [0, 0, 8, 1, 2, 0, 0],
    [7, 7, 7, 9, 3, 3, 3],
    [0, 0, 6, 5, 4, 0, 0],
    [0, 6, 0, 5, 0, 4, 0],
    [6, 0, 0, 5, 0, 0, 4]]
    For

    matrix =
    [[1, 0, 0, 2, 0, 0, 3],
    [0, 1, 0, 2, 0, 3, 0],
    [0, 0, 1, 2, 3, 0, 0],
    [8, 8, 8, 9, 4, 4, 4],
    [0, 0, 7, 6, 5, 0, 0]]
    width = 3, center = [1, 5], and t = 81, the output should be

    solution(matrix, width, center, t) =
    [[1, 0, 0, 2, 0, 0, 0],
    [0, 1, 0, 2, 3, 3, 3],
    [0, 0, 1, 2, 0, 0, 0],
    [8, 8, 8, 9, 4, 4, 4],
    [0, 0, 7, 6, 5, 0, 0]]*/
    fun solution105(matrix: MutableList<MutableList<Int>>, width: Int, center: MutableList<Int>, t: Int): MutableList<MutableList<Int>> {
        val x = center[0]
        val y = center[1]
        val w = width / 2

        for (j in 0 until t % 360) {
            for (i in 0 until w) {
                val temp = matrix[x - w + i][y - w + i]
                matrix[x - w + i][y - w + i] = matrix[x][y - w + i]
                matrix[x][y - w + i] = matrix[x + w - i][y - w + i]
                matrix[x + w - i][y - w + i] = matrix[x + w - i][y]
                matrix[x + w - i][y] = matrix[x + w - i][y + w - i]
                matrix[x + w - i][y + w - i] = matrix[x][y + w - i]
                matrix[x][y + w - i] = matrix[x - w + i][y + w - i]
                matrix[x - w + i][y + w - i] = matrix[x - w + i][y]
                matrix[x - w + i][y] = temp
            }
        }

        return matrix
    }
}