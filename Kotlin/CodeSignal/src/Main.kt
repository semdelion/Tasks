import intro.*

fun main(args: Array<String>) {
    theJourneyBegins()
    edgeOfTheOcean()
    smoothSailing()
    exploringTheWaters()
    islandOfKnowledge()
    rainsOfReason()
}

fun theJourneyBegins() {
    println("1 Sum: ${_1_TheJourneyBegins.solution1(2,2)}")
    println("2 CenturyFromYear: ${_1_TheJourneyBegins.solution2(1082)}")
    println("3 CheckPalindrome: ${_1_TheJourneyBegins.solution3("aabaa")}")
}

fun edgeOfTheOcean() {
    println("4 AdjacentElementsProduct: ${_2_EdgeOfTheOcean.solution4(mutableListOf(3, 6, -2, -5, 7, 3))}")
    println("5 ShapeArea: ${_2_EdgeOfTheOcean.solution5(5)}")
    println("6 Make Array Consecutive 2: ${_2_EdgeOfTheOcean.solution6(mutableListOf(6, 2, 3, 8))}")
    println("7 AlmostIncreasingSequence: ${_2_EdgeOfTheOcean.solution7(mutableListOf(1, 3, 2, 1))}")
    println("8 MatrixElementsSum: ${_2_EdgeOfTheOcean.solution8(mutableListOf(
        mutableListOf(0, 1, 1, 2),
        mutableListOf(0, 5, 0, 0),
        mutableListOf(2, 0, 3, 3)))}")
}

fun smoothSailing() {
    println("9 All Longest Strings: ${_3_SmoothSailing.solution9(mutableListOf("aba", "aa", "ad", "vcd", "aba"))}")
    println("10 CommonCharacterCounts: ${_3_SmoothSailing.solution10("aabcc","adcaa")}")
    println("11 IsLucky: ${_3_SmoothSailing.solution11(112301)}")
    println("12 Sort by Height: ${_3_SmoothSailing.solution12(mutableListOf(-1, 150, 190, 170, -1, -1, 160, 180))}")
    println("13 ReverseInParentheses: ${_3_SmoothSailing.solution13("foo(bar(baz))blim")}")
}


fun exploringTheWaters() {
    println("14 AlternatingSums: ${_4_ExploringTheWaters.solution14(mutableListOf(50, 60, 60, 45, 70))}")
    println("15 Add Border: ${_4_ExploringTheWaters.solution15(mutableListOf("abc", "ded"))}")
    println("16 Are Similar: ${_4_ExploringTheWaters.solution16(
        mutableListOf(1, 2, 3),
        mutableListOf(2, 1, 3))}")
    println("17 ArrayChange: ${_4_ExploringTheWaters.solution17(mutableListOf(1, 1, 1))}")
    println("18 PalindromeRearranging: ${_4_ExploringTheWaters.solution18("abbaaaca")}")

}

fun islandOfKnowledge() {
    println("19 AreEquallyStrong: ${_5_IslandOfKnowledge.solution19(10, 15,15, 10)}")
    println("20 ArrayMaximalAdjacentDifference: ${_5_IslandOfKnowledge.solution20(mutableListOf(2, 4, 1, 0))}")
    println("21 IsIPv4Address: ${_5_IslandOfKnowledge.solution21("121.121.321.01")}")
    println("22 AvoidObstacles: ${_5_IslandOfKnowledge.solution22(mutableListOf(5, 3, 6, 7, 9))}")
    println("23 Box Blur: ${_5_IslandOfKnowledge.solution23(mutableListOf(
        mutableListOf(7, 4, 0, 1),
        mutableListOf(5, 6, 2, 2),
        mutableListOf(6, 10, 7, 8),
        mutableListOf(1, 4, 2, 0)))}")
    println("24 Minesweeper: ${_5_IslandOfKnowledge.solution24(mutableListOf(
        mutableListOf(true, false, false),
        mutableListOf(false, true, false),
        mutableListOf(false, false, false)))}")
}

fun rainsOfReason() {

    

}