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
private fun shouldSwap(n1: Int, n2: Int, ascending: Boolean): Boolean {
    return if (ascending) n1 < n2 else n1 > n2
}

/**
 * @param arr array
 * @param ascending sort order, ascending (true) smallest to greatest, descending (false) otherwise
 */
fun bubbleSort(arr: Array<Int>, ascending: Boolean = true) {
    if (arr.size <= 1) return

    while (true) {
        // Pointer 2
        var p2 = 1
        // Untuk pengecekan jika swapped == false, berarti semua nilainya sudah di sort, maka hentikan loop
        var swapped = false
        // p1: Pointer 1
        for (p1 in arr.indices) {
            if (shouldSwap((arr.getOrNull(p2) ?: break), arr[p1], ascending)) swap(arr, p1, p2).also { swapped = true }
            p2++
        }
        if (!swapped) break
    }
}

fun main() {
    val arr = arrayOf(6,2,1,5,4,3)
    bubbleSort(arr)
    println(arr.contentDeepToString())
}
