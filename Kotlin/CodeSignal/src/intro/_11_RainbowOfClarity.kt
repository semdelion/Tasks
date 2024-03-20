package intro

import kotlin.math.pow

object _11_RainbowOfClarity {
    fun run() {
        println("48) Circle of Numbers\n" +
                "      input: symbol = '8'\n" +
                "      result: ${_11_RainbowOfClarity.solution48('8')}\n")
        println("49) LineEncoding\n" +
                "      input: s = \"aabbbc\"\n" +
                "      result: ${_11_RainbowOfClarity.solution49("aabbbc")}\n")
        println("50) ChessKnight\n" +
                "      input: cell = \"a1\"\n" +
                "      result: ${_11_RainbowOfClarity.solution50("a1")}\n")
        println("51) DeleteDigit\n" +
                "      input: n = 152\n" +
                "      result: ${_11_RainbowOfClarity.solution51(152)}\n")
    }

     /**
        * IsDigit
        * @see "https://app.codesignal.com/arcade/intro/level-11/Zr2XXEpkBPtYWqPJu"
        * @return IsDigit
        * * @sample Determine if the given character is a digit or not.

     Example

     For symbol = '0', the output should be
     solution(symbol) = true;
     For symbol = '-', the output should be
     solution(symbol) = false.
      */
     fun solution48(symbol: Char): Boolean = symbol.isDigit()

    /**
        * lineEncoding
        * @see "https://app.codesignal.com/arcade/intro/level-11/o2uq6eTuvk7atGadR"
        * @return lineEncoding
        * * @sample Given a string, return its encoding defined as follows:

    First, the string is divided into the least possible number of disjoint substrings consisting of identical characters
    for example, "aabbbc" is divided into ["aa", "bbb", "c"]
    Next, each substring with length greater than one is replaced with a concatenation of its length and the repeating character
    for example, substring "bbb" is replaced by "3b"
    Finally, all the new strings are concatenated together in the same order and a new string is returned.
     */
    fun solution49(s: String): String {
        var result = ""
        var count = 0
        for(i in 1 until s.length) {
            if(s[i-1]==s[i]) {
                count++
            } else {
                result += if(count > 0) (count + 1).toString() + s[i-1] else s[i-1]
                count = 0
            }

        }
        result += if(count > 0) (count + 1).toString() + s[s.length - 1] else s[s.length -1 ]
        return result
    }

    /**
     * chessKnight
     * @see "https://app.codesignal.com/arcade/intro/level-11/pwRLrkrNpnsbgMndb"
     * @return chessKnight
     * * @sample Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.

    The knight can move to a square that is two squares horizontally and one square vertically, or two squares vertically and one square horizontally away from it. The complete move therefore looks like the letter L. Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.

    Example
    For cell = "a1", the output should be
    solution(cell) = 2.

    For cell = "c2", the output should be
    solution(cell) = 6.
     */
    fun solution50(cell: String): Int {
        var count = 0
        var symbol = cell[0].code + 3
        var digit = cell[1].code
        for (i in 1..11) {
            symbol += (-1).toDouble().pow((((i - 1) / 6) + 1).toDouble()).toInt()
            digit  += (-1).toDouble().pow((((i + 2) / 6) + 1).toDouble()).toInt()
            if ((i % 3 != 0) && outBoard(symbol, digit))
                count++
        }
        return count
    }

    private fun outBoard(symbol: Int, digit: Int) : Boolean {
        if ((symbol in 97..104) && (digit in 49..56))
            return true
        return false
    }

    /**
     * deleteDigit
     * @see "https://app.codesignal.com/arcade/intro/level-11/vpfeqDwGZSzYNm2uX"
     * @return deleteDigit
     * * @sample Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

    Example

    For n = 152, the output should be
    solution(n) = 52;
    For n = 1001, the output should be
    solution(n) = 101.
     */
    fun solution51(n: Int): Int {
        val num = n.toString()
        var i = 1
        while (i < num.length && num[i - 1] >= num[i]) i++
        return num.removeRange(i - 1, i).toInt()
    }
}