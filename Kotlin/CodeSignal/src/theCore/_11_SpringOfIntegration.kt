package theCore

object _11_SpringOfIntegration {
    fun run() {
        println("88) Array Conversion\n" +
                "      input: inputArray = [1, 2, 3, 4, 5, 6, 7, 8]\n" +
                "      result: ${solution88(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8))}\n")
        println("89) Array Previous Less\n" +
                "      input: items = [3, 5, 2, 4, 5]\n" +
                "      result: ${solution89(mutableListOf(3, 5, 2, 4, 5))}\n")
        println("90) Pair of Shoes\n" +
                "      input: shoes  = [0, 21], [1, 23], [1, 21], [0, 23]\n" +
                "      result: ${solution90(mutableListOf(
                    mutableListOf(0, 21),mutableListOf(1, 23), mutableListOf(1, 21),mutableListOf(0, 23)))}\n")
        println("91) Combs\n" +
                "      input: comb1 = \"*..*.*\", comb2 = \"*.***\"\n" +
                "      result: ${solution91("*..*.*", "*.***")}\n")
        println("92) Strings Crossover\n" +
                "      input: inputArray = [\"abc\", \"aaa\", \"aba\", \"bab\"], result = \"bbb\"\n" +
                "      result: ${solution92(mutableListOf("abc", "aaa", "aba", "bab"),"bbb")}\n")
        println("93) Cyclic String\n" +
                "      input: s = \"caccacaccacacca\" \n" +
                "      result: ${solution93("caccacaccacacca")}\n")
        println("94) Beautiful Text\n" +
                "      input: s = inputString = \"Look at this example of a correct text\", l = 5, r = 15\n" +
                "      result: ${solution94("Look at this example of a correct text", 12, 15)}\n")
        println("95) Runners Meetings\n" +
                "      input: s = startPosition = [1, 4, 2], speed = [27, 18, 24]\n" +
                "      result: ${solution95(mutableListOf(1, 4, 2), mutableListOf(27, 18, 24) )}\n")
        println("96) Christmas Tree\n" +
                "      input: s = levelNum = 1, levelHeight = 3\n" +
                "      result: \n")
        solution96(2, 3).forEach { println("            $it") }
        println()

        println("97) File Naming\n" +
                    "      input: names = ${mutableListOf("doc", "doc", "image", "doc(1)","doc")}\n" +
                    "      result: ${solution97(mutableListOf("doc","doc","image","doc(1)","doc"))}\n" )
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

    /**
     * Runners Meetings
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/Hb9Cppx4pCY4d8J5P"
     * @return Runners Meetings
     * * @sample Some people run along a straight line in the same direction. They start simultaneously at pairwise distinct positions and run with constant speed (which may differ from person to person).

    If two or more people are at the same point at some moment we call that a meeting. The number of people gathered at the same point is called meeting cardinality.

    For the given starting positions and speeds of runners find the maximum meeting cardinality assuming that people run infinitely long. If there will be no meetings, return -1 instead.

    Example

    For startPosition = [1, 4, 2] and speed = [27, 18, 24], the output should be
    solution(startPosition, speed) = 3.

    In 20 seconds after the runners start running, they end up at the same point. Check out the gif below for better understanding:*/
    fun solution95(startPosition: MutableList<Int>, speed: MutableList<Int>): Int {
        //Initial max meetings
        var maxOfMeetingCardinality = -1

        for (i in 0 until speed.size) {
            for (j in i + 1 until speed.size) {
                //Ignore if runners same speed but diff start position
                if (speed[i] == speed[j] && startPosition[i] != startPosition[j]) continue

                //Meeting point between 2 runners
                val meetingPoint =
                    (startPosition[i] - startPosition[j]).toDouble() / (speed[j] - speed[i])

                //Check if meeting point not valid
                if (meetingPoint < 0) continue

                var currentMeetingCardinality = 2

                //Check if any more runners join meeting
                for (k in j + 1 until speed.size) {
                    if (startPosition[j] + speed[j] * meetingPoint ==
                        startPosition[k] + speed[k] * meetingPoint
                    ) {
                        currentMeetingCardinality++
                    }
                }
                if (currentMeetingCardinality > maxOfMeetingCardinality) {
                    maxOfMeetingCardinality = currentMeetingCardinality
                }
            }
        }
        return maxOfMeetingCardinality
    }

    /**
     * Christmas Tree
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/Hb9Cppx4pCY4d8J5P"
     * @return Christmas Tree
     * * @sample It's Christmas time! To share his Christmas spirit with all his friends, the young Christmas Elf decided to send each of them a Christmas e-mail with a nice Christmas tree. Unfortunately, Internet traffic is very expensive in the North Pole, so instead of sending an actual image he got creative and drew the tree using nothing but asterisks ('*' symbols). He has given you the specs (see below) and your task is to write a program that will generate trees following the spec and some initial parameters.

    Here is a formal definition of how the tree should be built, but before you read it the Elf HIGHLY recommends first looking at the examples that follow:

    Each tree has a crown as follows:

     *
     *
     ***
    Define a line as a horizontal group of asterisks and a level as a collection of levelHeight lines stacked one on top of the other.

    Below the crown there are levelNum levels.

    The tree is perfectly symmetrical so all the middle asterisks of the lines lie on the center of the tree.

    Each line of the same level (excluding the first one) has two more asterisks than the previous one (one added to each end);

    The number of asterisks in the first line of each level is chosen as follows:

    the first line of the first level has 5 asterisks;
    the first line of each consecutive level contains two more asterisks than the first line of the previous level.
    And finally there is the tree foot which has a height of levelNum and a width of:

    levelHeight asterisks if levelHeight is odd;
    levelHeight + 1 asterisks if levelHeight is even.
    Given levelNum and levelHeight, return the Christmas tree of the young elf.

    Example

    For levelNum = 1 and levelHeight = 3, the output should be

    solution(levelNum, levelHeight) =
    "    *",
    "    *",
    "   ***",
    "  *****",
    " *******",
    "*********",
    "   ***"
    , which represents the following tree:
                ___
         *        |
         *        |-- the crown
        ***    ___|
       *****      |
      *******     |-- level 1
     ********* ___|
        ***    ___|-- the foot
    For levelNum = 2 and levelHeight = 4, the output should be

    solution(levelNum, levelHeight) =
    "      *",
    "      *",
    "     ***",
    "    *****",
    "   *******",
    "  *********",
    " ***********",
    "   *******",
    "  *********",
    " ***********",
    "*************",
    "    *****",
    "    *****"
    , which represents the following tree:
                    ___
           *          |
           *          | -- the crown
          ***      ___|
         *****        |
        *******       | -- level 1
       *********      |
      ***********  ___|
        *******       |
       *********      | -- level 2
      ***********     |
     ************* ___|
         *****        | -- the foot
         *****     ___|*/
    fun solution96(levelNum: Int, levelHeight: Int): MutableList<String> {
        //the crown
        val christmasTree = mutableListOf<String>()
        christmasTree.add(" ".repeat(levelHeight + levelNum) + "*")
        christmasTree.add(christmasTree[0])
        christmasTree.add(" ".repeat(levelHeight + levelNum - 1) + "***")
        //levels
        for (i in 1..levelNum) {
            for(j in 1.. levelHeight) {
                christmasTree.add(" ".repeat(levelHeight + levelNum - i - j) + "*".repeat(1 + i * 2 + j * 2))
            }
        }
        //the foot
        for (i in 1..levelNum) {
            christmasTree.add(" ".repeat(levelHeight + levelNum - levelHeight / 2) + "*".repeat(levelHeight + (levelHeight + 1) % 2))
        }
        return christmasTree
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
    fun solution97(names: MutableList<String>): MutableList<String> {
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
}