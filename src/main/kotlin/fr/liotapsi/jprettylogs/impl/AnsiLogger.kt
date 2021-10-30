package fr.liotapsi.jprettylogs.impl

import fr.liotapsi.jprettylogs.Logger
import fr.liotapsi.jprettylogs.utils.AnsiCode
import java.io.PrintStream

/**
 * Implementation of Logger with Ansi handling
 * @author AlasDiablo
 * @since 3.0.0
 * @param printStream output steam (ex: System.out)
 * @param critical enable or not critical output
 * @param error enable or not error output
 * @param info enable or not info output
 * @param debug enable or not debug output
 * @param warning enable or not warning output
 */
class AnsiLogger(
    printStream: PrintStream,
    private val critical: Boolean = true,
    private val error: Boolean = true,
    private val info: Boolean = false,
    private val debug: Boolean = false,
    private val warning: Boolean = false
) : Logger(printStream) {

    private fun println(message: String) {
        this.printStream.println(message)
    }

    private fun printMessage(
        message: Array<String>,
        prefix: String,
        colorCode: AnsiCode,
        intensityCode: AnsiCode? = null
    ) {
        val intensity = when (intensityCode) {
            null -> ""
            else -> intensityCode.code
        }
        val color = colorCode.code
        val reset = AnsiCode.RESET.code

        this.println("${intensity}${color}    $prefix    | ${message[0]}${reset}")

        for (i in 1 until message.size step 1)
            this.println("${intensity}${color}           | ${message[i]}${reset}")
    }

    override fun critical(msg: String) {
        if (this.critical)
            printMessage(
                msg.split("\n").toTypedArray(),
                "!!!",
                AnsiCode.RED,
                AnsiCode.HIGH_INTENSITY
            )
    }

    override fun error(msg: String) {
        if (this.error)
            printMessage(
                msg.split("\n").toTypedArray(),
                "[!]",
                AnsiCode.RED,
                AnsiCode.LOW_INTENSITY
            )
    }

    override fun info(msg: String) {
        if (this.info)
            printMessage(
                msg.split("\n").toTypedArray(),
                "[i]",
                AnsiCode.GREEN,
            )
    }

    override fun debug(msg: String) {
        if (this.debug)
            printMessage(
                msg.split("\n").toTypedArray(),
                "...",
                AnsiCode.BLUE,
            )
    }

    override fun warning(msg: String) {
        if (this.warning)
            printMessage(
                msg.split("\n").toTypedArray(),
                "/!\\",
                AnsiCode.YELLOW,
            )
    }
}