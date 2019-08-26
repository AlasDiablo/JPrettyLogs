package fr.liotapsi.jprettylogs.file

import fr.liotapsi.jprettylogs.ILogger
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.util.*

class FileLogger(
    path: String,
    private val soft_name: String) : ILogger {

    /**
     * the output stream
     */
    private val out: FileOutputStream

    /**
     * the file output
     */
    private val writer: OutputStreamWriter

    /**
     * variable and constant initialization
     */
    init {
        val date = Date();
        val outFileName: String = path + "${this.soft_name}_$date.log".replace(" ", "_").replace(":", "_")
        this.out = FileOutputStream(outFileName)
        this.writer = OutputStreamWriter(this.out)
    }

    override fun error(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    [!]    | ${tmp[0]}"
        this.writer.write(str1)
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.writer.write(str2)
        }
        this.writer.flush()
    }

    override fun info(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    [i]    | ${tmp[0]}"
        this.writer.write(str1)
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.writer.write(str2)
        }
        this.writer.flush()
    }

    override fun debug(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    ...    | ${tmp[0]}"
        this.writer.write(str1)
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.writer.write(str2)
        }
        this.writer.flush()
    }

    override fun warning(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    /!\\    | ${tmp[0]}"
        this.writer.write(str1)
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.writer.write(str2)
        }
        this.writer.flush()
    }

    override fun critical(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    !!!    | ${tmp[0]}"
        this.writer.write(str1)
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            this.writer.write(str2)
        }
        this.writer.flush()
    }
}