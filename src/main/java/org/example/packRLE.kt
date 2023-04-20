package org.example

import java.io.File

class packRLE {




    fun packer(s: String): String {
        if (s == "") return ""
        val res = StringBuilder()
        var count = 0
        var prev = s[0]
        for (sym in s) {
            if (sym != prev) {
                if (count > 1) res.append(count)
                res.append(prev)
                count = 0
                prev = sym
            }
            count++
        }

        if (count > 1) res.append(count)
        res.append(prev)
        return res.toString()
    }


    fun unpacker(s: String): String {
        val res = StringBuilder()
        var i = 0
        while (i in s.indices) {
            val num = s.substring(i).takeWhile { it.isDigit() }
            val count = num.count()
            val char = s[i + count]

            repeat(num.toIntOrNull() ?: 1) { res.append(char) }
            i += 1 + count
        }
        return res.toString()
    }


    fun main(args: Array<String>) {
        Parser.main(args)
    }

    fun RLE(pack: Boolean, inputFile: String, outputFile: String?) {
        val inputStrings = File(inputFile).readLines()
        val outputStream = File(outputFile).bufferedWriter()
        outputStream.use {
            for (str in inputStrings) {
                val newStr = if (pack) packer(str) else unpacker(str)
                it.write(newStr)
                it.newLine()
            }
        }
        println("PackRLE: "+ if (pack) "pack" else "unpack")
    }

}
