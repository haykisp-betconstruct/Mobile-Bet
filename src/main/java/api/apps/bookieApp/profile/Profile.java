package api.apps.bookieApp.profile;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

public class Profile implements Activity {

    public ProfileUiObjects uiObject = new ProfileUiObjects();

    @Override
    public Object waitToLoad(int waitTime) {
        try {

            MyLogger.log.info("Waiting to load Profile screen");
            uiObject.textUsername().waitToAppear(waitTime);
            uiObject.buttonBookie().waitToAppear(waitTime);
            uiObject.buttonMyBets().waitToAppear(waitTime);
            return Android.app.bookieApp.profile;
        } catch (AssertionError e) {
            throw new AssertionError("Profile screen failed to load/open");
        }
    }

    public void tapMyBets() {
        try {
            MyLogger.log.info("Tapping on MY BETS Button");
            uiObject.buttonMyBets().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap MY BETS Button, element absent or blocked");
        }
    }

    public void tapBookie() {
        try {
            MyLogger.log.info("Tapping on the BOOKIE button");
            uiObject.buttonBookie().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap Bookie Button, element absent or blocked");
        }

    }

    public String getUsername() {
        return uiObject.textUsername().getText();
    }

    public void tapMyBet(int index){
        try {
            MyLogger.log.info("Trying to tap on "+index+"th bet");
            uiObject.objectMyBet(index).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Can't tap on "+index+"th bet");
        }
    }



}



