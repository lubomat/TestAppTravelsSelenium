package pl.seleniumdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();

                                // konfiguracja w log4j.xml
        logger.info("info");    // ust1     2
        logger.error("Error");  //    1     2     ust3             5
        logger.warn("Warn");    //    1     2                   ust5
        logger.debug("Debug");  //       ust2
        logger.fatal("Fatal");  //    1     2        3    ust4     5
        logger.trace("Trace");  // wszstkie
    }
}
