package theCore

import intro._4_ExploringTheWaters

object _9_WellOfIntegration {
    fun run() {
        println("67) House Numbers Sum\n" +
                "      input: inputArray = [5, 1, 2, 3, 0, 1, 5, 0, 2]\n" +
                "      result: ${solution67(mutableListOf(5, 1, 2, 3, 0, 1, 5, 0, 2))}\n")
        println("68) All Longest Strings\n" +
                "      input: inputArray = [\"aba\", \"aa\", \"ad\", \"vcd\", \"aba\"]\n" +
                "      result: ${solution68(mutableListOf("aba", "aa", "ad", "vcd", "aba"))}\n")
        println("69) House of Cats\n" +
                "      input: legs = 6\n" +
                "      result: ${solution69(legs = 6)}\n")
        println("70) Alphabet Subsequence\n" +
                "      input: s = \"bxz\"\n" +
                "      result: ${solution70(s = "bxz")}\n")
        println("71) Minimal Number of Coins\n" +
                "      input: coins = [1, 2, 10], price = 20\n" +
                "      result: ${solution71(mutableListOf(1, 2, 10), price = 28)}\n")
        println("72) Add Border\n" +
                "      input: picture = \n" +
                "            abc\n" +
                "            ded\n" +
                "      result:")
        _4_ExploringTheWaters.solution15(mutableListOf("abc", "ded")).forEach { println("            $it") }
        println()
        println("73) Switch Lights\n" +
                "      input: a = [1, 1, 1, 1, 1]\n" +
                "      result: ${solution73(mutableListOf(1, 1, 1, 1, 1))}\n")
        println("74) Timed Reading\n" +
                "      input: maxLength = 4, text = \"The Fox asked the stork, 'How is the soup?'\"\n" +
                "      result: ${solution74(maxLength = 4, text = "The Fox asked the stork, 'How is the soup?'")}\n")
        println("75) Elections Winners\n" +
                "      input: votes = [2, 3, 5, 2], k = 3\n" +
                "      result: ${solution75(mutableListOf(2, 3, 5, 2), k = 3)}\n")
        println("76) Add Two Digits\n" +
                "      input: number = 1234, width = 2\n" +
                "      result: ${solution76(number = 1234, width = 2)}\n")
        println("77) Are Similar?\n" +
                "      input: a = [1, 2, 3], b = [2, 1, 3]\n" +
                "      result: ${solution77(mutableListOf(1, 2, 3), mutableListOf(2, 1, 3))}\n")
        println("78) Ada Number\n" +
                "      input: line = \"123_456_789\"\n" +
                "      result: ${solution78(line = "123_456_789")}\n")
        println("79) Three Split\n" +
                "      input: a = [0, -1, 0, -1, 0, -1]\n" +
                "      result: ${solution79(mutableListOf(0, -1, 0, -1, 0, -1))}\n")
    }

    /**
     * House Numbers Sum
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/3QMXNwGfvLMoQwed7"
     * @return House Numbers Sum
     * * @sample A boy is walking a long way from school to his home. To make the walk more fun he decides to add up all the numbers of the houses that he passes by during his walk. Unfortunately, not all of the houses have numbers written on them, and on top of that the boy is regularly taking turns to change streets, so the numbers don't appear to him in any particular order.

    At some point during the walk the boy encounters a house with number 0 written on it, which surprises him so much that he stops adding numbers to his total right after seeing that house.

    For the given sequence of houses determine the sum that the boy will get. It is guaranteed that there will always be at least one 0 house on the path.

    Example

    For inputArray = [5, 1, 2, 3, 0, 1, 5, 0, 2], the output should be
    solution(inputArray) = 11.

    The answer was obtained as 5 + 1 + 2 + 3 = 11.*/
    fun solution67(inputArray: MutableList<Int>): Int = inputArray.takeWhile { it != 0 }.sum()

    /**
     * All Longest Strings
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/fzsCQGYbxaEcTr2bL"
     * @return All Longest Strings
     * * @sample Given an array of strings, return another array containing all of its longest strings.

    Example

    For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
    solution(inputArray) = ["aba", "vcd", "aba"].*/
    fun solution68(inputArray: MutableList<String>): MutableList<String> {
        val max = inputArray.maxOf { it.length }
        return inputArray.filter { it.length == max }.toMutableList()
    }

    /**
     * House of Cats
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/RaWLwT2eb96hp4N5Z"
     * @return House of Cats
     * * @sample There are some people and cats in a house. You are given the number of legs they have all together. Your task is to return an array containing every possible number of people that could be in the house sorted in ascending order. It's guaranteed that each person has 2 legs and each cat has 4 legs.

    Example

    For legs = 6, the output should be
    solution(legs) = [1, 3].

    There could be either 1 cat and 1 person (4 + 2 = 6) or 3 people (2 * 3 = 6).

    For legs = 2, the output should be
    solution(legs) = [1].

    There can be only 1 person.*/
    fun solution69(legs: Int): MutableList<Int> {
        val even = if (legs % 4 == 0) 0 else 1
        val humans = mutableListOf<Int>()
        for (i in even until (legs / 2 + 1) step 2) {
            humans.add(i)
        }
        return humans
    }

    /**
     * Alphabet Subsequence
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/Z9opBsx5fX6XfQJdt"
     * @return Alphabet Subsequence
     * * @sample Check whether the given string is a subsequence of the plaintext alphabet.

    Example

    For s = "effg", the output should be
    solution(s) = false;
    For s = "cdce", the output should be
    solution(s) = false;
    For s = "ace", the output should be
    solution(s) = true;
    For s = "bxz", the output should be
    solution(s) = true.*/
    fun solution70(s: String): Boolean {
        for (i in 1 until s.length) {
            if (s[i - 1].code >= s[i].code)
                return false
        }
        return true
    }

    /**
     * Minimal Number of Coins
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/sGwCfM5FzX7LhLcdk"
     * @return Minimal Number of Coins
     * * @sample You find yourself in Bananaland trying to buy a banana. You are super rich so you have an unlimited supply of banana-coins, but you are trying to use as few coins as possible.

    The coin values available in Bananaland are stored in a sorted array coins. coins[0] = 1, and for each i (0 < i < coins.length) coins[i] is divisible by coins[i - 1]. Find the minimal number of banana-coins you'll have to spend to buy a banana given the banana's price.

    Example

    For coins = [1, 2, 10] and price = 28, the output should be
    solution(coins, price) = 6.

    You have to use 10 twice, and 2 four times.*/
    var count = 0
    fun solution71(coins: MutableList<Int>, price: Int): Int {
        coins.reverse()

        for (coin in coins) {
            if (price > coin) {
                if (getCoin(coins, price - coin))
                    return count
            } else if (price == coin)
                return ++count
        }

        return count
    }

    private fun getCoin(coins: MutableList<Int>, price: Int): Boolean {
        count++
        for (coin in coins) {
            if (price == coin) {
                count++
                return true
            } else if (price > coin) {
                if (getCoin(coins, price - coin))
                    return true
            }
        }
        count--
        return false
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
    fun solution72(picture: MutableList<String>): MutableList<String> {
        for (i in 0 until picture.count()) {
            picture[i] = "*${picture[i]}*"
        }
        picture.add(0, "*".repeat(picture[0].length))
        picture.add("*".repeat(picture[0].length))

        return picture
    }

    /**
     * Switch Lights
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/x3ix7CY93z2bwKDtG"
     * @return Switch Lights
     * * @sample N candles are placed in a row, some of them are initially lit. For each candle from the 1st to the Nth the following algorithm is applied: if the observed candle is lit then states of this candle and all candles before it are changed to the opposite. Which candles will remain lit after applying the algorithm to all candles in the order they are placed in the line?

    Example

    For a = [1, 1, 1, 1, 1], the output should be
    solution(a) = [0, 1, 0, 1, 0].

    Check out the image below for better understanding:

    For a = [0, 0], the output should be
    solution(a) = [0, 0].

    The candles are not initially lit, so their states are not altered by the algorithm.
     */
    fun solution73(a: MutableList<Int>): MutableList<Int> {
        var invert = false
        for (index in a.indices) {
            val result = if (invert) 1 else 0
            if (a[a.size - 1 - index] == 1)
                invert = !invert
            a[a.size - 1 - index] = result
        }
        return a
    }

    /**
     * Timed Reading
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/mJr7vgtN4X4ecL7ZA"
     * @return Timed Reading
     * * @sample Timed Reading is an educational tool used in many schools to improve and advance reading skills. A young elementary student has just finished his very first timed reading exercise. Unfortunately he's not a very good reader yet, so whenever he encountered a word longer than maxLength, he simply skipped it and read on.

    Help the teacher figure out how many words the boy has read by calculating the number of words in the text he has read, no longer than maxLength.
    Formally, a word is a substring consisting of English letters, such that characters to the left of the leftmost letter and to the right of the rightmost letter are not letters.

    Example

    For maxLength = 4 and
    text = "The Fox asked the stork, 'How is the soup?'",
    the output should be
    solution(maxLength, text) = 7.

    The boy has read the following words: "The", "Fox", "the", "How", "is", "the", "soup".
     */
    fun solution74(maxLength: Int, text: String): Int {
        val words = text.split(" ").toTypedArray()
        var count = 0
        for (word in words) {
            val len = word.filter { it in 'A'..'Z' || it in 'a'..'z' }.length
            if (len <= maxLength && len != 0)
                count++
        }
        return count
    }

    /**
     * Elections Winners
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/8RiRRM3yvbuAd3MNg"
     * @return Elections Winners
     * * @sample Elections are in progress!

    Given an array of the numbers of votes given to each of the candidates so far, and an integer k equal to the number of voters who haven't cast their vote yet, find the number of candidates who still have a chance to win the election.

    The winner of the election must secure strictly more votes than any other candidate. If two or more candidates receive the same (maximum) number of votes, assume there is no winner at all.

    Example

    For votes = [2, 3, 5, 2] and k = 3, the output should be
    solution(votes, k) = 2.

    The first candidate got 2 votes. Even if all of the remaining 3 candidates vote for him, he will still have only 5 votes, i.e. the same number as the third candidate, so there will be no winner.
    The second candidate can win if all the remaining candidates vote for him (3 + 3 = 6 > 5).
    The third candidate can win even if none of the remaining candidates vote for him. For example, if each of the remaining voters cast their votes for each of his opponents, he will still be the winner (the votes array will thus be [3, 4, 5, 3]).
    The last candidate can't win no matter what (for the same reason as the first candidate).
    Thus, only 2 candidates can win (the second and the third), which is the answer.
     */
    fun solution75(votes: MutableList<Int>, k: Int): Int {
        var countOfWinner = 0
        val curMax = votes.maxOrNull() ?: 0
        if (k == 0) {
            return if (votes.filter { it == curMax }.size == 1) 1 else 0
        }

        for (vote in votes) {
            if ((vote + k) > curMax)
                countOfWinner++
        }

        return countOfWinner
    }

    /**
     * Integer to String of Fixed Width
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/kvGfZZxGyjNbD7yxv"
     * @return Integer to String of Fixed Width
     * * @sample Given a positive integer number and a certain length, we need to modify the given number to have a specified length. We are allowed to do that either by cutting out leading digits (if the number needs to be shortened) or by adding 0s in front of the original number.

    Example

    For number = 1234 and width = 2, the output should be
    solution(number, width) = "34";
    For number = 1234 and width = 4, the output should be
    solution(number, width) = "1234";
    For number = 1234 and width = 5, the output should be
    solution(number, width) = "01234".*/
    fun solution76(number: Int, width: Int): String {
        val stNumber = number.toString()
        if (stNumber.length < width)
            return "0".repeat(width - stNumber.length) + stNumber
        if (stNumber.length > width)
            return stNumber.substring(stNumber.length - width);
        return stNumber
    }

    /**
     * Are Similar?
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/xYXfzQmnhBvEKJwXP"
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

    Any swap of any two elements either in a or in b won't make a and b equal.*/
    fun solution77(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        var difIndex = -1
        for (index in a.indices) {
            if (a[index] != b[index]) {
                if (difIndex == -2)
                    return false

                difIndex = if (difIndex == -1) {
                    index
                } else if (a[difIndex] == b[index] && b[difIndex] == a[index]) {
                    -2
                } else
                    return false
            }
        }
        if (difIndex >= 0)
            return false

        return true
    }

    /**
     * Ada Number
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/Ghe6HWhFft8h6fR49"
     * @return Ada Number
     * * @sample Consider two following representations of a non-negative integer:

    A simple decimal integer, constructed of a non-empty sequence of digits from 0 to 9;
    An integer with at least one digit in a base from 2 to 16 (inclusive), enclosed between # characters, and preceded by the base, which can only be a number between 2 and 16 in the first representation. For digits from 10 to 15 characters a, b, ..., f and A, B, ..., F are used.
    Additionally, both representations may contain underscore (_) characters; they are used only as separators for improving legibility of numbers and can be ignored while processing a number.

    Your task is to determine whether the given string is a valid integer representation.

    Note: this is how integer numbers are represented in the programming language Ada.*/
    fun solution78(line: String): Boolean {
        var number = 0
        var notation = 0
        var stringNumber = ""
        if (line.substring(0,2) == "__")
            return false

        for((index, char) in line.withIndex()) {
            when(char) {
                '_' -> continue
                '#' -> {
                    if(notation == 0) {
                        if(number in 2..16)
                            notation = number
                        else
                            return false
                    }
                    else {
                        if(stringNumber.isEmpty())
                            return false
                        return index + 1 == line.length
                    }
                }
                else -> {
                    if (notation > 0) {
                        stringNumber += char

                        if(char.isDigit()) {
                            if(char.digitToInt() >= notation)
                                return false
                        }
                        else {
                            when (char.uppercaseChar()) {
                                in 'A'..'F' -> {
                                    if (notation < char.uppercaseChar() - 'A' + 10 + 1)
                                        return false
                                }
                                else -> return false
                            }
                        }
                    } else {
                        if(char.isDigit()) {
                            number = number * 10 + char.digitToInt()
                        }
                        else
                            return false
                    }
                }
            }
        }

        if (notation == 0)
            return true

        if(line[line.length-1]!='#')
            return false

        return false
    }

    /**
     * Three Split
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/Ghe6HWhFft8h6fR49"
     * @return Three Split
     * * @sample You have a long strip of paper with integers written on it in a single line from left to right. You wish to cut the paper into exactly three pieces such that each piece contains at least one integer and the sum of the integers in each piece is the same. You cannot cut through a number, i.e. each initial number will unambiguously belong to one of the pieces after cutting. How many ways can you do it?

    It is guaranteed that the sum of all elements in the array is divisible by 3.

    Example

    For a = [0, -1, 0, -1, 0, -1], the output should be
    solution(a) = 4.

    Here are all possible ways:

    [0, -1] [0, -1] [0, -1]
    [0, -1] [0, -1, 0] [-1]
    [0, -1, 0] [-1, 0] [-1]
    [0, -1, 0] [-1] [0, -1]*/
    fun solution79(a: MutableList<Int>): Int {
        val third = a.sumOf { it.toLong() } / 3
        var count = 0
        var firstIndex = -1
        var secondIndex = -1
        var sum = 0L
        for (i in a.count() -1 downTo  0  ) {
            sum += a[i]
            if(sum == third) {
                if(firstIndex == -1)
                    firstIndex= i
                else {
                    secondIndex = i
                    break
                }
                sum = 0
            }
        }
        var left = 0L
        for(i in 0 until secondIndex ) {
            left+=a[i]
            if(left == third) {
                var center = 0L
                for (j in i + 1 until firstIndex) {
                    center += a[j]
                    if(center == third) {
                        count ++
                    }
                }
            }
        }
        return count
    }
}