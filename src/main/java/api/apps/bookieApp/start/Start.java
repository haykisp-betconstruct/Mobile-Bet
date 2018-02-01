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
            uiObject.buttonSignIn().waitToAppear(waitTime);
            uiObject.buttonCreateAccount().waitToAppear(waitTime);
            uiObject.slide().waitToAppear(waitTime);
            uiObject.slider().waitToAppear(waitTime);
            return Android.app.bookieApp.start;
        } catch (AssertionError e) {
            throw new AssertionError("Start screen failed to load/open");
        }
    }

    public void tapSignIn() {
        try {
            MyLogger.log.info("Tapping on the SignIn Button");
            uiObject.buttonSignIn().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap SignIn Button, element absent or blocked");
        }
    }

    public void tapCreateAccount() {
        try {
            MyLogger.log.info("Tapping on the CreateAccount Button");
            uiObject.buttonCreateAccount().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap CreateAccount Button, element absent or blocked");
        }
    }


}
