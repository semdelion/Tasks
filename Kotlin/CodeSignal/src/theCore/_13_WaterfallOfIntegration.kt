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
}