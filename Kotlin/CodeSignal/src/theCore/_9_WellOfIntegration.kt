package theCore

object _9_WellOfIntegration {
    fun run() {
        println("67 House Numbers Sum: ${_9_WellOfIntegration.solution67(mutableListOf(5, 1, 2, 3, 0, 1, 5, 0, 2))}")


    }

    /**
     * House Numbers Sum
     * @see "https://app.codesignal.com/arcade/code-arcade/well-of-integration/3QMXNwGfvLMoQwed7"
     * @return House Numbers Sum
     * * @sample A boy is walking a long way from school to his home. To make the walk more fun he decides to add up all the numbers of the houses that he passes by during his walk. Unfortunately, not all of the houses have numbers written on them, and on top of that the boy is regularly taking turns to change streets, so the numbers don't appear to him in any particular order.

    At some point during the walk the boy encounters a house with number 0 written on it, which surprises him so much that he stops adding numbers to his total right after seeing that house.

    For the given sequence of houses determine the sum that the boy will get. It is guaranteed that there will always be at least one 0 house on the path.

    Example

    For inputArray = [5, 1, 2, 3, 0, 1, 5, 0, 2], the output should be
    solution(inputArray) = 11.

    The answer was obtained as 5 + 1 + 2 + 3 = 11.*/
    fun solution67(inputArray: MutableList<Int>): Int = inputArray.takeWhile { it != 0 }.sum()



}