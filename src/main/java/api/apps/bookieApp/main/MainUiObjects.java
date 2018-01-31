package api.apps.bookieApp.main;

import core.UiObject;
import core.UiSelector;

public class MainUiObjects {

    private static UiObject
            actionExplore,
            actionProfile,
            actionBetCenter,
            actionMore,
            buttonFab,
            buttonSearch,
            fieldSearch;

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

//    public UiObject actionBetCenter() {
//        if (actionBetCenter == null) actionBetCenter = new UiSelector().text("Sign in").makeUiObject();
//        return actionBetCenter;
//    }

    public UiObject actionMore() {
        if (actionMore == null) actionMore = new UiSelector().resourceId("com.betconstruct.bookie:id/navigation").xPath("[0]/2").makeUiObject();
        return actionMore;
    }

    public UiObject buttonFab() {
        if (buttonFab == null)
            buttonFab = new UiSelector().resourceId("com.betconstruct.bookie:id/action_more").makeUiObject();
        return buttonFab;
    }

    public UiObject buttonSearch() {
        if (buttonSearch == null)
            buttonSearch = new UiSelector().resourceId("com.betconstruct.bookie:id/search_button").makeUiObject();
        return buttonSearch;
    }

    public UiObject fieldSearch() {
        if (fieldSearch == null)
            fieldSearch = new UiSelector().resourceId("com.betconstruct.bookie:id/search_src_text").makeUiObject();
        return fieldSearch;
    }


}
