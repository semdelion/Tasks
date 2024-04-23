package algorithms

object _2_LeetCode {
    fun run() {
        println("1) Sub array sum\n" +
                "      input: array = mutableListOf(4,2,2,1,2,-3,5,-8)\n" +
                "      result: ${subArraySum(mutableListOf(4,2,2,1,2,-3,5,-8), 5)}")

        println("2) Сlockwise\n" +
                "      input: array = [1,   2,  3, 4]\n" +
                "                     [14, 15, 16, 5]\n" +
                "                     [13, 20, 17, 6]\n" +
                "                     [12, 19, 18, 7]\n" +
                "                     [11, 10,  9, 8]\n" +
                "      result: ${goСlockwise(mutableListOf(
                        mutableListOf(1,   2,  3, 4),
                        mutableListOf(14, 15, 16, 5),
                        mutableListOf(13, 20, 17, 6),
                        mutableListOf(12, 19, 18, 7),
                        mutableListOf(11, 10,  9, 8))) }")

        println("3) Сounterclockwise\n" +
                "      input: array = [1, 14, 13, 12]\n" +
                "                     [2, 15, 20, 11]\n" +
                "                     [3, 16, 19, 10]\n" +
                "                     [4, 17, 18,  9]\n" +
                "                     [5,  6,  7,  8]\n" +
                "      result: ${goСounterclockwise(mutableListOf(
                        mutableListOf(1, 14, 13, 12),
                        mutableListOf(2, 15, 20, 11),
                        mutableListOf(3, 16, 19, 10),
                        mutableListOf(4, 17, 18,  9),
                        mutableListOf(5,  6,  7,  8)))}")
    }

    /**
     * (1) Sub array sum
     */
    fun subArraySum(array: MutableList<Int>, k: Int): Int {
        var result = 0
        var subArraySum = 0
        val prefixSumCount = mutableMapOf<Int, Int>()
        prefixSumCount[0] = 1
        for (i in 0 until array.size) {
            subArraySum += array[i]
            val toRemove =  subArraySum - k
            result += prefixSumCount[toRemove] ?: 0
            prefixSumCount[subArraySum] = prefixSumCount.getOrDefault(subArraySum, 0) + 1
        }
        return result
    }

    /**
     * (2) Сlockwise
     */
    fun goСlockwise(matrix: MutableList<MutableList<Int>>) {
        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size -1
        while(top <= bottom && left <= right) {
            for(i in left .. right) {
                print("${matrix[top][i]} ")
            }
            top++
            for(i in top .. bottom) {
                print("${matrix[i][right]} ")
            }
            right--
            if(top <= bottom) {
                for(i in right downTo left){
                    print("${matrix[bottom][i]} ")
                }
                bottom--
            }
            if(left <= right) {
                for(i in bottom downTo top){
                    print("${matrix[i][left]} ")
                }
                left++
            }
        }
    }

    /**
     * (3) Сounterclockwise
     */
    fun goСounterclockwise(matrix: MutableList<MutableList<Int>>) {
        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size -1
        while(top <= bottom && left <= right) {
            for(i in top .. bottom) {
                print("${matrix[i][left]} ")
            }
            left++
            for (i in left .. right) {
                print("${matrix[bottom][i]} ")
            }
            bottom--
            if (left <= right) {
                for (i in bottom downTo top) {
                    print("${matrix[i][right]} ")
                }
                right--
            }
            if (top<=bottom) {
                for (i in right downTo left){
                    print("${matrix[top][i]} ")
                }
                top++
            }
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Add Two Numbers
     * @see "https://leetcode.com/problems/add-two-numbers/"
     * @return Add Two Digits
     * difficulty = normal
     * * @sample You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.



    Example 1:


    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
    Example 2:

    Input: l1 = [0], l2 = [0]
    Output: [0]
    Example 3:

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]


    Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.*/
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var next1 = l1
        var next2 = l2
        val result = ListNode(0)
        var resultNext = result
        var div = 0
        while(next1 != null || next2 != null ) {
            val val1 = next1?.`val` ?: 0
            val val2 = next2?.`val` ?: 0
            resultNext.`val` = (div + val1 + val2) % 10
            div = (div + val1 + val2) / 10
            next1 = next1?.next
            next2 = next2?.next
            if(next1!= null || next2 != null) {
                resultNext.next = ListNode(0)
                resultNext = resultNext.next!!
            }
        }

        if (div > 0) {
            resultNext.next = ListNode(div)
        }

        return result
    }

}