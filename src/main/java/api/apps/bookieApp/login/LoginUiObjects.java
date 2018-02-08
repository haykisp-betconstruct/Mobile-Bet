package api.apps.bookieApp.login;

import core.UiObject;
import core.UiSelector;

public class LoginUiObjects {
    private static UiObject
            fieldUsername,
            fieldPassword,
            buttonForgotPassword,
            buttonSignIn,
            buttonCreateAccount,
            buttonTogglePassword,
            textWelcome,
            textSignInToStart,
            textForgotPassword,
            textClickHere,
            errorPassword;


    public UiObject buttonSignIn() {
        if (buttonSignIn == null) buttonSignIn = new UiSelector().resourceId("com.betconstruct.bookie:id/sign_in").makeUiObject();
        return buttonSignIn;
    }

    public UiObject buttonCreateAccount() {
        if (buttonCreateAccount == null) buttonCreateAccount = new UiSelector().text("Create Account").makeUiObject();
        return buttonCreateAccount;
    }

    public UiObject fieldUsername() {
        if (fieldUsername == null)
            fieldUsername = new UiSelector().resourceId("com.betconstruct.bookie:id/username_edit_text").makeUiObject();
        return fieldUsername;
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

    public UiObject buttonTogglePassword() {
        if (buttonTogglePassword == null)
            buttonTogglePassword = new UiSelector().resourceId("com.betconstruct.bookie:id/text_input_password_toggle").makeUiObject();
        return buttonTogglePassword;
    }

    public UiObject textWelcome() {
        if (textWelcome == null) textWelcome = new UiSelector().text("Welcome").makeUiObject();
        return textWelcome;
    }

    public UiObject textSignInToStart() {
        if (textSignInToStart == null)
            textSignInToStart = new UiSelector().text("Sign in to your account to start").makeUiObject();
        return textSignInToStart;
    }

    public UiObject textForgotPassword() {
        if (textForgotPassword == null)
            textForgotPassword = new UiSelector().text("Forgot Your password?").makeUiObject();
        return textForgotPassword;
    }

    public UiObject textClickHere() {
        if (textClickHere == null) textClickHere = new UiSelector().text("Click here").makeUiObject();
        return textClickHere;
    }

    public UiObject errorPassword() {
        if (errorPassword == null) errorPassword = new UiSelector().text("Password must be minimum of 6 characters").makeUiObject();
        return errorPassword;
    }
}
