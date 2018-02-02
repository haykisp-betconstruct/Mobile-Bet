import core.MyLogger;
import core.Reporter;
import core.managers.DriverManager;
import core.managers.TestManager;
import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;
import tests.TestPrimer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Runner {

    public static void main(String[] args) throws IOException, ParserConfigurationException {

        MyLogger.log.setLevel(Level.INFO);
        String xmlLocation = System.getProperty("user.dir")+"/result.xml";
        MyLogger.log.info(xmlLocation);
        TestManager.setReporter(new Reporter(new File(xmlLocation)));



        try {
            DriverManager.createDriver();
            JUnitCore.runClasses(TestPrimer.class);
        } finally {
            DriverManager.killDriver();
        }
    }
}
