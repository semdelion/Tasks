package intro

object _8_DivingDeeper {
    fun run() {
        println("34 ExtractEachKth: ${_8_DivingDeeper.solution34(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2)}")
        println("35 FirstDigit: ${_8_DivingDeeper.solution35("var_1__Int")}")
        println("36 DifferentSymbolsNaive: ${_8_DivingDeeper.solution36("cabca")}")
        println("37 ArrayMaxConsecutiveSum: ${_8_DivingDeeper.solution37(mutableListOf(2, 3, 5, 1, 6), 2)}")
    }

    /**
     * extractEachKth
     * @see "https://app.codesignal.com/arcade/intro/level-8/3AgqcKrxbwFhd3Z3R"
     * @return extractEachKth
     * * @sample Given array of integers, remove each kth element from it.

    Example

    For inputArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] and k = 3, the output should be
    solution(inputArray, k) = [1, 2, 4, 5, 7, 8, 10].
     */
    fun solution34(inputArray: MutableList<Int>, k: Int): MutableList<Int> {
        val res = mutableListOf<Int>()
        for (i in 0 until inputArray.count()) {
            if ((i + 1) % k != 0)
                res.add(inputArray[i])
        }
        return res
    }

    /**
     * FirstDigit
     * @see "https://app.codesignal.com/arcade/intro/level-8/rRGGbTtwZe2mA8Wov"
     * @return FirstDigit
     * * @sample Find the leftmost digit that occurs in a given string.
    Example

    For inputString = "var_1__Int", the output should be
    solution(inputString) = '1';
    For inputString = "q2q-q", the output should be
    solution(inputString) = '2';
    For inputString = "0ss", the output should be
    solution(inputString) = '0'.
     */
    fun solution35(inputString: String): Char = inputString.first { it.isDigit() }


    /**
     * differentSymbolsNaive
     * @see "https://app.codesignal.com/arcade/intro/level-8/8N7p3MqzGQg5vFJfZ"
     * @return differentSymbolsNaive
     * * @sample Given a string, find the number of different characters in it.

    Example

    For s = "cabca", the output should be
    solution(s) = 3.

    There are 3 different characters a, b and c.
     */
    fun solution36(s: String): Int = s.toSet().count()

    /**
     * arrayMaxConsecutiveSum
     * @see "https://app.codesignal.com/arcade/intro/level-8/Rqvw3daffNE7sT7d5"
     * @return arrayMaxConsecutiveSum
     * * @sample Given array of integers, find the maximal possible sum of some of its k consecutive elements.

    Example

    For inputArray = [2, 3, 5, 1, 6] and k = 2, the output should be
    solution(inputArray, k) = 8.
    All possible sums of 2 consecutive elements are:

    2 + 3 = 5;
    3 + 5 = 8;
    5 + 1 = 6;
    1 + 6 = 7.
    Thus, the answer is 8.
     */
    fun solution37(inputArray: MutableList<Int>, k: Int): Int {
        var maxSum = 0
        for (i in 0 until k)
            maxSum += inputArray[i]
        var sum = maxSum
        for (i in 1..inputArray.count() - k) {
            sum -= inputArray[i - 1]
            sum += inputArray[i + k - 1]
            if (sum > maxSum)
                maxSum = sum
        }
        return maxSum
    }
}