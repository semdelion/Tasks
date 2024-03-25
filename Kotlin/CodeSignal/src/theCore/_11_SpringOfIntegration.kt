package theCore

object _11_SpringOfIntegration {
    fun run() {
        println("88) Array Conversion\n" +
                "      input: inputArray = [1, 2, 3, 4, 5, 6, 7, 8]\n" +
                "      result: ${_11_SpringOfIntegration.solution88(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8))}\n")
        println("89) Array Previous Less\n" +
                "      input: items = [3, 5, 2, 4, 5]\n" +
                "      result: ${_11_SpringOfIntegration.solution89(mutableListOf(3, 5, 2, 4, 5))}\n")
        println("90) Pair of Shoes\n" +
                "      input: shoes  = [0, 21], [1, 23], [1, 21], [0, 23]\n" +
                "      result: ${_11_SpringOfIntegration.solution90(mutableListOf(
                    mutableListOf(0, 21),mutableListOf(1, 23), mutableListOf(1, 21),mutableListOf(0, 23)))}\n")
        println("91) Combs\n" +
                "      input: comb1 = \"*..*.*\", comb2 = \"*.***\"\n" +
                "      result: ${_11_SpringOfIntegration.solution91("*..*.*", "*.***")}\n")
        println("92) Strings Crossover\n" +
                "      input: inputArray = [\"abc\", \"aaa\", \"aba\", \"bab\"], result = \"bbb\"\n" +
                "      result: ${_11_SpringOfIntegration.solution92(mutableListOf("abc", "aaa", "aba", "bab"),"bbb")}\n")
        println("93) Cyclic String\n" +
                "      input: s = \"caccacaccacacca\" \n" +
                "      result: ${_11_SpringOfIntegration.solution93("caccacaccacacca")}\n")
        println("94) Beautiful Text\n" +
                "      input: s = inputString = \"Look at this example of a correct text\", l = 5, r = 15\n" +
                "      result: ${_11_SpringOfIntegration.solution94("Look at this example of a correct text", 12, 15)}\n")
    }

    /**
     * Array Conversion
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/dwA8RtDF86WucuoaQ"
     * @return Array Conversion
     * * @sample Given an array of 2k integers (for some integer k), perform the following operations until the array contains only one element:

    On the 1st, 3rd, 5th, etc. iterations (1-based) replace each pair of consecutive elements with their sum;
    On the 2nd, 4th, 6th, etc. iterations replace each pair of consecutive elements with their product.
    After the algorithm has finished, there will be a single element left in the array. Return that element.

    Example

    For inputArray = [1, 2, 3, 4, 5, 6, 7, 8], the output should be
    solution(inputArray) = 186.

    We have [1, 2, 3, 4, 5, 6, 7, 8] -> [3, 7, 11, 15] -> [21, 165] -> [186], so the answer is 186.*/
    fun solution88(inputArray: MutableList<Int>): Int {
        var result = inputArray
        var even = false
        while (result.size != 1) {
            even = !even
            for (i in 0 until result.size step 2) {
                result[i] = if(even) result[i] + result[i+1] else result[i] * result[i+1]
            }
            result = result.filterIndexed { index, _ -> index % 2 == 0 } as MutableList<Int>
        }
        return result[0]
    }

    /**
     * Array Previous Less
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/MQg7s3dKrP4caN42A"
     * @return Array Previous Less
     * * @sample Given array of integers, for each position i, search among the previous positions for the last (from the left) position that contains a smaller value. Store this value at position i in the answer. If no such value can be found, store -1 instead.

    Example

    For items = [3, 5, 2, 4, 5], the output should be
    solution(items) = [-1, 3, -1, 2, 4].*/
    fun solution89(items: MutableList<Int>): MutableList<Int> {
        var flag = false
        for (i in items.size - 1 downTo 0) {
            for (j in i - 1 downTo 0) {
                if(items[j] < items[i]) {
                    items[i] = items[j]
                    flag = true
                    break
                }
            }
            if (!flag)
                items[i] = -1

            flag = false
        }
        items[0] = -1
        return items
    }

    /**
     * Pair of Shoes
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/picP24ieQnuqR4kxJ"
     * @return Pair of Shoes
     * * @sample     Yesterday you found some shoes in the back of your closet. Each shoe is described by two values:

    type indicates if it's a left or a right shoe;
    size is the size of the shoe.
    Your task is to check whether it is possible to pair the shoes you found in such a way that each pair consists of a right and a left shoe of an equal size.

    Example

    For

    shoes = [[0, 21],
    [1, 23],
    [1, 21],
    [0, 23]]
    the output should be
    solution(shoes) = true;

    For

    shoes = [[0, 21],
    [1, 23],
    [1, 21],
    [1, 23]]
    the output should be
    solution(shoes) = false*/
    fun solution90(shoes: MutableList<MutableList<Int>>): Boolean {
        while (shoes.size > 0) {
            var shoeIndex: Int? = null
            for (i in 1 until shoes.size) {
                if(shoes[i][0] == (shoes[0][0]+1) % 2 && shoes[i][1] == shoes[0][1]) {
                    shoeIndex = i
                    break
                }
            }
            if (shoeIndex == null)
                return false
            shoes.removeAt(shoeIndex)
            shoes.removeAt(0)
        }
        return true
    }

    /**
     * Combs
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/6ceKutpnCs4LzBKgf"
     * @return Combs
     * * @sample     Miss X has only two combs in her possession, both of which are old and miss a tooth or two. She also has many purses of different length, in which she carries the combs. The only way they fit is horizontally and without overlapping. Given teeth' positions on both combs, find the minimum length of the purse she needs to take them with her.

    It is guaranteed that there is at least one tooth at each end of the comb.
    It is also guaranteed that the total length of two strings is smaller than 32.
    Note, that the combs can not be rotated/reversed.

    Example

    For comb1 = "*..*" and comb2 = "*.*", the output should be
    solution(comb1, comb2) = 5.

    Although it is possible to place the combs like on the first picture, the best way to do this is either picture 2 or picture 3.*/
    fun solution91(comb1: String, comb2: String): Int {
        var minLength = comb1.length + comb2.length
        for (i in 0 until comb1.length + comb2.length - 1) {
            val from = if(i >= comb2.length) (i - comb2.length  + 1) else 0
            val to = if(i < comb1.length) i else comb1.length - 1
            var flag = true
            for (j in from ..to ) {
                if(comb1[j] == '*' && comb2[comb2.length - 1 - i + j]=='*') {
                    flag = false
                    break
                }
            }
            if (flag && minLength > comb1.length + comb2.length - (to - from + 1))
                minLength = comb1.length + comb2.length - (to - from + 1)

        }
        return minLength
    }

    /**
     * Strings Crossover
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/6ceKutpnCs4LzBKgf"
     * @return Strings Crossover
     * * @sample  Define crossover operation over two equal-length strings A and B as follows:

    the result of that operation is a string of the same length as the input strings
    result[i] is either A[i] or B[i], chosen at random
    Given array of strings inputArray and a string result, find for how many pairs of strings from inputArray the result of the crossover operation over them may be equal to result.

    Note that (A, B) and (B, A) are the same pair. Also note that the pair cannot include the same element of the array twice (however, if there are two equal elements in the array, they can form a pair).

    Example

    For inputArray = ["abc", "aaa", "aba", "bab"] and result = "bbb", the output should be
    solution(inputArray, result) = 2.*/
    fun solution92(inputArray: MutableList<String>, result: String): Int {
        var pairs = 0
        for (i in 0 until inputArray.size - 1) {
            for (j in i + 1 until inputArray.size) {
                if (possibleCrossover(inputArray[i], inputArray[j], result)) {
                    pairs++
                }
            }
        }
        return pairs
    }

    private fun possibleCrossover(A: String, B: String, result: String): Boolean {
        for (i in A.indices) {
            if (A[i] != result[i] && B[i] != result[i]) {
                return false
            }
        }
        return true
    }

    /**
     * Cyclic String
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/tKwbrKAQhoCZFqg33"
     * @return Cyclic String
     * * @sample  You're given a substring s of some cyclic string. What's the length of the smallest possible string that can be concatenated to itself many times to obtain this cyclic string?

    Example

    For s = "cabca", the output should be
    solution(s) = 3.

    "cabca" is a substring of a cycle string "abcabcabcabc..." that can be obtained by concatenating "abc" to itself. Thus, the answer is 3.*/
    fun solution93(s: String): Int {
        var endIndex = 0
        var i = 1
        while (i < s.length) {
            if(s[0]==s[i]) {
                var j = 0
                while ( i + j < s.length && j <= endIndex) {
                    if (s[j] != s[i+j]) {
                        endIndex = getIndex(endIndex + 2, s)
                        i = endIndex
                        break
                    }
                    j++
                }
                if(j > endIndex ||i + j >= s.length) {
                    i += j - 1
                }
            } else {
                endIndex = getIndex(endIndex + 2, s)
                i = endIndex
            }
            i++
        }
        return ++endIndex
    }

    private fun getIndex(k : Int, s: String) : Int {
        var i = k
        while (i < s.length && s[i] != s[0])
            i++
        return i - 1
    }

    /**
     * Beautiful Text
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/PSeEALZTxd93zBHS7"
     * @return Beautiful Text
     * * @sample  Consider a string containing only letters and whitespaces. It is allowed to replace some (possibly, none) whitespaces with newline symbols to obtain a multiline text. Call a multiline text beautiful if and only if each of its lines (i.e. substrings delimited by a newline character) contains an equal number of characters (only letters and whitespaces should be taken into account when counting the total while newline characters shouldn't). Call the length of the line the text width.

    Given a string and some integers l and r (l ≤ r), check if it's possible to obtain a beautiful text from the string with a text width that's within the range [l, r].

    Example

    For inputString = "Look at this example of a correct text", l = 5, and r = 15, the output should be
    solution(inputString, l, r) = true.

    We can replace 13th and 26th characters with '\n', and obtain the following multiline text of width 12:

    Look at this
    example of a
    correct text
    For inputString = "abc def ghi", l = 4, and r = 10, the output should be
    solution(inputString, l, r) = false.

    There are two ways to obtain a text with lines of equal length from this input, one has width = 3 and another has width = 11 (this is a one-liner). Both of these values are not within our bounds.*/
    fun solution94(inputString: String, l: Int, r: Int): Boolean {
        for (i in l..r) {
            val count = inputString.length - inputString.length / (i + 1)
            if (count % i == 0 && (count / i) == (inputString.length / (i + 1)) + 1) {
                var all = true
                for (j in 1 until count / i) {
                    if (inputString[i * j + j - 1] != ' ') {
                        all = false
                        break
                    }
                }
                if (all) return true
            }
        }
        return false
    }
}