fun main() {
    // write your code here
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    if (a + b > c && a + c > b && b + c > a) {
        println("YES")
    } else {
        println("NO")
    }
}