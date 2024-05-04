package theCore

object _16_TimeRiver {
    fun run() {
        println("130) Valid Time\n" +
                "      input: time = \"25:51\" \n" +
                "      result: ${solution130("25:51")}\n")
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
}