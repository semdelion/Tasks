import java.math.BigInteger
import java.util.*
import kotlin.collections.HashMap
import kotlin.experimental.xor


object TMP {
    fun run() {
        //val byteArray = byteArrayOf(1, 2, 3, 4, 5)

        //println("Исходный массив: ${byteArray.contentToString()}")

        // reverseByteArray(byteArray)

        // println("Перевернутый массив: ${byteArray.contentToString()}")

        /*println("4) Count Of Max Unique\n" +
                "      input: array = mutableListOf(1,2,3,3,3,4,5,5,6,7,8,8,9,10,10,11,11,11,12)\n" +
                "      result:${numberOfUniqueSequence(mutableListOf(1,2,3,3,4,5,5,6,7,8,8,9,10,10,11,11,11,12), k = 100)}")

        val byteArray = byteArrayOf(1, 2, 3, 4, 5)
        reverseByteArray(byteArray)
        println("Результат после переворота: ${byteArray.contentToString()}")

        var test = (1112).toByte()
        println("Результат после переворота: ${test.toByte()}")

        var array = mutableListOf(-3,1,2,7,10,11)
        println("$array")
        var result2 = getPairs(array, 9)
        println("$result2")
        val queue: Queue<Int> = LinkedList ( )
        queue.add(1)

        val stack = Stack<Int>()
        stack.add(1)
        var t = stack.peek()
        var tt = t

        println("5) sumOfArray\n" +
                "      input: array1 = mutableListOf(132)\n" +
                "             array2 = mutableListOf(92,82,9,9)\n" +
                "      result:${sumOfArray( mutableListOf(132),mutableListOf(92,82,9,9))}")

        var byteArray2 = byteArrayOf(1,2,4,5,6,7)

        val result = revertByteArray(byteArray2)

        val visited = BooleanArray(256){false}

        var queue1: Queue<Int> = LinkedList<Int>()
        queue1.add(1)
        queue1.add(2)
        queue1.add(3)
        queue1.add(4)



        var matrix = List(10){MutableList<Int>(8){0}}
    var tttttttttt = queue1.poll()
    var tttttttttt2 = queue1.poll()
    var tttttttttt3 = queue1.poll()*/
    }
    /*class Tree<T>(var valueTree: T) {
        var left: Tree<T>? = null
        var right: Tree<T>?= null
    }*/

    fun revertByteArray(array: ByteArray): ByteArray {
        var t = "fdf"
        t.length
        for (i in 0 .. array.size / 2 ) {
            val tmp = array[i]
            array[i] = array[array.size - 1 - i]
            array[array.size - 1 - i] = tmp
        }

        return array
    }



    fun sumOfArray(array1: List<Int>, array2: List<Int>): List<Int> {
        val result = mutableListOf<Int>()
        var div = 0
        val maxArray = if(array1.size > array2.size) array1 else array2
        for (i in maxArray.indices) {
            val ar1 = if(array1.size - i - 1 >= 0) array1[array1.size - i -1] else 0
            val ar2 = if(array2.size - i - 1 >= 0) array2[array2.size - i -1] else 0
            result.add((div + ar1 + ar2) % 10)
            div = (div + ar1 + ar2)/10
        }
        if(div > 0)
            result.add(div)

        return result.reversed()
    }


    fun numberOfUniqueSequence(array: List<Int>, k: Int): List<Int> {
        val map = HashMap<Int,Int>()
        for (i in array.indices) {
            map[array[i]] = (map[array[i]]?:0) + 1
        }
        val sortedList = map.toList().sortedBy{(k, v) -> v}
        val result = mutableListOf<Int>()
        val start = if(sortedList.size - k >=0) sortedList.size - k else 0
        for (i in start until sortedList.size) {
            result.add(sortedList[i].first)
        }
        return result
    }



    fun numberOfUniqueElements(array: MutableList<Int>) : Int {
        val map = HashMap<Int,Int>()
        for (i in 0 until array.size) {
            map[array[i]] = (map[array[i]]?:0) + 1
        }

        //val map = array.groupingBy { it }.eachCount()
        val maxCount = map.values.maxOrNull()
        return map.filterValues { it == maxCount }.keys.firstOrNull() ?: -1
    }

    /*fun numberOfUniqueElements(array: MutableList<Int>, k: Int) : List<Int> {
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until  array.size) {
            map[array[i]] = (map[array[i]]?: 0) + 1
        }
        val sortedMap = map.toList().sortedByDescending{(k, v) -> v}
        return sortedMap.take(k).map{it.first}
    }*/

    /*fun numberOfUniqueElements(array: MutableList<Int>, k: Int) : List<Int> {
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until  array.size) {
            map[array[i]] = (map[array[i]]?: 0) + 1
        }
        val sortedMap = map.toList().sortedBy{(k, v) -> v}
        return sortedMap.takeLast(k).map{it.first}
    }*/


    fun reverseByteArray(array: ByteArray) {
        for (i in 0 until  array.size / 2 ){
            array[i] = array[array.size - 1 - i] xor array[i]
            array[array.size - 1 - i] = array[array.size - 1 - i] xor array[i]
            array[i] = array[i] xor array[array.size - 1 - i]
        }
    }

/*    fun getPairs(array: MutableList<Int>, k: Int) : MutableList<Int> {
        if (array.size <= 1) {
            return mutableListOf()
        }

        val set = mutableSetOf<Int>(array[0])
        for (i in 1 until array.size) {
            val tmp = k - array[i]
            if(set.contains(tmp)) {
                return mutableListOf(tmp, array[i])
            } else {
                set.add(array[i])
            }
        }
        return mutableListOf()
    }*/

    fun getPairs(array: MutableList<Int>, k: Int) : MutableList<Int> {
        if (array.size <= 1)
            return mutableListOf()

        for (i in 0 until array.size - 1) {
            val searchNumber = k - array[i]
            var l = i + 1
            var r = array.size - 1
            while (l <= r) {
                val index = (l + r) / 2
                if (array[index] > searchNumber) {
                    r = index - 1
                } else if (array[index] < searchNumber) {
                    l = index + 1
                } else {
                    return mutableListOf(array[i], array[index])
                }
            }
        }
        return mutableListOf()
    }



   /* fun reverseByteArray(array: ByteArray) {

        for (i in   ){
            array[left] = array[left] xor array[right]
            array[right] = array[left] xor array[right]
            array[left] = array[left] xor array[right]

            left++
            right--
        }
    }*/



}







