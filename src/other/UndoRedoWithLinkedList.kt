package other

class Unre<T> {
    class UnreListNode<T>(var value: T) {
        var next: UnreListNode<T>? = null
        var prev: UnreListNode<T>? = null

        override fun toString(): String {
            return "ListNode(${value}, ${next?.toString()})"
        }
    }

    private var head: UnreListNode<T>? = null
    private var tail: UnreListNode<T>? = null

    fun isEmpty(): Boolean = head == null

    fun canUndo(): Boolean = tail?.prev != null

    fun canRedo(): Boolean = tail?.next != null

    fun add(element: T) {
        UnreListNode(element).let {
            if (isEmpty()) head = it.also { tail = it }
            else it.apply { prev = tail?.apply { next = it.also { tail = it } } }
        }
    }

    fun undo(): T {
        return if (canUndo()) {
            tail = tail!!.prev
            tail!!.value
        } else tail!!.value
    }

    fun redo(): T {
        return if (canRedo()) {
            tail = tail!!.next
            tail!!.value
        } else tail!!.value
    }

}

fun main() {
    val unre = Unre<String>()
    unre.add("Ena")
    unre.add("Enami")
    unre.add("Enami Asa")
    unre.add("Enami Asa <3")

    println(unre.undo()) // "Enami Asa"
    println(unre.undo()) // "Enami"
    println(unre.redo()) // "Enami Asa"
    println(unre.redo()) // "Enami Asa <3"
    unre.undo()
    unre.undo()
    println(unre.undo()) // "Ena"
    println(unre.redo()) // "Enami"
    unre.add("Enami Lisa")
    println(unre.undo()) // Enami
    println(unre.redo()) // Enami Lisa
}
