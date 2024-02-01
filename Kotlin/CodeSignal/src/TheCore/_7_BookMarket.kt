package TheCore

object _7_BookMarket {
    fun run() {
        println("51 Enclose In Brackets: ${_7_BookMarket.solution51("abacaba")}")
        println("52 Proper Noun Correction: ${_7_BookMarket.solution52("pARiS")}")
        println("53 Is Tandem Repeat?: ${_7_BookMarket.solution53("tandemtandem")}")
        println("54 Is Case-Insensitive Palindrome?: ${_7_BookMarket.solution54("AaBaa")}")
        println("55 Find Email Domain: ${_7_BookMarket.solution55("fully-qualified-domain@codesignal.com")}")

    }

    /**
     * Enclose In Brackets
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/K2ieDm98sPDzzMepz"
     * @return Enclose In Brackets
     * * @sample Given a string, enclose it in round brackets.

    Example

    For inputString = "abacaba", the output should be
    solution(inputString) = "(abacaba)".*/
    fun solution51(inputString: String): String  = "($inputString)"


    /**
     * Proper Noun Correction
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/2nSEQ8CGoddTJtnbo"
     * @return Proper Noun Correction
     * * @sample Proper nouns always begin with a capital letter, followed by small letters.

    Correct a given proper noun so that it fits this statement.

    Example

    For noun = "pARiS", the output should be
    solution(noun) = "Paris";
    For noun = "John", the output should be
    solution(noun) = "John".*/
    fun solution52(noun: String): String = noun.first().uppercaseChar() + noun.substring(1).lowercase()

    /**
     * Is Tandem Repeat?
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/2SDWWyHY9Xw5CpphY"
     * @return Is Tandem Repeat?
     * * @sample Determine whether the given string can be obtained by one concatenation of some string to itself.

    Example

    For inputString = "tandemtandem", the output should be
    solution(inputString) = true;
    For inputString = "qqq", the output should be
    solution(inputString) = false;
    For inputString = "2w2ww", the output should be
    solution(inputString) = false.*/
    fun solution53(inputString: String): Boolean {
        return inputString.substring(0, inputString.length/2) == inputString.substring(inputString.length/2)
    }


    /**
     * Is Case-Insensitive Palindrome?
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/G9wj2j6zaWwFWsise"
     * @return Is Case-Insensitive Palindrome?
     * * @sample Given a string, check if it can become a palindrome through a case change of some (possibly, none) letters.

    Example

    For inputString = "AaBaa", the output should be
    solution(inputString) = true.

    "aabaa" is a palindrome as well as "AABAA", "aaBaa", etc.

    For inputString = "abac", the output should be
    solution(inputString) = false.

    All the strings which can be obtained via changing case of some group of letters, i.e. "abac", "Abac", "aBAc" and 13 more, are not palindromes.*/

    fun solution54(inputString: String): Boolean {
        val str = inputString.lowercase()
        val length = str.length / 2
        for (i in 0..length) {
            if (str[i] != str[str.length - 1 - i])
                return false
        }
        return true
    }

    /**
     * Find Email Domain
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/G9wj2j6zaWwFWsise"
     * @return Find Email Domain
     * * @sample An email address such as "John.Smith@example.com" is made up of a local part ("John.Smith"), an "@" symbol, then a domain part ("example.com").

    The domain name part of an email address may only consist of letters, digits, hyphens and dots. The local part, however, also allows a lot of different special characters. Here you can look at several examples of correct and incorrect email addresses.

    Given a valid email address, find its domain part.

    Example

    For address = "prettyandsimple@example.com", the output should be
    solution(address) = "example.com";
    For address = "fully-qualified-domain@codesignal.com", the output should be
    solution(address) = "codesignal.com".*/
    fun solution55(address: String): String  = address.substring(address.lastIndexOf('@') + 1)



}