package sorting
fun swap(arr: IntArray, i: Int, j: Int) {
    arr[i] = arr[j].also { arr[j] = arr[i] }
}

fun partitionIndex(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1

    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            swap(arr, i, j)
        }
    }

    swap(arr, i + 1, high)
    return i + 1
}

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val index = partitionIndex(arr, low, high)

        quickSort(arr, low, index - 1)
        quickSort(arr, index + 1, high)
    }
}

