package api.apps.bookieApp.main;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

public class Main implements Activity {

    public MainUiObjects uiObject = new MainUiObjects();

    @Override
    public Object waitToLoad(int waitTime) {
        try {
            MyLogger.log.info("Waiting to load Main screen");
            uiObject.actionExplore().waitToAppear(waitTime);
            uiObject.actionProfile().waitToAppear(waitTime);
//            uiObject.actionBetCenter().waitToAppear(waitTime);
            uiObject.actionMore().waitToAppear(waitTime);
            uiObject.buttonFab().waitToAppear(waitTime);
            uiObject.buttonSearch().waitToAppear(waitTime);
            return Android.app.bookieApp.main;
        } catch (AssertionError e) {
            throw new AssertionError("Main screen failed to load/open");
        }
    }

    public void tapExplore() {
        try {
            MyLogger.log.info("Tapping on the Main action");
            uiObject.actionExplore().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap Main action, element absent or blocked");
        }
    }

    public void tapProfile() {
        try {
            MyLogger.log.info("Tapping on the Profile action");
            uiObject.actionProfile().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap Profile action, element absent or blocked");
        }
    }

    public void tapMore() {
        try {
            MyLogger.log.info("Tapping on the More action");
            uiObject.actionMore().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap More action, element absent or blocked");
        }
    }

    public void tapFab() {
        try {
            MyLogger.log.info("Tapping on the Fab button");
            uiObject.buttonFab().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap Fab button, element absent or blocked");
        }
    }

    public void tapSearch() {
        try {
            MyLogger.log.info("Tapping on the Search button");
            uiObject.buttonSearch().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap Search button, element absent or blocked");
        }
    }

    public void writeSearch() {
        try {
            MyLogger.log.info("Writing in the Search field");
            uiObject.buttonSearch().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't write in Search field, element absent or blocked");
        }
    }

}
