import fr.liotapsi.jprettylogs.DualLogger
import fr.liotapsi.jprettylogs.impl.AnsiLogger
import fr.liotapsi.jprettylogs.impl.GuiLogger

fun main() {
    val log1 = AnsiLogger(info = true, debug = true, warning = true)
    val log2 = GuiLogger(info = true, debug = true, warning = true)
    val logger = DualLogger(log1, log2)
    logger.critical("This is a critical log.\nOn multi line")
    logger.debug("This is a debug log.\nOn multi line")
    logger.error("This is a error log.\nOn multi line")
    logger.info("This is a info log.\nOn multi line")
    logger.warning("This is a warning log.\nOn multi line")
}