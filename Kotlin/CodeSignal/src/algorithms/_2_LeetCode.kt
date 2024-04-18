package algorithms

object _2_LeetCode {
    fun run() {
        println("1) subArraySum\n" +
                "      input: array = mutableListOf(4,2,2,1,2,-3,5,-8)\n" +
                "      result: ${subArraySum(mutableListOf(4,2,2,1,2,-3,5,-8), 5)}")


    }

    /**
     * subArraySum
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

}