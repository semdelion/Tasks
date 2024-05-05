package theCore

object _16_TimeRiver {
    fun run() {
        println("130) Valid Time\n" +
                "      input: time = \"25:51\" \n" +
                "      result: ${solution130("25:51")}\n")
        println("131) Video Part\n" +
                "      input: part = \"02:20:00\", total = \"07:00:00\"\n" +
                "      result: ${solution131("02:20:00","07:00:00" )}\n")
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
}