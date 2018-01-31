package api.apps.bookieApp.registration1;

import core.UiObject;
import core.UiSelector;

public class Registration1UiObjects {

    private static UiObject
            buttonClose,
            buttonAccept;

    public UiObject buttonClose() {
        if (buttonClose == null)
            buttonClose = new UiSelector().resourceId("com.betconstruct.bookie:id/close_button").makeUiObject();
        return buttonClose;
    }

    public UiObject buttonAccept() {
        if (buttonAccept == null)
            buttonAccept = new UiSelector().resourceId("com.betconstruct.bookie:id/accept_button").makeUiObject();
        return buttonAccept;
    }

}
