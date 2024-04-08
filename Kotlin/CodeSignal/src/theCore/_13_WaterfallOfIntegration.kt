package theCore

object _13_WaterfallOfIntegration {
    fun run() {
        println("106) Sudoku\n" +
                "      input: grid = \n" +
                "             [1,3,2,5,4,6,9,8,7]\n" +
                "             [4,6,5,8,7,9,3,2,1]\n" +
                "             [7,9,8,2,1,3,6,5,4]\n" +
                "             [9,2,1,4,3,5,8,7,6]\n" +
                "             [3,5,4,7,6,8,2,1,9]\n" +
                "             [6,8,7,1,9,2,5,4,3]\n" +
                "             [5,7,6,9,8,1,4,3,2]\n" +
                "             [2,4,3,6,5,7,1,9,8]\n" +
                "             [8,1,9,3,2,4,7,6,5]\n" +
                "      result: ${
                    solution106(
                        mutableListOf(
                            mutableListOf(1, 3, 2, 5, 4, 6, 9, 8, 7),
                            mutableListOf(4, 6, 5, 8, 7, 9, 3, 2, 1),
                            mutableListOf(7, 9, 8, 2, 1, 3, 6, 5, 4),
                            mutableListOf(9, 2, 1, 4, 3, 5, 8, 7, 6),
                            mutableListOf(3, 5, 4, 7, 6, 8, 2, 1, 9),
                            mutableListOf(6, 8, 7, 1, 9, 2, 5, 4, 3),
                            mutableListOf(5, 7, 6, 9, 8, 1, 4, 3, 2),
                            mutableListOf(2, 4, 3, 6, 5, 7, 1, 9, 8),
                            mutableListOf(8, 1, 9, 3, 2, 4, 7, 6, 5),
                        )
                    )
                }\n"
        )
        println("107) Minesweeper\n" +
                "      input: matrix = \n" +
                "             ${mutableListOf(true, false, false)} \n" +
                "             ${mutableListOf(false, true, false)} \n" +
                "             ${mutableListOf(false, false, false)} \n" +
                "      result: ")
        solution107(
            mutableListOf(
                mutableListOf(true, false, false),
                mutableListOf(false, true, false),
                mutableListOf(false, false, false)
            )
        ).forEach { println("             $it") }
        println()
    }

    /**
     * Sudoku
     * @see "https://app.codesignal.com/arcade/code-arcade/waterfall-of-integration/tQgasP8b62JBeirMS"
     * @return Sudoku
     * * @sample Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with digits so that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid contains all of the digits from 1 to 9.

    This algorithm should check if the given grid of numbers represents a correct solution to Sudoku.

    Example

    For
    grid = [[1, 3, 2, 5, 4, 6, 9, 8, 7],
    [4, 6, 5, 8, 7, 9, 3, 2, 1],
    [7, 9, 8, 2, 1, 3, 6, 5, 4],
    [9, 2, 1, 4, 3, 5, 8, 7, 6],
    [3, 5, 4, 7, 6, 8, 2, 1, 9],
    [6, 8, 7, 1, 9, 2, 5, 4, 3],
    [5, 7, 6, 9, 8, 1, 4, 3, 2],
    [2, 4, 3, 6, 5, 7, 1, 9, 8],
    [8, 1, 9, 3, 2, 4, 7, 6, 5]]
    the output should be
    solution(grid) = true;*/
    fun solution106(grid: MutableList<MutableList<Int>>): Boolean {
        for (i in 0..8) {
            val lineSet = mutableSetOf<Int>()
            val rowSet = mutableSetOf<Int>()
            val squareSet = mutableSetOf<Int>()
            for (j in 0..8) {
                lineSet.add(grid[i][j])
                rowSet.add(grid[j][i])
                squareSet.add(grid[((i/3) * 3) + j/3][((i*3) % 9) + j%3])
            }
            if(lineSet.count()!=9 || rowSet.count()!=9 || squareSet.count()!=9)
                return false
        }
        return true
    }

    /**
     * Minesweeper
     * @see "https://app.codesignal.com/arcade/code-arcade/waterfall-of-integration/ZMR5n7vJbexnLrgaM"
     * @return Minesweeper
     * * @sample In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a number in it that indicates the total number of mines in the neighboring cells. Starting off with some arrangement of mines we want to create a Minesweeper game setup.

    Example

    For

    matrix =
    [true, false, false],
    [false, true, false],
    [false, false, false]
    the output should be

    solution(matrix) =
    [1, 2, 1],
    [2, 1, 1],
    [1, 1, 1]
    Check out the image below for better understanding:
     */
    fun solution107(matrix: MutableList<MutableList<Boolean>>): MutableList<MutableList<Int>> {
        val resultMatrix = MutableList(matrix.count()) { MutableList(matrix[0].count()) { 0 } }
        for (i in 0 until matrix.count()) {
            for (j in 0 until matrix[i].count()) {
                if(matrix[i][j]) {
                    for(index in 0..8) {
                        val i1 = (i - 1 + index / 3)
                        val j1 = (j - 1 + index % 3)
                        if( i1 >= 0 &&  j1 >=0 && i1 < matrix.count() && j1 < matrix[i].count() && (i1 != i || j1 != j)) {
                            resultMatrix[i1][j1]++
                        }
                    }
                }
            }
        }
        return resultMatrix
    }
}