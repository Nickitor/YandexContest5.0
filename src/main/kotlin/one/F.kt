package one

import java.io.File

fun main() {
    val input = File("src/input.txt").readLines()
    val output = File("src/output.txt")

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
