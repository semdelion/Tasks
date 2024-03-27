package theCore

object _6_LabyrinthOfNestedLoops {
    fun run() {
        println("43) Is Power?\n" +
                "      input: n = 29\n" +
                "      result: ${solution43(29)}\n")
        println("44) Is Sum of Consecutive 2\n" +
                "      input: n = 9\n" +
                "      result: ${solution44(9)}\n")
        println("45) Square Digits Sequence\n" +
                "      input: a0 = 16\n" +
                "      result: ${solution45(16)}\n")
        println("46) Pages Numbering With Ink\n" +
                "      input: current = 21, numberOfDigits = 5\n" +
                "      result: ${solution46(21, 5)}\n")
        println("47) Comfortable Numbers\n" +
                "      input: l = 10, r = 12\n" +
                "      result: ${solution47(10, 12)}\n")
        println("48) Weak Numbers\n" +
                "      input: n = 9\n" +
                "      result: ${solution48(9)}\n")
        println("49) Rectangle Rotation\n" +
                "      input: a = 6, b = 4\n" +
                "      result: ${solution49( 6, 4)}\n")
        println("50) Crossword Formation\n" +
                "      input: words = [\"crossword\", \"square\", \"formation\", \"something\"]\n" +
                "      result: ${solution50(mutableListOf("crossword", "square", "formation", "something"))}\n")
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
    private fun solution43(n: Int): Boolean {
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
    private fun solution44(n: Int): Int {
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
    private fun solution45(a0: Int): Int {
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
    private fun solution46(current: Int, numberOfDigits: Int): Int {
        var printCount = numberOfDigits
        var page = current
        while (printCount >= page.toString().length) {
            printCount -= page.toString().length
            page++
        }
        return --page
    }

    /**
     * Comfortable Numbers
     * @see "https://app.codesignal.com/arcade/code-arcade/labyrinth-of-nested-loops/pNfGgNk46YZ4c4RW5"
     * @return Comfortable Numbers
     * * @sample Let's say that number a feels comfortable with number b if a ≠ b and b lies in the segment [a - s(a), a + s(a)], where s(x) is the sum of x's digits.

    How many pairs (a, b) are there, such that a < b, both a and b lie on the segment [l, r], and each number feels comfortable with the other (so a feels comfortable with b and b feels comfortable with a)?

    Example

    For l = 10 and r = 12, the output should be
    solution(l, r) = 2.

    Here are all values of s(x) to consider:

    s(10) = 1, so 10 is comfortable with 9 and 11;
    s(11) = 2, so 11 is comfortable with 9, 10, 12 and 13;
    s(12) = 3, so 12 is comfortable with 9, 10, 11, 13, 14 and 15.
    Thus, there are 2 pairs of numbers comfortable with each other within the segment [10; 12]: (10, 11) and (11, 12).*/
    private fun solution47(l: Int, r: Int): Int {
        var count = 0
        for (a in l until r) {
            for (b in a + 1..r) {
                if (isComfort(a, b) && isComfort(b, a))
                    count++
            }
        }
        return count
    }

    private fun isComfort(a: Int, b: Int): Boolean {
        val digits = a.toString().map { x -> x.toString().toInt() }.sum()
        return a != b && (a - digits <= b) && (b <= a + digits)
    }

    /**
     * Weak Numbers
     * @see "https://app.codesignal.com/arcade/code-arcade/labyrinth-of-nested-loops/oL7YuygJKtMSNLeJn"
     * @return Weak Numbers
     * * @sample We define the weakness of number x as the number of positive integers smaller than x that have more divisors than x.

    It follows that the weaker the number, the greater overall weakness it has. For the given integer n, you need to answer two questions:

    what is the weakness of the weakest numbers in the range [1, n]?
    how many numbers in the range [1, n] have this weakness?
    Return the answer as an array of two elements, where the first element is the answer to the first question, and the second element is the answer to the second question.

    Example

    For n = 9, the output should be
    solution(n) = [2, 2].

    Here are the number of divisors and the specific weakness of each number in range [1, 9]:

    1: d(1) = 1, weakness(1) = 0;
    2: d(2) = 2, weakness(2) = 0;
    3: d(3) = 2, weakness(3) = 0;
    4: d(4) = 3, weakness(4) = 0;
    5: d(5) = 2, weakness(5) = 1;
    6: d(6) = 4, weakness(6) = 0;
    7: d(7) = 2, weakness(7) = 2;
    8: d(8) = 4, weakness(8) = 0;
    9: d(9) = 3, weakness(9) = 2.
    As you can see, the maximal weakness is 2, and there are 2 numbers with that weakness level.*/
    private fun solution48(n: Int): MutableList<Int> {
        val listOfDiv = mutableListOf<Int>()
        val weakness = mutableListOf<Int>()
        for (i in 1..n) {
            val div = countDivisors(i)
            weakness.add(listOfDiv.count { x -> x > div })
            listOfDiv.add(div)
        }
        return mutableListOf(weakness.maxOf { it }, weakness.count { x -> x == weakness.maxOf { it } })
    }

    private fun countDivisors(n: Int): Int {
        var count = 0
        var i = 1
        while (i * i <= n) {
            if (n % i == 0) {
                count += if (i * i < n) 2 else 1
            }
            i++
        }
        return count
    }

    /**
     * Rectangle Rotation
     * @see "https://app.codesignal.com/arcade/code-arcade/labyrinth-of-nested-loops/tuKA5f3zpzkKKejJx"
     * @return Rectangle Rotation
     * * @sample A rectangle with sides equal to even integers a and b is drawn on the Cartesian plane. Its center (the intersection point of its diagonals) coincides with the point (0, 0), but the sides of the rectangle are not parallel to the axes; instead, they are forming 45 degree angles with the axes.

    How many points with integer coordinates are located inside the given rectangle (including on its sides)?

    Example

    For a = 6 and b = 4, the output should be
    solution(a, b) = 23.

    The following picture illustrates the example, and the 23 points are marked green.*/
    fun solution49(a: Int, b: Int): Int {
        val aa = (a / Math.sqrt(2.0)).toInt()
        val bb = (b / Math.sqrt(2.0)).toInt()
        val correct = if ((aa + bb) % 2 == 1) -1 else 0
        return (aa + 1) * (bb + 1) + (aa) * (bb) + correct
    }

    /**
     * Crossword Formation
     * @see "https://app.codesignal.com/arcade/code-arcade/labyrinth-of-nested-loops/W5Sq7taLSzNHh8GiF"
     * @return Crossword Formation
     * * @sample You're a crossword fanatic, and have finally decided to try and create your own. However, you also love symmetry and good design, so you come up with a set of rules they should follow:

    the crossword must contain exactly four words;
    these four words should form four pairwise intersections;
    all words must be written either left-to-right or top-to-bottom;
    the area of the rectangle formed by empty cells inside the intersections isn't equal to zero.
    Given 4 words, find the number of ways to make a crossword following the above-described rules. Note that two crosswords which differ by rotation are considered different.

    Example

    For words = ["crossword", "square", "formation", "something"], the output should be
    solution(words) = 6.

    The six crosswords can be formed as shown below:*/
    fun solution50(words: MutableList<String>): Int {
        var count = 0
        for(item in getPermutations(words, words.count())) {
            for(a1d1 in getIntersections(item[0], item[2], 0, 0)){
                for(a1d2 in getIntersections(item[0], item[3], a1d1[0] + 2, 0)){
                    for(a2d1 in getIntersections(item[1], item[2], 0, a1d1[1] + 2)){
                        val a2d2 = mutableListOf( a1d2[0] - a1d1[0] + a2d1[0], a2d1[1] - a1d1[1] + a1d2[1])
                        if (a2d2[0] < item[1].length && a2d2[1] < item[3].length && item[1][a2d2[0]] == item[3][a2d2[1]])
                            count++
                    }
                }
            }
        }

        return count
    }

    private fun <T> getPermutations(rootList: Iterable<T>, length: Int): List<List<T>> {
        if (length == 1) {
            return rootList.map { listOf(it) }.toList()
        }

        return getPermutations(rootList, length - 1).flatMap { listItem ->
            rootList.filter { e -> !listItem.contains(e) }.map { t1 -> listItem + listOf(t1) }
        }.toList()
    }

    private fun getIntersections(w1: String, w2: String, w1Start: Int, w2Start: Int): Sequence<Array<Int>> {
        return sequence {
            for (i in w1Start until w1.length) {
                for (j in w2Start until w2.length) {
                    if (w1[i] == w2[j]) {
                        yield(arrayOf(i, j))
                    }
                }
            }
        }
    }
}