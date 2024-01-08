package intro

import java.util.Stack

object _7_ThroughtheFog {

    fun run() {
        println("30 Circle of Numbers: ${_7_ThroughtheFog.solution30(10, 2)}")
        println("31 DepositProfit: ${_7_ThroughtheFog.solution31(100, 20, 170)}")
        println("32 AbsoluteValuesSumMinimization: ${_7_ThroughtheFog.solution32(mutableListOf(-1000000, -10000, -10000, -1000, -100, -10, -1, 0, 1, 10, 100, 1000, 10000, 100000, 1000000))}")
        println("33 StringsRearrangement: ${_7_ThroughtheFog.solution33(mutableListOf("aba", "bbb", "bab"))}")
    }

    /**
     * Circle of Numbers
     * @see "https://app.codesignal.com/arcade/intro/level-7/vExYvcGnFsEYSt8nQ"
     * @return Circle of Numbers
     * * @sample Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance between any two neighboring numbers is equal (note that 0 and n - 1 are neighboring, too).

    Given n and firstNumber, find the number which is written in the radially opposite position to firstNumber.

    Example

    For n = 10 and firstNumber = 2, the output should be
    solution(n, firstNumber) = 7.
     */
    fun solution30(n: Int, firstNumber: Int): Int {
        return (n/2 + firstNumber) % n
    }

    /**
     * depositProfit
     * @see "https://app.codesignal.com/arcade/intro/level-7/8PxjMSncp9ApA4DAb"
     * @return depositProfit
     * * @sample You have deposited a specific amount of money into your bank account. Each year your balance increases at the same growth rate. With the assumption that you don't make any additional deposits, find out how long it would take for your balance to pass a specific threshold.

    Example

    For deposit = 100, rate = 20, and threshold = 170, the output should be
    solution(deposit, rate, threshold) = 3.

    Each year the amount of money in your account increases by 20%. So throughout the years, your balance would be:

    year 0: 100;
    year 1: 120;
    year 2: 144;
    year 3: 172.8.
    Thus, it will take 3 years for your balance to pass the threshold, so the answer is 3..
     */
    fun solution31(deposit: Int, rate: Int, threshold: Int): Int {
        var year = 0
        var currentSum: Double = deposit.toDouble()
        while (currentSum < threshold) {
            currentSum = (currentSum / 100) * (100 + rate)
            year++
        }
        return year
    }

    /**
     * absoluteValuesSumMinimization
     * @see "https://app.codesignal.com/arcade/intro/level-7/ZFnQkq9RmMiyE6qtq"
     * @return absoluteValuesSumMinimization
     * * @sample Given a sorted array of integers a, your task is to determine which element of a is closest to all other values of a. In other words, find the element x in a, which minimizes the following sum:

    abs(a[0] - x) + abs(a[1] - x) + ... + abs(a[a.length - 1] - x)
    (where abs denotes the absolute value)

    If there are several possible answers, output the smallest one.

    Example

    For a = [2, 4, 7], the output should be solution(a) = 4.

    for x = 2, the value will be abs(2 - 2) + abs(4 - 2) + abs(7 - 2) = 7.
    for x = 4, the value will be abs(2 - 4) + abs(4 - 4) + abs(7 - 4) = 5.
    for x = 7, the value will be abs(2 - 7) + abs(4 - 7) + abs(7 - 7) = 8.
    The lowest possible value is when x = 4, so the answer is 4.

    For a = [2, 3], the output should be solution(a) = 2.

    for x = 2, the value will be abs(2 - 2) + abs(3 - 2) = 1.
    for x = 3, the value will be abs(2 - 3) + abs(3 - 3) = 1.
    Because there is a tie, the smallest x between x = 2 and x = 3 is the answer.
     */
    fun solution32(a: MutableList<Int>): Int = a[(a.count() - 1)/2]



    /**
     * stringsRearrangement
     * @see "https://app.codesignal.com/arcade/intro/level-7/PTWhv2oWqd6p4AHB9"
     * @return stringsRearrangement
     * * @sample Given an array of equal-length strings, you'd like to know if it's possible to rearrange the order of the elements in such a way that each consecutive pair of strings differ by exactly one character. Return true if it's possible, and false if not.

    Note: You're only rearranging the order of the strings, not the order of the letters within the strings!

    Example

    For inputArray = ["aba", "bbb", "bab"], the output should be
    solution(inputArray) = false.

    There are 6 possible arrangements for these strings:

    ["aba", "bbb", "bab"]
    ["aba", "bab", "bbb"]
    ["bbb", "aba", "bab"]
    ["bbb", "bab", "aba"]
    ["bab", "bbb", "aba"]
    ["bab", "aba", "bbb"]
    None of these satisfy the condition of consecutive strings differing by 1 character, so the answer is false.

    For inputArray = ["ab", "bb", "aa"], the output should be
    solution(inputArray) = true.

    It's possible to arrange these strings in a way that each consecutive pair of strings differ by 1 character (eg: "aa", "ab", "bb" or "bb", "ab", "aa"), so return true.
     */
    fun solution33(inputArray: MutableList<String>): Boolean = solutionInt(inputArray, Stack<String>())

    private fun solutionInt(inputArray: MutableList<String>, res: Stack<String>) : Boolean {
        if (inputArray.isEmpty())
            return true

        for (i in 0 until inputArray.count()) {
            if (res.isEmpty() || similar(inputArray[i], res.peek())) {
                res.push(inputArray[i])
                val newArray = mutableListOf<String>()
                newArray.addAll(inputArray)
                newArray.removeAt(i)
                if (solutionInt(newArray, res))
                    return true
                else if (res.count() == 1 && res.peek() == inputArray[i])
                    res.pop()
            }
        }
        if(res.isNotEmpty())
            res.pop()

        return false
    }

    private fun similar(str1 : String, str2 : String): Boolean {
        var count = 0
        for(i in 0 until str1.length) {
            if(str1[i] != str2[i]) {
                if(count>0)
                    return false
                count++
            }
        }
        return count == 1
    }
}