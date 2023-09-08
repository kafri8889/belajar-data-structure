package sorting

/*
    KODE YANG DISEDERHANAKAN
*/

/**
 * Swap value dari index i ke j, dan index j ke i
 */
private fun swap(arr: Array<Int>, i: Int, j: Int) {
    val temp = arr[i] // simpan nilai arr[i] ke dalam variable temp
    arr[i] = arr[j] // ganti nilai di index ke-i dengan nilai di index ke-j
    arr[j] = temp // ganti nilai di index j dengan nilai dari variable temp (nilai di index ke-i sebelum diubah)
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
fun simpledBubbleSort(arr: Array<Int>, ascending: Boolean = true) {
    // Jika array kosong atau hanya berisi satu elemen saja, batalkan penyortiran
    if (arr.size <= 1) return

    // Iterasi sebanyak size array
    // Variable "x" tidak dipakai
    for (x in 0 until arr.size) {
        for (i in 0 until arr.size) {
            // Jika "i" adalah index terakhir, maka hentikan perulangan
            // Jika tidak dihentikan, maka akan terjadi error IndexOutOfBoundsException di bagian "arr[i + 1]"
            if (i == arr.size - 1) break

            // Cek apakah kedua nilai harus di tukar
            val shouldSwap = shouldSwap(arr[i + 1], arr[i], ascending)

            // Jika kedua nilai harus ditukar, maka tukar kedua nilai tersebut
            if (shouldSwap) swap(arr, i, i + 1)
        }
    }
}
