package one

import java.io.FileOutputStream

fun print(str: String) {
    FileOutputStream("src/output.txt", true).bufferedWriter().use { writer ->
        writer.write(str)
    }
}

fun println(str: String) {
    FileOutputStream("src/output.txt", true).bufferedWriter().use { writer ->
        writer.write(str + "\n")
    }
}
