fun main() {    
    // write your code here
    val lowHours = readln().toInt()
    val highHours = readln().toInt()
    val currentHours = readln().toInt()

    if (currentHours in lowHours..highHours) {
        println("Normal")
    } else if (currentHours < lowHours) {
        println("Deficiency")
    } else if (currentHours > highHours) {
        println("Excess")
    }
}