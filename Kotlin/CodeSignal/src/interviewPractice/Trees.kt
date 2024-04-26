package interviewPractice

object Trees {

    data class Tree<T>(var value: T) {
        var left: Tree<T>? = null;
        var right: Tree<T>? = null;
    }

    /**
     * hasPathWithGivenSum
     * @see "https://app.codesignal.com/interview-practice/question/TG4tEMPnAc3PnzRCs/description"
     * @return Given a binary tree t and an integer s, determine whether there is a root to leaf path in t such that the sum of vertex values equals s.

    Example

    For

    t = {
            "value": 4,
            "left": {
                        "value": 1,
                        "left": {
                                    "value": -2,
                                    "left": null,
                                    "right": {
                                                "value": 3,
                                                "left": null,
                                                "right": null
                                                }
                                },
                        "right": null
                    },
            "right": {
                        "value": 3,
                        "left": {
                                    "value": 1,
                                    "left": null,
                                    "right": null
                                },
                        "right": {
                                    "value": 2,
                                    "left": {
                                                "value": -2,
                                                "left": null,
                                                "right": null
                                            },
                                    "right": {
                                                "value": -3,
                                                "left": null,
                                                "right": null
                                            }
                                }
                        }
        }
    and
    s = 7,
    the output should be solution(t, s) = true.

    This is what this tree looks like:

         4
        / \
       1   3
      /   / \
    -2  1   2
      \    / \
      3  -2 -3
    Path 4 -> 3 -> 2 -> -2 gives us 7, the required sum.

    For

    t = {
        "value": 4,
        "left": {
                    "value": 1,
                    "left": {
                                "value": -2,
                                "left": null,
                                "right": {
                                            "value": 3,
                                            "left": null,
                                            "right": null
                                         }
                            },
                    "right": null
                 },
        "right": {
                    "value": 3,
                    "left": {
                                "value": 1,
                                "left": null,
                                "right": null
                            },
                    "right": {
                                "value": 2,
                                "left": {
                                            "value": -4,
                                            "left": null,
                                            "right": null
                                        },
                                "right": {
                                            "value": -3,
                                            "left": null,
                                            "right": null
                                         }
                              }
                    }
        }
    and
    s = 7,
    the output should be solution(t, s) = false.

    This is what this tree looks like:
            4
           / \
          1   3
         /   / \
        -2  1   2
          \    / \
           3  -4 -3
    There is no path from root to leaf with the given sum 7.
     */
    fun solution1(t: Tree<Int>?, s: Int): Boolean {
        if (t == null)
            return false

        return solution2Sum(t!!, s, 0)
    }

    fun solution2Sum(t: Tree<Int>, s: Int, sum: Int): Boolean {
        if (t.left == null && t.right == null) {
            return t.value + sum == s
        }

        if(t.left != null && solution2Sum(t.left!!, s, sum + t.value))
            return true
        if(t.right != null && solution2Sum(t.right!!, s, sum + t.value))
            return true

        return false
    }

    /**
     * isTreeSymmetric
     * @see "https://app.codesignal.com/interview-practice/question/tXN6wQsTknDT6bNrf/description"
     * @return Given a binary tree t, determine whether it is symmetric around its center, i.e. each side mirrors the other.

    Example

    For

    t = {
            "value": 1,
            "left": {
                        "value": 2,
                        "left": {
                                    "value": 3,
                                    "left": null,
                                    "right": null
                                 },
                        "right": {
                                    "value": 4,
                                    "left": null,
                                    "right": null
                                  }
                     },
            "right": {
                        "value": 2,
                        "left": {
                                    "value": 4,
                                    "left": null,
                                    "right": null
                                },
                        "right": {
                                    "value": 3,
                                    "left": null,
                                    "right": null
                                 }
                     }
        }

    the output should be solution(t) = true.

    Here's what the tree in this example looks like:

             1
            / \
           2   2
          / \ / \
         3  4 4  3
    As you can see, it is symmetric.

    For

    t = {
            "value": 1,
            "left": {
                        "value": 2,
                        "left": null,
                        "right": {
                                    "value": 3,
                                    "left": null,
                                    "right": null
                                 }
                     },
            "right": {
                        "value": 2,
                        "left": null,
                        "right": {
                                    "value": 3,
                                    "left": null,
                                    "right": null
                                 }
                    }
        }
    the output should be solution(t) = false.

    Here's what the tree in this example looks like:

            1
           / \
          2   2
           \   \
            3    3
    As you can see, it is not symmetric.*/
    fun solution2(t: Tree<Int>?): Boolean {
        if (t == null)
            return true

        if(t.left == null && t.right == null)
            return true

        if(t.left == null || t.right == null)
            return false

        return isTreeSymmetric(t.left!!, t.right!!)
    }

    fun isTreeSymmetric(t1: Tree<Int>, t2: Tree<Int>): Boolean {
        if (t1.value != t2.value) return false

        val leftSymmetric = (t1.left == null && t2.right == null) ||
                (t1.left != null && t2.right != null && isTreeSymmetric(t1.left!!, t2.right!!))

        val rightSymmetric = (t1.right == null && t2.left == null) ||
                (t1.right != null && t2.left != null && isTreeSymmetric(t1.right!!, t2.left!!))

        return leftSymmetric && rightSymmetric
    }
}