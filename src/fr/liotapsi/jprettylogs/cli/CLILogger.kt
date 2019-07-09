package fr.liotapsi.jprettylogs.cli

import fr.liotapsi.jprettylogs.ILogger
import fr.liotapsi.jprettylogs.io.LoggerFileOut
import java.util.*

/**
 * the main class for call and build the logger
 */
class CLILogger(private val isError: Boolean,
                private val isInfo: Boolean,
                private val isDebug: Boolean,
                private val isWarning: Boolean,
                private val isCritical: Boolean,
                path: String?,
                logName: String?) : ILogger {


    /**
     * the day for the execution
     */
    private val date = Date()

    /**
     * the file stream output
     */
    private val loggerFileOut: LoggerFileOut

    init {
        if (path != null)
            this.loggerFileOut = LoggerFileOut("$path${logName}_${this.date.toString()}.log".replace(" ", "_").replace(":", "_"), true)
        else
            loggerFileOut = LoggerFileOut(null, false)
    }

    /**
     * print a log
     */
    override fun critical(msg: String) {
        if (isCritical) {
            val tmp = msg.split("\n")
            val str1 = "    !!!    | ${tmp[0]}"
            println("${CLIAnsiColor.HIGH_INTENSITY}${CLIAnsiColor.ANSI_RED} $str1 ${CLIAnsiColor.ANSI_RESET}")
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "           | ${tmp[i]}"
                println("${CLIAnsiColor.HIGH_INTENSITY}${CLIAnsiColor.ANSI_RED} $str2 ${CLIAnsiColor.ANSI_RESET}")
                loggerFileOut.println(str2)
            }
        }
    }


    /**
     * print a log
     */
    override fun error(msg: String) {
        if (isError) {
            val tmp = msg.split("\n")
            val str1 = "    [!]    | ${tmp[0]}"
            println("${CLIAnsiColor.LOW_INTESITY}${CLIAnsiColor.ANSI_RED} $str1 ${CLIAnsiColor.ANSI_RESET}")
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "           | ${tmp[i]}"
                println("${CLIAnsiColor.LOW_INTESITY}${CLIAnsiColor.ANSI_RED} $str2 ${CLIAnsiColor.ANSI_RESET}")
                loggerFileOut.println(str2)
            }
        }
    }

    /**
     * print a log
     */
    override fun info(msg: String) {
        if (isInfo) {
            val tmp = msg.split("\n")
            val str1 = "    [i]    | ${tmp[0]}"
            println("${CLIAnsiColor.ANSI_GREEN} $str1 ${CLIAnsiColor.ANSI_RESET}")
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "           | ${tmp[i]}"
                println("${CLIAnsiColor.ANSI_GREEN} $str2 ${CLIAnsiColor.ANSI_RESET}")
                loggerFileOut.println(str2)
            }
        }
    }

    /**
     * print a log
     */
    override fun debug(msg: String) {
        if (isDebug) {
            val tmp = msg.split("\n")
            val str1 = "    ...    | ${tmp[0]}"
            println("${CLIAnsiColor.ANSI_BLUE} $str1 ${CLIAnsiColor.ANSI_RESET}")
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "           | ${tmp[i]}"
                println("${CLIAnsiColor.ANSI_BLUE} $str2 ${CLIAnsiColor.ANSI_RESET}")
                loggerFileOut.println(str2)
            }
        }
    }

    /**
     * print a log
     */
    override fun warning(msg: String) {
        if (isWarning) {
            val tmp = msg.split("\n")
            val str1 = "    /!\\    | ${tmp[0]}"
            println("${CLIAnsiColor.ANSI_YELLOW} $str1 ${CLIAnsiColor.ANSI_RESET}")
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "           | ${tmp[i]}"
                println("${CLIAnsiColor.ANSI_YELLOW} $str2 ${CLIAnsiColor.ANSI_RESET}")
                loggerFileOut.println(str2)
            }
        }
    }
}