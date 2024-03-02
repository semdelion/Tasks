package theCore

object TMP {

    fun run() {

        println("83 Cipher 26: ${solution83("taiaiaertkixquxjnfxxdh")}")
        println("84 Stolen Lunch: ${solution84("you'll n4v4r 6u4ss 8t: cdja")}")
        println("85 Higher Version: ${solution85("1.2.2", "1.2.0")}")
        println("86 Decipher: ${solution86("10197115121")}")



    }



    /**
     * Cipher 26
     * @see "https://app.codesignal.com/arcade/code-arcade/lab-of-transformations/JeDDnToFtitiiWDZn"
     * @return Cipher 26
     * * @sample You've intercepted an encrypted message, and you are really curious about its contents. You were able to find out that the message initially contained only lowercase English letters, and was encrypted with the following cipher:

    Let all letters from 'a' to 'z' correspond to the numbers from 0 to 25, respectively.
    The number corresponding to the ith letter of the encrypted message is then equal to the sum of numbers corresponding to the first i letters of the initial unencrypted message modulo 26.
    Now that you know how the message was encrypted, implement the algorithm to decipher it.

    Example

    For message = "taiaiaertkixquxjnfxxdh", the output should be
    solution(message) = "thisisencryptedmessage".

    The initial message "thisisencryptedmessage" was encrypted as follows:

    letter 0: t -> 19 -> t;
    letter 1: th -> (19 + 7) % 26 -> 0 -> a;
    letter 2: thi -> (19 + 7 + 8) % 26 -> 8 -> i;
    etc.*/
    fun solution83(message: String): String {
        var sum = 0
        return  message.map {
            val dif = (it.code - sum % 26 - 71) % 26
            sum += dif
            (dif + 97).toChar()
        }.joinToString("")
    }

    /**
     * Stolen Lunch
     * @see "https://app.codesignal.com/arcade/code-arcade/lab-of-transformations/M97sbwRp3tGy8uAb8"
     * @return Stolen Lunch
     * * @sample When you recently visited your little nephew, he told you a sad story: there's a bully at school who steals his lunch every day, and locks it away in his locker. He also leaves a note with a strange, coded message. Your nephew gave you one of the notes in hope that you can decipher it for him. And you did: it looks like all the digits in it are replaced with letters and vice versa. Digit 0 is replaced with 'a', 1 is replaced with 'b' and so on, with digit 9 replaced by 'j'.

    The note is different every day, so you decide to write a function that will decipher it for your nephew on an ongoing basis.*/
    fun solution84(note: String): String {
        var result = ""
        for (item in note) {
            result += when (item.code) {
                in 48..57 ->
                    ('a'.code + item.code - 48).toChar()
                in 97..106 ->
                    ('0'.code + item.code - 97).toChar()
                else ->
                    item
            }
        }
        return result
    }

    /**
     * Higher Version
     * @see "https://app.codesignal.com/arcade/code-arcade/lab-of-transformations/vsKRjYKv4SCjzJc8r"
     * @return Higher Version
     * * @sample Given two version strings composed of several non-negative decimal fields separated by periods ("."), both strings contain equal number of numeric fields. Return true if the first version is higher than the second version and false otherwise.

    The syntax follows the regular semver ordering rules:

    1.0.5 < 1.1.0 < 1.1.5 < 1.1.10 < 1.2.0 < 1.2.2
    < 1.2.10 < 1.10.2 < 2.0.0 < 10.0.0
    There are no leading zeros in any of the numeric fields, i.e. you do not have to handle inputs like 100.020.003 (it would instead be given as 100.20.3).

    Example

    For ver1 = "1.2.2" and ver2 = "1.2.0", the output should be
    solution(ver1, ver2) = true;
    For ver1 = "1.0.5" and ver2 = "1.1.0", the output should be
    solution(ver1, ver2) = false.*/
    fun solution85(ver1: String, ver2: String): Boolean {
        val var1S = ver1.split('.')
        val var2S = ver2.split('.')
        if(var1S.count() != var2S.count())
            throw NumberFormatException()
        for (i in 0 until  var1S.count()) {
            if(var1S[i].toInt() > var2S[i].toInt())
                return true
            if (var1S[i].toInt() < var2S[i].toInt())
                return false
        }

        return false
    }

    /**
     * Decipher
     * @see "https://app.codesignal.com/arcade/code-arcade/lab-of-transformations/dB9drnfWzpiWznESA"
     * @return Decipher
     * * @sample Consider the following ciphering algorithm:

    For each character replace it with its code.
    Concatenate all of the obtained numbers.
    Given a ciphered string, return the initial one if it is known that it consists only of lowercase letters.

    Note: here the character's code means its decimal ASCII code, the numerical representation of a character used by most modern programming languages.

    Example

    For cipher = "10197115121", the output should be
    solution(cipher) = "easy".

    Explanation: charCode('e') = 101, charCode('a') = 97, charCode('s') = 115 and charCode('y') = 121.*/
    fun solution86(cipher: String): String {
        var result = ""
        var symbol = ""
        for (item  in cipher) {
            symbol += item
            if(symbol.length > 1 && symbol.toInt() > 96) {
                result += symbol.toInt().toChar()
                symbol = ""
            }
        }
        return result
    }

    /**
     * Alphanumeric Less
     * @see "https://app.codesignal.com/arcade/code-arcade/lab-of-transformations/bBgu7NEfk2GoQuNzf"
     * @return Alphanumeric Less
     * * @sample An alphanumeric ordering of strings is defined as follows: each string is considered as a sequence of tokens, where each token is a letter or a number (as opposed to an isolated digit, as is the case in lexicographic ordering). For example, the tokens of the string "ab01c004" are [a, b, 01, c, 004]. In order to compare two strings, we'll first break them down into tokens and then compare the corresponding pairs of tokens with each other (i.e. compare the first token of the first string with the first token of the second string, etc).

    Here is how tokens are compared:

    If a letter is compared with another letter, the usual alphabetical order applies.
    A number is always considered less than a letter.
    When two numbers are compared, their values are compared. Leading zeros, if any, are ignored.
    If at some point one string has no more tokens left while the other one still does, the one with fewer tokens is considered smaller.

    If the two strings s1 and s2 appear to be equal, consider the smallest index i such that tokens(s1)[i] and tokens(s2)[i] (where tokens(s)[i] is the ith token of string s) differ only by the number of leading zeros. If no such i exists, the strings are indeed equal. Otherwise, the string whose ith token has more leading zeros is considered smaller.

    Here are some examples of comparing strings using alphanumeric ordering.

    "a" < "a1" < "ab"
    "ab42" < "ab000144" < "ab00144" < "ab144" < "ab000144x"
    "x11y012" < "x011y13"
    Your task is to return true if s1 is strictly less than s2, and false otherwise.

    Example

    For s1 = "a" and s2 = "a1", the output should be solution(s1, s2) = true;

    These strings have equal first tokens, but since s1 has fewer tokens than s2, it's considered smaller.

    For s1 = "ab" and s2 = "a1", the output should be solution(s1, s2) = false;

    These strings also have equal first tokens, but since numbers are considered less than letters, s1 is larger.

    For s1 = "b" and s2 = "a1", the output should be solution(s1, s2) = false.

    Since b is greater than a, s1 is larger.*/
    /*fun solution87(s1: String, s2: String): Boolean {

  } */






}