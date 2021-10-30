package fr.liotapsi.jprettylogs.impl

import fr.liotapsi.jprettylogs.Logger
import java.io.PrintStream

/**
 * Implementation of Logger
 * @author AlasDiablo
 * @since 3.0.0
 * @param printStream output steam (ex: System.out)
 * @param critical enable or not critical output
 * @param error enable or not error output
 * @param info enable or not info output
 * @param debug enable or not debug output
 * @param warning enable or not warning output
 */
open class SimpleLogger(
    printStream: PrintStream = System.out,
    private val critical: Boolean = true,
    private val error: Boolean = true,
    private val info: Boolean = false,
    private val debug: Boolean = false,
    private val warning: Boolean = false
) : Logger(printStream) {

    protected open fun println(message: String) {
        this.printStream.println(message)
    }

    protected open fun printMessage(message: Array<String>, prefix: String) {
        this.println("    $prefix    | ${message[0]}")

        for (i in 1 until message.size step 1)
            this.println("           | ${message[i]}")
    }

    override fun critical(msg: String) {
        if (this.critical)
            printMessage(msg.split("\n").toTypedArray(), "!!!")
    }

    override fun error(msg: String) {
        if (this.error)
            printMessage(msg.split("\n").toTypedArray(), "[!]")
    }

    override fun info(msg: String) {
        if (this.info)
            printMessage(msg.split("\n").toTypedArray(), "[i]")
    }

    override fun debug(msg: String) {
        if (this.debug)
            printMessage(msg.split("\n").toTypedArray(), "...")
    }

    override fun warning(msg: String) {
        if (this.warning)
            printMessage(msg.split("\n").toTypedArray(), "/!\\")
    }
}