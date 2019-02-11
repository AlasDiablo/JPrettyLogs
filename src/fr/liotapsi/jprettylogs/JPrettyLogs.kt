package fr.liotapsi.jprettylogs

import fr.liotapsi.jprettylogs.cli.CLILogger

/**
 *
 */
open class JPrettyLogs {
    /**
     *
     */
    companion object {
        /**
         *
         */
        fun cliLogger(args: Array<String>): ILogger {
            return CLILogger(args.contains("-PLError"),
                args.contains("-PLInfo"),
                args.contains("-PLDebug"),
                args.contains("-PLWarning"),
                args.contains("-PLCritical"))
        }
    }
}