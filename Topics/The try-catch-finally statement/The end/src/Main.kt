import java.lang.Exception

fun solution() {
    // write here
    try {
        val num1 = readln().toInt()
        val num2 = readln().toInt()

        val total = num1 / num2

        println(total)

    } catch (e1: Exception) {
        println(e1.message)
    } finally {
        println("This is the end, my friend.")
    }




}