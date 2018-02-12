import core.HTML;
import core.MyLogger;
import core.managers.DriverManager;
import core.managers.TestManager;
import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;
import tests.TestPrimer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException, ParserConfigurationException {

        MyLogger.log.setLevel(Level.DEBUG);
        String xmlLocation = System.getProperty("user.dir")+"/result.html";
        MyLogger.log.info(xmlLocation);
        TestManager.setReporter(new HTML(new File(xmlLocation)));

        try {
            DriverManager.createDriver();
            JUnitCore.runClasses(TestPrimer.class);
        } finally {
            DriverManager.killDriver();
        }
    }
}
