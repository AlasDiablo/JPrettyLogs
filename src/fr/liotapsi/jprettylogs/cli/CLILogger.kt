package fr.liotapsi.jprettylogs.cli

import fr.liotapsi.jprettylogs.ILogger

/**
 *
 */
class CLILogger(private val isError: Boolean,
                private val isInfo: Boolean,
                private val isDebug: Boolean,
                private val isWarning: Boolean,
                private val isCritical: Boolean) : ILogger {

    /**
     *
     */
    override fun critical(msg: String) {
        if (isCritical) {
            val tmp = msg.split("\n")
            println("${CLIAnsiColor.HIGH_INTENSITY}${CLIAnsiColor.ANSI_RED}    !!!    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}")
            for (i in 1 until tmp.size step 1) println("${CLIAnsiColor.HIGH_INTENSITY}${CLIAnsiColor.ANSI_RED}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}")
        }
    }


    /**
     *
     */
    override fun error(msg: String) {
        if (isError) {
            val tmp = msg.split("\n")
            println("${CLIAnsiColor.LOW_INTESITY}${CLIAnsiColor.ANSI_RED}    [!]    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}")
            for (i in 1 until tmp.size step 1) println("${CLIAnsiColor.LOW_INTESITY}${CLIAnsiColor.ANSI_RED}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}")
        }
    }

    /**
     *
     */
    override fun info(msg: String) {
        if (isInfo) {
            val tmp = msg.split("\n")
            println("${CLIAnsiColor.ANSI_GREEN}    [i]    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}")
            for (i in 1 until tmp.size step 1) println("${CLIAnsiColor.ANSI_GREEN}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}")
        }
    }

    /**
     *
     */
    override fun debug(msg: String) {
        if (isDebug) {
            val tmp = msg.split("\n")
            println("${CLIAnsiColor.ANSI_BLUE}    ...    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}")
            for (i in 1 until tmp.size step 1) println("${CLIAnsiColor.ANSI_BLUE}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}")
        }
    }

    /**
     *
     */
    override fun warning(msg: String) {
        if (isDebug) {
            val tmp = msg.split("\n")
            println("${CLIAnsiColor.ANSI_YELLOW}    /!\\    | ${tmp[0]}${CLIAnsiColor.ANSI_RESET}")
            for (i in 1 until tmp.size step 1) println("${CLIAnsiColor.ANSI_YELLOW}           | ${tmp[i]}${CLIAnsiColor.ANSI_RESET}")
        }
    }
}