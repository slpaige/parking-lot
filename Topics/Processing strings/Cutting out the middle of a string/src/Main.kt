fun main() {
    // write your code here
    val input = readln()

    if (input.length % 2 == 0) {
        val mid = input.length / 2
        val range = mid - 1..mid
        println(input.removeRange(range))
    } else {
        val middle = input.length / 2
        val range = middle..middle
        println(input.removeRange(range))
    }
}