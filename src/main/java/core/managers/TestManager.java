package core.managers;

import core.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.concurrent.TimeUnit;

public class TestManager {

    public static TestInfo testInfo = new TestInfo();
    private static HTML reporter;
    protected long startTime, endTime;

    @Rule
    public Retry retry = new Retry(1);

    @Rule
    public TestRule listen = new TestWatcher() {
        @Override
        public void failed(Throwable t, Description description) {
            endTime = System.currentTimeMillis();
            if (TestManager.reporter != null) {
                TestManager.reporter.update(millisToShortDHMS(endTime-startTime), TestInfo.suite(), TestInfo.name(), "FAIL");
            }
        }

        @Override
        public void succeeded(Description description) {
            endTime = System.currentTimeMillis();
            if (TestManager.reporter != null) {
                TestManager.reporter.update(millisToShortDHMS(endTime-startTime), TestInfo.suite(), TestInfo.name(), "PASS");
            }
        }
    };

    public static void setReporter(HTML reporter) {
        TestManager.reporter = reporter;

    }

    public static String millisToShortDHMS(long duration) {
        String res = "";    // java.util.concurrent.TimeUnit;
        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration) -
                TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration) -
                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
        long millis = TimeUnit.MILLISECONDS.toMillis(duration) -
                TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(duration));

        if (days == 0) res = String.format("%02d:%02d:%02d.%04d", hours, minutes, seconds, millis);
        else res = String.format("%dd %02d:%02d:%02d.%04d", days, hours, minutes, seconds, millis);
        return res;
    }
}
