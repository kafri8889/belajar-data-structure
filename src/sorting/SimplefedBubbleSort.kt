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

    while (true) {
        // Pointer 2
        var p2 = 1
        // Untuk pengecekan jika swapped == false, berarti semua nilainya sudah di sort, maka hentikan loop
        var swapped = false
        // p1: Pointer 1
        for (p1 in arr.indices) {
            // Jika nilai n1 itu null, maka hentikan perulangan (for loop)
            // mengapa nilai n1 bisa null?, karena saat nilai p1 berada di index terakhir
            // index p2 berada di "p1 + 1", saat kita mencoba untuk mendapatkan nilai di index p2
            // maka akan terjadi error IndexOutOfBoundsException, hal inilah yang menyebabkan nilai n1 bisa null
            val n1 = arr.getOrNull(p2) ?: break
            val n2 = arr[p1]
            // Cek apakah kedua nilai harus di tukar
            val shouldSwap = shouldSwap(n1, n2, ascending)

            // Jika kedua nilai harus ditukar, maka tukar kedua nilai tersebut
            // lalu ganti nilai variable "swapped" menjadi true
            if (shouldSwap) {
                swap(arr, p1, p2)
                swapped = true // Ubah nilai variabel "swapped" ke true, karena terjadi pertukaran nilai
            }

            p2++
        }

        // Jika swapped bernilai false, maka tidak terjadi penukaran
        // hal ini menandakan bahwa elemen-elemen didalam array sudah diurutkan
        if (!swapped) break
    }
}
