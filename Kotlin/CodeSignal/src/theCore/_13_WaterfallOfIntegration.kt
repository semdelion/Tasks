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
        println("108) Box Blur\n" +
                "      input: image = \n" +
                "             ${mutableListOf(7, 4, 0, 1)} \n" +
                "             ${mutableListOf(5, 6, 2, 2)} \n" +
                "             ${mutableListOf(6, 10, 7, 8)} \n" +
                "             ${mutableListOf(1, 4, 2, 0)} \n" +
                "      result:")
        solution108(
            mutableListOf(
                mutableListOf(7, 4, 0, 1),
                mutableListOf(5, 6, 2, 2),
                mutableListOf(6, 10, 7, 8),

                mutableListOf(1, 4, 2, 0)
            )
        ).forEach { println("             $it") }
        println()
        println("109) Contours Shifting\n" +
                "      input: image = \n" +
                "             ${mutableListOf(1,   2,  3,  4)} \n" +
                "             ${mutableListOf(5,   6,  7,  8)} \n" +
                "             ${mutableListOf(9,  10, 11, 12)} \n" +
                "             ${mutableListOf(13, 14, 15, 16)} \n" +
                "             ${mutableListOf(17, 18, 19, 20)} \n" +
                "      result:")
        solution109(
            mutableListOf(
                mutableListOf(1,   2,  3,   4),
                mutableListOf(5,   6,  7,   8),
                mutableListOf(9,   10, 11, 12),
                mutableListOf(13,  14, 15, 16),
                mutableListOf(17,  18, 19, 20)
            )
        ).forEach { println("             $it") }
        println()
        println("110) Polygon Perimeter\n" +
                "      input: matrix = \n" +
                "             ${mutableListOf(false, true,  true)} \n" +
                "             ${mutableListOf(true,  true,  false)} \n" +
                "             ${mutableListOf(true,  false, false)} \n" +
                "      result: ${
                    solution110(
                        mutableListOf(
                            mutableListOf(false, true, true),
                            mutableListOf(true, true, false),
                            mutableListOf(true, false, false)
                        )
                    )
                }\n")
        println("111) Gravitation\n" +
                "      input: rows = \n" +
                "             \"#..##\",\n" +
                "             \".##.#\",\n" +
                "             \".#.##\",\n" +
                "             \".....\",\n" +
                "      result: ${solution111(mutableListOf("#..##", ".##.#", ".#.##", "....."))}\n")

        println("112)  Is Information Consistent?\n" +
                "      input: evidences = \n" +
                "             [ 0, 1, 0, 1]\n" +
                "             [-1, 1, 0, 0]\n" +
                "             [-1, 0, 0, 1]\n" +
                "      result: ${solution112(mutableListOf(
                                            mutableListOf(  0, 1, 0, 1),
                                            mutableListOf( -1, 1, 0, 0),
                                            mutableListOf( -1, 0, 0, 1)))}\n")
        println("113)  Is Information Consistent?\n" +
        "      input: nonogramField = \n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"-\",\"4\",\"3\",\"-\",\"-\",\"-\",\"-\",\"-\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"-\",\"2\",\"2\",\"2\",\"1\",\"1\",\"3\",\"4\",\"2\",\"2\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"1\",\".\",\".\",\".\",\".\",\"#\",\".\",\".\",\".\",\".\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"5\",\".\",\".\",\"#\",\"#\",\"#\",\"#\",\"#\",\".\",\".\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"7\",\".\",\"#\",\"#\",\"#\",\"#\",\"#\",\"#\",\"#\",\".\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"9\",\"#\",\"#\",\"#\",\"#\",\"#\",\"#\",\"#\",\"#\",\"#\"]\n" +
        "             [\"1\",\"1\",\"1\",\"1\",\"1\",\"#\",\".\",\"#\",\".\",\"#\",\".\",\"#\",\".\",\"#\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"1\",\".\",\".\",\".\",\".\",\"#\",\".\",\".\",\".\",\".\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"1\",\".\",\".\",\".\",\".\",\"#\",\".\",\".\",\".\",\".\"]\n" +
        "             [\"-\",\"-\",\"-\",\"1\",\"1\",\".\",\".\",\"#\",\".\",\"#\",\".\",\".\",\".\",\".\"]\n" +
        "             [\"-\",\"-\",\"-\",\"-\",\"3\",\".\",\".\",\"#\",\"#\",\"#\",\".\",\".\",\".\",\".\"]\n" +
        "             size: 9\n" +
        "      result: ${solution113(9, mutableListOf(
                                                    mutableListOf("-","-","-","-","-","-","-","-","-","-" ,"-","-","-","-"),
                                                    mutableListOf("-","-","-","-","-","-","-","-","-","-" ,"-","-","-","-"),
                                                    mutableListOf("-","-","-","-","-","-","-","-","-","-" ,"-","-","-","-"),
                                                    mutableListOf("-","-","-","-","-","-","-","4","3","-" ,"-","-","-","-"),
                                                    mutableListOf("-","-","-","-","-","2","2","2","1","9","3","4","2","2"),
                                                    mutableListOf("-","-","-","-","1",".",".",".",".","#",".",".",".","."),
                                                    mutableListOf("-","-","-","-","5",".",".","#","#","#","#","#",".","."),
                                                    mutableListOf("-","-","-","-","7",".","#","#","#","#","#","#","#","."),
                                                    mutableListOf("-","-","-","-","9","#","#","#","#","#","#","#","#","#"),
                                                    mutableListOf("1","1","1","1","1","#",".","#",".","#",".","#",".","#"),
                                                    mutableListOf("-","-","-","-","1",".",".",".",".","#",".",".",".","."),
                                                    mutableListOf("-","-","-","-","1",".",".",".",".","#",".",".",".","."),
                                                    mutableListOf("-","-","-","1","1",".",".","#",".","#",".",".",".","."),
                                                    mutableListOf("-","-","-","-","3",".",".","#","#","#",".",".",".",".")))}\n")
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

    /**
     * Box Blur
     * @see "https://app.codesignal.com/arcade/code-arcade/waterfall-of-integration/5xPitc3yT3dqS7XkP"
     * @return Box Blur
     * * @sample Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral! You can't let this ruin your reputation, so you want to apply the box blur algorithm to the photo to hide its content.

    The pixels in the input image are represented as integers. The algorithm distorts the input image in the following way: Every pixel x in the output image has a value equal to the average value of the pixel values from the 3 × 3 square that has its center at x, including x itself. All the pixels on the border of x are then removed.

    Return the blurred image as an integer, with the fractions rounded down.

    Example

    For

    image =
    [1, 1, 1],
    [1, 7, 1],
    [1, 1, 1]
    the output should be solution(image) = [[1]].

    To get the value of the middle pixel in the input 3 × 3 square: (1 + 1 + 1 + 1 + 7 + 1 + 1 + 1 + 1) = 15 / 9 = 1.66666 = 1. The border pixels are cropped from the final result.

    For

    image =
    [7, 4,  0, 1],
    [5, 6,  2, 2],
    [6, 10, 7, 8],
    [1, 4,  2, 0]
    the output should be

    solution(image) = [[5, 4],
    [4, 4]]
    There are four 3 × 3 squares in the input image, so there should be four integers in the blurred output. To get the first value: (7 + 4 + 0 + 5 + 6 + 2 + 6 + 10 + 7) = 47 / 9 = 5.2222 = 5. The other three integers are obtained the same way, then the surrounding integers are cropped from the final result.
     */
    fun solution108(image: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        val blurImage = MutableList(image.count() - 2) { MutableList(image[0].count() - 2) { 0 } }
        for (i in 0..image.count() - 3) {
            for (j in 0..image[i].count() - 3) {
                blurImage[i][j] = (
                        (image[i][j] + image[i][j + 1] + image[i][j + 2] +
                                image[i + 1][j] + image[i + 1][j + 1] + image[i + 1][j + 2] +
                                image[i + 2][j] + image[i + 2][j + 1] + image[i + 2][j + 2]) / 9)
            }
        }
        return blurImage
    }

    /**
     * Contours Shifting
     * @see "https://app.codesignal.com/arcade/code-arcade/waterfall-of-integration/LfP67YRDw2rxoLmeP"
     * @return Contours Shifting
     * * @sample Mark got a rectangular array matrix for his birthday, and now he's thinking about all the fun things he can do with it. He likes shifting a lot, so he decides to shift all of its i-contours in a clockwise direction if i is even, and counterclockwise if i is odd.

    Here is how Mark defines i-contours:

    the 0-contour of a rectangular array as the union of left and right columns as well as top and bottom rows;
    consider the initial matrix without the 0-contour: its 0-contour is the 1-contour of the initial matrix;
    define 2-contour, 3-contour, etc. in the same manner by removing 0-contours from the obtained arrays.
    Implement a function that does exactly what Mark wants to do to his matrix.

    Example

    For

    matrix =
    [ 1,  2,  3,  4],
    [ 5,  6,  7,  8],
    [ 9, 10, 11, 12],
    [13, 14, 15, 16],
    [17, 18, 19, 20]
    the output should be

    solution(matrix) =
    [ 5,  1,  2,  3],
    [ 9,  7, 11,  4],
    [13,  6, 15,  8],
    [17, 10, 14, 12],
    [18, 19, 20, 16]
    For matrix = [[238, 239, 240, 241, 242, 243, 244, 245]],
    the output should be
    solution(matrix) = [[245, 238, 239, 240, 241, 242, 243, 244]].

    Note, that if a contour is represented by a 1 × n array, its center is considered to be below it.

    For

    matrix = [[238],
    [239],
    [240],
    [241],
    [242],
    [243],
    [244],
    [245]]
    the output should be

    solution(matrix) = [[245],
    [238],
    [239],
    [240],
    [241],
    [242],
    [243],
    [244]]
    If a contour is represented by an n × 1 array, its center is considered to be to the left of it.*/
    fun solution109(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        val maxContour = if (matrix.size > 1 && matrix[0].size > 1) Math.round(Math.min(matrix.size, matrix[0].size) /
                2.0) - 1
        else 0
        (0..maxContour.toInt()).forEach {
            val contourI = icontour(matrix, it)
            val shiftedContour = shiftContour(contourI, if (it % 2 == 1) 1 else -1)
            shiftedContour.forEach {
                matrix[it.first.first][it.first.second] = it.second
            }
        }
        return matrix
    }

    private fun icontour(inputMatrix: MutableList<MutableList<Int>>, i: Int): MutableList<Pair<Pair<Int, Int>, Int>> {
        val m = inputMatrix.indices.map { ri ->
            inputMatrix[ri].indices.map { ci ->
                Pair(ri, ci) to inputMatrix[ri][ci]
            }
        }
        if ((m.size - 1 - i) == i) {
            return m[i].subList(i, m[0].size - i).toMutableList()
        }
        if ((m[0].size - 1 - i) == i) {
            return m.subList(i, m.size - i).map { it[i] }.toMutableList()
        }
        val topRow = m[i].subList(i, m[0].size - i)

        val rightCol = m.subList(i + 1, m.size - i - 1)
            .map { it[m[0].size - i - 1]}
        val bottomRow = (m[0].size - 1 - i).downTo(i).map {m[m.size - 1 - i][it] }
        val leftCol = (m.size - i - 2).downTo(i+1).map { m[it][i]}
        val contour = listOf(topRow, rightCol, bottomRow, leftCol).flatten()
        return contour.toMutableList()
    }

    private fun shiftContour(contour: MutableList<Pair<Pair<Int, Int>, Int>>, d: Int): MutableList<Pair<Pair<Int, Int>, Int>> {
        return contour.indices.map {
            contour[it].first to contour[(it + contour.size + d) % contour.size].second
        }.toMutableList()
    }

    /**
     * Polygon Perimeter
     * @see "https://app.codesignal.com/arcade/code-arcade/waterfall-of-integration/L7KWEYbPoornGyf7K"
     * @return Polygon Perimeter
     * * @sample You have a rectangular white board with some black cells. The black cells create a connected black figure, i.e. it is possible to get from any black cell to any other one through connected adjacent (sharing a common side) black cells.

    Find the perimeter of the black figure assuming that a single cell has unit length.

    It's guaranteed that there is at least one black cell on the table.

    Example

    For

    matrix = [[false, true,  true ],
    [true,  true,  false],
    [true,  false, false]]
    the output should be
    solution(matrix) = 12.



    For

    matrix = [[true, true,  true],
    [true, false, true],
    [true, true,  true]]
    the output should be
    solution(matrix) = 16.

     */
    fun solution110(matrix: MutableList<MutableList<Boolean>>): Int {
        var count = 0
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                if (matrix[i][j]) {
                    if (i - 1 < 0 || !matrix[i - 1][j])
                        count++
                    if (j - 1 < 0 || !matrix[i][j - 1])
                        count++
                    if (i + 1 == matrix.size || !matrix[i + 1][j])
                        count++
                    if (j + 1 == matrix[0].size || !matrix[i][j + 1])
                        count++
                }
            }
        }
        return count
    }

    /**
     * Gravitation
     * @see "https://app.codesignal.com/arcade/code-arcade/waterfall-of-integration/hqrYesGKEaKQnv7Sv"
     * @return Gravitation
     * * @sample You are given a vertical box divided into equal columns. Someone dropped several stones from its top through the columns. Stones are falling straight down at a constant speed (equal for all stones) while possible (i.e. while they haven't reached the ground or they are not blocked by another motionless stone). Given the state of the box at some moment in time, find out which columns become motionless first.

    Example

    For

    rows =
    "#..##",
    ".##.#",
    ".#.##",
    "....."
    the output should be solution(rows) = [1, 4].

    Check out the image below for better understanding:

     */
    fun solution111(rows: MutableList<String>): MutableList<Int> {
        val times = mutableListOf<Int>()
        for (i in 0 until rows[0].length) {
            var flag = false
            var count = 0
            for (j in 0 until rows.size) {
                if (rows[j][i] == '#') flag = true
                if (rows[j][i] == '.' && flag) count++
            }
            times.add(count)
        }
        val min = times.minOf{it}
        val result = mutableListOf<Int>()
        for (i in 0 until times.size) {
            if (times[i] == min) result.add(i)
        }
        return result
    }

    /**
     * Is Information Consistent?
     * @see "https://app.codesignal.com/arcade/code-arcade/waterfall-of-integration/jkuhbNn7AdeCC7z7R"
     * @return Is Information Consistent?
     * * @sample Court is in session. We got a group of witnesses who have all taken an oath to tell the truth. The prosecutor is pointing at the defendants one by one and asking each witnesses a simple question - "guilty or not?". The witnesses are allowed to respond in one of the following three ways:

    I am sure he/she is guilty.
    I am sure he/she is innocent.
    I have no idea.
    The prosecutor has a hunch that one of the witnesses might not be telling the truth so she decides to cross-check all of their testimonies and see if the information gathered is consistent, i.e. there are no two witnesses A and B and a defendant C such that A says C is guilty while B says C is innocent.

    Example

    For

    evidences =
    [ 0, 1, 0, 1],
    [-1, 1, 0, 0],
    [-1, 0, 0, 1]
    the output should be
    solution(evidences) = true;

    For

    evidences =
    [ 1, 0],
    [-1, 0],
    [ 1, 1],
    [ 1, 1]
    the output should be
    solution(evidences) = false. */
    fun solution112(evidences: MutableList<MutableList<Int>>): Boolean {
        for (i in 0 until evidences[0].size) {
            var flag = 0
            for(j in 0 until evidences.size) {
                if (evidences[j][i] != 0) {
                    if (flag == 0) {
                        flag = evidences[j][i]
                    } else if(flag != evidences[j][i]) {
                        return false
                    }
                }
            }
        }
        return true
    }

    /**
     * Correct Nonogram
     * @see "https://app.codesignal.com/arcade/code-arcade/waterfall-of-integration/jkuhbNn7AdeCC7z7R"
     * @return Is Information Consistent?
     * * @sample A nonogram is also known as Paint by Numbers and Japanese Crossword. The aim in this puzzle is to color the grid into black and white squares. At the top of each column, and at the side of each row, there are sets of one or more numbers which describe the runs of black squares in that row/column in exact order. For example, if you see 10 1 along some column/row, this indicates that there will be a run of exactly ten black squares, followed by one or more white squares, followed by a single black square. The cells along the edges of the grid can also be white.

    You are given a square nonogram of size size. Its grid is given as a square matrix nonogramField of size (size + 1) / 2 + size, where the first (size + 1) / 2 cells of each row and and each column define the numbers for the corresponding row/column, and the rest size × size cells define the the grid itself.

    Determine if the given nonogram has been solved correctly.

    Note: here / means integer division.

    Example

    For size = 5 and

    nonogramField =
    ["-", "-", "-", "-", "-", "-", "-", "-"],
    ["-", "-", "-", "2", "2", "1", "-", "1"],
    ["-", "-", "-", "2", "1", "1", "3", "3"],
    ["-", "3", "1", "#", "#", "#", ".", "#"],
    ["-", "-", "2", "#", "#", ".", ".", "."],
    ["-", "-", "2", ".", ".", ".", "#", "#"],
    ["-", "1", "2", "#", ".", ".", "#", "#"],
    ["-", "-", "5", "#", "#", "#", "#", "#"]
    the output should be solution(size, nonogramField) = true;

    For size = 5 and

    nonogramField =
    ["-", "-", "-", "-", "-", "-", "-", "-"],
    ["-", "-", "-", "-", "-", "1", "-", "-"],
    ["-", "-", "-", "3", "3", "2", "5", "5"],
    ["-", "-", "3", ".", ".", ".", "#", "#"],
    ["-", "2", "2", "#", "#", "#", "#", "#"],
    ["-", "-", "5", "#", "#", "#", "#", "#"],
    ["-", "-", "5", "#", "#", "#", "#", "#"],
    ["-", "-", "2", ".", ".", ".", "#", "#"]
    the output should be solution(size, nonogramField) = false.

    There are three mistakes in the nonogram:

    In the 5th (1-based) row there are numbers ["-", "2", "2"], so there should be two runs of 2 black squares separated by at least one white square. However, there is only one run of 5 black squares.
    In the 6th column there are numbers ["-", "1", "2"], so there should be a run of exactly 1 black square, followed by one or more white squares, followed by another 2 black squares. However, there is a single run of 3 black squares not separated by white ones.
    Finally, in the 4th row there are numbers ["-", "-", "3"], so there should be a single run of exactly 3 black squares. However, there is just a 2-square run in that row.*/
    fun solution113(size: Int, nonogramField: MutableList<MutableList<String>>): Boolean {
        val start = (size + 1) / 2
        val end = (size + 1) / 2 + size
        for (i in start until end) {
            var j = start
            for (k in 0 until start) {
                if(nonogramField[i][k][0].isDigit()) {
                    var count = nonogramField[i][k].toInt()
                    while (j < end && nonogramField[i][j] == ".") j++

                    if (nonogramField[i][j - 1] == "#")
                        return false

                    while (j < end && count > 0) {
                        if (nonogramField[i][j] != "#")
                            return false
                        count--
                        j++
                    }
                    if (count > 0)
                        return false
                }
            }
            while (j < end) {
                if (nonogramField[i][j] == "#")
                    return false
                j++
            }
        }
        for (j in start until end) {
            var i = start
            for (k in 0 until start) {
                if(nonogramField[k][j][0].isDigit()) {
                    var count = nonogramField[k][j].toInt()
                    while (i < end && nonogramField[i][j] == ".") i++

                    if (nonogramField[i - 1][j] == "#")
                        return false

                    while (i < end && count > 0) {
                        if (nonogramField[i][j] != "#")
                            return false
                        count--
                        i++
                    }
                    if (count > 0)
                        return false
                }
            }
            while (i < end) {
                if (nonogramField[i][j] == "#")
                    return false
                i++
            }
        }
        return true
    }
}