package fr.liotapsi.jprettylogs

import com.sun.istack.internal.Nullable
import fr.liotapsi.jprettylogs.cli.CLILogger

/**
 * the class use for use the logger builder
 */
open class JPrettyLogs {

    /**
     * equivalent to java static fonction
     */
    companion object {

        /**
         * the logger builder
         */
        fun cliLogger(@Nullable args: Array<String>, directory:  String?, logfilename: String?): ILogger {
            return if (args == null) {
                CLILogger(
                    isError = false,
                    isInfo = false,
                    isDebug = false,
                    isWarning = false,
                    isCritical = false,
                    path = directory,
                    logName = logfilename
                )
            } else {
                CLILogger(args.contains("-PLError"),
                    args.contains("-PLInfo"),
                    args.contains("-PLDebug"),
                    args.contains("-PLWarning"),
                    args.contains("-PLCritical"),
                    directory,
                    logfilename)
            }
        }
    }
}