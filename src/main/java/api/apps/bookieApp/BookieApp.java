package api.apps.bookieApp;

import api.android.Android;
import api.apps.bookieApp.main.Main;
import api.apps.bookieApp.registration1.Registration1;
import api.apps.bookieApp.login.Login;
import api.apps.bookieApp.registration2.Registration2;
import api.apps.bookieApp.start.Start;
import api.interfaces.Application;
import core.UiObject;

public class BookieApp implements Application {

    public Start start = new Start();
    public Login login = new Login();
    public Registration1 registration1 = new Registration1();
    public Registration2 registration2 = new Registration2();
    public Main main = new Main();

    @Override
    public void forceStop() {
        Android.adb.forceStopApp(packageId());
    }

    @Override
    public void clearData() {
        Android.adb.clearAppsData(packageId());
    }

    @Override
    public UiObject open() {
        Android.adb.openAppsActivity(packageId(), activityID());
//        return Android.app.bookieApp.start;
        return null;
    }

    @Override
    public String packageId() {
        return "com.betconstruct.bookie";
    }

    @Override
    public String activityID() {
        return "com.betconstruct.bookie.activities.SplashActivity";
    }
}
