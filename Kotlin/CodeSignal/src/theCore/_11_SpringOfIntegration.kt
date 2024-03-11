package theCore

object _11_SpringOfIntegration {
    fun run() {
        println("88 Array Conversion: ${_11_SpringOfIntegration.solution88(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8))}")
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




}