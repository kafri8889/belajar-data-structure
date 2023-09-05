class BinaryTree<T>(var value: T) {
    var right: BinaryTree<T>? = null
    var left: BinaryTree<T>? = null
}

fun <T> getDepth(root: BinaryTree<T>?): Int {
    if (root == null) return 0

    val lh = getDepth(root.left)
    val rh = getDepth(root.right)

    return if (lh > rh) lh + 1 else rh + 1
}

fun main() {
    val root1 = BinaryTree(1).apply {
        right = BinaryTree(3)
        left = BinaryTree(2).apply {
            right = BinaryTree(5)
            left = BinaryTree(4).apply {
                left = BinaryTree(6).apply {
                    left = BinaryTree(7)
                }
            }
        }
    }

    println(getDepth(root1))
}
