package encryptiondecryption

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DecryptionTest {
    @Test
    fun testDecryptUnicode(){
        val out = decryptWithKeyUnicode("a~\u0085\u0085\u0088", 25)
        assertEquals("Hello", out)
    }

    @Test
    fun testDecryptionUnicode2(){
        val out = decryptWithKeyUnicode("Ifmmp", 1)
        assertEquals("Hello", out)
    }

    @Test
    fun testDecryptionShift(){
        val out = decryptWithKeyShift("ZaBc", 25)
        assertEquals("AbCd", out)
    }

    @Test
    fun testDecryptionShift2(){
        val out = decryptWithKeyShift("Qjopztubu", 1)
        assertEquals("Pinoystat", out)
    }
}