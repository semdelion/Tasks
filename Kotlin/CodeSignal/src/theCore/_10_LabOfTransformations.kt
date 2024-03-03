package theCore

object _10_LabOfTransformations {
    fun run() {
        println("80 Character Parity: ${_10_LabOfTransformations.solution80('5')}")
        println("81 Reflect String: ${_10_LabOfTransformations.solution81("abcdefghijklmnopqrstuvwxyz")}")
        println("82 New Numeral System: ${_10_LabOfTransformations.solution82('G')}")
        println("83 Cipher 26: ${_10_LabOfTransformations.solution83("taiaiaertkixquxjnfxxdh")}")
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
        if (!symbol.isDigit())
            return "not a digit"

        return if (symbol.code % 2 == 0) "even" else "odd"
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

    /**
     * New Numeral System
     * @see "https://app.codesignal.com/arcade/code-arcade/lab-of-transformations/ngQTG9kra7GE9pnnK"
     * @return New Numeral System
     * * @sample Your Informatics teacher at school likes coming up with new ways to help you understand the material. When you started studying numeral systems, he introduced his own numeral system, which he's convinced will help clarify things. His numeral system has base 26, and its digits are represented by English capital letters - A for 0, B for 1, and so on.

    The teacher assigned you the following numeral system exercise: given a one-digit number, you should find all unordered pairs of one-digit numbers whose values add up to the number.

    Example

    For number = 'G', the output should be
    solution(number) = ["A + G", "B + F", "C + E", "D + D"].

    Translating this into the decimal numeral system we get: number = 6, so it is ["0 + 6", "1 + 5", "2 + 4", "3 + 3"].*/
    fun solution82(number: Char): MutableList<String> {
        val result = mutableListOf<String>()
        var index = 0
        while (('A'.code + index) <= (number.code - index)) {
            result.add("${('A'.code + index).toChar()} + ${(number.code - index).toChar()}")
            index++
        }

        return result
    }

    /**
     * Cipher 26
     * @see "https://app.codesignal.com/arcade/code-arcade/lab-of-transformations/JeDDnToFtitiiWDZn"
     * @return Cipher 26
     * * @sample You've intercepted an encrypted message, and you are really curious about its contents. You were able to find out that the message initially contained only lowercase English letters, and was encrypted with the following cipher:

    Let all letters from 'a' to 'z' correspond to the numbers from 0 to 25, respectively.
    The number corresponding to the ith letter of the encrypted message is then equal to the sum of numbers corresponding to the first i letters of the initial unencrypted message modulo 26.
    Now that you know how the message was encrypted, implement the algorithm to decipher it.

    Example

    For message = "taiaiaertkixquxjnfxxdh", the output should be
    solution(message) = "thisisencryptedmessage".

    The initial message "thisisencryptedmessage" was encrypted as follows:

    letter 0: t -> 19 -> t;
    letter 1: th -> (19 + 7) % 26 -> 0 -> a;
    letter 2: thi -> (19 + 7 + 8) % 26 -> 8 -> i;
    etc.*/
    fun solution83(message: String): String {
        var sum = 0
        return  message.map {
            val dif = (it.code - sum % 26 - 71) % 26
            sum += dif
            (dif + 97).toChar()
        }.joinToString("")
    }
}