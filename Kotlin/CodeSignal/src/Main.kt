import intro._2_EdgeOfTheOcean
import intro._1_TheJourneyBegins
import intro._3_SmoothSailing

fun main(args: Array<String>) {
    theJourneyBegins()
    edgeOfTheOcean()
    smoothSailing()
}

fun theJourneyBegins() {
    println("1 sum: ${_1_TheJourneyBegins.solution1(2,2)}")
    println("2 centuryFromYear: ${_1_TheJourneyBegins.solution2(1082)}")
    println("3 checkPalindrome: ${_1_TheJourneyBegins.solution3("aabaa")}")
}

fun edgeOfTheOcean() {
    println("4 adjacentElementsProduct: ${_2_EdgeOfTheOcean.solution4(mutableListOf(3, 6, -2, -5, 7, 3))}")
    println("5 shapeArea: ${_2_EdgeOfTheOcean.solution5(5)}")
    println("6 Make Array Consecutive 2: ${_2_EdgeOfTheOcean.solution6(mutableListOf(6, 2, 3, 8))}")
    println("7 almostIncreasingSequence: ${_2_EdgeOfTheOcean.solution7(mutableListOf(1, 3, 2, 1))}")
    println("8 matrixElementsSum: ${_2_EdgeOfTheOcean.solution8(mutableListOf(
        mutableListOf(0, 1, 1, 2),
        mutableListOf(0, 5, 0, 0),
        mutableListOf(2, 0, 3, 3)))}")
}

fun smoothSailing() {
    //println("9 adjacentElementsProduct: ${_3_SmoothSailing.solution9(mutableListOf(3, 6, -2, -5, 7, 3))}")
}