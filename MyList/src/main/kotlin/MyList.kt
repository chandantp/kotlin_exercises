package com.chandantp

import sun.text.normalizer.UTF16.append



class MyList<T> private constructor(
    private var first: Node<T>? = null,
    private var last: Node<T>? = null,
    private var count: Int = 0) {

    private class Node<T>(val data: T, var next: Node<T>? = null)

    companion object {
        fun <T> newList(): MyList<T> {
            return MyList()
        }
    }

    fun size(): Int = this.count

    fun isEmpty(): Boolean = (this.count == 0)

    fun add(data: T) {
        val e = Node(data)

        if (this.isEmpty()) {
            first = e
            last = first
        } else {
            last?.next = e
            last = e
        }
        count++
    }

    fun remove(): T? = when (this.size()) {
        0 -> null
        1 -> {
            val data = first?.data
            first = null
            last = null
            count = 0
            data
        }
        else -> {
            val data = first?.data
            first = first?.next
            count--
            data
        }
    }

    override fun toString(): String {
        val buf = StringBuffer("(")
        var curr: Node<T>? = first
        while (curr != null) {
            if (buf.length != 1) buf.append(", ")
            buf.append(curr.data)
            curr = curr.next
        }
        buf.append(")")
        return buf.toString()
    }
}
