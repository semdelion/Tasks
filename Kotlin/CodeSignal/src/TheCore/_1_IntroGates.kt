package TheCore


object _1_IntroGates {
    fun run() {
        println("1 Add Two Digits: ${_1_IntroGates.solution1(29)}")
        println("2 Largest Number: ${_1_IntroGates.solution2(2)}")
        println("3 Candies: ${_1_IntroGates.solution3(3,10)}")
        println("4 Seats in Theater: ${_1_IntroGates.solution4(nCols = 16, nRows = 11, col = 5, row = 3)}")
        println("5 Max Multiple: ${_1_IntroGates.solution5(3,10)}")
        println("6 Circle of Numbers: ${_1_IntroGates.solution6(10, 2)}")
        println("7 Late Ride: ${_1_IntroGates.solution7(808)}")
        println("8 Phone Call: ${_1_IntroGates.solution8(min1 = 3, min2_10 = 1, min11 = 2, s = 20)}")

    }

    /**
     * Add Two Digits
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/wAGdN6FMPkx7WBq66"
     * @return Add Two Digits
     * * @sample You are given a two-digit integer n. Return the sum of its digits.

    Example

    For n = 29, the output should be
    solution(n) = 11.*/
    fun solution1(n: Int): Int = n/10 + n%10

    /**
     * Largest Number
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/SZB5XypsMokGusDhX"
     * @return Largest Number
     * * @sample Given an integer n, return the largest number that contains exactly n digits.

    Example

    For n = 2, the output should be
    solution(n) = 99.*/
    fun solution2(n: Int): Int {
        return (Math.pow(10.0, n.toDouble()) - 1).toInt()
    }

    /**
     * Candies
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/DdNKFA3XCX6XN7bNz"
     * @return Candies
     * * @sample n children have got m pieces of candy. They want to eat as much candy as they can, but each child must eat exactly the same amount of candy as any other child. Determine how many pieces of candy will be eaten by all the children together. Individual pieces of candy cannot be split.

    Example

    For n = 3 and m = 10, the output should be
    solution(n, m) = 9.

    Each child will eat 3 pieces. So the answer is 9.*/
    fun solution3(n: Int, m: Int): Int = (m/n) * n


    /**
     * Seats in Theater
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/bszFiQAog96G9CXKg"
     * @return Seats in Theater
     * * @sample Your friend advised you to see a new performance in the most popular theater in the city. He knows a lot about art and his advice is usually good, but not this time: the performance turned out to be awfully dull. It's so bad you want to sneak out, which is quite simple, especially since the exit is located right behind your row to the left. All you need to do is climb over your seat and make your way to the exit.

    The main problem is your shyness: you're afraid that you'll end up blocking the view (even if only for a couple of seconds) of all the people who sit behind you and in your column or the columns to your left. To gain some courage, you decide to calculate the number of such people and see if you can possibly make it to the exit without disturbing too many people.

    Given the total number of rows and columns in the theater (nRows and nCols, respectively), and the row and column you're sitting in, return the number of people who sit strictly behind you and in your column or to the left, assuming all seats are occupied.

    Example

    For nCols = 16, nRows = 11, col = 5, and row = 3, the output should be
    solution(nCols, nRows, col, row) = 96.*/
    fun solution4(nCols: Int, nRows: Int, col: Int, row: Int): Int = (nCols - col + 1) * (nRows - row)


    /**
     * Max Multiple
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/HEsmEacHr2s9wahjr"
     * @return Max Multiple
     * * @sample Given a divisor and a bound, find the largest integer N such that:

    N is divisible by divisor.
    N is less than or equal to bound.
    N is greater than 0.
    It is guaranteed that such a number exists.

    Example

    For divisor = 3 and bound = 10, the output should be
    solution(divisor, bound) = 9.

    The largest integer divisible by 3 and not larger than 10 is 9.*/
    fun solution5(divisor: Int, bound: Int): Int = bound - (bound % divisor)


    /**
     * Circle of Numbers
     * @see "https://app.codesignal.com/arcade/intro/level-7/vExYvcGnFsEYSt8nQ"
     * @return Circle of Numbers
     * * @sample Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance between any two neighboring numbers is equal (note that 0 and n - 1 are neighboring, too).

    Given n and firstNumber, find the number which is written in the radially opposite position to firstNumber.

    Example

    For n = 10 and firstNumber = 2, the output should be
    solution(n, firstNumber) = 7.
     */
    fun solution6(n: Int, firstNumber: Int): Int {
        return (n/2 + firstNumber) % n
    }

    /**
     * Late Ride
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/aiKck9MwwAKyF8D4L"
     * @return Late Ride
     * * @sample One night you go for a ride on your motorcycle. At 00:00 you start your engine, and the built-in timer automatically begins counting the length of your ride, in minutes. Off you go to explore the neighborhood.

    When you finally decide to head back, you realize there's a chance the bridges on your route home are up, leaving you stranded! Unfortunately, you don't have your watch on you and don't know what time it is. All you know thanks to the bike's timer is that n minutes have passed since 00:00.

    Using the bike's timer, calculate the current time. Return an answer as the sum of digits that the digital timer in the format hh:mm would show.

    Example

    For n = 240, the output should be
    solution(n) = 4.

    Since 240 minutes have passed, the current time is 04:00. The digits sum up to 0 + 4 + 0 + 0 = 4, which is the answer.

    For n = 808, the output should be
    solution(n) = 14.

    808 minutes mean that it's 13:28 now, so the answer should be 1 + 3 + 2 + 8 = 14.
     */
    fun solution7(n: Int): Int {
        val min = n/60
        val sec = n%60
        return min/10+min%10+sec/10+sec%10
    }

    /**
     * Phone Call
     * @see "https://app.codesignal.com/arcade/code-arcade/intro-gates/mZAucMXhNMmT7JWta"
     * @return Phone Call
     * * @sample     For min1 = 3, min2_10 = 1, min11 = 2, and s = 20, the output should be
    solution(min1, min2_10, min11, s) = 14.

    Here's why:

    the first minute costs 3 cents, which leaves you with 20 - 3 = 17 cents;
    the total cost of minutes 2 through 10 is 1 * 9 = 9, so you can talk 9 more minutes and still have 17 - 9 = 8 cents;
    each next minute costs 2 cents, which means that you can talk 8 / 2 = 4 more minutes.
    Thus, the longest call you can make is 1 + 9 + 4 = 14 minutes long.
     */

    fun solution8(min1: Int, min2_10: Int, min11: Int, s: Int): Int {
        if(s < min1)
            return 0

        var sum = s-min1
        var min = 1

        if(sum < min2_10 * 9 )
            return min + sum/min2_10

        sum -= min2_10 * 9
        min += 9
        return min + sum / min11
    }
}