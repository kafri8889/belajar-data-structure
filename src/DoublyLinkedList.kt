class DoublyLinkedList<E> {
    private var head: DoublyListNode<E>? = null
    private var tail: DoublyListNode<E>? = null

    var size = 0

    fun isEmpty(): Boolean = size == 0

//    fun contains(e: E): Boolean = indexOf(e) != -1

    fun addFirst(e: E) {
        head = DoublyListNode(e).apply {
            next = head
            head?.prev = this

            if (isEmpty()) tail = this
        }

        size++
    }

    fun addLast(e: E) {
        DoublyListNode(e).let { node ->
            if (isEmpty()) head = node.also { tail = it }
            else tail?.next = node.also { tail = node }
        }

        size++
    }

    override fun toString(): String {
        var string = "["
        var currNode: DoublyListNode<E>? = head
        while (currNode != null) {
            string += "${currNode.value}${if (currNode.next != null) ", " else ""}"
            currNode = currNode.next
        }
        return "$string]"
    }
}

class DoublyListNode<E>(var value: E) {
    var next: DoublyListNode<E>? = null
    var prev: DoublyListNode<E>? = null

    override fun toString(): String {
        return "DoublyListNode(${prev?.toString()}, ${value}, ${next?.toString()})"
    }
}

fun main() {
    val dll = DoublyLinkedList<Int>()

    dll.addFirst(1)
    dll.addFirst(2)
    println(dll)
}
