package api.apps.bookieApp.main;

import core.UiObject;
import core.UiSelector;

public class MainUiObjects {

    private static UiObject
            actionExplore,
            actionProfile,
            actionMore,
            actionBetCenter,
            buttonFab,
            windowBookmakers;

    public UiObject actionExplore() {
        if (actionExplore == null)
            actionExplore = new UiSelector().resourceId("com.betconstruct.bookie:id/action_lobby").makeUiObject();
        return actionExplore;
    }

    public UiObject actionProfile() {
        if (actionProfile == null)
            actionProfile = new UiSelector().resourceId("com.betconstruct.bookie:id/action_profile").makeUiObject();
        return actionProfile;
    }

    public UiObject actionMore() {
        if (actionMore == null)
            actionMore = new UiSelector().resourceId("com.betconstruct.bookie:id/action_more").makeUiObject();
        return actionMore;
    }

    public UiObject buttonFab() {
        if (buttonFab == null)
            buttonFab = new UiSelector().resourceId("com.betconstruct.bookie:id/fab").makeUiObject();
        return buttonFab;
    }
    public UiObject windowBookmakers() {
        if (windowBookmakers == null)
            windowBookmakers = new UiSelector().resourceId("com.betconstruct.bookie:id/recycle_view").makeUiObject();
        return windowBookmakers;
    }
}
