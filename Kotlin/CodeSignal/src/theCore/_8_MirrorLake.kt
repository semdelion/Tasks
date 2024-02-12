package theCore

object _8_MirrorLake {
    fun run() {
        println("59 Strings Construction: ${_8_MirrorLake.solution59(a = "abc", b = "abccbac")}")
        println("60 Is Substitution Cipher?: ${_8_MirrorLake.solution60("aacb", "aabc")}")
        println("61 Create Anagram: ${_8_MirrorLake.solution61("OVGHK", "RPGUC")}")
        println("62 Construct Square: ${_8_MirrorLake.solution62("ab")}")
        println(
            "63 Numbers Grouping: ${
                _8_MirrorLake.solution63(
                    mutableListOf(
                        20000,
                        239,
                        10001,
                        999999,
                        10000,
                        20566,
                        29999
                    )
                )
            }"
        )
        println(
            "64 Different Squares: ${
                _8_MirrorLake.solution64(
                    mutableListOf(
                        mutableListOf(1, 2, 1),
                        mutableListOf(2, 2, 2),
                        mutableListOf(2, 2, 2),
                        mutableListOf(1, 2, 3),
                        mutableListOf(2, 2, 1),
                    )
                )
            }"
        )

        println("65 Construct Square: ${_8_MirrorLake.solution65(88)}")
        println("66 Number of Clans: ${_8_MirrorLake.solution66(mutableListOf(2,3), 6)}")
    }

    /**
     * Strings Construction
     * @see "https://app.codesignal.com/arcade/code-arcade/mirror-lake/chW9F8bCgxYJBcgj3"
     * @return Strings Construction
     * * @sample Given two strings a and b, both consisting only of lowercase English letters, your task is to calculate how many strings equal to a can be constructed using only letters from the string b? Each letter can be used only once and in one string only.

    Example

    For a = "abc" and b = "abccba", the output should be solution(a, b) = 2.

    We can construct 2 strings a = "abc" using only letters from the string b.

    For a = "ab" and b = "abcbcb", the output should be solution(a, b) = 1.*/

    fun solution59(a: String, b: String): Int {
        val mapA = a.groupingBy { it }.eachCount()
        val mapB = b.groupingBy { it }.eachCount()

        var min = Int.MAX_VALUE
        for (item in mapA) {
            if (mapB.containsKey(item.key)) {
                if (mapB[item.key]!!.div(item.value) < min)
                    min = mapB[item.key]!!.div(item.value)
            } else return 0
        }

        return min
    }

    /**
     * Is Substitution Cipher?
     * @see "https://app.codesignal.com/arcade/code-arcade/mirror-lake/EeKpdMQXpBkgWjcvt"
     * @return Is Substitution Cipher?
     * * @sample A ciphertext alphabet is obtained from the plaintext alphabet by means of rearranging some characters. For example "bacdef...xyz" will be a simple ciphertext alphabet where a and b are rearranged.

    A substitution cipher is a method of encoding where each letter of the plaintext alphabet is replaced with the corresponding (i.e. having the same index) letter of some ciphertext alphabet.

    Given two strings, check whether it is possible to obtain them from each other using some (possibly, different) substitution ciphers.

    Example

    For string1 = "aacb" and string2 = "aabc", the output should be
    solution(string1, string2) = true.

    Any ciphertext alphabet that starts with acb... would make this transformation possible.

    For string1 = "aa" and string2 = "bc", the output should be
    solution(string1, string2) = false.*/
    fun solution60(a: String, b: String): Boolean {
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until a.count()) {
            if (map.containsKey(a[i].code)) {
                if (map[a[i].code] != b[i].code)
                    return false
            } else {
                if (map.containsValue(b[i].code))
                    return false
                else
                    map[a[i].code] = b[i].code
            }
        }
        return true
    }

    /**
     * Create Anagram
     * @see "https://app.codesignal.com/arcade/code-arcade/mirror-lake/BsShkFDfbkWxozmMN"
     * @return Create Anagram
     * * @sample You are given two strings s and t of the same length, consisting of uppercase English letters. Your task is to find the minimum number of "replacement operations" needed to get some anagram of the string t from the string s. A replacement operation is performed by picking exactly one character from the string s and replacing it by some other character.

    Example

    For s = "AABAA" and t = "BBAAA", the output should be
    solution(s, t) = 1;
    For s = "OVGHK" and t = "RPGUC", the output should be
    solution(s, t) = 4.*/
    fun solution61(s: String, test: String): Int {
        var number: Int = 0
        var t = test
        for (ch in s) {
            if (t.contains(ch))
                t = t.replaceFirst(ch, '-')
            else
                number++
        }
        return number
    }

    /**
     * Construct Square
     * @see "https://app.codesignal.com/arcade/code-arcade/mirror-lake/BsShkFDfbkWxozmMN"
     * @return Construct Square
     * * @sample Given a string consisting of lowercase English letters, find the largest square number which can be obtained by reordering the string's characters and replacing them with any digits you need (leading zeros are not allowed) where same characters always map to the same digits and different characters always map to different digits.

    If there is no solution, return -1.

    Example

    For s = "ab", the output should be
    solution(s) = 81.
    The largest 2-digit square number with different digits is 81.
    For s = "zzz", the output should be
    solution(s) = -1.
    There are no 3-digit square numbers with identical digits.
    For s = "aba", the output should be
    solution(s) = 900.
    It can be obtained after reordering the initial string into "baa" and replacing "a" with 0 and "b" with 9.*/
    fun solution62(s: String): Int {
        val code = convert(s)

        val maxNumber = Math.pow(10.0, s.length.toDouble()) - 1
        val minNumber = Math.pow(10.0, (s.length.toDouble() - 1) - 1)

        var sqrtN = Math.sqrt(maxNumber).toInt()
        var result = maxNumber.toInt()
        while (result > minNumber) {
            result = sqrtN * sqrtN
            if (convert(result.toString()) == code)
                return result
            else
                sqrtN--
        }
        return -1
    }

    private fun convert(s: String): String {
        val numb = s.groupingBy { it }.eachCount()
        return numb.values.sorted().joinToString("")
    }

    /**
     * Numbers Grouping
     * @see "https://app.codesignal.com/arcade/code-arcade/mirror-lake/kGeuCkJNbqczCCqgg"
     * @return Numbers Grouping
     * * @sample You are given an array of integers that you want distribute between several groups. The first group should contain numbers from 1 to 104, the second should contain those from 104 + 1 to 2 * 104, ..., the 100th one should contain numbers from 99 * 104 + 1 to 106 and so on.

    All the numbers will then be written down in groups to the text file in such a way that:

    the groups go one after another;
    each non-empty group has a header which occupies one line;
    each number in a group occupies one line.
    Calculate how many lines the resulting text file will have.
    Example

    For a = [20000, 239, 10001, 999999, 10000, 20566, 29999], the output should be
    solution(a) = 11.

    The numbers can be divided into 4 groups:

    239 and 10000 go to the 1st group (1 ... 104);
    10001 and 20000 go to the second 2nd (104 + 1 ... 2 * 104);
    20566 and 29999 go to the 3rd group (2 * 104 + 1 ... 3 * 104);
    groups from 4 to 99 are empty;
    999999 goes to the 100th group (99 * 104 + 1 ... 106).
    Thus, there will be 4 groups (i.e. four headers) and 7 numbers, so the file will occupy 4 + 7 = 11 lines.*/
    fun solution63(a: MutableList<Int>): Int {
        var countGroup = 0
        val groups = BooleanArray(100001)
        for (el in a)
            groups[((el - 1) / 10000)] = true

        countGroup = groups.count { c -> c }

        return countGroup + a.count()
    }

    /**
     * Different Squares
     * @see "https://app.codesignal.com/arcade/code-arcade/mirror-lake/fQpfgxiY6aGiGHLtv"
     * @return Different Squares
     * * @sample Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.

    Example

    For

    matrix = [[1, 2, 1],
    [2, 2, 2],
    [2, 2, 2],
    [1, 2, 3],
    [2, 2, 1]]
    the output should be
    solution(matrix) = 6.

    Here are all 6 different 2 × 2 squares:

    1 2    2 1    2 2    2 2    2 2    2 3
    2 2    2 2    2 2    1 2    2 3    2 1
     */
    fun solution64(matrix: MutableList<MutableList<Int>>): Int {
        if (matrix.size <= 1 || matrix.first().size <= 1)
            return 0

        val codes = hashMapOf<String, Boolean>()
        for (i in 0 until (matrix.size - 1))
            for (j in 0 until (matrix[i].size - 1))
                codes["${matrix[i][j]},${matrix[i][j + 1]},${matrix[i + 1][j]},${matrix[i + 1][j + 1]}"] = true

        return codes.keys.count();
    }

    /**
     * Most Frequent Digit Sum
     * @see "https://app.codesignal.com/arcade/code-arcade/mirror-lake/RpoP4Aqa5mbmC8koC"
     * @return Most Frequent Digit Sum
     * * @sample A step(x) operation works like this: it changes a number x into x - s(x), where s(x) is the sum of x's digits. You like applying functions to numbers, so given the number n, you decide to build a decreasing sequence of numbers: n, step(n), step(step(n)), etc., with 0 as the last element.

    Building a single sequence isn't enough for you, so you replace all elements of the sequence with the sums of their digits (s(x)). Now you're curious as to which number appears in the new sequence most often. If there are several answers, return the maximal one.

    Example

    For n = 88, the output should be
    solution(n) = 9.

    Here is the first sequence you built: 88, 72, 63, 54, 45, 36, 27, 18, 9, 0;
    And here is s(x) for each of its elements: 16, 9, 9, 9, 9, 9, 9, 9, 9, 0.
    As you can see, the most frequent number in the second sequence is 9.

    For n = 8, the output should be
    solution(n) = 8.

    At first you built the following sequence: 8, 0
    s(x) for each of its elements is: 8, 0
    As you can see, the answer is 8 (it appears as often as 0, but is greater than it).
     */
    fun solution65(n: Int): Int {
        var next = n
        val numbers = mutableMapOf<Int,Int>()
        while(next > 0) {
            val sum = next.toString().map { it.toString().toInt() }.sum()
            numbers[sum] = (numbers[sum] ?: 0) + 1
            next -= sum
        }
        return getMax(numbers)
    }

    private fun getMax(numbers: MutableMap<Int,Int>): Int {
        val key = numbers.maxByOrNull { it.value }
        val maxKeys = numbers.filter{ it.value == (key?.value ?: 0) }
        return maxKeys.maxByOrNull { it.key }?.key ?:0
    }



    /**
     * Number of Clans
     * @see "https://app.codesignal.com/arcade/code-arcade/mirror-lake/BLbGNY3kEcvKjBCFC"
     * @return Number of Clans
     * * @sample Let's call two integers A and B friends if each integer from the array divisors is either a divisor of both A and B or neither A nor B. If two integers are friends, they are said to be in the same clan. How many clans are the integers from 1 to k, inclusive, broken into?

    Example

    For divisors = [2, 3] and k = 6, the output should be
    solution(divisors, k) = 4.

    The numbers 1 and 5 are friends and form a clan, 2 and 4 are friends and form a clan, and 3 and 6 do not have friends and each is a clan by itself. So the numbers 1 through 6 are broken into 4 clans.
     */
    fun solution66(divisors: MutableList<Int>, k: Int): Int {
        val clans = mutableSetOf<Int>()
        for (i in 1..k) {
            var clan = 0
            for (divisor in divisors) {
                clan = (clan * 10) + if (i % divisor == 0) 1 else 0
            }
            clans.add(clan)
        }
        return clans.size
    }

}