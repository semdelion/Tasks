package theCore


object _2_AtTheCrossroads {

    fun run() {
        println("9 Reach Next Level: ${_2_AtTheCrossroads.solution9(experience = 10, threshold = 15, reward = 5)}")
        println(
            "10 Knapsack Light: ${
                _2_AtTheCrossroads.solution10(
                    value1 = 10,
                    weight1 = 5,
                    value2 = 6,
                    weight2 = 4,
                    maxW = 8
                )
            }"
        )
        println("11 Extra Number: ${_2_AtTheCrossroads.solution11(a = 2, b = 7, c = 2)}")
        println("12 Is Infinite Process?: ${_2_AtTheCrossroads.solution12(a = 2, b = 6)}")
        println("13 Arithmetic Expression: ${_2_AtTheCrossroads.solution13(2, 3, 5)}")
        println("14 Tennis Set: ${_2_AtTheCrossroads.solution14(7, 5)}")
        println("15 Will you?: ${_2_AtTheCrossroads.solution15( young = true, beautiful = true, loved = true)}")
        println("16 Metro Card: ${_2_AtTheCrossroads.solution16( 31)}")

    }

    /**
     * Reach Next Level
     * @see "https://app.codesignal.com/arcade/code-arcade/at-the-crossroads/m9wjpkCjgofg7gs8N"
     * @return Reach Next Level
     * * @sample You are playing an RPG game. Currently your experience points (XP) total is equal to experience. To reach the next level your XP should be at least at threshold. If you kill the monster in front of you, you will gain more experience points in the amount of the reward.

    Given values experience, threshold and reward, check if you reach the next level after killing the monster.

    Example

    For experience = 10, threshold = 15, and reward = 5, the output should be
    solution(experience, threshold, reward) = true;
    For experience = 10, threshold = 15, and reward = 4, the output should be
    solution(experience, threshold, reward) = false.*/
    fun solution9(experience: Int, threshold: Int, reward: Int): Boolean = experience + reward >= threshold


    /**
     * Knapsack Light
     * @see "https://app.codesignal.com/arcade/intro/level-9/r9azLYp2BDZPyzaG2"
     * @return Knapsack Light
     * * @sample You found two items in a treasure chest! The first item weighs weight1 and is worth value1, and the second item weighs weight2 and is worth value2. What is the total maximum value of the items you can take with you, assuming that your max weight capacity is maxW and you can't come back for the items later?

    Note that there are only two items and you can't bring more than one item of each type, i.e. you can't take two first items or two second items.

    Example

    For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4, and maxW = 8, the output should be
    solution(value1, weight1, value2, weight2, maxW) = 10.

    You can only carry the first item.

    For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4, and maxW = 9, the output should be
    solution(value1, weight1, value2, weight2, maxW) = 16.

    You're strong enough to take both of the items with you.

    For value1 = 5, weight1 = 3, value2 = 7, weight2 = 4, and maxW = 6, the output should be
    solution(value1, weight1, value2, weight2, maxW) = 7.

    You can't take both items, but you can take any of them.
     */
    fun solution10(value1: Int, weight1: Int, value2: Int, weight2: Int, maxW: Int): Int {
        if (weight1 + weight2 <= maxW)
            return value1 + value2
        if (weight1 <= maxW && weight2 <= maxW)
            return if (value1 > value2) value1 else value2
        if (weight1 <= maxW)
            return value1
        if (weight2 <= maxW)
            return value2
        return 0
    }


    /**
     * Extra Number
     * @see "https://app.codesignal.com/arcade/code-arcade/at-the-crossroads/sgDWKCFQHHi5D3Szj"
     * @return Extra Number
     * * @sample You're given three integers, a, b and c. It is guaranteed that two of these integers are equal to each other. What is the value of the third integer?

    Example

    For a = 2, b = 7, and c = 2, the output should be
    solution(a, b, c) = 7.

    The two equal numbers are a and c. The third number (b) equals 7, which is the answer.
     */
    fun solution11(a: Int, b: Int, c: Int): Int = if (a == b) c else a + b - c

    /**
     * Is Infinite Process?
     * @see "https://app.codesignal.com/arcade/code-arcade/at-the-crossroads/aFF9HDm2Rsti9j5kc"
     * @return Is Infinite Process?
     * * @sample Given integers a and b, determine whether the following pseudocode results in an infinite loop

    while a is not equal to b do
    increase a by 1
    decrease b by 1
    Assume that the program is executed on a virtual machine which can store arbitrary long numbers and execute forever.

    Example

    For a = 2 and b = 6, the output should be
    solution(a, b) = false;
    For a = 2 and b = 3, the output should be
    solution(a, b) = true
     */
    fun solution12(a: Int, b: Int): Boolean = if (a > b || (b - a) % 2 == 1) true else false

    /**
     * Arithmetic Expression
     * @see "https://app.codesignal.com/arcade/code-arcade/at-the-crossroads/QrCSNQWhnQoaK9KgK"
     * @return Arithmetic Expression
     * * @sample Consider an arithmetic expression of the form a#b=c. Check whether it is possible to replace # with one of the four signs: +, -, * or / to obtain a correct expression.

    Example

    For a = 2, b = 3, and c = 5, the output should be
    solution(a, b, c) = true.

    We can replace # with a + to obtain 2 + 3 = 5, so the answer is true.

    For a = 8, b = 2, and c = 4, the output should be
    solution(a, b, c) = true.

    We can replace # with a / to obtain 8 / 2 = 4, so the answer is true.

    For a = 8, b = 3, and c = 2, the output should be
    solution(a, b, c) = false.

    8 + 3 = 11 ≠ 2;
    8 - 3 = 5 ≠ 2;
    8 * 3 = 24 ≠ 2;
    8 / 3 = 2.(6) ≠ 2.
    So the answer is false.
     */
    fun solution13(a: Int, b: Int, c: Int): Boolean {
        if ((a + b) == c || (a - b) == c || (a * b) == c)
            return true
        if (b != 0 && a % b == 0 && a / b == c)
            return true
        return false
    }


    /**
     * Tennis Set
     * @see "https://app.codesignal.com/arcade/code-arcade/at-the-crossroads/7jaup9HprdJno2diw"
     * @return Tennis Set
     * * @sample In tennis, the winner of a set is based on how many games each player wins. The first player to win 6 games is declared the winner unless their opponent had already won 5 games, in which case the set continues until one of the players has won 7 games.

    Given two integers score1 and score2, your task is to determine if it is possible for a tennis set to be finished with a final score of score1 : score2.

    Example

    For score1 = 3 and score2 = 6, the output should be
    solution(score1, score2) = true.

    Since player 1 hadn't reached 5 wins, the set ends once player 2 has won 6 games.

    For score1 = 8 and score2 = 5, the output should be
    solution(score1, score2) = false.

    Since both players won at least 5 games, the set would've ended once one of them won the 7th one.

    For score1 = 6 and score2 = 5, the output should be
    solution(score1, score2) = false.

    This set will continue until one of these players wins their 7th game, so this can't be the final score.
     */
    fun solution14(score1: Int, score2: Int): Boolean {
        val loser = Math.min(score1, score2)
        val winner = Math.max(score1, score2)
        return winner == 6 && loser < 5 || winner == 7 && loser in 5..6
    }

    /**
     * Will You?
     * @see "https://app.codesignal.com/arcade/code-arcade/at-the-crossroads/jZ4ZSiGohzFTeg4yb"
     * @return Will You?
     * * @sample Once Mary heard a famous song, and a line from it stuck in her head. That line was "Will you still love me when I'm no longer young and beautiful?". Mary believes that a person is loved if and only if he/she is both young and beautiful, but this is quite a depressing thought, so she wants to put her belief to the test.

    Knowing whether a person is young, beautiful and loved, find out if they contradict Mary's belief.

    A person contradicts Mary's belief if one of the following statements is true:

    they are young and beautiful but not loved;
    they are loved but not young or not beautiful.
    Example

    For young = true, beautiful = true, and loved = true, the output should be
    solution(young, beautiful, loved) = false.

    Young and beautiful people are loved according to Mary's belief.

    For young = true, beautiful = false, and loved = true, the output should be
    solution(young, beautiful, loved) = true.

    Mary doesn't believe that not beautiful people can be loved
     */
    fun solution15(young: Boolean, beautiful: Boolean, loved: Boolean): Boolean = if(young && beautiful) !loved else loved

    /**
     * Metro Card
     * @see "https://app.codesignal.com/arcade/code-arcade/at-the-crossroads/J7PQDxpWqhx7HrvBZ"
     * @return Metro Card
     * * @sample You just bought a public transit card that allows you to ride the Metro for a certain number of days.

    Here is how it works: upon first receiving the card, the system allocates you a 31-day pass, which equals the number of days in January. The second time you pay for the card, your pass is extended by 28 days, i.e. the number of days in February (note that leap years are not considered), and so on. The 13th time you extend the pass, you get 31 days again.

    You just ran out of days on the card, and unfortunately you've forgotten how many times your pass has been extended so far. However, you do remember the number of days you were able to ride the Metro during this most recent month. Figure out the number of days by which your pass will now be extended, and return all the options as an array sorted in increasing order.

    Example

    For lastNumberOfDays = 30, the output should be
    solution(lastNumberOfDays) = [31].

    There are 30 days in April, June, September and November, so the next months to consider are May, July, October or December. All of them have exactly 31 days, which means that you will definitely get a 31-days pass the next time you extend your card.
     */
    fun solution16(lastNumberOfDays: Int): MutableList<Int> = if(lastNumberOfDays == 28 || lastNumberOfDays == 30) mutableListOf(31) else mutableListOf( 28, 30, 31 )

}