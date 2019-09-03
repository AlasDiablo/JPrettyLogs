import fr.liotapsi.jprettylogs.trem.TermLogger

fun main() {
    val logger = TermLogger()
    logger.critical("This is a critical log.\nOn multi line")
    logger.debug("This is a debug log.\nOn multi line")
    logger.error("This is a error log.\nOn multi line")
    logger.info("This is a info log.\nOn multi line")
    logger.warning("This is a warning log.\nOn multi line")
}