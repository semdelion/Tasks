package TheCore

object _7_BookMarket {
    fun run() {
        println("51 Enclose In Brackets: ${_7_BookMarket.solution51("abacaba")}")
        println("52 Proper Noun Correction: ${_7_BookMarket.solution52("pARiS")}")


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


    /**
     * Proper Noun Correction
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/2nSEQ8CGoddTJtnbo"
     * @return Proper Noun Correction
     * * @sample Proper nouns always begin with a capital letter, followed by small letters.

    Correct a given proper noun so that it fits this statement.

    Example

    For noun = "pARiS", the output should be
    solution(noun) = "Paris";
    For noun = "John", the output should be
    solution(noun) = "John".*/
    fun solution52(noun: String): String = noun.first().uppercaseChar() + noun.substring(1).lowercase()



}