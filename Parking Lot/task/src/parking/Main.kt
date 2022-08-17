package parking

var dict = mutableMapOf<Int, ParkingSpot>()

class ParkingSpot(var isFull: Boolean = false) {
    var color = ""
    var regNumber = ""
}

fun park(registration: String, color: String) {

    if(!isCreated()) {
        return
    }

    var counter = 0
    for (spot in dict.keys) {
        if(dict[spot]?.isFull == false) {
            dict[spot]?.isFull = true
            dict[spot]?.regNumber = registration
            dict[spot]?.color = color

            println("$color car parked in spot ${spot}.")
            return
        }

        counter++
    }

    if(counter == dict.size) {
        println("Sorry, the parking lot is full.")
    }
}

fun leave(spot: Int) {

    if(!isCreated()) {
        return
    }

    if(spot in dict) {
        if(dict[spot]?.isFull == true) {
            dict[spot]?.isFull = false
            dict[spot]?.regNumber = ""
            dict[spot]?.color = ""
            println("Spot $spot is free.")
        } else {
            println("There is no car in spot ${spot}.")
        }
    }
}

fun create(totalSpots: Int) {
    if(!dict.isEmpty()) {
        dict = mutableMapOf()
    }

    //render N spots
    for (spot in 1..totalSpots) {
        dict[spot] = ParkingSpot()
    }
    println("Created a parking lot with $totalSpots spots.")
}

fun status() {
    if(!isCreated()) {
        return
    }

    var isEmpty = true;

    for (spot in dict) {
        if (spot.value.isFull) {
            println("${spot.key} ${spot.value.regNumber} ${spot.value.color}")
            isEmpty = false
        }
    }

    if (isEmpty) {
        println("Parking lot is empty.")
    }
}

fun spotByColor(color: String) {
    if(!isCreated()) {
        return
    }

    var colorFound = false
    var printOutput = ""
    for (spot in dict) {
        if (spot.value.color.lowercase() == color.lowercase()) {
            printOutput +="${spot.key}, "
            colorFound = true
        }
    }

    if (!colorFound) {
        println("No cars with color $color were found.")
    } else {
        println(printOutput.substringBeforeLast(", "))
    }

}

fun spotByReg(registration: String) {
    if(!isCreated()) {
        return
    }

    var regFound = false
    var printOutput = ""
    for (spot in dict) {
        if (spot.value.regNumber.lowercase() == registration.lowercase()) {
            printOutput +="${spot.key}, "
            regFound = true
        }
    }

    if (!regFound) {
        println("No cars with registration number $registration were found.")
    } else {
        println(printOutput.substringBeforeLast(", "))
    }
}

fun regByColor(color: String) {
    if(!isCreated()) {
        return
    }

    var colorFound = false
    var printOutput = ""
    for (spot in dict) {
        if (spot.value.color.lowercase() == color.lowercase()) {
            printOutput +="${spot.value.regNumber}, "
            colorFound = true
        }
    }

    if (!colorFound) {
        println("No cars with color $color were found.")
    } else {
        println(printOutput.substringBeforeLast(", "))
    }
}

fun isCreated() : Boolean {
    if(dict.isEmpty()) {
        println("Sorry, a parking lot has not been created.")
        return false
    }
    return true
}

fun main() {
    while(true) {
        val parts = readln().split(" ")
        when (parts[0].lowercase()) {
            "park" -> park(parts[1], parts[2])
            "leave" -> leave(parts[1].toInt())
            "create" -> create(parts[1].toInt())
            "status" -> status()
            "reg_by_color" -> regByColor(parts[1])
            "spot_by_color" -> spotByColor(parts[1])
            "spot_by_reg" -> spotByReg(parts[1])
            "exit" -> break
            else -> continue
        }
    }
}

