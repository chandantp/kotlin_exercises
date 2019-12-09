package com.chandantp

import io.kotlintest.matchers.types.shouldBeNull
import io.kotlintest.should
import io.kotlintest.specs.StringSpec
import io.kotlintest.shouldBe

class MyListTests : StringSpec({

    "Empty list size should be 0" {
        MyList.newList<Int>().size() shouldBe 0
    }

    "Empty list string representation should be ()" {
        MyList.newList<Int>().toString() shouldBe "()"
    }

    "Remove operation on empty list returns null" {
        MyList.newList<Int>().remove().shouldBeNull()
    }

    "Non-empty list should have correct non-zero size" {
        val x = MyList.newList<Int>()
        x.add(1)
        x.size() shouldBe 1
        x.add(2)
        x.size() shouldBe 2

        x.toString() shouldBe "(1, 2)"
    }

    "List that is emptied using remove operation should have size 0" {
        val x = MyList.newList<Int>()
        x.add(1)
        x.size() shouldBe 1
        x.add(2)
        x.size() shouldBe 2

        val a = x.remove()
        x.size() shouldBe 1
        a shouldBe 1
        val b = x.remove()
        x.size() shouldBe 0
        b shouldBe 2
    }

})