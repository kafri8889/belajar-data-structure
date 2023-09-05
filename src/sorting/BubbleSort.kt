package sorting

private fun swap(arr: Array<Int>, i: Int, j: Int) {
    arr[i] = arr[j].also { arr[j] = arr[i] }
}

fun bubbleSort(arr: Array<Int>) {
    if (arr.size <= 1) return

    while (true) {
        var p2 = 1
        var swapped = false
        for (p1 in arr.indices) {
            if ((arr.getOrNull(p2) ?: break) < arr[p1]) swap(arr, p1, p2).also { swapped = true }
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
