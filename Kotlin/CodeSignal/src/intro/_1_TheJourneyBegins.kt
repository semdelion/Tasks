package intro

object _1_TheJourneyBegins {

    fun run() {
        println("1) Sum\n" +
                "      input: 2 + 2\n" +
                "      result: ${_1_TheJourneyBegins.solution1(2,2)}\n")
        println("2) CenturyFromYear\n" +
                "      input: year 1082\n" +
                "      result: ${_1_TheJourneyBegins.solution2(1082)}\n")
        println("3) CheckPalindrome\n" +
                "      input: \"aabaa\"\n" +
                "      result: ${_1_TheJourneyBegins.solution3("aabaa")}\n")
    }

    /**
     * sum
     * https://app.codesignal.com/arcade/intro/level-1/jwr339Kq6e3LQTsfa
     * @return sum.
     */
    fun solution1(param1: Int, param2: Int): Int {
        return param1 + param2
    }

    /**
     * centuryFromYear
     * @see "https://app.codesignal.com/arcade/intro/level-1/egbueTZRRL5Mm4TXN"
     * @return
     * * @sample Given a year, return the century it is in. The first century spans from the year 1 up to and including the year 100, the second - from the year 101 up to and including the year 200, etc.
     * Example
        For year = 1905, the output should be
        solution(year) = 20;
        For year = 1700, the output should be
        solution(year) = 17.
     */
    fun solution2(year: Int): Int {
        var century = year / 100
        if (year % 100 > 0) {
            century += 1
        }
        return century
    }

    /**
     * checkPalindrome
     * @see "https://app.codesignal.com/arcade/intro/level-1/s5PbmwxfECC52PWyQ"
     * @return string is palindrome?
     * * @sample for inputString = "aabaa", the output should be
        solution(inputString) = true;
        For inputString = "abac", the output should be
        solution(inputString) = false;
        For inputString = "a", the output should be
        solution(inputString) = true.
    */
    fun solution3(inputString: String): Boolean {
       val length = inputString.length / 2
       for (i in 0..length) {
           if (inputString[i] != inputString[inputString.length - 1 - i])
               return false
       }
       return true
    }
}