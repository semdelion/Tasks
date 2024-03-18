package intro

object _4_ExploringTheWaters {

    fun run() {
        println("14 AlternatingSums  --> a = [50, 60, 60, 45, 70]; result: ${_4_ExploringTheWaters.solution14(mutableListOf(50, 60, 60, 45, 70))}")
        println("15 Add Border  --> picture = [\"abc\", \"ded\"]; result: ${_4_ExploringTheWaters.solution15(mutableListOf("abc", "ded"))}")
        println("16 Are Similar  --> a = [1, 2, 3] b = [2, 1, 3]; result: ${_4_ExploringTheWaters.solution16(
            mutableListOf(1, 2, 3),
            mutableListOf(2, 1, 3))}")
        println("17 ArrayChange  --> inputArray = [1, 1, 1]; result: ${_4_ExploringTheWaters.solution17(mutableListOf(1, 1, 1))}")
        println("18 PalindromeRearranging  --> inputString = \"abbaaaca\"; result: ${_4_ExploringTheWaters.solution18("abbaaaca")}")
    }

    /**
     * alternatingSums
     * @see "https://app.codesignal.com/arcade/intro/level-4/cC5QuL9fqvZjXJsW9"
     * @return alternatingSums
     * * @sample Several people are standing in a row and need to be divided into two teams. The first person goes into team 1, the second goes into team 2, the third goes into team 1 again, the fourth into team 2, and so on.

    You are given an array of positive integers - the weights of the people. Return an array of two integers, where the first element is the total weight of team 1, and the second element is the total weight of team 2 after the division is complete.

    Example

    For a = [50, 60, 60, 45, 70], the output should be
    solution(a) = [180, 105].
     */
    fun solution14(a: MutableList<Int>): MutableList<Int> {
        val result = mutableListOf(0, 0)
        for (i in 0 until a.count()) {
            result[i % 2] += a[i]
        }
        return result
    }

    /**
     * Add Border
     * @see "https://app.codesignal.com/arcade/intro/level-4/ZCD7NQnED724bJtjN"
     * @return Add Border
     * * @sample Given a rectangular matrix of characters, add a border of asterisks(*) to it.

    Example
    For
    picture = ["abc",
    "ded"]
    the output should be
    solution(picture) = ["*****",
    "*abc*",
    "*ded*",
    "*****"]
     */
    fun solution15(picture: MutableList<String>): MutableList<String> {
        for (i in 0 until picture.count()) {
            picture[i] = "*${picture[i]}*"
        }
        picture.add(0, "*".repeat(picture[0].length))
        picture.add("*".repeat(picture[0].length))

        return picture
    }

    /**
     * Are Similar?
     * @see "https://app.codesignal.com/arcade/intro/level-4/xYXfzQmnhBvEKJwXP"
     * @return Are Similar?
     * * @sample Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.

    Given two arrays a and b, check whether they are similar.

    Example

    For a = [1, 2, 3] and b = [1, 2, 3], the output should be
    solution(a, b) = true.

    The arrays are equal, no need to swap any elements.

    For a = [1, 2, 3] and b = [2, 1, 3], the output should be
    solution(a, b) = true.

    We can obtain b from a by swapping 2 and 1 in b.

    For a = [1, 2, 2] and b = [2, 1, 1], the output should be
    solution(a, b) = false.

    Any swap of any two elements either in a or in b won't make a and b equal.
     */
    fun solution16(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        var index = -1
        var countOfSwap = 0

        for (i in 0 until a.count()) {
            if (a[i] != b[i]) {
                if (countOfSwap > 0)
                    return false
                if (index == -1) {
                    index = i
                } else {
                    if (a[index] != b[i] || b[index] != a[i]) {
                        return false
                    } else {
                        countOfSwap++
                        index = -1
                    }
                }
            }
        }
        return index == -1
    }

    /**
     * arrayChange
     * @see "https://app.codesignal.com/arcade/intro/level-4/xvkRbxYkdHdHNCKjg"
     * @return arrayChange
     * * @sample You are given an array of integers. On each move you are allowed to increase exactly one of its element by one. Find the minimal number of moves required to obtain a strictly increasing sequence from the input.

    Example

    For inputArray = [1, 1, 1], the output should be
    solution(inputArray) = 3.
     */
    fun solution17(inputArray: MutableList<Int>): Int {
        var countOfChange = 0
        for (i in 1 until inputArray.count()) {
            if (inputArray[i - 1] >= inputArray[i]) {
                val tmp = inputArray[i - 1] - inputArray[i]  + 1
                inputArray[i] += tmp
                countOfChange += tmp
            }
        }
        return countOfChange
    }

    /**
     * palindromeRearranging
     * @see "https://app.codesignal.com/arcade/intro/level-4/Xfeo7r9SBSpo3Wico"
     * @return palindromeRearranging
     * * @sample Given a string, find out if its characters can be rearranged to form a palindrome.

    Example

    For inputString = "aabb", the output should be
    solution(inputString) = true.

    We can rearrange "aabb" to make "abba", which is a palindrome.
     */
    fun solution18(inputString: String): Boolean {
        val mapItems = MutableList(256){0}
        for(item in inputString)
            mapItems[item.code] += 1
        val count = mapItems.count { char -> char % 2 == 1  }
        return count <= (inputString.length%2)
    }
}