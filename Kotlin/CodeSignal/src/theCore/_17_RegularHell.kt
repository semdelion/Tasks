package theCore

object _17_RegularHell {
    fun run() {
        /*println("138) Add Two Digits\n" +
                "      input:\n" +
                "      result: ${_17_RegularHell.solution138(29)}\n")*/
    }

    /**
     * Add Two Digits
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/wAGdN6FMPkx7WBq66"
     * @return Add Two Digits
     * * @sample You are given a two-digit integer n. Return the sum of its digits.

    Example

    For n = 29, the output should be
    solution(n) = 11.*/
    fun solution138(n: Int): Int = n/10 + n%10
}