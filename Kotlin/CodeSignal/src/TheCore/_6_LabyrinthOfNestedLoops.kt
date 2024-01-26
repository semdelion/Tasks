package TheCore

object _6_LabyrinthOfNestedLoops {
    fun run() {
        println("43 Is Power?: ${_6_LabyrinthOfNestedLoops.solution43(29)}")
        println("44 Is Sum of Consecutive 2: ${_6_LabyrinthOfNestedLoops.solution44(9)}")
        println("45 Square Digits Sequence: ${_6_LabyrinthOfNestedLoops.solution45(16)}")
        println("46 Pages Numbering With Ink: ${_6_LabyrinthOfNestedLoops.solution46(21, 5)}")
    }

    /**
     * Is Power?
     * @see "https://app.codesignal.com/arcade/code-arcade/labyrinth-of-nested-loops/yBFfNv5fTqhcacZ7w"
     * @return Is Power?
     * * @sample Determine if the given number is a power of some non-negative integer.

    Example

    For n = 125, the output should be
    solution(n) = true;
    For n = 72, the output should be
    solution(n) = false.*/
    fun solution43(n: Int): Boolean {
        for (i in 1..20)
            for (j in 2..8)
                if (n == Math.pow(i.toDouble(), j.toDouble()).toInt())
                    return true
        return false
    }


    /**
     * Is Sum of Consecutive 2
     * @see "https://app.codesignal.com/arcade/code-arcade/labyrinth-of-nested-loops/yBFfNv5fTqhcacZ7w"
     * @return Is Sum of Consecutive 2
     * * @sample Determine if the given number is a power of some non-negative integer.

    Example

    For n = 125, the output should be
    solution(n) = true;
    For n = 72, the output should be
    solution(n) = false.*/
    fun solution44(n: Int): Int {
        var count = 0
        for (i in 3..n step 2)
            if (n % i == 0) count++

        return count
    }

    /**
     * Square Digits Sequence
     * @see "https://app.codesignal.com/arcade/code-arcade/labyrinth-of-nested-loops/MvX84CA5HN6GKqv7R"
     * @return Square Digits Sequence
     * * @sample Consider a sequence of numbers a0, a1, ..., an, in which an element is equal to the sum of squared digits of the previous element. The sequence ends once an element that has already been in the sequence appears again.

    Given the first element a0, find the length of the sequence.

    Example

    For a0 = 16, the output should be
    solution(a0) = 9.

    Here's how elements of the sequence are constructed:

    a0 = 16
    a1 = 12 + 62 = 37
    a2 = 32 + 72 = 58
    a3 = 52 + 82 = 89
    a4 = 82 + 92 = 145
    a5 = 12 + 42 + 52 = 42
    a6 = 42 + 22 = 20
    a7 = 22 + 02 = 4
    a8 = 42 = 16, which has already occurred before (a0)
    Thus, there are 9 elements in the sequence.

    For a0 = 103, the output should be
    solution(a0) = 4.

    The sequence goes as follows: 103 -> 10 -> 1 -> 1, 4 elements altogether.*/
    fun solution45(a0: Int): Int {
        var ma0 = a0
        val map = mutableMapOf<Int, Int>()
        while (!map.containsKey(ma0)) {
            map.put(ma0, 0)
            ma0 = ma0.toString().map { it.toString().toInt() }.sumOf { it * it }
        }
        return map.count() + 1
    }

    /**
     * Pages Numbering With Ink
     * @see "https://app.codesignal.com/arcade/code-arcade/labyrinth-of-nested-loops/pdw3izd7SpMTBJqSy"
     * @return Pages Numbering With Ink
     * * @sample You work in a company that prints and publishes books. You are responsible for designing the page numbering mechanism in the printer. You know how many digits a printer can print with the leftover ink. Now you want to write a function to determine what the last page of the book is that you can number given the current page and numberOfDigits left. A page is considered numbered if it has the full number printed on it (e.g. if we are working with page 102 but have ink only for two digits then this page will not be considered numbered).

    It's guaranteed that you can number the current page, and that you can't number the last one in the book.

    Example

    For current = 1 and numberOfDigits = 5, the output should be
    solution(current, numberOfDigits) = 5.

    The following numbers will be printed: 1, 2, 3, 4, 5.

    For current = 21 and numberOfDigits = 5, the output should be
    solution(current, numberOfDigits) = 22.

    The following numbers will be printed: 21, 22.

    For current = 8 and numberOfDigits = 4, the output should be
    solution(current, numberOfDigits) = 10.

    The following numbers will be printed: 8, 9, 10.*/
    fun solution46(current: Int, numberOfDigits: Int): Int {
        var printCount = numberOfDigits
        var page = current
        while (printCount >= page.toString().length) {
            printCount -= page.toString().length
            page++
        }
        return --page
    }
}