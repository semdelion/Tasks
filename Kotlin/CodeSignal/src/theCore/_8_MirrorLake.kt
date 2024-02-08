package theCore

object _8_MirrorLake {
    fun run() {
        println("59 Strings Construction: ${_8_MirrorLake.solution59(a = "abc", b = "abccbac")}")
        println("60 Is Substitution Cipher?: ${_8_MirrorLake.solution60("aacb", "aabc")}")
        println("61 Create Anagram: ${_8_MirrorLake.solution61("OVGHK", "RPGUC")}")
        println("62 Construct Square: ${_8_MirrorLake.solution62("ab")}")

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

    private fun convert(s: String) : String
    {
        var numb = mutableMapOf<Char,Int>()

        for(ch in s)
            numb[ch] = (numb[ch] ?: 0) + 1

        val sorted = numb.values.sorted()
        var result: String = ""
        for (count in sorted)
            result += count

        return result
    }

}