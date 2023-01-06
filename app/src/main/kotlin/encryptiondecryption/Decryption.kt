package encryptiondecryption

import kotlin.math.abs

fun decryptWithKeyShift(msg:String, key:Int):String {
    var encrypted = ""
    //generate a list of a, b c d up to z
    val codeSmallCaps = ('a'..'z').toList()
    val codeLargeCaps = ('A'..'Z').toList()
    //checker if key is within the range of char values:
    val keys = key % codeSmallCaps.size
    //decrypt now:
    for (ch in msg) {
        when (ch) {
            in codeSmallCaps -> {
                var replacementCharIndex = codeSmallCaps.indexOf(ch) - keys
                if(replacementCharIndex < 0) {
                    replacementCharIndex = abs(replacementCharIndex)
                    encrypted += codeSmallCaps[codeSmallCaps.size-1 +OFFSET- replacementCharIndex]
                }
                else{
                    encrypted += codeSmallCaps[replacementCharIndex]
                }
            }
            in codeLargeCaps -> {
                var replacementCharIndex = codeLargeCaps.indexOf(ch) - keys
                if(replacementCharIndex < 0) {
                    replacementCharIndex = abs(replacementCharIndex)
                    encrypted += codeLargeCaps[ codeLargeCaps.size-1 +OFFSET - replacementCharIndex]
                }
                else{
                    encrypted += codeLargeCaps[replacementCharIndex]
                }
            }
            else -> {
                encrypted += ch
            }
        }

    }
    return encrypted
}
//below uses unicode
fun decryptWithKeyUnicode(msg:String, key:Int):String {
    var decrypted = ""

    for(ch in msg){
        decrypted += (ch.code - key).toChar()
    }

    return decrypted
}
