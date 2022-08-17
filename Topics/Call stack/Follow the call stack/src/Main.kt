fun printIfPrime(number: Int) {
    // write here
    var flag = false
    for (i in 2..number / 2) {
        // condition for nonprime number
        if (number % i == 0) {
            flag = true
            break
        }
    }

    if (!flag)
        println("$number is a prime number.")
    else
        println("$number is not a prime number.")
}

fun main(args: Array<String>) {
    // write here
    val input = readln().toInt()
    printIfPrime(input)
}