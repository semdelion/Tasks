package theCore

object _4_LoopTunnel {
    fun run() {
        println("25) Least Factorial\n" +
                "      input: n = 29\n" +
                "      result: ${solution25(29)}\n")
        println("26) Count Sum of Two Representations 2\n" +
                "      input: n = 6, l = 2, r = 4\n" +
                "      result: ${solution26(n = 6, l = 2, r = 4)}\n")
        println("27) Magical Well\n" +
                "      input: a = 1, b = 2, n = 2\n" +
                "      result: ${solution27(a = 1, b = 2, n = 2)}\n")
        println("28) Lineup\n" +
                "      input: commands = \"LLARL\"\n" +
                "      result: ${solution28("LLARL")}\n")
        println("29) Addition Without Carrying\n" +
                "      input: param1 = 456, param2 = 1734\n" +
                "      result: ${solution29(456, 1734)}\n")
        println("30) Apple Boxes\n" +
                "      input: k = 5\n" +
                "      result: ${solution30(5)}\n")
        println("31) Increase Number Roundness\n" +
                "      input: n = 902200100\n" +
                "      result: ${solution31(902200100)}\n")
        println("32) Rounders\n" +
                "      input: n = 1445\n" +
                "      result: ${solution32(1445)}\n")
        println("33) Candles\n" +
                "      input: candlesNumber = 5, makeNew = 2\n" +
                "      result: ${solution33(5, 2)}\n")
        println("34) Count Black Cells:\n" +
                "      input: n = 3, m = 4\n" +
                "      result: ${solution34(3, 4)}\n")
    }

    /**
     * Least Factorial
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/7BFPq6TpsNjzgcpXy"
     * @return Least Factorial
     * * @sample Given an integer n, find the minimal k such that

    k = m! (where m! = 1 * 2 * ... * m) for some integer m;
    k >= n.
    In other words, find the smallest factorial which is not less than n.

    Example

    For n = 17, the output should be
    solution(n) = 24.

    17 < 24 = 4! = 1 * 2 * 3 * 4, while 3! = 1 * 2 * 3 = 6 < 17).*/
    fun solution25(n: Int): Int {
        var result = 1
        var factorial = 1
        while (result < n) {
            result *= ++factorial
        }
        return result
    }

    /**
     * Count Sum of Two Representations 2
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/hBw5BJiZ4LmXcy92u"
     * @return Count Sum of Two Representations 2
     * * @sample Given integers n, l and r, find the number of ways to represent n as a sum of two integers A and B such that l ≤ A ≤ B ≤ r.

    Example

    For n = 6, l = 2, and r = 4, the output should be
    solution(n, l, r) = 2.

    There are just two ways to write 6 as A + B, where 2 ≤ A ≤ B ≤ 4: 6 = 2 + 4 and 6 = 3 + 3.*/
    fun solution26(n: Int, l: Int, r: Int): Int {
        if (2 * l > n || 2 * r < n)
            return 0
        if (r + l == n)
            return (r - l) / 2 + 1
        return if (r + l < n)
            (2 * r - n) / 2 + 1
        else
            (n - 2 * l) / 2 + 1
    }

    /**
     * Magical Well
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/LbuWRHnMoJH9SAo4o"
     * @return Magical Well
     * * @sample You are standing at a magical well. It has two positive integers written on it: a and b. Each time you cast a magic marble into the well, it gives you a * b dollars and then both a and b increase by 1. You have n magic marbles. How much money will you make?

    Example

    For a = 1, b = 2, and n = 2, the output should be
    solution(a, b, n) = 8.

    You will cast your first marble and get $2, after which the numbers will become 2 and 3. When you cast your second marble, the well will give you $6. Overall, you'll make $8. So, the output is 8.*/
    fun solution27(a: Int, b: Int, n: Int): Int {
        var result = 0
        for (i in 0 until n) {
            result += (i + a) * (i + b)
        }
        return result
    }

    /**
     * Lineup
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/8rqs3BLpdKePhouQM"
     * @return Lineup
     * * @sample To prepare his students for an upcoming game, the sports coach decides to try some new training drills. To begin with, he lines them up and starts with the following warm-up exercise: when the coach says 'L', he instructs the students to turn to the left. Alternatively, when he says 'R', they should turn to the right. Finally, when the coach says 'A', the students should turn around.

    Unfortunately some students (not all of them, but at least one) can't tell left from right, meaning they always turn right when they hear 'L' and left when they hear 'R'. The coach wants to know how many times the students end up facing the same direction.

    Given the list of commands the coach has given, count the number of such commands after which the students will be facing the same direction.

    Example

    For commands = "LLARL", the output should be
    solution(commands) = 3.

    Let's say that there are 4 students, and the second one can't tell left from right. In this case, only after the second, third and fifth commands will the students face the same direction.*/
    fun solution28(commands: String): Int {
        var state = true
        var count = 0
        for (command in commands) {
            if (command != 'A')
                state = !state
            if (state)
                count++
        }
        return count
    }

    /**
     * Addition Without Carrying
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/xzeZqCQjpfDJuN72S"
     * @return Addition Without Carrying
     * * @sample A little child is studying arithmetic. They have just learned how to add two integers, written one below another, column by column. But the child always forgets about the important part - carrying.

    Given two integers, your task is to find the result that the child will get.

    Note: The child had learned from this site, so feel free to check it out too if you are not familiar with column addition.

    Example

    For param1 = 456 and param2 = 1734, the output should be
    solution(param1, param2) = 1180.

    456
    1734
    + ____
    1180
    The child performs the following operations from right to left:

    6 + 4 = 10 but the child forgets about carrying the 1 and just writes down the 0 in the last column
    5 + 3 = 8
    4 + 7 = 11 but the child forgets about the leading 1 and just writes down 1 under 4 and 7.
    There is no digit in the first number corresponding to the leading digit of the second one, so the child imagines that 0 is written before 456. Thus, they get 0 + 1 = 1.*/
    fun solution29(param1: Int, param2: Int): Int {
        var result = 0
        val count = Math.max(param1, param2).toString().length
        for (i in 0 until count) {
            val div = Math.pow(10.0, i.toDouble()).toInt()
            result += (((param1 / div) % 10 + (param2 / div) % 10) % 10) * div
        }
        return result
    }

    /**
     * Apple Boxes
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/scG8AFsPuqQGx8Qjf"
     * @return Apple Boxes
     * * @sample You have k apple boxes full of apples. Each square box of size m contains m × m apples. You just noticed two interesting properties about the boxes:

    The smallest box is size 1, the next one is size 2,..., all the way up to size k.
    Boxes that have an odd size contain only yellow apples. Boxes that have an even size contain only red apples.
    Your task is to calculate the difference between the number of red apples and the number of yellow apples.

    Example

    For k = 5, the output should be
    solution(k) = -15.

    There are 1 + 3 * 3 + 5 * 5 = 35 yellow apples and 2 * 2 + 4 * 4 = 20 red apples, making the answer 20 - 35 = -15.*/
    fun solution30(k: Int): Int {
        val result = (1..k).sum()
        return if (k % 2 == 1) result * -1 else result
    }

    /**
     * Increase Number Roundness
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/KLbRMcWhaZi3dvYH5"
     * @return Increase Number Roundness
     * * @sample Define an integer's roundness as the number of trailing zeroes in it.

    Given an integer n, check if it's possible to increase n's roundness by swapping some pair of its digits.

    Example

    For n = 902200100, the output should be
    solution(n) = true.

    One of the possible ways to increase roundness of n is to swap digit 1 with digit 0 preceding it: roundness of 902201000 is 3, and roundness of n is 2.

    For instance, one may swap the leftmost 0 with 1.

    For n = 11000, the output should be
    solution(n) = false.

    Roundness of n is 3, and there is no way to increase it.*/
    fun solution31(n: Int): Boolean {
        var digitNotNull = false
        var i = 1
        while (n / i != 0) {
            if ((n / i) % 10 != 0)
                digitNotNull = true
            else if (digitNotNull)
                return true
            i *= 10
        }
        return false
    }

    /**
     * Rounders
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/H5PP5MXvYvWXxTytH"
     * @return Rounders
     * * @sample We want to turn the given integer into a number that has only one non-zero digit using a tail rounding approach. This means that at each step we take the last non 0 digit of the number and round it to 0 or to 10. If it's less than 5 we round it to 0 if it's larger than or equal to 5 we round it to 10 (rounding to 10 means increasing the next significant digit by 1). The process stops immediately once there is only one non-zero digit left.

    Example

    For n = 15, the output should be
    solution(n) = 20;

    For n = 1234, the output should be
    solution(n) = 1000.

    1234 -> 1230 -> 1200 -> 1000.

    For n = 1445, the output should be
    solution(n) = 2000.

    1445 -> 1450 -> 1500 -> 2000.*/
    fun solution32(n: Int): Int {
        var result = n
        var i = 1
        while (n / i > 9) {
            if ((result / i) % 10 > 4) {
                result += i * 10
            }
            i *= 10
        }
        return (result / i) * i
    }

    /**
     * Candles
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/LAKReA3CR9EwkZGSz"
     * @return Candles
     * * @sample When a candle finishes burning it leaves a leftover. makeNew leftovers can be combined to make a new candle, which, when burning down, will in turn leave another leftover.

    You have candlesNumber candles in your possession. What's the total number of candles you can burn, assuming that you create new candles as soon as you have enough leftovers?

    Example

    For candlesNumber = 5 and makeNew = 2, the output should be
    solution(candlesNumber, makeNew) = 9.

    Here is what you can do to burn 9 candles:

    burn 5 candles, obtain 5 leftovers;
    create 2 more candles, using 4 leftovers (1 leftover remains);
    burn 2 candles, end up with 3 leftovers;
    create another candle using 2 leftovers (1 leftover remains);
    burn the created candle, which gives another leftover (2 leftovers in total);
    create a candle from the remaining leftovers;
    burn the last candle.
    Thus, you can burn 5 + 2 + 1 + 1 = 9 candles, which is the answer.*/
    fun solution33(candlesNumber: Int, makeNew: Int): Int = candlesNumber + (candlesNumber - 1) / (makeNew - 1)

    /**
     * Count Black Cells
     * @see "https://app.codesignal.com/arcade/code-arcade/loop-tunnel/RcK4vupi8sFhakjnh"
     * @return Count Black Cells
     * * @sample Imagine a white rectangular grid of n rows and m columns divided into two parts by a diagonal line running from the upper left to the lower right corner. Now let's paint the grid in two colors according to the following rules:

    A cell is painted black if it has at least one point in common with the diagonal;
    Otherwise, a cell is painted white.
    Count the number of cells painted black.

    Example

    For n = 3 and m = 4, the output should be
    solution(n, m) = 6.

    There are 6 cells that have at least one common point with the diagonal and therefore are painted black.



    For n = 3 and m = 3, the output should be
    solution(n, m) = 7.

    7 cells have at least one common point with the diagonal and are painted black.*/
    fun solution34(n: Int, m: Int): Int = n + m - 2 + gcd(n, m)

    private fun gcd(a1: Int, b1: Int): Int {
        var a = a1
        var b = b1
        while (b != 0) {
            val tmp = b
            b = a % b
            a = tmp
        }
        return a
    }
}