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
}