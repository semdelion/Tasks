package intro

object _3_SmoothSailing {
    /**
     * All Longest Strings
     * @see "https://app.codesignal.com/arcade/intro/level-3/fzsCQGYbxaEcTr2bL"
     * @return Longest Strings
     * * @sample Given an array of strings, return another array containing all of its longest strings.

    Example

    For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
    solution(inputArray) = ["aba", "vcd", "aba"].
     */
    fun solution9(inputArray: MutableList<String>): MutableList<String> {
        var res = mutableListOf<String>()
        var maxLength = 0
        for (item in inputArray) {
            if (item.length > maxLength) {
                maxLength = item.length
                res = mutableListOf(item)
            } else if (item.length == maxLength) {
                res.add(item)
            }
        }

        return res;
    }

    /**
     * commonCharacterCount
     * @see "https://app.codesignal.com/arcade/intro/level-3/JKKuHJknZNj4YGL32"
     * @return commonCharacterCount
     * * @sample Given two strings, find the number of common characters between them.

    Example

    For s1 = "aabcc" and s2 = "adcaa", the output should be
    solution(s1, s2) = 3.

    Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun solution10(s1: String, s2: String): Int {
        var count = 0
        var s = s2

        for (element in s1) {
            var j = 0
            while (j < s.length) {
                if (element == s[j]) {
                    s = s.removeRange(j, j + 1)
                    count++
                    break
                }
                j++
            }
        }
        return count
    }



    /**
     * commonCharacterCount
     * @see "https://app.codesignal.com/arcade/intro/level-3/JKKuHJknZNj4YGL32"
     * @return commonCharacterCount
     * * @sample Given two strings, find the number of common characters between them.

    Example

    For s1 = "aabcc" and s2 = "adcaa", the output should be
    solution(s1, s2) = 3.

    Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun solution(n: Int): Boolean {
TODO()
    }


}