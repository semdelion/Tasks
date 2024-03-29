package intro

import kotlin.math.abs

object _5_IslandOfKnowledge {

    fun run() {
        println("19) AreEquallyStrong\n" +
                "      input: yourLeft=10, yourRight=15, friendsLeft=15, friendsRight=10\n" +
                "      result: ${solution19(10, 15,15, 10)}\n")
        println("20) ArrayMaximalAdjacentDifference\n" +
                "      input: inputArray = [2, 4, 1, 0]\n" +
                "      result: ${solution20(mutableListOf(2, 4, 1, 0))}\n")
        println("21) IsIPv4Address\n" +
                "      input: inputString = \"121.121.321.01\"\n" +
                "      result: ${solution21("121.121.321.01")}\n")
        println("22) AvoidObstacles\n" +
                "      input: inputArray = [5, 3, 6, 7, 9]\n" +
                "      result: ${solution22(mutableListOf(5, 3, 6, 7, 9))}\n")
        println("23) Box Blur\n" +
                "      input: image = \n" +
                "             ${mutableListOf(7, 4, 0, 1)} \n" +
                "             ${mutableListOf(5, 6, 2, 2)} \n" +
                "             ${mutableListOf(6, 10, 7, 8)} \n" +
                "             ${mutableListOf(1, 4, 2, 0)} \n" +
                "      result:")
        solution23(mutableListOf(
            mutableListOf(7, 4, 0, 1),
            mutableListOf(5, 6, 2, 2),
            mutableListOf(6, 10, 7, 8),
            mutableListOf(1, 4, 2, 0))).forEach { println("             $it") }
        println()

        println("24) Minesweeper\n" +
                "      input: matrix = \n" +
                "             ${mutableListOf(true, false, false)} \n" +
                "             ${mutableListOf(false, true, false)} \n" +
                "             ${mutableListOf(false, false, false)} \n" +
                "      result: ")
        solution24(mutableListOf(
            mutableListOf(true, false, false),
            mutableListOf(false, true, false),
            mutableListOf(false, false, false))).forEach { println("             $it") }
        println()
    }

    /**
     * areEquallyStrong
     * @see "https://app.codesignal.com/arcade/intro/level-5/g6dc9KJyxmFjB98dL"
     * @return palindromeRearranging
     * * @sample Call two arms equally strong if the heaviest weights they each are able to lift are equal.

    Call two people equally strong if their strongest arms are equally strong (the strongest arm can be both the right and the left), and so are their weakest arms.

    Given your and your friend's arms' lifting capabilities find out if you two are equally strong.
     */
    fun solution19(yourLeft: Int, yourRight: Int, friendsLeft: Int, friendsRight: Int): Boolean {
        if (yourLeft == friendsLeft) {
            return yourRight == friendsRight
        } else if (yourLeft == friendsRight) {
            return yourRight == friendsLeft
        }
        return false
    }

    /**
     * arrayMaximalAdjacentDifference
     * @see "https://app.codesignal.com/arcade/intro/level-5/EEJxjQ7oo7C5wAGjE"
     * @return arrayMaximalAdjacentDifference
     * * @sample Call two arms equally strong if the heaviest weights they each are able to lift are equal.

    Call two people equally strong if their strongest arms are equally strong (the strongest arm can be both the right and the left), and so are their weakest arms.

    Given your and your friend's arms' lifting capabilities find out if you two are equally strong.
     */
    fun solution20(inputArray: MutableList<Int>): Int {
        var max = Int.MIN_VALUE
        for (i in 1 until inputArray.count()) {
            if (abs(inputArray[i - 1] - inputArray[i]) > max)
                max = abs(inputArray[i - 1] - inputArray[i])
        }
        return max
    }

    /**
     * isIPv4Address
     * @see "https://app.codesignal.com/arcade/intro/level-5/veW5xJednTy4qcjso"
     * @return isIPv4Address
     * * @sample An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions of addresses. One of them is the IPv4 address.

    Given a string, find out if it satisfies the IPv4 address naming rules.

    Example

    For inputString = "172.16.254.1", the output should be
    solution(inputString) = true;

    For inputString = "172.316.254.1", the output should be
    solution(inputString) = false.

    316 is not in range [0, 255].

    For inputString = ".254.255.0", the output should be
    solution(inputString) = false.

    There is no first number.
     */
    fun solution21(inputString: String): Boolean {
        val octets = inputString.split('.')
        if (octets.count() != 4)
            return false
        for (octet in octets) {
            val item = octet.toIntOrNull()
            if (item == null || item.toString() != octet || item !in (0..255))
                return false
        }
        return true
    }

    /**
     * avoidObstacles
     * @see "https://app.codesignal.com/arcade/intro/level-5/XC9Q2DhRRKQrfLhb5"
     * @return avoidObstacles
     * * @sample You are given an array of integers representing coordinates of obstacles situated on a straight line.

    Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to make jumps of the same length represented by some integer.

    Find the minimal length of the jump enough to avoid all the obstacles.

    Example

    For inputArray = [5, 3, 6, 7, 9], the output should be
    solution(inputArray) = 4.

    Check out the image below for better understanding:
     */
    fun solution22(inputArray: MutableList<Int>): Int {
        for (i in 2 until Int.MAX_VALUE) {
            if (inputArray.all { it % i != 0 })
                return i
        }
        return Int.MAX_VALUE;
    }

    /**
     * Box Blur
     * @see "https://app.codesignal.com/arcade/intro/level-5/XC9Q2DhRRKQrfLhb5"
     * @return Box Blur
     * * @sample Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral! You can't let this ruin your reputation, so you want to apply the box blur algorithm to the photo to hide its content.

    The pixels in the input image are represented as integers. The algorithm distorts the input image in the following way: Every pixel x in the output image has a value equal to the average value of the pixel values from the 3 × 3 square that has its center at x, including x itself. All the pixels on the border of x are then removed.

    Return the blurred image as an integer, with the fractions rounded down.
     */
    fun solution23(image: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
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
    fun solution24(matrix: MutableList<MutableList<Boolean>>): MutableList<MutableList<Int>> {
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