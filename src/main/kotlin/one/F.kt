package one

import java.io.File

fun F() {
    val input = File("input.txt").readLines()

    val numbers = input[1].split(" ").map { it.toInt() }
    var a = numbers[0] % 2 == 0

    numbers.drop(1).forEach {
        val b = it % 2 == 0
        if (!(a || b)) {
            print("x")
            a = false
        } else {
            print("+")
            a = a && b
        }
    }
}
