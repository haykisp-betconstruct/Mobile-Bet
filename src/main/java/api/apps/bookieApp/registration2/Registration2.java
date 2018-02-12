package api.apps.bookieApp.registration2;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

public class Registration2 implements Activity {

    public Registration2UiObjects uiObject = new Registration2UiObjects();

    @Override
    public Object waitToLoad(int waitTime) {
        try {
            MyLogger.log.info("Waiting to load Registration2 screen");
            uiObject.fieldUsername().waitToAppear(waitTime);
            uiObject.fieldEmail().waitToAppear(waitTime);
            uiObject.fieldPassword().waitToAppear(waitTime);
            uiObject.fieldConfirmPassword().waitToAppear(waitTime);
            uiObject.buttonNext().waitToAppear(waitTime);
            return Android.app.bookieApp.registration2;
        } catch (AssertionError e) {
            throw new AssertionError("Registration2 screen failed to load/open " + waitTime + " second");
        }
    }

    public void writeUsername(String Text) {
        try {
            MyLogger.log.info("Writing in Username field");
            uiObject.fieldUsername().clearText();
            uiObject.fieldUsername().typeText(Text);
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't write in Username field, element absent or blocked");
        }
    }

    public void writeEmail(String Text) {
        try {
            MyLogger.log.info("Writing in Username field");
            uiObject.fieldEmail().clearText();
            uiObject.fieldEmail().typeText(Text);
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't write in Email field, element absent or blocked");
        }
    }

    public void writePassword(String Text) {
        try {
            MyLogger.log.info("Writing in Username field");
            uiObject.fieldPassword().clearText();
            uiObject.fieldPassword().typeText(Text);
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't write in Password field, element absent or blocked");
        }
    }

    public void writeConfirmPassword(String Text) {
        try {
            MyLogger.log.info("Writing in Username field");
            uiObject.fieldConfirmPassword().clearText();
            uiObject.fieldConfirmPassword().typeText(Text);
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't write in Confirm Password field, element absent or blocked");
        }
    }

    public void tapNext() {
        try {
            MyLogger.log.info("Tapping on the SignIn Button");
            uiObject.buttonNext().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap SignIn Button, element absent or blocked");
        }
    }
}
