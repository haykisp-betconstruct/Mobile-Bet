package api.apps.bookieApp.profile;

import core.UiObject;
import core.UiSelector;

public class ProfileUiObjects {

    private static UiObject textUsername;
    private static UiObject buttonMyBets;
    private static UiObject buttonBookie;
    private static UiObject objectMyBet;

    public UiObject textUsername() {
        if (textUsername == null) {
            textUsername = new UiSelector().resourceId("com.betconstruct.bookie:id/user_name").makeUiObject();
        }
        return textUsername;
    }

    public UiObject buttonMyBets(){
        if(buttonMyBets==null) {
            buttonMyBets = new UiSelector().text("My Bets").makeUiObject();
        }
        return buttonMyBets;
    }

    public UiObject buttonBookie(){
        if(buttonBookie== null){
            buttonBookie= new UiSelector().text("Bookie").makeUiObject();
        }
        return buttonBookie;
    }

    public UiObject objectMyBet(int index){
        if(objectMyBet==null){
            objectMyBet= new UiSelector().resourceId("com.betconstruct.bookie:id/recycle_view").className("android.widget.LinearLayout").index(index).makeUiObject();
        }
        return objectMyBet;
    }

}
