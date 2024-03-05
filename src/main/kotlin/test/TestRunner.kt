package test

import java.io.File

private const val taskName = "G"

fun main() {
    runTests()
}

private fun runTests() {

    val inputTaskFilePath = "input.txt"
    val inputTestFilePath = "src/main/kotlin/test/$taskName/input.txt"
    val outputTaskFilePath = "output.txt"
    val outputTestFilePath = "src/main/kotlin/test/$taskName/output.txt"

    val inputTaskFile = File(inputTaskFilePath)
    val inputTestFile = File(inputTestFilePath)
    val outputTaskFile = File(outputTaskFilePath)
    val outputTestFile = File(outputTestFilePath)

    if (!inputTestFile.exists()) {
        inputTestFile.createNewFile()
    }

    if (!outputTestFile.exists()) {
        outputTestFile.createNewFile()
    }

    val inputs = inputTestFile.readText().split("\n\r")
    val outputs = outputTestFile.readText().split("\n\r")
    inputs.forEachIndexed { index, s ->
        val testNumber = index + 1

        clearOutputTaskFile(outputTaskFile)
        rewriteInputTest(s.trim(), inputTaskFile)
        one.main()

        val outputTask = outputTaskFile.readText()
        val outputTest = outputs.getOrNull(index)?.trim()

        if (outputTest == null) {
            emptyTestErrorMessage(testNumber)
            return
        }

        if (outputTest == outputTask) {
            testSuccessMessage(testNumber)
        } else {
            testFailureMessage(testNumber, outputTask, outputTest)
        }

        println("____________________________")
    }
}

private fun rewriteInputTest(
    inputTest: String,
    inputTaskFile: File
) {
    inputTaskFile.writeText(inputTest)
}

private fun clearOutputTaskFile(outputTaskFile: File) {
    outputTaskFile.writeText("")
}

private fun emptyTestErrorMessage(testNumber: Int) {
    println("Тест $testNumber не содержит выходных данных!")
}

private fun testSuccessMessage(testNumber: Int) {
    println("Тест $testNumber прошел успешно!")
}

private fun testFailureMessage(
    testNumber: Int,
    outputTask: String,
    outputTest: String
) {
    println("Тест $testNumber неверный!")
    println("Ожидаемый результат")
    println(outputTest)
    println("Получившийся результат")
    println(outputTask)
}
