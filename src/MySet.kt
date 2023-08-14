class MySet<T> {

    private var arr: Array<T?> = arrayOfNulls<Any?>(5) as Array<T?>

    var size = 0
        private set

    private fun ensureCapacity() {
        if (size >= arr.size) {
            val newArr = arrayOfNulls<Any?>(size * 2) as Array<T?>
            for ((i, e) in arr.withIndex()) newArr[i] = e
        }
    }

    fun indexOf(t: T): Int {
        for ((i, t1) in arr.withIndex()) if (t1 == t) return i
        return -1
    }

    fun contains(t: T): Boolean {
        for (t1 in arr) if (t1 == t) return true
        return false
    }

    fun add(t: T): Boolean {
        if (!contains(t)) {
            ensureCapacity()

            arr[size] = t
            size++
            return true
        }

        return false
    }

    fun remove(t: T): Boolean {
        if (contains(t)) {
            val index = indexOf(t)
            for (i in index until arr.size) arr[i] = arr.getOrNull(i + 1)

            return true
        }

        return false
    }

}