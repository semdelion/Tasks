import java.math.BigInteger
import kotlin.experimental.xor


object TMP {
    fun run() {
        println("Сlockwise ${
            goСlockwise(mutableListOf(
                    mutableListOf(1,   2,  3,   4),
                    mutableListOf(14,   15,  16,   5),
                    mutableListOf(13,   20, 17, 6),
                    mutableListOf(12,  19, 18, 7),
                    mutableListOf(11,  10, 9, 8)
                ))
        }")
        println("Сlockwise ${
            goСlockwise(mutableListOf(
            mutableListOf(1,   2,  3),
            mutableListOf(8,   9,  4),
            mutableListOf(7,   6, 5)
        ))
        }")

        println("Сounterclockwise ${
            goСounterclockwise(mutableListOf(
            mutableListOf(1, 14, 13, 12),
            mutableListOf(2, 15, 20, 11),
            mutableListOf(3, 16, 19, 10),
            mutableListOf(4, 17, 18,  9),
            mutableListOf(5,  6,  7,  8)
        ))
        }")

        println("Сounterclockwise ${
            goСounterclockwise(mutableListOf(
            mutableListOf(1, 8, 7),
            mutableListOf(2, 9, 6),
            mutableListOf(3, 4, 5)
        ))
        }")





        //val byteArray = byteArrayOf(1, 2, 3, 4, 5)

        //println("Исходный массив: ${byteArray.contentToString()}")

      // reverseByteArray(byteArray)

       // println("Перевернутый массив: ${byteArray.contentToString()}")


        println("4) Count Of Max Unique\n" +
                "      input: array = mutableListOf(1,2,3,3,4,5,5,6,7,8,8,9,10,10,11,11,11,12)\n" +
                "      result:${numberOfUniqueElements(mutableListOf(1,2,3,3,4,5,5,6,7,8,8,9,10,10,11,11,11,12))}")

        val byteArray = byteArrayOf(1, 2, 3, 4, 5)
        reverseByteArray(byteArray)
        println("Результат после переворота: ${byteArray.contentToString()}")

        var test = (1112).toByte()
        println("Результат после переворота: ${test.toByte()}")
    }

    fun numberOfUniqueElements(array: MutableList<Int>) : Int {
        val map = array.groupingBy { it }.eachCount()
        val maxCount = map.values.maxOrNull()
        return map.filterValues { it == maxCount }.keys.firstOrNull() ?: -1
    }

    fun reverseByteArray(array: ByteArray) {
        for (i in 0 until  array.size / 2 ){
            array[i] = array[array.size - 1 - i] xor array[i]
            array[array.size - 1 - i] = array[array.size - 1 - i] xor array[i]
            array[i] = array[i] xor array[array.size - 1 - i]
        }
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







