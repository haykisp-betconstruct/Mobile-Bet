package api.apps.bookieApp.start;

import core.UiObject;
import core.UiSelector;

public class StartUiObjects {
    private static UiObject
            buttonSignIn,
            buttonCreateAccount,
            slide,
            slider;

    public UiObject buttonSignIn() {
        if (buttonSignIn == null) buttonSignIn = new UiSelector().text("Sign in").makeUiObject();
        return buttonSignIn;
    }

    public UiObject buttonCreateAccount() {
        if (buttonCreateAccount == null) buttonCreateAccount = new UiSelector().text("Create Account").makeUiObject();
        return buttonCreateAccount;
    }

    public UiObject slide() {
        if (slide == null)
            slide = new UiSelector().resourceId("com.betconstruct.bookie:id/tutorial_pager").makeUiObject();
        return slide;
    }

    public UiObject slider() {
        if (slider == null)
            slider = new UiSelector().resourceId("com.betconstruct.bookie:id/tab_layout").makeUiObject();
        return slider;
    }

}
