package fr.liotapsi.jprettylogs

import com.sun.istack.internal.NotNull
import com.sun.istack.internal.Nullable
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
        fun cliLogger(@Nullable args: Array<String>, @NotNull directory:  String): ILogger {
            return if (args == null) {
                CLILogger(
                    isError = false,
                    isInfo = false,
                    isDebug = false,
                    isWarning = false,
                    isCritical = false,
                    path = directory
                )
            } else {
                CLILogger(args.contains("-PLError"),
                    args.contains("-PLInfo"),
                    args.contains("-PLDebug"),
                    args.contains("-PLWarning"),
                    args.contains("-PLCritical"),
                    directory)
            }
        }
    }
}