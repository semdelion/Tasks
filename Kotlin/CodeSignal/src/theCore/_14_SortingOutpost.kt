package theCore

object _14_SortingOutpost {
    fun run() {
        println("114) Shuffled Array\n" +
                "      input: [1, -3, -5, 7, 2]\n" +
                "      result: ${_14_SortingOutpost.solution114(mutableListOf(1, -3, -5, 7, 2))}\n")
        println("115) Sort by Height\n" +
                "      input: [-1, 150, 190, 170, -1, -1, 160, 180]\n" +
                "      result: ${_14_SortingOutpost.solution115(mutableListOf(-1, 150, 190, 170, -1, -1, 160, 180))}\n")
        println("116) Sort by Height\n" +
                "      input: [\"abc\",\"\", \"aaa\",\"a\",\"zz\"]\n" +
                "      result: ${_14_SortingOutpost.solution116(mutableListOf("abc","", "aaa","a","zz"))}\n")
        println("117) Boxes Packing\n" +
                "      input: length = [1, 3, 2], width = [1, 3, 2], and height = [1, 3, 2]\n" +
                "      result: ${_14_SortingOutpost.solution117(mutableListOf(1, 3, 2), mutableListOf(1, 3, 2), mutableListOf(1, 3, 2))}\n")
        println("118) Maximum Sum\n" +
                "      input: length = a[9, 7, 2, 4, 4], q=[[1, 3], [1, 4], [0, 2]]\n" +
                "      result: ${_14_SortingOutpost.solution118(mutableListOf(9, 7, 2, 4, 4), 
                    mutableListOf(
                        mutableListOf(1, 3),
                        mutableListOf(1, 4),
                        mutableListOf(0, 2)
                ))}\n")
        println("119) Rows Rearranging\n" +
                "      input: matrix = \n" +
                "             [2, 7, 1]\n" +
                "             [0, 2, 0]\n" +
                "             [1, 3, 1]\n" +
                "      result: ${solution119(mutableListOf(
                        mutableListOf(2, 7, 1),
                        mutableListOf(0, 2, 0),
                        mutableListOf(1, 3, 1)))}\n")

        println("120) Digit Difference Sort\n" +
                "      input: a = [152, 23, 7, 887, 243]\n" +
                "      result: ${solution120(mutableListOf(152, 23, 7, 887, 243))}\n")

        println("121) Unique Digit Products\n" +
                "      input: a = [2, 8, 121, 42, 222, 23]\n" +
                "      result: ${solution121(mutableListOf(2, 8, 121, 42, 222, 23))}\n")
    }

    /**
     * Shuffled Array
     * @see "https://app.codesignal.com/arcade/code-arcade/sorting-outpost/s4BEFMcpLdGbjX9KX"
     * @return Shuffled Array
     * * @sample A noob programmer was given two simple tasks: sum and sort the elements of the given array
    a = [a1, a2, ..., an]. He started with summing and did it easily, but decided to store the sum he found in some random position of the original array which was a bad idea. Now he needs to cope with the second task, sorting the original array a, and it's giving him trouble since he modified it.

    Given the array shuffled, consisting of elements a1, a2, ..., an, a1 + a2 + ... + an in random order, return the sorted array of original elements a1, a2, ..., an.

    Example

    For shuffled = [1, 12, 3, 6, 2], the output should be
    solution(shuffled) = [1, 2, 3, 6].

    1 + 3 + 6 + 2 = 12, which means that 1, 3, 6 and 2 are original elements of the array.

    For shuffled = [1, -3, -5, 7, 2], the output should be
    solution(shuffled) = [-5, -3, 2, 7].*/
    fun solution114(shuffled: MutableList<Int>): MutableList<Int> {
        shuffled.removeAt(shuffled.indexOf(shuffled.sumOf { it } / 2))
        shuffled.sort()
        return shuffled
    }

    /**
     * Sort by Height
     * @see "https://app.codesignal.com/arcade/code-arcade/sorting-outpost/D6qmdBL2NYz49XHwM"
     * @return Sort by Height
     * * @sample Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees. People can be very tall!

    Example

    For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
    solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun solution115(a: MutableList<Int>): MutableList<Int> {
        for (i in 0 until a.count()) {
            if (a[i] != -1) {
                var min = a[i]
                var index = i
                for (j in i + 1 until a.count()) {
                    if (min > a[j] && a[j] != -1) {
                        min = a[j]
                        index = j
                    }
                }
                val tmp = a[i]
                a[i] = min
                a[index] = tmp
            }
        }
        return a
    }

    /**
     * Sort By Length
     * @see "https://app.codesignal.com/arcade/code-arcade/sorting-outpost/QQB7f8ouAqY6jf7xi"
     * @return Sort By Length
     * * @sample Given an array of strings, sort them in the order of increasing lengths. If two strings have the same length, their relative order must be the same as in the initial array.

    Example

    For

    inputArray = ["abc","", "aaa","a","zz"]
    the output should be

    solution(inputArray) = ["","a","zz","abc","aaa"]
     */
    fun solution116(inputArray: MutableList<String>): MutableList<String> {
        inputArray.sortBy{it.length}
        return inputArray
    }

    /**
     * Boxes Packing
     * @see "https://app.codesignal.com/arcade/code-arcade/sorting-outpost/9y4wLpcqnNozn92tG"
     * @return Boxes Packing
     * * @sample You are given n rectangular boxes, the ith box has the length lengthi, the width widthi and the height heighti. Your task is to check if it is possible to pack all boxes into one so that inside each box there is no more than one another box (which, in turn, can contain at most one another box, and so on). More formally, your task is to check whether there is such sequence of n different numbers pi (1 ≤ pi ≤ n) that for each 1 ≤ i < n the box number pi can be put into the box number pi+1.
    A box can be put into another box if all sides of the first one are less than the respective ones of the second one. You can rotate each box as you wish, i.e. you can swap its length, width and height if necessary.

    Example

    For length = [1, 3, 2], width = [1, 3, 2], and height = [1, 3, 2], the output should be
    solution(length, width, height) = true;
    For length = [1, 1], width = [1, 1], and height = [1, 1], the output should be
    solution(length, width, height) = false;
    For length = [3, 1, 2], width = [3, 1, 2], and height = [3, 2, 1], the output should be
    solution(length, width, height) = false.
     */
    fun solution117(length: MutableList<Int>, width: MutableList<Int>, height: MutableList<Int>): Boolean {
        val boxesLWH = mutableListOf<Triple<Int,Int,Int>>()
        val box = MutableList<Int>(3){ 0 }
        for (i in 0 until length.size) {
            box[0] = length[i]
            box[1] = width[i]
            box[2] = height[i]
            box.sort()
            boxesLWH.add(Triple(box[0], box[1], box[2]))
        }
        boxesLWH.sortBy{it.first}
        for (i in 1 until boxesLWH.size) {
            if (boxesLWH[i - 1].first >= boxesLWH[i].first ||
                boxesLWH[i - 1].second >= boxesLWH[i].second ||
                boxesLWH[i - 1].third >= boxesLWH[i].third)
                return false
        }
        return true
    }

    /**
     * Maximum Sum
     * @see "https://app.codesignal.com/arcade/code-arcade/sorting-outpost/64koZSDqndwYxFZj6"
     * @return Maximum Sum
     * * @sample You are given an array of integers a. A range sum query is defined by a pair of non-negative integers l and r (l <= r). The output to a range sum query on the given array a is the sum of all the elements of a that have indices from l to r, inclusive.

    You have the array a and a list of range sum queries q. Find an algorithm that can rearrange the array a in such a way that the total sum of all of the query outputs is maximized, and return this total sum.

    Example

    For a = [9, 7, 2, 4, 4] and q = [[1, 3], [1, 4], [0, 2]], the output should be
    solution(a, q) = 62.

    You can get this sum if the array a is rearranged to be [2, 9, 7, 4, 4]. In that case, the first range sum query [1, 3] returns the sum 9 + 7 + 4 = 20, the second query [1, 4] returns the sum 9 + 7 + 4 + 4 = 24, and the third query [0, 2] returns the sum 2 + 9 + 7 = 18. The total sum will be 20 + 24 + 18 = 62.
     */
    fun solution118(a: MutableList<Int>, q: MutableList<MutableList<Int>>): Int {
        val frequencies = MutableList(a.size){0}
        for(i in 0 until q.size) {
            for(j in q[i][0]..q[i][1]) {
                frequencies[j]++
            }
        }
        frequencies.sort()
        a.sort()
        var result = 0
        var i = frequencies.size - 1
        while(i >= 0 && frequencies[i] != 0) {
            result += frequencies[i]*a[i]
            i--
        }
        return result
    }

    /**
     * Rows Rearranging
     * @see "https://app.codesignal.com/arcade/code-arcade/sorting-outpost/vuXQuYFReJPe6hHAf"
     * @return Rows Rearranging
     * * @sample Given a rectangular matrix of integers, check if it is possible to rearrange its rows in such a way that all its columns become strictly increasing sequences (read from top to bottom).

    Example

    For

    matrix =
    [2, 7, 1],
    [0, 2, 0],
    [1, 3, 1]
    the output should be
    solution(matrix) = false;

    For

    matrix =
    [6, 4],
    [2, 2],
    [4, 3]
    the output should be
    solution(matrix) = true.*/
    fun solution119(matrix: MutableList<MutableList<Int>>): Boolean {
        var isPossible = true
        for (i in matrix.indices) {
            for (j in matrix.indices) {
                if (i != j) {
                    isPossible = isPossible && (
                            matrix[i].all { it > matrix[j][matrix[i].indexOf(it)] } ||
                                    matrix[i].all { it < matrix[j][matrix[i].indexOf(it)] }
                            )
                }
            }
        }
        return isPossible
    }

    /**
     * Digit Difference Sort
     * @see "https://app.codesignal.com/arcade/code-arcade/sorting-outpost/2SFFWqkhkqC7mMBse"
     * @return Digit Difference Sort
     * * @sample Given an array of integers, sort its elements by the difference of their largest and smallest digits. In the case of a tie, that with the larger index in the array should come first.

    Example

    For a = [152, 23, 7, 887, 243], the output should be
    solution(a) = [7, 887, 23, 243, 152].

    Here are the differences of all the numbers:

    152: difference = 5 - 1 = 4;
    23: difference = 3 - 2 = 1;
    7: difference = 7 - 7 = 0;
    887: difference = 8 - 7 = 1;
    243: difference = 4 - 2 = 2.
    23 and 887 have the same difference, but 887 goes after 23 in a, so in the sorted array it comes first.*/
    fun solution120(a: MutableList<Int>): MutableList<Int> {
        val dif = mutableListOf<Int>()
        a.forEach { dif.add(getMaxMinDif(it)) }
        val result = mutableListOf<Int>()
        while (dif.isNotEmpty()) {
            var minIndex = dif.size - 1
            for (i in dif.size - 2 downTo 0) {
                if(dif[i] < dif[minIndex])
                    minIndex = i
            }
            result.add(a[minIndex])
            dif.removeAt(minIndex)
            a.removeAt(minIndex)
        }
        return result
    }

    private fun getMaxMinDif(number: Int): Int {
        val digits = number.toString().map { it.digitToInt() }
        return digits.maxOrNull()!! - digits.minOrNull()!!
    }

    /**
     * Unique Digit Products
     * @see "https://app.codesignal.com/arcade/code-arcade/sorting-outpost/oY6FASrCMEqkxwcAC"
     * @return Unique Digit Products
     * * @sample Let's call product(x) the product of x's digits. Given an array of integers a, calculate product(x) for each x in a, and return the number of distinct results you get.

    Example

    For a = [2, 8, 121, 42, 222, 23], the output should be
    solution(a) = 3.

    Here are the products of the array's elements:

    2: product(2) = 2;
    8: product(8) = 8;
    121: product(121) = 1 * 2 * 1 = 2;
    42: product(42) = 4 * 2 = 8;
    222: product(222) = 2 * 2 * 2 = 8;
    23: product(23) = 2 * 3 = 6.
    As you can see, there are only 3 different products: 2, 6 and 8.*/
    fun solution121(a: MutableList<Int>): Int {
        val map = mutableSetOf<Int>()
        for (item in a) {
            map.add(getMultiplyOfDigits(item))
        }
        return map.size
    }

    private fun getMultiplyOfDigits(number: Int): Int {
        var result = 1
        val digits = number.toString().map { it.digitToInt() }
        digits.forEach{ result *= it }
        return result
    }
}