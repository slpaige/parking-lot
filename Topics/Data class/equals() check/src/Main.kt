data class Client(val name: String, val age: Int, val balance: Int){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }
}

fun main() {

    //implement your code here
    val input1 = readln()
    val input2 = readln().toInt()
    val input3 = readln().toInt()
    val client1 = Client(input1, input2, input3)

    val input4 = readln()
    val input5 = readln().toInt()
    val input6 = readln().toInt()

    val client2 = Client(input4, input5, input6)
    println(client1.equals(client2))
}