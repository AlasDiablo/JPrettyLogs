package fr.liotapsi.jprettylogs.trem

import fr.liotapsi.jprettylogs.ILogger

/**
 * the main class for call and build the logger
 */
class TermLogger : ILogger {

    /**
     * print a log
     */
    override fun critical(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    !!!    | ${tmp[0]}"
        println("${TermAnsiColor.HIGH_INTENSITY}${TermAnsiColor.ANSI_RED} $str1 ${TermAnsiColor.ANSI_RESET}")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            println("${TermAnsiColor.HIGH_INTENSITY}${TermAnsiColor.ANSI_RED} $str2 ${TermAnsiColor.ANSI_RESET}")
        }
    }

    /**
     * print a log
     */
    override fun error(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    [!]    | ${tmp[0]}"
        println("${TermAnsiColor.LOW_INTESITY}${TermAnsiColor.ANSI_RED} $str1 ${TermAnsiColor.ANSI_RESET}")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            println("${TermAnsiColor.LOW_INTESITY}${TermAnsiColor.ANSI_RED} $str2 ${TermAnsiColor.ANSI_RESET}")
        }

    }

    /**
     * print a log
     */
    override fun info(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    [i]    | ${tmp[0]}"
        println("${TermAnsiColor.ANSI_GREEN} $str1 ${TermAnsiColor.ANSI_RESET}")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            println("${TermAnsiColor.ANSI_GREEN} $str2 ${TermAnsiColor.ANSI_RESET}")
        }
    }

    /**
     * print a log
     */
    override fun debug(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    ...    | ${tmp[0]}"
        println("${TermAnsiColor.ANSI_BLUE} $str1 ${TermAnsiColor.ANSI_RESET}")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            println("${TermAnsiColor.ANSI_BLUE} $str2 ${TermAnsiColor.ANSI_RESET}")
        }

    }

    /**
     * print a log
     */
    override fun warning(msg: String) {
        val tmp = msg.split("\n")
        val str1 = "    /!\\    | ${tmp[0]}"
        println("${TermAnsiColor.ANSI_YELLOW} $str1 ${TermAnsiColor.ANSI_RESET}")
        for (i in 1 until tmp.size step 1) {
            val str2 = "           | ${tmp[i]}"
            println("${TermAnsiColor.ANSI_YELLOW} $str2 ${TermAnsiColor.ANSI_RESET}")
        }
    }
}