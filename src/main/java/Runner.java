import core.MyLogger;
import core.managers.DriverManager;
import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;
import tests.TestPrimer;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        MyLogger.log.setLevel(Level.INFO);
        try {
            DriverManager.createDriver();
            JUnitCore.runClasses(TestPrimer.class);
        } finally {
            DriverManager.killDriver();
        }


    }
}
