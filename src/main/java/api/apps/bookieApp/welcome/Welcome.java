package api.apps.bookieApp.welcome;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

public class Welcome implements Activity {

    public WelcomeUiObjects uiObject = new WelcomeUiObjects();

    @Override
    public Welcome waitToLoad(int waitTime) {
        try {
            MyLogger.log.info("Waiting to load Welcome screen");
            uiObject.buttonSignIn().waitToAppear(waitTime);
            return Android.app.bookieApp.welcome;
        } catch (AssertionError e) {
            throw new AssertionError("Welcome screen failed to load/open");
        }
    }

    public void tapSignIn(){
        try {
            MyLogger.log.info("Tapping on Sign In Button");
            uiObject.buttonSignIn().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap Sign In Button, element absent or blocked");
        }
    }
}
