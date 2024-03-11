package theCore

object TMP {

    fun run() {
        println("89 Array Previous Less: ${TMP.solution89(mutableListOf(3, 5, 2, 4, 5))}")
        println("90 Pair of Shoes: ${TMP.solution90(mutableListOf(
            mutableListOf(0, 21),
            mutableListOf(1, 23),
            mutableListOf(1, 21),
            mutableListOf(0, 23)
        ))}")

       // println("91 Array Previous Less: ${TMP.solution91(mutableListOf(3, 5, 2, 4, 5))}")
    }

    /**
     * Array Previous Less
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/MQg7s3dKrP4caN42A"
     * @return Array Previous Less
     * * @sample Given array of integers, for each position i, search among the previous positions for the last (from the left) position that contains a smaller value. Store this value at position i in the answer. If no such value can be found, store -1 instead.

    Example

    For items = [3, 5, 2, 4, 5], the output should be
    solution(items) = [-1, 3, -1, 2, 4].*/
    fun solution89(items: MutableList<Int>): MutableList<Int> {
        var flag = false
        for (i in items.size - 1 downTo 0) {
            for (j in i - 1 downTo 0) {
                if(items[j] < items[i]) {
                    items[i] = items[j]
                    flag = true
                    break
                }
            }
            if (!flag)
                items[i] = -1

            flag = false
        }
        items[0] = -1
        return items
    }


    /**
     * Pair of Shoes
     * @see "https://app.codesignal.com/arcade/code-arcade/spring-of-integration/picP24ieQnuqR4kxJ"
     * @return Pair of Shoes
     * * @sample     Yesterday you found some shoes in the back of your closet. Each shoe is described by two values:

    type indicates if it's a left or a right shoe;
    size is the size of the shoe.
    Your task is to check whether it is possible to pair the shoes you found in such a way that each pair consists of a right and a left shoe of an equal size.

    Example

    For

    shoes = [[0, 21],
    [1, 23],
    [1, 21],
    [0, 23]]
    the output should be
    solution(shoes) = true;

    For

    shoes = [[0, 21],
    [1, 23],
    [1, 21],
    [1, 23]]
    the output should be
    solution(shoes) = false*/
    fun solution90(shoes: MutableList<MutableList<Int>>): Boolean {
        while (shoes.size > 0) {
            var shoeIndex: Int? = null
            for (i in 1 until shoes.size) {
                if(shoes[i][0] == (shoes[0][0]+1) % 2 && shoes[i][1] == shoes[0][1]) {
                    shoeIndex = i
                    break
                }
            }
            if (shoeIndex == null)
                return false
            shoes.removeAt(shoeIndex)
            shoes.removeAt(0)
        }
        return true
    }

}