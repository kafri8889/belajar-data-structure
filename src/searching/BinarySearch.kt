package searching

import kotlin.system.measureNanoTime

// Binary search is faster than linear search except for small arrays.
// However, the array must be sorted first to be able to apply binary search.
// There are specialized data structures designed for fast searching,
// such as hash tables, that can be searched more efficiently than binary search.

val arr_s_10m = Array(10_000_000) { it }

fun main() {
    val bins = measureNanoTime { // Ex: 25_567_000
        println("found the index: ${binarySearch(arr_s_10m, 5000000, 0, arr_s_10m.lastIndex)}")
    }

    val lins = measureNanoTime { // Ex: 26_023_300
        println("found the index: ${linearSearch(arr_s_10m, 5000000)}")
    }

    println("binary search vs linear search: $bins : $lins")
}

fun <T: Comparable<T>> binarySearch(array: Array<T>, x: T, low: Int, high: Int): Int {
    val mid = (low + high) / 2

    return when {
        array[mid] == x -> mid
        array[mid] < x -> binarySearch(array, x, mid + 1, high)
        array[mid] > x -> binarySearch(array, x, low, mid - 1)
        else -> -1
    }
}

fun <T: Comparable<T>> linearSearch(array: Array<T>, x: T): Int {
    for (i in array.indices) {
        if (array[i] == x) return i
    }

    return -1
}
