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
}