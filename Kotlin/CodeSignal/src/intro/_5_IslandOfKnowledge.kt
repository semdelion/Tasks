package intro

import kotlin.math.abs
import kotlin.test.todo

object _5_IslandOfKnowledge {
    /**
     * areEquallyStrong
     * @see "https://app.codesignal.com/arcade/intro/level-5/g6dc9KJyxmFjB98dL"
     * @return palindromeRearranging
     * * @sample Call two arms equally strong if the heaviest weights they each are able to lift are equal.

    Call two people equally strong if their strongest arms are equally strong (the strongest arm can be both the right and the left), and so are their weakest arms.

    Given your and your friend's arms' lifting capabilities find out if you two are equally strong.
     */
    fun solution19(yourLeft: Int, yourRight: Int, friendsLeft: Int, friendsRight: Int): Boolean {
        if (yourLeft == friendsLeft) {
            return yourRight == friendsRight
        } else if (yourLeft == friendsRight) {
            return yourRight == friendsLeft
        }
        return false
    }

    /**
     * arrayMaximalAdjacentDifference
     * @see "https://app.codesignal.com/arcade/intro/level-5/EEJxjQ7oo7C5wAGjE"
     * @return arrayMaximalAdjacentDifference
     * * @sample Call two arms equally strong if the heaviest weights they each are able to lift are equal.

    Call two people equally strong if their strongest arms are equally strong (the strongest arm can be both the right and the left), and so are their weakest arms.

    Given your and your friend's arms' lifting capabilities find out if you two are equally strong.
     */
    fun solution20(inputArray: MutableList<Int>): Int {
        var max = Int.MIN_VALUE
        for (i in 1 until inputArray.count()) {
            if (abs(inputArray[i - 1] - inputArray[i]) > max)
                max = abs(inputArray[i - 1] - inputArray[i])
        }
        return max
    }


    /**
     * isIPv4Address
     * @see "https://app.codesignal.com/arcade/intro/level-5/veW5xJednTy4qcjso"
     * @return isIPv4Address
     * * @sample An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions of addresses. One of them is the IPv4 address.

    Given a string, find out if it satisfies the IPv4 address naming rules.

    Example

    For inputString = "172.16.254.1", the output should be
    solution(inputString) = true;

    For inputString = "172.316.254.1", the output should be
    solution(inputString) = false.

    316 is not in range [0, 255].

    For inputString = ".254.255.0", the output should be
    solution(inputString) = false.

    There is no first number.
     */
    fun solution21(inputString: String): Boolean {
        val octets = inputString.split('.')
        if(octets.count() != 4)
            return false
        for (octet in octets) {
            val item = octet.toIntOrNull()
            if(item == null || item.toString() != octet || item !in (0..255))
                return false
        }
        return true
    }
}