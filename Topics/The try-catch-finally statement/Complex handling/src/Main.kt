import java.io.IOException
import java.lang.ArithmeticException

fun suspiciousFunction (param: Int) {
    when (param) {
        0 -> throw Exception("Some exceptions?")
        1 -> throw ArithmeticException("Division by zero")
        2 -> throw Exception("An exception occurred here")
        3 -> throw IOException()
    }
}        

fun handleException (data: Int) {

    try {
        suspiciousFunction(data)
    } catch(e1: ArithmeticException) {
        println(e1.message)
    } catch(e2: IOException) {
        println("The IOException occurred")
    } catch(e3: Exception) {
        println(e3.message)
    } finally {
        println("Handling completed successfully!")
    }
}