package theCore

object _10_LabOfTransformations {
    fun run() {
        println("80 Character Parity: ${_10_LabOfTransformations.solution80('5')}")
        println("81 Reflect String: ${_10_LabOfTransformations.solution81("abcdefghijklmnopqrstuvwxyz")}")
    }

    /**
     * Character Parity
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/wAGdN6FMPkx7WBq66"
     * @return Character Parity
     * * @sample Given a character, check if it represents an odd digit, an even digit or not a digit at all.

    Example

    For symbol = '5', the output should be
    solution(symbol) = "odd";
    For symbol = '8', the output should be
    solution(symbol) = "even";
    For symbol = 'q', the output should be
    solution(symbol) = "not a digit".*/
    fun solution80(symbol: Char): String {
        if(!symbol.isDigit())
            return "not a digit"

        return if(symbol.code%2==0) "even" else "odd"
    }

    /**
     * Reflect String
     * @see "https://app.codesignal.com/arcade/code-arcade/lab-of-transformations/8nAgfjhDvKCpxwGWF"
     * @return Reflect String
     * * @sample Define an alphabet reflection as follows: a turns into z, b turns into y, c turns into x, ..., n turns into m, m turns into n, ..., z turns into a.

    Define a string reflection as the result of applying the alphabet reflection to each of its characters.

    Reflect the given string.

    Example

    For inputString = "name", the output should be
    solution(inputString) = "mznv".*/
    fun solution81(inputString: String): String {
        return inputString.map { ('z'.code - (it.code - 'a'.code)).toChar() }.joinToString("")
    }
}