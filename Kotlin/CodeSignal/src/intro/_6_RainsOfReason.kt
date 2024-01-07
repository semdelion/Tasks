package intro

object _6_RainsOfReason {
    /**
     * Minesweeper
     * @see "https://app.codesignal.com/arcade/intro/level-5/ZMR5n7vJbexnLrgaM"
     * @return Minesweeper
     * * @sample In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a number in it that indicates the total number of mines in the neighboring cells. Starting off with some arrangement of mines we want to create a Minesweeper game setup.

    Example

    For

    matrix = [[true, false, false],
    [false, true, false],
    [false, false, false]]
    the output should be

    solution(matrix) = [[1, 2, 1],
    [2, 1, 1],
    [1, 1, 1]]
    Check out the image below for better understanding:
     */
    fun solution25(matrix: MutableList<MutableList<Boolean>>): MutableList<MutableList<Int>> {
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