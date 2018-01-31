package api.apps.bookieApp.registration1;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

public class Registration1 implements Activity {

    public Registration1UiObjects uiObject = new Registration1UiObjects();


    @Override
    public Object waitToLoad(int waitTime) {
        try {
            MyLogger.log.info("Waiting to load Registration1 screen");
            uiObject.buttonClose().waitToAppear(waitTime);
            uiObject.buttonAccept().waitToAppear(waitTime);
            return Android.app.bookieApp.start;
        } catch (AssertionError e) {
            throw new AssertionError("Registration1 screen failed to load/open");
        }
    }

    public void tapCloseButton() {
        try {
            MyLogger.log.info("Tapping on the close Button");
            uiObject.buttonClose().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap close Button, element absent or blocked");
        }
    }

    public void tapAcceptButton() {
        try {
            MyLogger.log.info("Tapping on the Accept Button");
            uiObject.buttonAccept().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap close Button, element absent or blocked");
        }
    }
}
