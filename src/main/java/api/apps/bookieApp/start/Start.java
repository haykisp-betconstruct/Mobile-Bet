package api.apps.bookieApp.start;

import api.android.Android;
import api.apps.bookieApp.login.Login;
import api.interfaces.Activity;
import core.MyLogger;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.NoSuchElementException;

public class Start implements Activity {

    public StartUiObjects uiObject = new StartUiObjects();

    @Override
    public Start waitToLoad(int waitTime) {
        try {
            MyLogger.log.info("Waiting to load Start screen");
            uiObject.buttonGetStarted().waitToAppear(waitTime);
            return Android.app.bookieApp.start;
        } catch (AssertionError e) {
            throw new AssertionError("Start screen failed to load/open in " + waitTime + " second");
        }
    }

    public void tapGetStarted() {
        try {
            MyLogger.log.info("Tapping on GetStarted Button");
            uiObject.buttonGetStarted().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap GetStarted Button, element absent or blocked");
        }
    }
}
