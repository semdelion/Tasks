package theCore

import kotlin.math.min

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

}