package api.apps.bookieApp.login;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

public class Login implements Activity {
    public LoginUiObjects uiObject = new LoginUiObjects();

    @Override
    public Login waitToLoad(int waitTime) {
        try {
            MyLogger.log.info("Waiting to load Login screen");
            uiObject.fieldUsername().waitToAppear(waitTime);
            uiObject.fieldPassword().waitToAppear(waitTime);
            uiObject.buttonForgotPassword().waitToAppear(waitTime);
            uiObject.buttonSignIn().waitToAppear(waitTime);
            uiObject.buttonCreateAccount().waitToAppear(waitTime);
            return Android.app.bookieApp.login;
        } catch (AssertionError e) {
            throw new AssertionError("Login screen failed to load/open");
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

    public void tapForgotPassword() {
        try {
            MyLogger.log.info("Tapping on the Forgot Password Button");
            uiObject.buttonForgotPassword().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap Forgot Password Button, element absent or blocked");
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

    public void writePassword(String Text) {
        try {
            MyLogger.log.info("Writing in Password field");
//            uiObject.fieldPassword().tap();
            uiObject.fieldPassword().clearText();
            uiObject.fieldPassword().typeText(Text);
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't write in Password field, element absent or blocked");
        }
    }

    public void tapTryAgain() {
        try {
            MyLogger.log.info("Tapping on TRY AGAIN button");
            uiObject.buttonSignInDialogTryAgain();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Can't tap TRY AGAIN button, element absent or blocked");
        }

    }


}
