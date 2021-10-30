package fr.liotapsi.jprettylogs

import java.io.PrintStream

abstract class Logger(protected val printStream: PrintStream) : ILogger