package theCore

object _7_BookMarket {
    fun run() {
        println("51) Enclose In Brackets\n" +
                "      input: inputString = \"abacaba\"\n" +
                "      result: ${solution51(inputString = "abacaba")}\n")
        println("52) Proper Noun Correction\n" +
                "      input: noun = \"pARiS\"\n" +
                "      result: ${solution52(noun = "pARiS")}\n")
        println("53) Is Tandem Repeat?\n" +
                "      input: inputString = \"tandemtandem\"\n" +
                "      result: ${solution53(inputString = "tandemtandem")}\n")
        println("54) Is Case-Insensitive Palindrome?\n" +
                "      input: inputString = \"AaBaa\"\n" +
                "      result: ${solution54(inputString = "AaBaa")}\n")
        println("55) Find Email Domain\n" +
                "      input: address = \"fully-qualified-domain@codesignal.com\"\n" +
                "      result: ${solution55(address = "fully-qualified-domain@codesignal.com")}\n")
        println("56) HTML End Tag By Start Tag\n" +
                "      input: startTag = \"<button type='button' disabled>\"\n" +
                "      result: ${solution56(startTag = "<button type='button' disabled>")}\n")
        println("57) Is MAC48 Address?\n" +
                "      input: inputString = \"00-1B-63-84-45-E6\"\n" +
                "      result: ${solution57(inputString = "00-1B-63-84-45-E6")}\n")
        println("58) Is Unstable Pair?\n" +
                "      input: filename1 = \"aa\", filename2 = \"AAB\"\n" +
                "      result: ${solution58(filename1 = "aa", filename2 = "AAB")}\n")
    }

    /**
     * Enclose In Brackets
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/K2ieDm98sPDzzMepz"
     * @return Enclose In Brackets
     * * @sample Given a string, enclose it in round brackets.

    Example

    For inputString = "abacaba", the output should be
    solution(inputString) = "(abacaba)".*/
    fun solution51(inputString: String): String = "($inputString)"

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
        return inputString.substring(0, inputString.length / 2) == inputString.substring(inputString.length / 2)
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
    fun solution55(address: String): String = address.substring(address.lastIndexOf('@') + 1)

    /**
     * HTML End Tag By Start Tag
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/MX94DWTrwQw2gLrTi"
     * @return HTML End Tag By Start Tag
     * * @sample You are implementing your own HTML editor. To make it more comfortable for developers you would like to add an auto-completion feature to it.

    Given the starting HTML tag, find the appropriate end tag which your editor should propose.

    If you are not familiar with HTML, consult with this note.

    Example

    For startTag = "<button type='button' disabled>", the output should be
    solution(startTag) = "</button>";
    For startTag = "<i>", the output should be
    solution(startTag) = "</i>".*/
    fun solution56(startTag: String): String {
        val index = startTag.indexOfFirst { x -> x == ' ' || x == '>' }
        return "</${startTag.substring(1, index)}>"
    }

    /**
     *  Is Unstable Pair?
     * @see "https://app.codesignal.com/arcade/intro/level-10/HJ2thsvjL25iCvvdm"
     * @return  Is Unstable Pair?
     * * @sample Some file managers sort filenames taking into account case of the letters, others compare strings as if all of the letters are of the same case. That may lead to different ways of filename ordering.

    Call two filenames an unstable pair if their ordering depends on the case.

    To compare two filenames a and b, find the first position i at which a[i] ≠ b[i]. If a[i] < b[i], then a < b. Otherwise a > b. If such position doesn't exist, the shorter string goes first.

    Given two filenames, check whether they form an unstable pair.

    Example

    For filename1 = "aa" and filename2 = "AAB", the output should be
    solution(filename1, filename2) = true.

    Because "AAB" < "aa", but "AAB" > "AA".

    For filename1 = "A" and filename2 = "z", the output should be
    solution(filename1, filename2) = false.

    Both "A" < "z" and "a" < "z".*/
    fun solution57(inputString: String): Boolean {
        val regex = Regex("^(([\\dA-F]{2}-){5}[\\dA-F]{2})$")
        val matches = regex.findAll(inputString)
        return matches.count() == 1
    }

    /**
     *  Is Unstable Pair?
     * @see "https://app.codesignal.com/arcade/code-arcade/book-market/Ky2mjgmxnWLi6KNPp"
     * @return  Is Unstable Pair?
     * * @sample Some file managers sort filenames taking into account case of the letters, others compare strings as if all the letters are of the same case. That may lead to different ways of filename ordering.

    Call two filenames an unstable pair if their ordering depends on the case.

    To compare two filenames a and b, find the first position i at which a[i] ≠ b[i]. If a[i] < b[i], then a < b. Otherwise a > b. If such position doesn't exist, the shorter string goes first.

    Given two filenames, check whether they form an unstable pair.

    Example

    For filename1 = "aa" and filename2 = "AAB", the output should be
    solution(filename1, filename2) = true.

    Because "AAB" < "aa", but "AAB" > "AA".

    For filename1 = "A" and filename2 = "z", the output should be
    solution(filename1, filename2) = false.

    Both "A" < "z" and "a" < "z".*/
    fun solution58(filename1: String, filename2: String): Boolean {

        val minLength = minOf(filename1.length, filename2.length)
        var less = false
        var i = 0
        while (i < minLength && filename1[i] == filename2[i]) i++
        if (i < minLength)
            less = filename1[i].code < filename2[i].code

        val a = filename1.lowercase()
        val b = filename2.lowercase()
        for (j in i until minLength) {
            if (a[i].code != b[i].code)
                return (a[i].code < b[i].code) xor less
        }
        return (a.length < b.length) xor less
    }
}