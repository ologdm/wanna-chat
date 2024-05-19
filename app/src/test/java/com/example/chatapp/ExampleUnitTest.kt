package com.example.chatapp

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val list = listOf(1, 2, 3, 4)
            .filter { it % 2 == 0 }

        Assert.assertEquals(listOf(2,4), list)


        Assert.assertEquals(4, 2 + 2)
    }
}