fun main() {
    val string = readln()
    // write here
    val lastChunk = string.substringAfterLast('u')
    println(string.replace(lastChunk, lastChunk.uppercase()))
}