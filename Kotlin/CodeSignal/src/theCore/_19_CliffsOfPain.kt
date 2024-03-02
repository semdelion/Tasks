package theCore

object _19_CliffsOfPain {
    fun run() {
        println("155 Add Two Digits: ${_19_CliffsOfPain.solution155(29)}")


    }

    /**
     * Add Two Digits
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/wAGdN6FMPkx7WBq66"
     * @return Add Two Digits
     * * @sample You are given a two-digit integer n. Return the sum of its digits.

    Example

    For n = 29, the output should be
    solution(n) = 11.*/
    fun solution155(n: Int): Int = n/10 + n%10
}