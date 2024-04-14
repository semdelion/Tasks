package algorithms

object _1_SortAlgorithms {
    fun run() {
        println("1) Binary Search\n" +
                "      input: roadRegister = mutableListOf(1,3,5,8,9,12,22,24,25,26,28,31,33,46,47,48,50)\n" +
                "             k = 9\n" +
                "      result:${binarySearch(mutableListOf(1,3,5,8,9,12,22,24,25,26,28,31,33,46,47,48,50), k = 9)}")
    }
    /**
     * Binary Search
     */
    fun binarySearch(array: MutableList<Int>, k: Int): Int {
        var l = 0
        var r = array.size -1
        while (l <= r) {
            val center = (r + l)/2
            if (array[center] > k)
                r = center - 1
            else if(array[center] < k)
                l = center + 1
            else
                return center
        }
        return -1
    }
}