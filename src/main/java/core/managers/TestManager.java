package core.managers;

import core.*;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.concurrent.TimeUnit;

public class TestManager {

    public static TestInfo testInfo = new TestInfo();
    private static HTML reporter;
    protected long startTime, endTime;
    protected String time;

    @Rule
    public Retry retry = new Retry(1);

    @Rule
    public TestRule listen = new TestWatcher() {
        @Override
        public void failed(Throwable t, Description description) {
            endTime = System.currentTimeMillis();
            TestManager.reporter.update(time, millisToShortDHMS(endTime - startTime), TestInfo.suite(), TestInfo.name(), "FAIL", t);
        }

        @Override
        public void succeeded(Description description) {
            Throwable t = null;
            endTime = System.currentTimeMillis();
            TestManager.reporter.update(time, millisToShortDHMS(endTime - startTime), TestInfo.suite(), TestInfo.name(), "PASS", t);
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

        if (days == 0) res = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        else res = String.format("%dd %02d:%02d:%02d", days, hours, minutes, seconds);
        return res;
    }
}
