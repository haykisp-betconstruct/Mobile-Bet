package api.apps.bookieApp.start;

import core.UiObject;
import core.UiSelector;

public class StartUiObjects {
    private static UiObject
            buttonGetStarted;

    public UiObject buttonGetStarted() {
        if (buttonGetStarted == null) buttonGetStarted = new UiSelector().text("Get started").makeUiObject();
        return buttonGetStarted;
    }
}
