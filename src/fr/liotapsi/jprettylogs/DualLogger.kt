package fr.liotapsi.jprettylogs

class DualLogger(private val logger1: ILogger,
                 private val logger2: ILogger): ILogger {

    override fun error(msg: String) {
        logger1.error(msg)
        logger2.error(msg)
    }

    override fun info(msg: String) {
        logger1.info(msg)
        logger2.info(msg)
    }

    override fun debug(msg: String) {
        logger1.debug(msg)
        logger2.debug(msg)
    }

    override fun warning(msg: String) {
        logger1.warning(msg)
        logger2.warning(msg)
    }

    override fun critical(msg: String) {
        logger1.critical(msg)
        logger2.critical(msg)
    }
}