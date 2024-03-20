package intro

object _2_EdgeOfTheOcean {

    fun run() {
        println("4) AdjacentElementsProduct\n" +
                "      input: inputArray = ${mutableListOf(3, 6, -2, -5, 7, 3)}\n" +
                "      result: ${_2_EdgeOfTheOcean.solution4(mutableListOf(3, 6, -2, -5, 7, 3))}\n")
        println("5) ShapeArea\n" +
                "      input: n = 5\n" +
                "      result: ${_2_EdgeOfTheOcean.solution5(5)}\n")
        println("6) Make Array Consecutive 2\n" +
                "      input: statues = ${mutableListOf(6, 2, 3, 8)}\n" +
                "      result: ${_2_EdgeOfTheOcean.solution6(mutableListOf(6, 2, 3, 8))}\n")
        println("7) AlmostIncreasingSequence\n" +
                "      input: sequence = ${mutableListOf(1, 3, 2, 1)}\n" +
                "      result: ${_2_EdgeOfTheOcean.solution7(mutableListOf(1, 3, 2, 1))}\n")
        println("8) MatrixElementsSum\n" +
                "      input: matrixElementsSum = \n" +
                "             ${mutableListOf(0, 1, 1, 2)}\n" +
                "             ${mutableListOf(0, 5, 0, 0)}\n" +
                "             ${mutableListOf(2, 0, 3, 3)}\n" +
                "      result: ${_2_EdgeOfTheOcean.solution8(mutableListOf(
            mutableListOf(0, 1, 1, 2),
            mutableListOf(0, 5, 0, 0),
            mutableListOf(2, 0, 3, 3)))}\n")
    }

    /**
     * adjacentElementsProduct
     * Given an array of integers, find the pair of adjacent elements that has the largest product and return that product.
     * @see "https://app.codesignal.com/arcade/intro/level-2/xzKiBHjhoinnpdh6m"
     * * @sample for inputArray = [3, 6, -2, -5, 7, 3], the output should be
    solution(inputArray) = 21.

    7 and 3 produce the largest product
     */
    fun solution4(inputArray: MutableList<Int>): Int {
        var max = Int.MIN_VALUE
        for (i in 1..inputArray.count() - 1 ) {
            if(inputArray[i-1] * inputArray[i] > max)
                max = inputArray[i-1] * inputArray[i]
        }
        return max
    }

    /**
     * shapeArea
     * @see "https://app.codesignal.com/arcade/intro/level-2/yuGuHvcCaFCKk56rJ"
     * @return area
     * * @sample area of shape
     * -------*---
     * --*---***--
     * -***-*****-
     * --*---***--
     * -------*---
     */
    fun solution5(n: Int): Int {
        return (n*n) + ((n-1)*(n-1))
    }

    /**
     * Make Array Consecutive 2
     * @see "https://app.codesignal.com/arcade/intro/level-2/bq2XnSr5kbHqpHGJC"
     * @return count
     * * @sample Ratiorg got statues of different sizes as a present from CodeMaster for his birthday, each statue having an non-negative integer size. Since he likes to make things perfect, he wants to arrange them from smallest to largest so that each statue will be bigger than the previous one exactly by 1. He may need some additional statues to be able to accomplish that. Help him figure out the minimum number of additional statues needed.
        Example
        For statues = [6, 2, 3, 8], the output should be
        solution(statues) = 3.
        Ratiorg needs statues of sizes 4, 5 and 7.
     */
    fun solution6(statues: MutableList<Int>): Int {
        val max = statues.maxOf { it }
        val min = statues.minOf { it }
        return (max - min) - statues.count() + 1
    }

    /**
     * almostIncreasingSequence
     * @see "https://app.codesignal.com/arcade/intro/level-2/2mxbGwLzvkTCKAJMG"
     * @return can or not
     * * @sample Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by removing no more than one element from the array.

    Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an. Sequence containing only one element is also considered to be strictly increasing.

    Example

    For sequence = [1, 3, 2, 1], the output should be
    solution(sequence) = false.

    There is no one element in this array that can be removed in order to get a strictly increasing sequence.

    For sequence = [1, 3, 2], the output should be
    solution(sequence) = true.

    You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].
     */
    fun solution7(sequence: MutableList<Int>): Boolean {
        var flag = true
        for (i in 1 until sequence.count()) {
            if (sequence[i-1] >= sequence[i]) {
                if (flag) {
                    if (i > 1 && sequence[i-2] >= sequence[i] ) {
                        sequence[i]=sequence[i-1]
                    }
                    flag = false
                }
                else
                    return false
            }
        }
        return true
    }
    /**
     * matrixElementsSum
     * @see "https://app.codesignal.com/arcade/intro/level-2/xskq4ZxLyqQMCLshr"
     * @return can or not
     * * @sample After becoming famous, the CodeBots decided to move into a new building together. Each of the rooms has a different cost, and some of them are free, but there's a rumour that all the free rooms are haunted! Since the CodeBots are quite superstitious, they refuse to stay in any of the free rooms, or any of the rooms below any of the free rooms.

    Given matrix, a rectangular matrix of integers, where each value represents the cost of the room, your task is to return the total sum of all rooms that are suitable for the CodeBots (ie: add up all the values that don't appear below a 0).

    Example

    For

    matrix = [[0, 1, 1, 2],
    [0, 5, 0, 0],
    [2, 0, 3, 3]]
    the output should be
    solution(matrix) = 9
     */
    fun solution8(matrix: MutableList<MutableList<Int>>): Int {
        var sum = 0
        for (j in 0 until matrix[0].count()) {
            if(matrix[0][j] != 0) {
                var i = 0
                while ((i < matrix.count()) && matrix[i][j]>0) {
                    sum += matrix[i][j]
                    i++
                }
            }
        }
        return sum
    }


}