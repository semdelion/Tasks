package theCore

object _12_ListBackwoods {
    fun run() {
        println("98) Add Two Digits: ${_12_ListBackwoods.solution98(29)}")


    }

    /**
     * Add Two Digits
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/wAGdN6FMPkx7WBq66"
     * @return Add Two Digits
     * * @sample You are given a two-digit integer n. Return the sum of its digits.

    Example

    For n = 29, the output should be
    solution(n) = 11.*/
    fun solution98(n: Int): Int = n/10 + n%10
}