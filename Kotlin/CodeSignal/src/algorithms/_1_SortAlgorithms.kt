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

        val arrayQuickSort =  mutableListOf(6,77,5,8,11,2,22,4,23,21,28,32,263,96,4,8,50)
        println("3) Quick Sort\n" +
                "      input: array = ${arrayQuickSort}\n")
        QuickSort(arrayQuickSort, 0 , arrayQuickSort.size - 1)
        println("      result: $arrayQuickSort")

        val arrayInsertion =  mutableListOf(6,77,5,8,11,2,22,4,23,21,28,32,263,96,4,8,50)
        println("4) Insertion\n" +
                "      input: array = ${arrayInsertion}")
        insertionSort(arrayInsertion)
        println("      result: $arrayInsertion")

        println("5) Count Unique\n" +
                "      input: array = mutableListOf(1,2,3,3,4,5,5,6,7,8,8,9,10,10,11,11,12)\n" +
                "      result: ${countUnique(mutableListOf(1,2,3,3,4,5,5,6,7,8,8,9,10,10,11,11,12))}")
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

    /**
     * Quick Sort
     */
    fun QuickSort(array: MutableList<Int>, startIndex: Int , endIndex: Int) {
        if(startIndex < endIndex) {
            val pivot = PartitionStart(array, startIndex, endIndex)
            //val pivot = PartitionEnd(array, startIndex, endIndex)
            QuickSort(array, startIndex, pivot - 1 )
            QuickSort(array, pivot + 1, endIndex)
        }
    }

    //pivot Start
    private fun PartitionStart(array: MutableList<Int>, startIndex: Int , endIndex: Int) : Int {
        var pivot = endIndex + 1
        for (i in endIndex downTo startIndex) {
            if (array[i] > array[startIndex]) {
                pivot--
                Swap(array, i, pivot)
            }
        }
        pivot--
        Swap(array, startIndex, pivot)
        return pivot
    }

    //pivot End
    private fun PartitionEnd(array: MutableList<Int>, l: Int, r: Int): Int {
        var pivot = l  - 1
        for (i in l..r) {
            if (array[i] < array[r])
            {
                pivot++
                Swap(array, pivot, i)
            }
        }
        pivot++
        Swap(array, pivot, r)
        return pivot
    }

    private fun Swap(array: MutableList<Int>, i: Int, j: Int ) {
        if(i == j)
            return
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    /**
     * Insertion Sort
     */
    fun insertionSort(array: MutableList<Int>) {

        for (i in 1 until array.size) {
            var key = array[i]
            var j = i - 1
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]
                j--
            }
            if(j != i - 1) {
                array[j + 1] = key
            }
        }
    }

    /**
     * Count Unique
     */
    fun countUnique(array: MutableList<Int>) : Int = array.toSet().size
}