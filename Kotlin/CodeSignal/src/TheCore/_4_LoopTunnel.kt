package TheCore

object _4_LoopTunnel {
    fun run() {
        println("25 Least Factorial: ${_4_LoopTunnel.solution25(29)}")
        println("26 Count Sum of Two Representations 2: ${_4_LoopTunnel.solution26(n = 6, l = 2, r = 4)}")
        println("27 Magical Well: ${_4_LoopTunnel.solution27(a = 1, b = 2, n = 2)}")
        println("28 Lineup: ${_4_LoopTunnel.solution28("LLARL")}")


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
        while(result < n) {
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
        if(2 * l > n || 2 * r < n)
            return 0
        if(r + l == n)
            return (r - l) / 2 + 1
        return if(r + l < n)
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
        for(i in 0 until n) {
            result += (i+a)*(i+b)
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
        for(command in commands) {
            if(command != 'A')
                state = !state
            if(state)
                count++
        }
        return count
    }


}