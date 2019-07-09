package fr.liotapsi.jprettylogs.io

import java.io.FileOutputStream
import java.io.OutputStreamWriter

/**
 * the log file handler
 */
class LoggerFileOut(private val path: String?, private val isLogs: Boolean) {

    /**
     * the output stream
     */
    private var out: FileOutputStream = FileOutputStream(this.path)

    /**
     * the file output
     */
    private var writer = OutputStreamWriter(this.out)

    /**
     * print in the file
     */
    fun print(str: String) {
        if (this.isLogs) {
            this.writer.write(str)
            this.writer.flush()
        }
    }

    /**
     * println in the file
     */
    fun println(str: String) {
        if (this.isLogs) {
            this.writer.write("$str\n")
            this.writer.flush()
        }
    }

}