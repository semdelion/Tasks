package intro

object _10_EruptionOfLight {

    fun run() {
        println("43) IsBeautifulString\n" +
                "      input: inputString = \"bbbaacdafe\"\n" +
                "      result: ${solution43("bbbaacdafe")}\n")
        println("44) Find Email Domain\n" +
                "      input: address = \"prettyandsimple@example.com\"\n" +
                "      result: ${solution44("prettyandsimple@example.com")}\n")
        println("45) BuildPalindrome\n" +
                "      input: st = \"abcdc\"\n" +
                "      result: ${solution45("abcdc")}\n")
        println("46) Elections Winners\n" +
                "      input: votes = [2, 3, 5, 2], k = 3\n" +
                "      result: ${solution46(mutableListOf(2, 3, 5, 2), 3)}\n")
        println("47) Is MAC48 Address?\n" +
                "      input: inputString = \"00-1B-63-84-45-E6\"\n" +
                "      result: ${solution47("00-1B-63-84-45-E6")}\n")
    }

    /**
     * isBeautifulString
     * @see "https://app.codesignal.com/arcade/intro/level-10/PHSQhLEw3K2CmhhXE"
     * @return isBeautifulString
     * * @sample A string is said to be beautiful if each letter in the string appears at most as many times as the previous letter in the alphabet within the string; ie: b occurs no more times than a; c occurs no more times than b; etc. Note that letter a has no previous letter.

    Given a string, check whether it is beautiful.

    Example

    For inputString = "bbbaacdafe", the output should be solution(inputString) = true.

    This string contains 3 as, 3 bs, 1 c, 1 d, 1 e, and 1 f (and 0 of every other letter), so since there aren't any letters that appear more frequently than the previous letter, this string qualifies as beautiful.

    For inputString = "aabbb", the output should be solution(inputString) = false.

    Since there are more bs than as, this string is not beautiful.

    For inputString = "bbc", the output should be solution(inputString) = false.

    Although there are more bs than cs, this string is not beautiful because there are no as, so therefore there are more bs than as.
     */
    fun solution43(inputString: String): Boolean {
        val symbols = MutableList(26) { 0 }
        inputString.forEach { symbols[it.code - 97]++ }
        for (i in 1 until symbols.count()) {
            if (symbols[i - 1] < symbols[i])
                return false
        }
        return true
    }

    /**
     *  Find Email Domain
     * @see "https://app.codesignal.com/arcade/intro/level-10/TXFLopNcCNbJLQivP"
     * @return  Find Email Domain
     * * @sample An email address such as "John.Smith@example.com" is made up of a local part ("John.Smith"), an "@" symbol, then a domain part ("example.com").

    The domain name part of an email address may only consist of letters, digits, hyphens and dots. The local part, however, also allows a lot of different special characters. Here you can look at several examples of correct and incorrect email addresses.

    Given a valid email address, find its domain part.

    Example

    For address = "prettyandsimple@example.com", the output should be
    solution(address) = "example.com";
    For address = "fully-qualified-domain@codesignal.com", the output should be
    solution(address) = "codesignal.com".
     */
    fun solution44(address: String): String = address.substring(address.lastIndexOf('@') + 1)

    /**
     *  BuildPalindrome
     * @see "https://app.codesignal.com/arcade/intro/level-10/ppZ9zSufpjyzAsSEx"
     * @return  BuildPalindrome
     * * @sample Given a string, find the shortest possible string which can be achieved by adding characters to the end of initial string to make it a palindrome.

    Example

    For st = "abcdc", the output should be
    solution(st) = "abcdcba".
     */
    fun solution45(st: String): String {
        val tail = st.reversed()
        for (i in st.indices)
            if (st[i] == tail[0]) {
                for (k in 0..tail.length) {
                    if (i + k == st.length)
                        return st + tail.substring(k)
                    if (st[i + k] != tail[k])
                        break
                }
            }
        return st + tail.substring(1)
    }

    /**
     *  Elections Winners
     * @see "https://app.codesignal.com/arcade/intro/level-10/8RiRRM3yvbuAd3MNg"
     * @return  Elections Winners
     * * @sample Elections are in progress!

    Given an array of the numbers of votes given to each of the candidates so far, and an integer k equal to the number of voters who haven't cast their vote yet, find the number of candidates who still have a chance to win the election.

    The winner of the election must secure strictly more votes than any other candidate. If two or more candidates receive the same (maximum) number of votes, assume there is no winner at all.

    Example

    For votes = [2, 3, 5, 2] and k = 3, the output should be
    solution(votes, k) = 2.

    The first candidate got 2 votes. Even if all of the remaining 3 candidates vote for him, he will still have only 5 votes, i.e. the same number as the third candidate, so there will be no winner.
    The second candidate can win if all the remaining candidates vote for him (3 + 3 = 6 > 5).
    The third candidate can win even if none of the remaining candidates vote for him. For example, if each of the remaining voters cast their votes for each of his opponents, he will still be the winner (the votes array will thus be [3, 4, 5, 3]).
    The last candidate can't win no matter what (for the same reason as the first candidate).
    Thus, only 2 candidates can win (the second and the third), which is the answer.
     */
    fun solution46(votes: MutableList<Int>, k: Int): Int {
        val max = votes.maxOf {it}
        if(k == 0)
            return if(votes.count{ it == max} > 1) 0 else  1
        return votes.count {(it + k) > max}
    }

    /**
     *  Is MAC48 Address?
     * @see "https://app.codesignal.com/arcade/intro/level-10/HJ2thsvjL25iCvvdm"
     * @return  Is MAC48 Address?
     * * @sample A media access control address (MAC address) is a unique identifier assigned to network interfaces for communications on the physical network segment.

    The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly form is six groups of two hexadecimal digits (0 to 9 or A to F), separated by hyphens (e.g. 01-23-45-67-89-AB).

    Your task is to check by given string inputString whether it corresponds to MAC-48 address or not.

    Example

    For inputString = "00-1B-63-84-45-E6", the output should be
    solution(inputString) = true;
    For inputString = "Z1-1B-63-84-45-E6", the output should be
    solution(inputString) = false;
    For inputString = "not a MAC-48 address", the output should be
    solution(inputString) = false.
     */
    fun solution47(inputString: String): Boolean {
        val regex = Regex("^(([\\dA-F]{2}-){5}[\\dA-F]{2})$")
        val matches = regex.findAll(inputString)
        return matches.count() == 1
    }
}