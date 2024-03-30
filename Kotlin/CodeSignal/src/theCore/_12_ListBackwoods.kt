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
                        ),column = 2)}\n")

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
}