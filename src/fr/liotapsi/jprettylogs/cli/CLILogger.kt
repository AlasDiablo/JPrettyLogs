package fr.liotapsi.jprettylogs.cli

import fr.liotapsi.jprettylogs.ILogger
import fr.liotapsi.jprettylogs.io.LoggerFileOut
import java.util.*

/**
 *
 */
class CLILogger(private val isError: Boolean,
                private val isInfo: Boolean,
                private val isDebug: Boolean,
                private val isWarning: Boolean,
                private val isCritical: Boolean,
                path: String) : ILogger {

    private val date = Date()
    private val loggerFileOut = LoggerFileOut(path + "free-server-tools_" + this.date.toString() + ".log")

    /**
     *
     */
    override fun critical(msg: String) {
        if (isCritical) {
            val tmp = msg.split("\n")
            val str1 = "${CLIAnsiColor.HIGH_INTENSITY}${CLIAnsiColor.ANSI_RED}    !!!    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}"
            println(str1)
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "${CLIAnsiColor.HIGH_INTENSITY}${CLIAnsiColor.ANSI_RED}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}"
                println(str2)
                loggerFileOut.println(str2)
            }
        }
    }


    /**
     *
     */
    override fun error(msg: String) {
        if (isError) {
            val tmp = msg.split("\n")
            val str1 = "${CLIAnsiColor.LOW_INTESITY}${CLIAnsiColor.ANSI_RED}    [!]    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}"
            println(str1)
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "${CLIAnsiColor.LOW_INTESITY}${CLIAnsiColor.ANSI_RED}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}"
                println(str2)
                loggerFileOut.println(str2)
            }
        }
    }

    /**
     *
     */
    override fun info(msg: String) {
        if (isInfo) {
            val tmp = msg.split("\n")
            val str1 = "${CLIAnsiColor.ANSI_GREEN}    [i]    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}"
            println(str1)
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "${CLIAnsiColor.ANSI_GREEN}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}"
                println(str2)
                loggerFileOut.println(str2)
            }
        }
    }

    /**
     *
     */
    override fun debug(msg: String) {
        if (isDebug) {
            val tmp = msg.split("\n")
            val str1 = "${CLIAnsiColor.ANSI_BLUE}    ...    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}"
            println(str1)
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "${CLIAnsiColor.ANSI_BLUE}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}"
                println(str2)
                loggerFileOut.println(str2)
            }
        }
    }

    /**
     *
     */
    override fun warning(msg: String) {
        if (isWarning) {
            val tmp = msg.split("\n")
            val str1 = "${CLIAnsiColor.ANSI_YELLOW}    /!\\    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}"
            println(str1)
            loggerFileOut.println(str1)
            for (i in 1 until tmp.size step 1) {
                val str2 = "${CLIAnsiColor.ANSI_YELLOW}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}"
                println(str2)
                loggerFileOut.println(str2)
            }
        }
    }
}