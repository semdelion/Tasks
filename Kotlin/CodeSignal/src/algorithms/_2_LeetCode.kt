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

}