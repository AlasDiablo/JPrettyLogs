package fr.liotapsi.jprettylogs.utils

enum class AnsiCode(val code: String) {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    HIGH_INTENSITY("\u001B[1m"),
    LOW_INTENSITY("\u001B[2m")
}