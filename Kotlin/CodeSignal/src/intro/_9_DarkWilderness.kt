package intro

object _9_DarkWilderness {
    fun run() {
        println("38) Circle of Numbers: ${_9_DarkWilderness.solution38(100, 10, 910)}")
        println("39) Knapsack Light: ${_9_DarkWilderness.solution39(value1 = 10, weight1 = 5, value2 = 6, weight2 = 4,  maxW = 8)}")
        println("40) LongestDigitsPrefix: ${_9_DarkWilderness.solution40("123aa1fdsfs13145")}")
        println("41) DigitDegree: ${_9_DarkWilderness.solution41(1239)}")
        println("42) Bishop and Pawn: ${_9_DarkWilderness.solution42(bishop = "a1", pawn = "c3")}")
    }

     /**
      * Circle of Numbers
      * @see "https://app.codesignal.com/arcade/intro/level-9/xHvruDnQCx7mYom3T"
      * @return Circle of Numbers
      * * @sample Caring for a plant can be hard work, but since you tend to it regularly, you have a plant that grows consistently. Each day, its height increases by a fixed amount represented by the integer upSpeed. But due to lack of sunlight, the plant decreases in height every night, by an amount represented by downSpeed.

     Since you grew the plant from a seed, it started at height 0 initially. Given an integer desiredHeight, your task is to find how many days it'll take for the plant to reach this height.

     Example

     For upSpeed = 100, downSpeed = 10, and desiredHeight = 910, the output should be
     solution(upSpeed, downSpeed, desiredHeight) = 10.

     #	Day	Night
     1	100	90
     2	190	180
     3	280	270
     4	370	360
     5	460	450
     6	550	540
     7	640	630
     8	730	720
     9	820	810
     10	910	900
     The plant first reaches a height of 910 on day 10
      */
     fun solution38(upSpeed: Int, downSpeed: Int, desiredHeight: Int): Int {
         var plantHeight = upSpeed
         var countOfDay = 1
         while(plantHeight < desiredHeight) {
             plantHeight += upSpeed - downSpeed
             countOfDay++
         }
         return countOfDay
     }


    /**
     * Knapsack Light
     * @see "https://app.codesignal.com/arcade/intro/level-9/r9azLYp2BDZPyzaG2"
     * @return Knapsack Light
     * * @sample You found two items in a treasure chest! The first item weighs weight1 and is worth value1, and the second item weighs weight2 and is worth value2. What is the total maximum value of the items you can take with you, assuming that your max weight capacity is maxW and you can't come back for the items later?

    Note that there are only two items and you can't bring more than one item of each type, i.e. you can't take two first items or two second items.

    Example

    For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4, and maxW = 8, the output should be
    solution(value1, weight1, value2, weight2, maxW) = 10.

    You can only carry the first item.

    For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4, and maxW = 9, the output should be
    solution(value1, weight1, value2, weight2, maxW) = 16.

    You're strong enough to take both of the items with you.

    For value1 = 5, weight1 = 3, value2 = 7, weight2 = 4, and maxW = 6, the output should be
    solution(value1, weight1, value2, weight2, maxW) = 7.

    You can't take both items, but you can take any of them.
     */
    fun solution39(value1: Int, weight1: Int, value2: Int, weight2: Int, maxW: Int): Int {
        if (weight1 + weight2 <= maxW)
            return value1 + value2
        if(weight1 <= maxW && weight2 <= maxW)
            return if (value1 > value2) value1 else value2
        if(weight1 <= maxW)
            return value1
        if(weight2 <= maxW)
            return value2
        return 0
    }


    /**
     * LongestDigitsPrefix
     * @see "https://app.codesignal.com/arcade/intro/level-9/AACpNbZANCkhHWNs3"
     * @return LongestDigitsPrefix
     * * @sample Given a string, output its longest prefix which contains only digits.

    Example

    For inputString = "123aa1", the output should be
    solution(inputString) = "123".
     */
    fun solution40(inputString: String): String = inputString.takeWhile { it.isDigit() }


    /**
     * digitDegree
     * @see "https://app.codesignal.com/arcade/intro/level-9/hoLtYWbjdrD2PF6yo"
     * @return digitDegree
     * * @sample Let's define digit degree of some positive integer as the number of times we need to replace this number with the sum of its digits until we get to a one digit number.

    Given an integer, find its digit degree.

    Example

    For n = 5, the output should be
    solution(n) = 0;
    For n = 100, the output should be
    solution(n) = 1.
    1 + 0 + 0 = 1.
    For n = 91, the output should be
    solution(n) = 2.
    9 + 1 = 10 -> 1 + 0 = 1.
     */
    fun solution41(n: Int): Int {
        var str = n.toString()
        var degree = 0
        while (str.length > 1) {
            str = str.map { it.toString().toInt() }.sum().toString()
            degree++
        }
        return degree
    }


    /**
     * Bishop and Pawn
     * @see "https://app.codesignal.com/arcade/intro/level-9/6M57rMTFB9MeDeSWo"
     * @return Bishop and Pawn
     * * @sample Given the positions of a white bishop and a black pawn on the standard chess board, determine whether the bishop can capture the pawn in one move.

    The bishop has no restrictions in distance for each move, but is limited to diagonal movement. Check out the example below to see how it can move:

    Example
    For bishop = "a1" and pawn = "c3", the output should be
    solution(bishop, pawn) = true.

    For bishop = "h1" and pawn = "h3", the output should be
    solution(bishop, pawn) = false.
     */
    fun solution42(bishop: String, pawn: String): Boolean {
        return Math.abs(bishop[0].code - pawn[0].code) == Math.abs(bishop[1].code - pawn[1].code)
    }
}