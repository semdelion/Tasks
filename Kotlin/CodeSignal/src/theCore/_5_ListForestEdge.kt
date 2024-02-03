package theCore

object _5_ListForestEdge {
    fun run() {
        println("35 Add Two Digits: ${_5_ListForestEdge.solution35(9)}")
        println("36 AvoidObstacles: ${_5_ListForestEdge.solution36(mutableListOf(1, 2, 1), 1, 3)}")
        println("37 First Reverse Try: ${_5_ListForestEdge.solution37(mutableListOf(1, 2, 3, 4, 5))}")
        println("38 Concatenate Arrays: ${_5_ListForestEdge.solution38(mutableListOf(2, 2, 1), mutableListOf(10, 11))}")
        println(
            "39 Remove Array Part: ${
                _5_ListForestEdge.solution39(
                    inputArray = mutableListOf(2, 3, 2, 3, 4, 5),
                    l = 2,
                    r = 4
                )
            }"
        )
        println("40 Is Smooth?: ${_5_ListForestEdge.solution40(mutableListOf(-12, 34, 40, -5, -12, 4, 0, 0, -12))}")
        println("41 Replace Middle: ${_5_ListForestEdge.solution41(mutableListOf(7, 2, 2, 5, 10, 7))}")
        println("42 Make Array Consecutive 2: ${_5_ListForestEdge.solution42(mutableListOf(6, 2, 3, 8))}")
    }

    /**
     * Add Two Digits
     * @see "https://app.codesignal.com/arcade/code-arcade/list-forest-edge/gmZFbpR9cirL3Jpf2"
     * @return Add Two Digits
     * * @sample Given an integer size, return array of length size filled with 1s.

    Example

    For size = 4, the output should be
    solution(size) = [1, 1, 1, 1].*/
    fun solution35(size: Int): MutableList<Int> = MutableList(size) { 1 }

    /**
     * Array Replace
     * @see "https://app.codesignal.com/arcade/intro/level-6/mCkmbxdMsMTjBc3Bm"
     * @return Array Replace
     * * @sample Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.

    Example

    For inputArray = [1, 2, 1], elemToReplace = 1, and substitutionElem = 3, the output should be
    solution(inputArray, elemToReplace, substitutionElem) = [3, 2, 3].
     */
    fun solution36(inputArray: MutableList<Int>, elemToReplace: Int, substitutionElem: Int): MutableList<Int> {
        inputArray.replaceAll { if (it == elemToReplace) substitutionElem else it }
        return inputArray
    }

    /**
     * First Reverse Try
     * @see "https://app.codesignal.com/arcade/code-arcade/list-forest-edge/ND8nghbndTNKPP4Tb"
     * @return First Reverse Try
     * * @sample Reversing an array can be a tough task, especially for a novice programmer. Mary just started coding, so she would like to start with something basic at first. Instead of reversing the array entirely, she wants to swap just its first and last elements.

    Given an array arr, swap its first and last elements and return the resulting array.

    Example

    For arr = [1, 2, 3, 4, 5], the output should be
    solution(arr) = [5, 2, 3, 4, 1].
     */
    fun solution37(arr: MutableList<Int>): MutableList<Int> {
        if (arr.isNotEmpty()) {
            val tmp = arr[arr.count() - 1]
            arr[arr.count() - 1] = arr[0]
            arr[0] = tmp
        }
        return arr
    }

    /**
     * Concatenate Arrays
     * @see "https://app.codesignal.com/arcade/code-arcade/list-forest-edge/GeqSK26bvdrarkGH9"
     * @return Concatenate Arrays
     * * @sample Given two arrays of integers a and b, obtain the array formed by the elements of a followed by the elements of b.

    Example

    For a = [2, 2, 1] and b = [10, 11], the output should be
    solution(a, b) = [2, 2, 1, 10, 11].
     */
    fun solution38(a: MutableList<Int>, b: MutableList<Int>): MutableList<Int> {
        a.addAll(b)
        return a
    }

    /**
     * Remove Array Part
     * @see "https://app.codesignal.com/arcade/code-arcade/list-forest-edge/vPJB7T28fyCeh2Ljn"
     * @return Remove Array Part
     * * @sample Remove a part of a given array between given 0-based indexes l and r (inclusive).

    Example

    For inputArray = [2, 3, 2, 3, 4, 5], l = 2, and r = 4, the output should be
    solution(inputArray, l, r) = [2, 3, 5].
     */
    fun solution39(inputArray: MutableList<Int>, l: Int, r: Int): MutableList<Int> {
        for (i in l..r) inputArray.removeAt(l)
        return inputArray
    }

    /**
     * Is Smooth?
     * @see "https://app.codesignal.com/arcade/code-arcade/list-forest-edge/3LmZafR9wMCWpdgra"
     * @return Is Smooth?
     * * @sample We define the middle of the array arr as follows:

    if arr contains an odd number of elements, its middle is the element whose index number is the same when counting from the beginning of the array and from its end;
    if arr contains an even number of elements, its middle is the sum of the two elements whose index numbers when counting from the beginning and from the end of the array differ by one.
    An array is called smooth if its first and its last elements are equal to one another and to the middle. Given an array arr, determine if it is smooth or not.

    Example

    For arr = [7, 2, 2, 5, 10, 7], the output should be
    solution(arr) = true.

    The first and the last elements of arr are equal to 7, and its middle also equals 2 + 5 = 7. Thus, the array is smooth and the output is true.

    For arr = [-5, -5, 10], the output should be
    solution(arr) = false.

    The first and middle elements are equal to -5, but the last element equals 10. Thus, arr is not smooth and the output is false.
     */
    fun solution40(arr: MutableList<Int>): Boolean {
        val count = arr.count()
        val middle = if (count % 2 == 1) arr[count / 2] else {
            arr[count / 2] + arr[count / 2 - 1]
        }
        return arr[0] == middle && middle == arr[count - 1]
    }

    /**
     * Replace Middle
     * @see "https://app.codesignal.com/arcade/code-arcade/list-forest-edge/APD5T5CybxTtfkdjL"
     * @return Replace Middle
     * * @sample We define the middle of the array arr as follows:

    if arr contains an odd number of elements, its middle is the element whose index number is the same when counting from the beginning of the array and from its end;
    if arr contains an even number of elements, its middle is the sum of the two elements whose index numbers when counting from the beginning and from the end of the array differ by one.
    Given array arr, your task is to find its middle, and, if it consists of two elements, replace those elements with the value of middle. Return the resulting array as the answer.

    Example

    For arr = [7, 2, 2, 5, 10, 7], the output should be
    solution(arr) = [7, 2, 7, 10, 7].

    The middle consists of two elements, 2 and 5. These two elements should be replaced with their sum, i.e. 7.

    For arr = [-5, -5, 10], the output should be
    solution(arr) = [-5, -5, 10].

    The middle is defined as a single element -5, so the initial array with no changes should be returned.
     */
    fun solution41(arr: MutableList<Int>): MutableList<Int> {
        val count = arr.count()
        if (count % 2 != 1) {
            val middle = arr[count / 2] + arr[count / 2 - 1]
            arr.removeAt(count / 2 - 1)
            arr[count / 2 - 1] = middle
        }
        return arr
    }

    /**
     * Make Array Consecutive 2
     * @see "https://app.codesignal.com/arcade/intro/level-2/bq2XnSr5kbHqpHGJC"
     * @return count
     * * @sample Ratiorg got statues of different sizes as a present from CodeMaster for his birthday, each statue having an non-negative integer size. Since he likes to make things perfect, he wants to arrange them from smallest to largest so that each statue will be bigger than the previous one exactly by 1. He may need some additional statues to be able to accomplish that. Help him figure out the minimum number of additional statues needed.
    Example
    For statues = [6, 2, 3, 8], the output should be
    solution(statues) = 3.
    Ratiorg needs statues of sizes 4, 5 and 7.
     */
    fun solution42(statues: MutableList<Int>): Int {
        val max = statues.maxOf { it }
        val min = statues.minOf { it }
        return (max - min) - statues.count() + 1
    }
}