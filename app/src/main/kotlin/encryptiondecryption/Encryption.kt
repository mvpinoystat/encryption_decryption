package encryptiondecryption


//below uses unicode
fun encryptWithKeyUnicode(msg:String, key:Int):String {
    var encrypted = ""
    //encrypt now:

    for (ch in msg) {
        encrypted += (ch.code + key).toChar()

    }
    return encrypted
}
fun encryptManualMessage(message:String):String {
    var encrypted = ""
    val code = mutableListOf<Char>()
    var i = 'a'
    while (i <= 'z') {
        code.add(i)
        i++
    }

    //set now the encryption:
    for (m in message) {
        encrypted += if(m in code) {
            val index = code.indexOf(m)
            code[code.size-1-index]
        } else{
            m
        }
    }

    return encrypted
}
//below uses caesar algo shift
fun encryptWithKeyShift(msg:String, key:Int):String {
    var encrypted = ""
    //generate a list of a, b c d up to z
    val codeSmallCaps = ('a'..'z').toList()
    val codeLargeCaps = ('A'..'Z').toList()
    //check key if  key is within range:
    val keys = key % codeSmallCaps.size
    //encrypt now:
    for (ch in msg) {
        when(ch) {
            in codeSmallCaps -> {
                /** get the index of the replacement character
                 * Here, we add 1 since the index starts at 0.
                 * Then we subtract 1 again after getting the remainder
                 */

                var replacementCharIndex = codeSmallCaps.indexOf(ch) + keys + OFFSET
                replacementCharIndex = (replacementCharIndex % codeSmallCaps.size) - OFFSET
                encrypted += codeSmallCaps[replacementCharIndex]
            }

            in codeLargeCaps -> {
                /** get the index of the replacement character
                 * Here, we add 1 since the index starts at 0.
                 * Then we subtract 1 again after getting the remainder
                 */
                var replacementCharIndex = codeLargeCaps.indexOf(ch) + keys + OFFSET
                replacementCharIndex = (replacementCharIndex % codeLargeCaps.size) - OFFSET
                encrypted += codeLargeCaps[replacementCharIndex]
            }
            else -> {
                encrypted += ch
            }
        }
    }
    return encrypted
}

