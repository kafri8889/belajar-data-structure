import kotlin.system.measureTimeMillis

// Ex:  O(n), O(n), O(log(n)), O(log(n)), O(2n), dan O(n!)

val list = arrayListOf<Int>()
val arr = Array(1000) { it }

fun main() {
    val o1 = o1()
    val o2N = o2N()
    val oLogN = oLogN()
    val oN = oN()
    val oN2 = oN2()

    println("execution time O(1): $o1")
    println("execution time O(2n): $o2N")
    println("execution time O(log n): $oLogN")
    println("execution time O(n): $oN")
    println("execution time O(n^2): $oN2")
}

fun o1() = measureTimeMillis {
    // O(1)
    print(arr[50])

    // O(2)
    print(arr[30])
    print(arr[768])
}

fun oN() = measureTimeMillis {
    print(" ") // O(1)
    for (i in 0 until 1000) { // O(n)
        print(" ")
    }
    print(" ") // O(1)

    // O(1 + n + 1) = O(2 + n) = O(n)
}

fun o2N() = measureTimeMillis {
    for (i in 0 until 1000) {
        print(" ")
    }

    for (i in 0 until 1000) {
        print(" ")
    }
}

fun oN2() = measureTimeMillis {
    for (i in 0 until 1000) {
        for (j in 0 until 1000) {
            print(" ")
        }
    }
}

// Binary search
fun oLogN() = measureTimeMillis {
    binarySearch(arr, 500, 0, arr.lastIndex)
}
