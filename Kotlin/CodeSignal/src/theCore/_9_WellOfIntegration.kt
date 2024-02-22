package theCore

object _9_WellOfIntegration {
    fun run() {
        println("67 House Numbers Sum: ${_9_WellOfIntegration.solution67(mutableListOf(5, 1, 2, 3, 0, 1, 5, 0, 2))}")
        println(
            "68 All Longest Strings: ${
                _9_WellOfIntegration.solution68(
                    mutableListOf(
                        "aba",
                        "aa",
                        "ad",
                        "vcd",
                        "aba"
                    )
                )
            }"
        )
        println("69 House of Cats: ${_9_WellOfIntegration.solution69(6)}")
        println("70 Alphabet Subsequence: ${_9_WellOfIntegration.solution70("bxz")}")
        println("71 Minimal Number of Coins: ${_9_WellOfIntegration.solution71(mutableListOf(1, 2, 10), 28)}")
        println("72 Add Border: ${_9_WellOfIntegration.solution72(mutableListOf("abc", "ded"))}")
        println("73 Switch Lights: ${_9_WellOfIntegration.solution73(mutableListOf(1, 1, 1, 1, 1))}")
        println("74 Timed Reading: ${_9_WellOfIntegration.solution74(4, "The Fox asked the stork, 'How is the soup?'")}")

       // println("79 Alphabet Subsequence: ${_9_WellOfIntegration.solution79(mutableListOf(0, -1, 0, -1, 0, -1))}")


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
        for(i in 1 until s.length){
            if(s[i - 1].code >= s[i].code)
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

        for(coin in coins) {
            if(price > coin) {
                if(getCoin(coins, price - coin))
                    return count
            } else if(price == coin)
                return ++count
        }

        return count
    }

    private fun getCoin(coins: MutableList<Int>, price: Int): Boolean {
        count++
        for(coin in coins) {
            if(price == coin) {
                count++
                return true
            }
            else if(price > coin) {
                if(getCoin(coins, price - coin))
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
            val result = if(invert) 1 else 0
            if(a[a.size-1 - index] == 1)
                invert =! invert
            a[a.size-1 - index] = result
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
            val len = word.filter { it in 'A'..'Z' || it in 'a'..'z'}.length
            if(len <= maxLength && len != 0)
                count++
        }
        return count
    }


}