package other

class BrowserHistory(homepage: String) {

    private class DoublyListNode(var value: String) {
        var next: DoublyListNode? = null
        var prev: DoublyListNode? = null
    }

    // [2, 1, 3]

    // Node awal, contoh: 2
    private var head: DoublyListNode? = null

    // Node akhir, contoh: 3
    // Untuk kasus ini, tail adalah url yang sedang dikunjungi
    private var tail: DoublyListNode? = null

    init { visit(homepage) }

    // Menambahkan node di akhir
    fun visit(url: String) {
        // Node saat ini
        val node = DoublyListNode(url)

        // Jika head == null, berarti linked list ini masih kosong
        if (head == null) {
            head = node
            // Karena hanya ada 1 node, maka node akhir adalah "head"
            tail = node
        } else {
            // Jika head != null, berarti sudah ada node di linked list ini
            // Karena kita akan menambahkan node baru di akhir, maka previous node dari node saat ini adalah "tail"
            node.prev = tail

            // Menambahkan node baru
            // Contoh: [2, 1] + [3]
            //       : [2, 1, 3] | "tail" masih di 1
            tail?.next = node

            // Ubah value tail dengan node saat ini
            tail = node // tail = 3
        }
    }

    fun back(steps: Int): String {
        // Buat variable mSteps
        var mSteps = steps
        // Buat variabel untuk current node
        var curr = tail

        // Ketika mSteps != 0, ulangi
        while (mSteps != 0) {
            // Jika previous node dari current node null
            // Berarti current node ini adalah "head"
            // Maka henntikan iterasi
            if (curr?.prev == null) break

            // Ganti current node dengan previous node dari current node
            curr = curr.prev
            // Kurangi step
            mSteps--
        }
        tail = curr
        return curr?.value ?: ""
    }

    fun forward(steps: Int): String {
        // Buat variable mSteps
        var mSteps = 0
        // Buat variabel untuk current node
        var curr = tail

        // Ketika mSteps lebih kecil daripada steps, ulangi
        while (mSteps < steps) {
            // Jika next node dari current node null
            // Berarti current node saat ini adalah node terakhir
            // Maka henntikan iterasi
            if (curr?.next == null) break

            // Ganti current node dengan next node dari current node
            curr = curr.next
            // Tambahkan step
            mSteps++
        }
        tail = curr
        return curr?.value ?: ""
    }
}

fun main() {
    BrowserHistory("a").apply {
        visit("b")
        visit("c")
    }
}
