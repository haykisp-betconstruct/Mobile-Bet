package api.apps.bookieApp.registration2;

import core.UiObject;
import core.UiSelector;

public class Registration2UiObjects {

    private static UiObject
            fieldUsername,
            fieldEmail,
            fieldPassword,
            fieldConfirmPassword,
            buttonNext;

    public UiObject fieldUsername() {
        if (fieldUsername == null)
            fieldUsername = new UiSelector().resourceId("com.betconstruct.bookie:id/username_edit_text").makeUiObject();
        return fieldUsername;
    }

    public UiObject fieldEmail() {
        if (fieldEmail == null)
            fieldEmail = new UiSelector().resourceId("com.betconstruct.bookie:id/email_edit_text").makeUiObject();
        return fieldEmail;
    }

    public UiObject fieldPassword() {
        if (fieldPassword == null)
            fieldPassword = new UiSelector().resourceId("com.betconstruct.bookie:id/password_edit_text").makeUiObject();
        return fieldPassword;
    }

    public UiObject fieldConfirmPassword() {
        if (fieldConfirmPassword == null)
            fieldConfirmPassword = new UiSelector().resourceId("com.betconstruct.bookie:id/confirm_password_edit_text").makeUiObject();
        return fieldConfirmPassword;
    }

    public UiObject buttonNext() {
        if (buttonNext == null)
            buttonNext = new UiSelector().resourceId("com.betconstruct.bookie:id/next_button").makeUiObject();
        return buttonNext;
    }


}
