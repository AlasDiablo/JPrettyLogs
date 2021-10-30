package fr.liotapsi.jprettylogs.impl

import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.util.*

/**
 * Implementation of File logger
 * @author AlasDiablo
 * @since 3.0.0
 * @param path file folder use to put the log file
 * @param name the name of the file
 * @param critical enable or not critical output
 * @param error enable or not error output
 * @param info enable or not info output
 * @param debug enable or not debug output
 * @param warning enable or not warning output
 */
class FileLogger(
    path: String,
    name: String,
    critical: Boolean = true,
    error: Boolean = true,
    info: Boolean = false,
    debug: Boolean = false,
    warning: Boolean = false
) : SimpleLogger(critical = critical, error = error, info = info, debug = debug, warning = warning) {

    private val writer: OutputStreamWriter

    init {
        val date = Date()
        val dateFileFriendly = date.toString().replace(" ", "_").replace(":", "_")
        val fileName = "${name}_${dateFileFriendly}.log"
        val filePath = File(path, fileName)
        val outputStream = FileOutputStream(filePath)
        this.writer = OutputStreamWriter(outputStream)
    }

    override fun println(message: String) {
        this.writer.write("$message\n")
    }

    override fun printMessage(message: Array<String>, prefix: String) {
        this.println("    $prefix    | ${message[0]}")

        for (i in 1 until message.size step 1)
            this.println("           | ${message[i]}")

        this.writer.flush()
    }
}