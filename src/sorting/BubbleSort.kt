package sorting

/**
 * Swap value dari index i ke j, dan index j ke i
 */
private fun swap(arr: Array<Int>, i: Int, j: Int) {
    arr[i] = arr[j].also { arr[j] = arr[i] }
}

/**
 * Cek apakah kedua nilai [n1] dan [n2] harus ditukar
 *
 * @param n1 nilai ke-1
 * @param n2 nilai ke-2
 * @param ascending sort order
 *
 * @return true jika kedua nilai tersebut harus ditukar, false otherwise
 */
private fun shouldSwap(n1: Int, n2: Int, ascending: Boolean): Boolean = if (ascending) n1 < n2 else n1 > n2

/**
 * @param arr array
 * @param ascending sort order, ascending (true) smallest to greatest, descending (false) otherwise
 */
fun bubbleSort(arr: Array<Int>, ascending: Boolean = true) {
    if (arr.size <= 1) return

    for (x in arr.indices) {
        for (i in arr.indices) {
            if (i == arr.size - 1) break
            if (shouldSwap(arr[i + 1], arr[i], ascending)) swap(arr, i, i + 1)
        }
    }
}

fun main() {
    val arr = arrayOf(6,2,1,5,4,3)
//    val arr = arrayOf(1,2,3,4,5,6)
    bubbleSort(arr)
    println(arr.contentDeepToString())
}
