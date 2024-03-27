package intro

object _3_SmoothSailing {

    fun run() {
        println("9) All Longest Strings\n" +
                "      input: inputArray = [\"aba\", \"aa\", \"ad\", \"vcd\", \"aba\"]\n" +
                "      result: ${solution9(mutableListOf("aba", "aa", "ad", "vcd", "aba"))}\n")
        println("10) CommonCharacterCounts\n" +
                "      input: s1 = \"aabcc\", s2 = \"adcaa\"\n" +
                "      result: ${solution10("aabcc","adcaa")}\n")
        println("11) IsLucky\n" +
                "      input: n = 112301\n" +
                "      result: ${solution11(112301)}\n")
        println("12) Sort by Height\n" +
                "      input: a = [-1, 150, 190, 170, -1, -1, 160, 180]\n" +
                "      result: ${solution12(mutableListOf(-1, 150, 190, 170, -1, -1, 160, 180))}\n")
        println("13) ReverseInParentheses\n" +
                "      input: inputString = \"foo(bar(baz))blim\"\n" +
                "      result: ${solution13("foo(bar(baz))blim")}\n")
    }

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
     * isLucky
     * @see "https://app.codesignal.com/arcade/intro/level-3/3AdBC97QNuhF6RwsQ"
     * @return isLucky ticket
     * * @sample Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.

    Given a ticket number n, determine if it's lucky or not.

    Example

    For n = 1230, the output should be
    solution(n) = true;
    For n = 239017, the output should be
    solution(n) = false.
     */
    fun solution11(n: Int): Boolean {
        var number = n
        var left = 0
        var right = 0
        val length = n.toString().length
        for (i in 0 until length/2) {
            right += number%10
            number /= 10
        }
        for (i in 0 until length/2) {
            left += number%10
            number /= 10
        }

        return left==right
    }

    /**
     * Sort by Height
     * @see "https://app.codesignal.com/arcade/intro/level-3/D6qmdBL2NYz49XHwM"
     * @return Sort by Height
     * * @sample Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees. People can be very tall!

    Example

    For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
    solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun solution12(a: MutableList<Int>): MutableList<Int> {
        for (i in 0 until a.count())
        {
            if (a[i] != -1)
            {
                var min = a[i];
                var index = i;
                for (j in i + 1 until a.count())
                {
                    if (min > a[j] && a[j] != -1)
                    {
                        min = a[j];
                        index = j;
                    }
                }
                val tmp = a[i];
                a[i] = min;
                a[index] = tmp;
            }
        }
        return a;
    }

    /**
     * reverseInParentheses
     * @see "https://app.codesignal.com/arcade/intro/level-3/9DgaPsE2a7M6M2Hu6"
     * @return reverseInParentheses
     * * @sample Write a function that reverses characters in (possibly nested) parentheses in the input string.

    Input strings will always be well-formed with matching ()s.

    Example
    For inputString = "foo(bar(baz))blim", the output should be
    solution(inputString) = "foobazrabblim".
    Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
     */
    fun solution13(inputString: String): String {
        var data = inputString

        var i = data.length - 1
        var rBracket = -1
        while ( i >= 0 ) {
            if(data[i]==')') {
                rBracket = i
            } else if(data[i]=='(') {
                data = revert(data, i, rBracket)
                i = data.length
            }
            i--
        }
        return data
    }

    private fun revert(inputString : String, l: Int, r: Int) : String {
        val data = inputString.substring(l+1, r).reversed()
        return inputString.replaceRange(l, r+1, data)
    }

}