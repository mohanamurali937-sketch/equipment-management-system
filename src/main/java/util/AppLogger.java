package util;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
public final class AppLogger {
    private AppLogger() {

    }
    public static void configure()
    {          Logger rootLogger = Logger.getLogger("");
        // Set root logger level
        rootLogger.setLevel(Level.ALL);
        // Set console handler level
        for (Handler handler : rootLogger.getHandlers())
        {             handler.setLevel(Level.ALL);
        }
    }
    public static Logger getLogger(Class<?> c) {
        return Logger.getLogger(c.getName());
    } }