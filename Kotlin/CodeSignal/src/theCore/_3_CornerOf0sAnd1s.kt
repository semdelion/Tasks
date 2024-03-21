package theCore

object _3_CornerOf0sAnd1s {
    fun run() {
        println("17) Not support kotlin, solved by C#\n")
        println("18) Array Packing\n" +
                "      input: a = [24, 85, 0]\n" +
                "      result: ${_3_CornerOf0sAnd1s.solution18(mutableListOf(24, 85, 0))}\n")
        println("19) Range Bit Count\n" +
                "      input: a = 2, b = 7\n" +
                "      result: ${_3_CornerOf0sAnd1s.solution19(2,7)}\n")
        println("20) Mirror Bits\n" +
                "      input: a = 97\n" +
                "      result: ${_3_CornerOf0sAnd1s.solution20(97)}\n")
        println("21) Not support kotlin, solved by C#\n")
        println("22) Not support kotlin, solved by C#\n")
        println("23) Not support kotlin, solved by C#\n")
        println("24) Not support kotlin, solved by C#\n")
    }

    /**
     * Array Packing
     * @see "https://app.codesignal.com/arcade/code-arcade/corner-of-0s-and-1s/KeMqde6oqfF5wBXxf"
     * @return Array Packing
     * * @sample You are given an array of up to four non-negative integers, each less than 256.

    Your task is to pack these integers into one number M in the following way:

    The first element of the array occupies the first 8 bits of M;
    The second element occupies next 8 bits, and so on.
    Return the obtained integer M.

    Note: the phrase "first bits of M" refers to the least significant bits of M - the right-most bits of an integer. For further clarification see the following example.

    Example

    For a = [24, 85, 0], the output should be
    solution(a) = 21784.

    An array [24, 85, 0] looks like [00011000, 01010101, 00000000] in binary.
    After packing these into one number we get 00000000 01010101 00011000 (spaces are placed for convenience), which equals to 21784.*/
    fun solution18(a: MutableList<Int>): Int {
        var res = 0
        for( i in a.count() - 1 downTo 0)
            res += a[i] shl (8 * i)
        return res
    }

    /**
     * Range Bit Count
     * @see "https://app.codesignal.com/arcade/code-arcade/corner-of-0s-and-1s/eC2Zxu5H5SnuKxvPT"
     * @return Range Bit Count
     * * @sample You are given two numbers a and b where 0 ≤ a ≤ b. Imagine you construct an array of all the integers from a to b inclusive. You need to count the number of 1s in the binary representations of all the numbers in the array.

    Example

    For a = 2 and b = 7, the output should be
    solution(a, b) = 11.

    Given a = 2 and b = 7 the array is: [2, 3, 4, 5, 6, 7]. Converting the numbers to binary, we get [10, 11, 100, 101, 110, 111], which contains 1 + 2 + 1 + 2 + 2 + 3 = 11 1s.*/
    fun solution19(a: Int, b: Int): Int {
        var count = 0
        for (i in a..b)  {
            var num = i
            while (num != 0) {
                count += num and 1
                num = num shr 1
            }
        }
        return count
    }

    /**
     * Mirror Bits
     * @see "https://app.codesignal.com/arcade/code-arcade/corner-of-0s-and-1s/e3zfPNTwTa9qTQzcX"
     * @return Mirror Bits
     * * @sample Reverse the order of the bits in a given integer.

    Example

    For a = 97, the output should be
    solution(a) = 67.

    97 equals to 1100001 in binary, which is 1000011 after mirroring, and that is 67 in base 10.

    For a = 8, the output should be
    solution(a) = 1.*/
    fun solution20(a: Int): Int {
        var result = 0
        var index = 0
        for (i in 0..30) {
            if(a and (1 shl i) > 0)
                index = i
        }
        for (i in 0..index)
            result = (result shl 1) or (if( a and (1 shl i) > 0) 1 else 0)

        return result
    }
}