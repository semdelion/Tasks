package intro

object _12_LandOfLogic {
    fun run() {
        println("52 LongestWord: ${_12_LandOfLogic.solution52("Ready, steady, go!")}")
        println("53 Valid Time: ${_12_LandOfLogic.solution53("25:51")}")
        println("54 SumUpNumbers: ${_12_LandOfLogic.solution54("2 apples, 12 oranges")}")
        println(
            "55 Different Squares: ${
                _12_LandOfLogic.solution55(
                    mutableListOf(
                        mutableListOf(1, 2, 1),
                        mutableListOf(2, 2, 2),
                        mutableListOf(2, 2, 2),
                        mutableListOf(1, 2, 3),
                        mutableListOf(2, 2, 1)
                    )
                )
            }"
        )
        println("56 DigitsProduct: ${_12_LandOfLogic.solution56(19)}")
        println(
            "57 File Naming: ${
                _12_LandOfLogic.solution57(
                    mutableListOf(
                        "doc",
                        "doc",
                        "image",
                        "doc(1)",
                        "doc"
                    )
                )
            }"
        )
        println("58 MessageFromBinaryCode: ${_12_LandOfLogic.solution58("010010000110010101101100011011000110111100100001")}")

    }

    /**
     * LongestWord
     * @see "https://app.codesignal.com/arcade/intro/level-12/s9qvXv4yTaWg8g4ma"
     * @return LongestWord
     * * @sample Define a word as a sequence of consecutive English letters. Find the longest word from the given string.

    Example

    For text = "Ready, steady, go!", the output should be
    solution(text) = "steady".
     */
    fun solution52(text: String): String {
        var maxLengthWord = ""
        var maxLength = 0
        var tmpWords = ""
        for (i in 0 until text.count()) {
            if (text[i].isLetter()) {
                tmpWords += text[i]
            } else {
                if (tmpWords.isNotEmpty() && tmpWords.length > maxLength) {
                    maxLength = tmpWords.length
                    maxLengthWord = tmpWords
                }
                tmpWords = ""
            }
        }

        return if (tmpWords.length > maxLength) tmpWords else maxLengthWord
    }

    /**
     * Valid Time
     * @see "https://app.codesignal.com/arcade/intro/level-12/ywMyCTspqGXPWRZx5"
     * @return Valid Time
     * * @sample Check if the given string is a correct time representation of the 24-hour clock.

    Example

    For time = "13:58", the output should be
    solution(time) = true;
    For time = "25:51", the output should be
    solution(time) = false;
    For time = "02:76", the output should be
    solution(time) = false.
     */
    fun solution53(time: String): Boolean {
        val regex = Regex("^((([0-1]\\d)|2[0-3]):([0-5]\\d))$")
        return regex.findAll(time).count() == 1
    }


    /**
     * SumUpNumbers
     * @see "https://app.codesignal.com/arcade/intro/level-12/YqZwMJguZBY7Hz84T"
     * @return SumUpNumbers
     * * @sample CodeMaster has just returned from shopping. He scanned the check of the items he bought and gave the resulting string to Ratiorg to figure out the total number of purchased items. Since Ratiorg is a bot he is definitely going to automate it, so he needs a program that sums up all the numbers which appear in the given input.

    Help Ratiorg by writing a function that returns the sum of numbers that appear in the given inputString.

    Example

    For inputString = "2 apples, 12 oranges", the output should be
    solution(inputString) = 14.
     */
    fun solution54(inputString: String): Int {
        var numberOfPurchases = 0
        var digit = ""
        for (item in inputString) {
            if (item.isDigit()) {
                digit += item
            } else {
                if (digit.isNotEmpty()) {
                    numberOfPurchases += digit.toInt()
                    digit = ""
                }
            }
        }
        if (digit.isNotEmpty())
            numberOfPurchases += digit.toInt()
        return numberOfPurchases
    }

    /**
     * Different Squares
     * @see "https://app.codesignal.com/arcade/intro/level-12/fQpfgxiY6aGiGHLtv"
     * @return Different Squares
     * * @sample Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.
    Example
    For
    matrix =[
    [1, 2, 1],
    [2, 2, 2],
    [2, 2, 2],
    [1, 2, 3],
    [2, 2, 1]]
    the output should be
    solution(matrix) = 6.

    Here are all 6 different 2 × 2 squares: */

    fun solution55(matrix: MutableList<MutableList<Int>>): Int {
        val set = mutableSetOf<String>()
        for (i in 0 until matrix.count() - 1) {
            for (j in 0 until matrix[i].count() - 1) {
                set.add(
                    matrix[i][j].toString() + matrix[i][j + 1].toString() +
                            matrix[i + 1][j].toString() + matrix[i + 1][j + 1].toString()
                )
            }
        }

        return set.count()
    }

    /**
     * DigitsProduct
     * @see "https://app.codesignal.com/arcade/intro/level-12/NJJhENpgheFRQbPRA"
     * @return DigitsProduct
     * * @sample Given an integer product, find the smallest positive (i.e. greater than 0) integer the product of whose digits is equal to product. If there is no such integer, return -1 instead.

    Example

    For product = 12, the output should be
    solution(product) = 26;
    For product = 19, the output should be
    solution(product) = -1. */
    fun solution56(product: Int): Int {
        if (product == 0) return 10
        if (product == 1) return 1
        var mProduct = product
        var res = ""
        while (mProduct > 1) {
            for (i in 9 downTo 0) {
                if (i <= 1)
                    return -1
                if (mProduct % i == 0) {
                    res = i.toString() + res
                    mProduct /= i
                    break
                }
            }
        }
        return res.toInt()
    }

    /**
     * File Naming
     * @see "https://app.codesignal.com/arcade/intro/level-12/sqZ9qDTFHXBNrQeLC"
     * @return File Naming
     * * @sample You are given an array of strings names representing filenames. The array is sorted in order of file creation, such that names[i] represents the name of a file created before names[i+1] and after names[i-1] (assume 0-based indexing). Because all files must have unique names, files created later with the same name as a file created earlier should have an additional (k) suffix in their names, where k is the smallest positive integer (starting from 1) that does not appear in previous file names.

    Your task is to iterate through all elements of names (from left to right) and update all filenames based on the above. Return an array of proper filenames.

    Example

    For names = ["doc", "doc", "image", "doc(1)", "doc"], the output should be solution(names) = ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"].

    Since names[0] = "doc" and names[1] = "doc", update names[1] = "doc(1)"
    Since names[1] = "doc(1)" and names[3] = "doc(1)", update names[3] = "doc(1)(1)"
    Since names[0] = "doc", names[1] = "doc(1)", and names[4] = "doc", update names[4] = "doc(2)" */
    fun solution57(names: MutableList<String>): MutableList<String> {
        val files = mutableListOf<String>()
        for (name in names)
            files.add(safeAdd(name, files))
        return files
    }

    private fun safeAdd(str: String, files: MutableList<String>): String {
        var purStr = str;
        var index = 1
        while (files.contains(purStr)) {
            purStr = "${str}(${index++})";
        }
        return purStr;
    }

    /**
     * messageFromBinaryCode
     * @see "https://app.codesignal.com/arcade/intro/level-12/sCpwzJCyBy2tDSxKW"
     * @return messageFromBinaryCode
     * * @sample You are taking part in an Escape Room challenge designed specifically for programmers. In your efforts to find a clue, you've found a binary code written on the wall behind a vase, and realized that it must be an encrypted message. After some thought, your first guess is that each consecutive 8 bits of the code stand for the character with the corresponding extended ASCII code.

    Assuming that your hunch is correct, decode the message.

    Example

    For code = "010010000110010101101100011011000110111100100001", the output should be
    solution(code) = "Hello!".

    The first 8 characters of the code are 01001000, which is 72 in the binary numeral system. 72 stands for H in the ASCII-table, so the first letter is H.
    Other letters can be obtained in the same manner. */
    fun solution58(code: String): String {
        var cryptoMessage = ""
        for (i in code.indices step 8) {
            cryptoMessage +=code.substring(i,i + 8).toInt(2).toChar()
        }
        return cryptoMessage
    }


}