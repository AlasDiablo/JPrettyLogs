package fr.liotapsi.jprettylogs

/**
 * the interface with all function listed
 */
interface ILogger {

    fun error(msg: String)

    fun info(msg: String)

    fun debug(msg: String)

    fun warning(msg: String)

    fun critical(msg: String)
}