package theCore

import java.time.DayOfWeek

object _16_TimeRiver {
    fun run() {
        println("130) Valid Time\n" +
                "      input: time = \"25:51\" \n" +
                "      result: ${solution130("25:51")}\n")
        println("131) Video Part\n" +
                "      input: part = \"02:20:00\", total = \"07:00:00\"\n" +
                "      result: ${solution131("02:20:00","07:00:00" )}\n")
        println("132) Day of Week\n" +
                "      input: birthdayDate = \"02-01-2016\"\n" +
                "      result: ${solution132("02-01-2016" )}\n")
    }

    /**
     * Valid Time
     * @see "https://app.codesignal.com/arcade/code-arcade/time-river/ywMyCTspqGXPWRZx5"
     * @return Valid Time
     * * @sample Check if the given string is a correct time representation of the 24-hour clock.

    Example

    For time = "13:58", the output should be
    solution(time) = true;
    For time = "25:51", the output should be
    solution(time) = false;
    For time = "02:76", the output should be
    solution(time) = false.
     */
    fun solution130(time: String): Boolean {
        val regex = Regex("^((([0-1]\\d)|2[0-3]):([0-5]\\d))$")
        return regex.findAll(time).count() == 1
    }

    /**
     * Video Part
     * @see "https://app.codesignal.com/arcade/code-arcade/time-river/DKjM5qLz5ccK2ukhH"
     * @return Video Part
     * * @sample You have been watching a video for some time. Knowing the total video duration find out what portion of the video you have already watched.

    Example

    For part = "02:20:00" and total = "07:00:00", the output should be
    solution(part, total) = [1, 3].

    You have watched 1 / 3 of the whole video.
     */
    fun solution131(part: String, total: String): MutableList<Int> {
        val partSplit = part.split(':')
        val totalSplit = total.split(':')
        val partSeconds = partSplit[0].toInt() * 3600 + partSplit[1].toInt() * 60 + partSplit[2].toInt()
        val totalSeconds = totalSplit[0].toInt() * 3600 + totalSplit[1].toInt() * 60 + totalSplit[2].toInt()
        val gcd = gcd(partSeconds, totalSeconds)
        return mutableListOf(partSeconds/gcd,totalSeconds/gcd)
    }

    private fun gcd(a1: Int, b1: Int): Int {
        var a = a1
        var b = b1
        while (b != 0 && a != 0) {
            if(a > b)
                a %= b
            else
                b %= a
        }
        return a + b
    }

    /**
     * Day of Week
     * @see "https://app.codesignal.com/arcade/code-arcade/time-river/Xg8AXfc4hHeebq4se"
     * @return Day of Week
     * * @sample Whenever you decide to celebrate your birthday you always do this your favorite café, which is quite popular and as such usually very crowded. This year you got lucky: when you and your friend enter the café you're surprised to see that it's almost empty. The waiter lets slip that there are always very few people on this day of the week.

    You enjoyed having the café all to yourself, and are now curious about the next time you'll be this lucky. Given the current birthdayDate, determine the number of years until it will fall on the same day of the week.

    For your convenience, here is the list of months lengths (from January to December, respectively):

    Months lengths: 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31.
    Please, note that in leap years February has 29 days. If your birthday is on the 29th of February, you celebrate it once in four years. Otherwise you birthday is celebrated each year.

    Example

    For birthdayDate = "02-01-2016", the output should be
    solution(birthdayDate) = 5.

    February 1 in 2016 is a Monday. The next year in which this same date will be Monday too is 2021. 2021 - 2016 = 5, which is the answer.

    Input/Output

    [execution time limit] 3 seconds (kt)

    [memory limit] 1 GB

    [input] string birthdayDate

    A string representing the correct date in the format mm-dd-yyyy, where mm is the number of month (1-based, i.e. 01 for January, 02 for February and so on), dd is the day, and yyyy is the year.

    Guaranteed constraints:
    1 ≤ int(mm) ≤ 12,
    1 ≤ int(dd) ≤ 31,
    1900 ≤ int(yyyy) ≤ 2100.

    [output] integer

    An integer describing the number of years until your birthday falls on the same day of the week */
    fun solution132(birthdayDate: String): Int {
        val formatter = java.time.format.DateTimeFormatter.ofPattern("MM-dd-yyyy")
        val birthDate = java.time.LocalDate.parse(birthdayDate, formatter)
        val birthDayOfWeek = birthDate.dayOfWeek
        var yearsPassed = 1

        while (true) {
            val nextBirthday = birthDate.plusYears(yearsPassed.toLong())

            // Проверяем, високосный ли год, если дата 29 февраля
            if (birthDate.monthValue == 2 && birthDate.dayOfMonth == 29 && !nextBirthday.isLeapYear) {
                yearsPassed++
                continue
            }

            if (nextBirthday.dayOfWeek == birthDayOfWeek) {
                return yearsPassed
            }
            yearsPassed++
        }
    }
}