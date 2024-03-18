package intro

object _6_RainsOfReason {

    fun run() {
        println("25) AvoidObstacles: ${_6_RainsOfReason.solution25(mutableListOf(1, 2, 1), 1, 3)}")
        println("26) EvenDigitsOnly: ${_6_RainsOfReason.solution26(2345246)}")
        println("27) VariableName: ${_6_RainsOfReason.solution27("_fAAAfs23231___342")}")
        println("28) AlphabeticShift: ${_6_RainsOfReason.solution28("aabbccddz")}")
        println("29) ChessBoardCellColor: ${_6_RainsOfReason.solution29("A1","B1")}")
    }

    /**
     * Array Replace
     * @see "https://app.codesignal.com/arcade/intro/level-6/mCkmbxdMsMTjBc3Bm"
     * @return Array Replace
     * * @sample Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.

    Example

    For inputArray = [1, 2, 1], elemToReplace = 1, and substitutionElem = 3, the output should be
    solution(inputArray, elemToReplace, substitutionElem) = [3, 2, 3].
     */
    fun solution25(inputArray: MutableList<Int>, elemToReplace: Int, substitutionElem: Int): MutableList<Int> {
        inputArray.replaceAll { if (it == elemToReplace) substitutionElem else it }
        return inputArray
    }

    /**
     * evenDigitsOnly
     * @see "https://app.codesignal.com/arcade/intro/level-6/6cmcmszJQr6GQzRwW"
     * @return evenDigitsOnly
     * * @sample Check if all digits of the given integer are even.

    Example

    For n = 248622, the output should be
    solution(n) = true;
    For n = 642386, the output should be
    solution(n) = false.
     */
    fun solution26(n: Int): Boolean {
        var n1 = n
        while (n1 > 0) {
            val digit = n1 % 10
            n1 /= 10
            if (digit % 2 == 1)
                return false
        }
        return true
    }

    /**
     * variableName
     * @see "https://app.codesignal.com/arcade/intro/level-6/6Wv4WsrsMJ8Y2Fwno"
     * @return variableName
     * * @sample Correct variable names consist only of English letters, digits and underscores and they can't start with a digit.

    Check if the given string is a correct variable name.

    Example

    For name = "var_1__Int", the output should be
    solution(name) = true;
    For name = "qq-q", the output should be
    solution(name) = false;
    For name = "2w2", the output should be
    solution(name) = false.
     */
    fun solution27(name: String): Boolean {
        return name.all { it.isDigit() || it.isLetter() || it == '_' && !name[0].isDigit() }
    }

    /**
     * alphabeticShift
     * @see "https://app.codesignal.com/arcade/intro/level-6/PWLT8GBrv9xXy4Dui"
     * @return alphabeticShift
     * * @sample Given a string, your task is to replace each of its characters by the next one in the English alphabet; i.e. replace a with b, replace b with c, etc (z would be replaced by a).

    Example

    For inputString = "crazy", the output should be solution(inputString) = "dsbaz".
     */
    fun solution28(inputString: String): String {
        var newString = ""
        inputString.forEach { newString += if (it == 'z') 'a' else (it.code + 1).toChar() }
        return newString
    }

    /**
     * chessBoardCellColor
     * @see "https://app.codesignal.com/arcade/intro/level-6/t97bpjfrMDZH8GJhi"
     * @return chessBoardCellColor
     * * @sample Given two cells on the standard chess board, determine whether they have the same color or not.

    Example

    For cell1 = "A1" and cell2 = "C3", the output should be
    solution(cell1, cell2) = true.



    For cell1 = "A1" and cell2 = "H3", the output should be
    solution(cell1, cell2) = false.
     */
    fun solution29(cell1: String, cell2: String): Boolean {
        return isBlack(cell1) == isBlack(cell2);
    }

    private fun isBlack(cell: String) : Boolean {
        return (cell[0].code + cell[1].code) % 2 == 0
    }
}