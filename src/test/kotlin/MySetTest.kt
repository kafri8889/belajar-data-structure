package test.kotlin

import MySet
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MySetTest {

    @Test
    fun containsTest() {
        MySet<String>().apply {
            add("Rora")
            add("Asa")
            add("Ruka")
            assertTrue(contains("Ruka"))
            assertFalse(contains("Pharita"))
        }
    }

    @Test
    fun addTest() {
        MySet<String>().apply {
            assertTrue(add("Rora"))
            assertTrue(add("Asa"))
            assertFalse(add("Asa"))
            assertTrue(size == 2)
        }
    }

    @Test
    fun indexOfTest() {
        MySet<String>().apply {
            add("Rora")
            add("Asa")
            add("Ruka")
            assertEquals(1, indexOf("Asa"))
        }
    }

    @Test
    fun removeTest() {
        MySet<String>().apply {
            add("Rora")
            add("Asa")
            add("Ruka")
            assertTrue(remove("Asa"))
            assertFalse(remove("Asa"))
        }
    }

}