package algorithms

object _1_SortAlgorithms {
    fun run() {
        println("1) Binary Search\n" +
                "      input: array = mutableListOf(1,3,5,8,9,12,22,24,25,26,28,31,33,46,47,48,50)\n" +
                "             k = 9\n" +
                "      result: ${binarySearch(mutableListOf(1,3,5,8,9,12,22,24,25,26,28,31,33,46,47,48,50), k = 9)}")

        val arrayBubbleSort =  mutableListOf(6,77,5,8,11,2,22,4,23,21,28,32,263,96,4,8,50)
        println("2) Bubble Sort\n" +
                "      input: array = ${arrayBubbleSort}\n")
        BubbleSort(arrayBubbleSort)
        println("      result: $arrayBubbleSort")


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
    /**
     * Quick Sort
     */
    fun BubbleSort(array: MutableList<Int>) {

        for (i in 1 until  array.size){
            for (j in 0 until array.size - i) {
                if (array[j]>array[j + 1]) {
                    Swap(array,j,j + 1)
                }
            }
        }
    }

    private fun Swap(array: MutableList<Int>, i: Int, j: Int ) {
        if(i == j)
            return
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}