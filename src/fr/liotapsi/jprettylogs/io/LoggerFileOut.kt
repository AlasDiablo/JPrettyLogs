package fr.liotapsi.jprettylogs.io

import java.io.FileOutputStream
import java.io.OutputStreamWriter

class LoggerFileOut(private val path: String) {

    private var out: FileOutputStream = FileOutputStream(this.path)
    private var writer = OutputStreamWriter(this.out)

    fun print(str: String) {
        this.writer.write(str)
    }

    fun println(str: String) {
        this.writer.write("$str\n")
    }

}