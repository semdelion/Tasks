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
}