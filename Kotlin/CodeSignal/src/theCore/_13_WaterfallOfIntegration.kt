package theCore

object _13_WaterfallOfIntegration {
    fun run() {
        /*println("106) Add Two Digits\n" +
                "      input:\n" +
                "      result: ${_13_WaterfallOfIntegration.solution106(29)}\n")*/
    }

    /**
     * Add Two Digits
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/wAGdN6FMPkx7WBq66"
     * @return Add Two Digits
     * * @sample You are given a two-digit integer n. Return the sum of its digits.

    Example

    For n = 29, the output should be
    solution(n) = 11.*/
    fun solution106(n: Int): Int = n/10 + n%10
}