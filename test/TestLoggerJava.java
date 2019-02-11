import fr.liotapsi.jprettylogs.ILogger;
import fr.liotapsi.jprettylogs.JPrettyLogs;

public class TestLoggerJava {

    public static void main(String[] args) {
        ILogger myLogger = JPrettyLogs.Companion.cliLogger(args);
        myLogger.info("hello i'm info");
        myLogger.debug("hello i'm debug");
        myLogger.warning("hello i'm warning");
        myLogger.error("hello i'm error");
        myLogger.critical("hello i'm critical");
        System.out.println("--------------------------------------------------------");
        myLogger.info("hello i'm multi\nline info\nlel");
        myLogger.debug("hello i'm multi\nline debug\nlel");
        myLogger.warning("hello i'm multi\nline warning\nlel");
        myLogger.error("hello i'm multi\nline error\nlel");
        myLogger.critical("hello i'm multi\nline critical\nlel");
    }
}
