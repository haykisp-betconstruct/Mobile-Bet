package api.apps.bookieApp.welcome;

import core.UiObject;
import core.UiSelector;

public class WelcomeUiObjects {
    private static UiObject
            buttonSignIn;

    public UiObject buttonSignIn() {
        if (buttonSignIn == null) buttonSignIn = new UiSelector().text("Sign in").makeUiObject();
        return buttonSignIn;
    }
}
