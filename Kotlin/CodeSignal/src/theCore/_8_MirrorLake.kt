package theCore

object _8_MirrorLake {
    fun run() {
        println("59 Strings Construction: ${_8_MirrorLake.solution59(a = "abc", b = "abccbac")}")
        println("60 Is Substitution Cipher?: ${_8_MirrorLake.solution60("aacb", "aabc")}")
        println("61 Create Anagram: ${_8_MirrorLake.solution61("OVGHK", "RPGUC")}")
        println("62 Construct Square: ${_8_MirrorLake.solution62("ab")}")
        println("63 Numbers Grouping: ${_8_MirrorLake.solution63(mutableListOf(20000, 239, 10001, 999999, 10000, 20566, 29999))}")
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
        for(ch in s) {
            if(t.contains(ch))
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
        while(result > minNumber)
        {
            result = sqrtN*sqrtN
            if(convert(result.toString()) == code)
                return result
            else
                sqrtN--
        }
        return -1
    }

    private fun convert(s: String) : String {
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
        for(el in a)
            groups[((el - 1) / 10000)] = true

        countGroup = groups.count { c -> c }

        return countGroup + a.count()
    }

}