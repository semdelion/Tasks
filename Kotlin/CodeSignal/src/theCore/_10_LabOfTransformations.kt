package theCore

object _10_LabOfTransformations {
    fun run() {
        println("80 Character Parity: ${_10_LabOfTransformations.solution80('5')}")

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
}