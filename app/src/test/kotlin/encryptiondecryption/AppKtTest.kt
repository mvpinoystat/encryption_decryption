package encryptiondecryption



import kotlin.test.Test
import kotlin.test.assertEquals

internal class AppKtTest {

    @Test
    fun userInterface01() {
        val commandLine = "-data Pinoystat -mode enc -alg shift -key 1"
        val args = commandLine.split("\\s".toRegex()).toTypedArray()
        val out = userInterface(args)
        assertEquals("Qjopztubu", out)
    }
}