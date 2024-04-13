package graphs

object _1_KingdomRoads {
    fun run() {
        println("1) New Road System\n" +
                "      input: roadRegister = \n" +
                "             ${mutableListOf(false, true,  false, false)} \n" +
                "             ${mutableListOf(false, false, true,  false)} \n" +
                "             ${mutableListOf(true,  false, false, true)} \n" +
                "             ${mutableListOf(false, false, true,  false)} \n" +
                "      result:${solution1(mutableListOf(
                mutableListOf(false, true,  false, false),
                mutableListOf(false, false, true,  false),
                mutableListOf(true,  false, false, true),
                mutableListOf(false, false, true,  false)
            ))}")
    }

    /**
     * New Road System
     * @see "https://app.codesignal.com/arcade/graphs-arcade/kingdom-roads/nCMisf4ZKpDLdHevE"
     * @return Once upon a time, in a kingdom far, far away, there lived a King Byteasar I. As a kind and wise ruler, he did everything in his (unlimited) power to make life for his subjects comfortable and pleasant. One cold evening a messenger arrived at the king's castle with the latest news: all kings in the Kingdoms Union had started enforcing traffic laws! In order to not lose his membership in the Union, King Byteasar decided he must do the same within his kingdom. But what would the citizens think of it?

    The king decided to start introducing the changes with something more or less simple: change all the roads in the kingdom from two-directional to one-directional (one-way). He personally prepared the roadRegister of the new roads, and now he needs to make sure that the road system is convenient and there will be no traffic jams, i.e. each city has the same number of incoming and outgoing roads. As the Hand of the King, you're the one who he has decreed must check his calculations.

    Example

    For

    roadRegister =
    [false, true,  false, false],
    [false, false, true,  false],
    [true,  false, false, true ],
    [false, false, true,  false]
    the output should be
    solution(roadRegister) = true.

    The cities will be connected as follows:


    Cities 0, 1 and 3 (0-based) have one incoming and one outgoing road, and city 2 has two incoming and two outgoing roads. Thus, the output should be true.

    For

    roadRegister = [[false, true,  false, false, false, false, false],
    [true,  false, false, false, false, false, false],
    [false, false, false, true,  false, false, false],
    [false, false, true,  false, false, false, false],
    [false, false, false, false, false, false, true ],
    [false, false, false, false, true,  false, false],
    [false, false, false, false, false, true,  false]]
    the output should be
    solution(roadRegister) = true.

    The cities will be connected as follows:


    Each city has one incoming and one outgoing road.

    For

    roadRegister = [[false, true,  false],
    [false, false, false],
    [true,  false, false]]
    the output should be
    solution(roadRegister) = false.

    The cities will be connected as follows:


    City 1 has one incoming and no outgoing roads, and city 2 has one outgoing and no incoming roads.
     */
    fun solution1(roadRegister: MutableList<MutableList<Boolean>>): Boolean {
        for(i in 0 until roadRegister.size)
            if (roadRegister[i].count{x -> x } != roadRegister.count{ x -> x[i] })
                return false
        return true
    }
}