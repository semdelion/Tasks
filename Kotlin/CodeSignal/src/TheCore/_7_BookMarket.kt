package TheCore

object _7_BookMarket {
    fun run() {
        println("51 Enclose In Brackets: ${_7_BookMarket.solution51("abacaba")}")


    }

    /**
     * Enclose In Brackets
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/K2ieDm98sPDzzMepz"
     * @return Enclose In Brackets
     * * @sample Given a string, enclose it in round brackets.

    Example

    For inputString = "abacaba", the output should be
    solution(inputString) = "(abacaba)".*/
    fun solution51(inputString: String): String  = "($inputString)"
}