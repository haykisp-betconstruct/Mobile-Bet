package api.apps.bookieApp.login;

import core.UiObject;
import core.UiSelector;

public class LoginUiObjects {
    private static UiObject
            fielduUername,
            fieldPassword,
            buttonForgotPassword,
            buttonSignIn,
            buttonCreateAccount;

    public UiObject buttonSignIn() {
        if (buttonSignIn == null) buttonSignIn = new UiSelector().text("Sign in").makeUiObject();
        return buttonSignIn;
    }

    public UiObject buttonCreateAccount() {
        if (buttonCreateAccount == null) buttonCreateAccount = new UiSelector().text("Create Account").makeUiObject();
        return buttonCreateAccount;
    }

    public UiObject fieldUsername() {
        if (fielduUername == null)
            fielduUername = new UiSelector().resourceId("com.betconstruct.bookie:id/username_edit_text").makeUiObject();
        return fielduUername;
    }

    public UiObject fieldPassword() {
        if (fieldPassword == null)
            fieldPassword = new UiSelector().resourceId("com.betconstruct.bookie:id/password_edit_text").makeUiObject();
        return fieldPassword;
    }

    public UiObject buttonForgotPassword() {
        if (buttonForgotPassword == null)
            buttonForgotPassword = new UiSelector().text("Click here").makeUiObject();
        return buttonForgotPassword;
    }
}
