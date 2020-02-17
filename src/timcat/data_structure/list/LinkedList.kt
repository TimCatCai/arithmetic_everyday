package timcat.data_structure.list

fun main() {
    val a = ListNode(10, null)
    val b = ListNode(20, null)
    val c = ListNode(30, null)
    val d = ListNode(40, null)
    val e = ListNode(50, null)
    a.next = b
    b.next = c
    c.next = d
    d.next = e
    printLinkedList(a)
    var head = reverseList2(a)
    printLinkedList(head)
}

fun reverseList(head: ListNode?): ListNode? {
    var next: ListNode? = head?.next
    var newHead = head
    head?.next = null
    var afterNext: ListNode?

    while (next != null) {
        afterNext = next.next
        next.next = newHead
        newHead = next
        next = afterNext
    }
    return newHead
}

fun reverseList2(head: ListNode?): ListNode? {
    var listHead = head
    var newHead: ListNode? = null
    var next: ListNode?
    while (listHead != null) {
        next = listHead.next
        listHead.next = newHead
        newHead = listHead
        listHead = next
    }
    return newHead
}

fun printLinkedList(head: ListNode?) {
    var ptr: ListNode? = head
    while (ptr != null) {
        print("${ptr.value} ")
        ptr = ptr.next
    }
    println()
}

data class ListNode(var value: Int, var next: ListNode?)
