import java.util.*

class LinkedList<E>() {
    private var head: ListNode<E>? = null
    private var tail: ListNode<E>? = null

    var size = 0

    val ListNode<E>.previous: ListNode<E>?
        get() {
            var currNode: ListNode<E>? = head
            while (currNode != null) {
                if (currNode.next == this) return currNode
                currNode = currNode.next
            }

            return null
        }

    fun isEmpty(): Boolean = size == 0

    fun contains(e: E): Boolean = indexOf(e) != -1

    fun removeFirst() {
        if (head == tail) {
            head = null.also { tail = it }
            return
        }

        // [4, 2, 1, 3, 5]
        // Backup: [2, 1, 3, 5]
        val nextHead = head?.next
        // Unlink
        head?.next = null
        // Change head
        head = nextHead

        size--
    }

    fun removeLast() {
        if (head == tail) {
            head = null.also { tail = it }
            return
        }

        // [2, 1, 3, 5]
        // prev = 3
        val prev = tail?.previous
        // Unlink: [2, 1, 3]->[5]
        tail = prev
        // Remove: [2, 1, 3]
        tail?.next = null
    }

    fun addFirst(e: E) {
        // [2] + [1]
        //     listNode.next = head
        // [2]        ->            [1] = [2, 1] "head" is still at "[1]"
        // Change head: head = [2]

        head = ListNode(e).apply {
            next = head

            if (isEmpty()) tail = this
        }

        size++
    }

    fun addLast(e: E) {
        // [2, 1] + [3]
        //        tail.next = it
        // [2, 1]        ->      [3] = [2, 1, 3] "tail" is still at "[1]"
        // Change tail: it.also { tail = it }

        ListNode(e).let {
            if (isEmpty()) head = it.also { tail = it }
            else tail?.next = it.also { tail = it }
        }

        size++
    }

    fun indexOf(e: E): Int {
        var index = 0
        var currNode: ListNode<E>? = head
        while (currNode != null) {
            if (currNode.value == e) return index
            else currNode = currNode.next
            index++
        }

        return -1
    }

    fun getOrNull(index: Int): E? {
        return try {
            get(index)
        } catch (e: IndexOutOfBoundsException) { null }
    }

    operator fun get(index: Int): E {
        var i = 0
        var currNode: ListNode<E>? = head
        while (currNode != null) {
            if (index == i) return currNode.value
            currNode = currNode.next.also { i++ }
        }

        throw IndexOutOfBoundsException()
    }

    override fun toString(): String {
        var string = "["
        var currNode: ListNode<E>? = head
        while (currNode != null) {
            string += "${currNode.value}${if (currNode.next != null) ", " else ""}"
            currNode = currNode.next
        }
        return "$string]"
    }
}

class ListNode<E>(var value: E) {
    var next: ListNode<E>? = null

    override fun toString(): String {
        return "ListNode(${value}, ${next?.toString()})"
    }
}

fun main() {
    val ll = LinkedList<Int>()

    insert(ll)
    println()
    indexOf(ll)
    println()
    println(ll.contains(1))
    println(ll.contains(20))
    println()
    get(ll)
    println()
    removeFirstAndLast(ll)
}

private fun insert(linkedList: LinkedList<Int>) {
    linkedList.apply {
        addFirst(1) // [1]
        addFirst(2) // [2, 1]
        addLast(3) // [2, 1, 3]
        addFirst(4) // [4, 2, 1, 3]
        addLast(5) // [4, 2, 1, 3, 5]
    }

    println(linkedList)
}

private fun get(linkedList: LinkedList<Int>) {
    println(linkedList[2])
    println(linkedList.getOrNull(100))
}

private fun indexOf(linkedList: LinkedList<Int>) {
    println(linkedList.indexOf(3))
}

private fun removeFirstAndLast(linkedList: LinkedList<Int>) {
    linkedList.removeFirst()
    linkedList.removeLast()
    println(linkedList)
}

fun removeValueAtIndex() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(6).apply {
                            next = ListNode(7)
                        }
                    }
                }
            }
        }
    }

}
