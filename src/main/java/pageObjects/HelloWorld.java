package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {

    public static Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {

        logger.debug("deubg");
        logger.error("donedone");
        logger.info("infooooo");
        

        // in old days, we need to check the log level log to increase performance
        /*if (logger.isDebugEnabled()) {
            logger.debug("{}", getNumber());
        }*/

        // with Java 8, we can do this, no need to check the log level
        
    }

    

}
