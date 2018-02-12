package tests;

import api.android.Android;
import api.apps.bookieApp.BookieApp;
import core.managers.TestManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main extends TestManager{
    private static BookieApp bookieApp = Android.app.bookieApp;

    @Before
    public void before() {
        testInfo.reset();
        time = new SimpleDateFormat("HH:mm:ss      dd/MM/yyyy").format(Calendar.getInstance().getTime());
        startTime = System.currentTimeMillis();
        testInfo.suite("Main");

        bookieApp.open();
        bookieApp.start.waitToLoad(30);
        bookieApp.start.tapGetStarted();
        bookieApp.welcome.waitToLoad(30);
        bookieApp.welcome.tapSignIn();
        bookieApp.login.waitToLoad(30);
        bookieApp.login.writeUsername("testbeta");
        bookieApp.login.writePassword("Isp463125");
        Android.driver.hideKeyboard();
        bookieApp.login.uiObject.buttonSignIn().waitToAppear(15);
        bookieApp.login.tapSignIn();
        bookieApp.main.waitToLoad(30);
    }

    @After
    public void after() {
        bookieApp.forceStop();
        bookieApp.clearData();
    }

    @Test
    public void test1() {
        testInfo.name("Login Main Loading");

        Assert.assertTrue(bookieApp.main.uiObject.actionExplore().exists());
        Assert.assertTrue(bookieApp.main.uiObject.actionProfile().exists());
        Assert.assertTrue(bookieApp.main.uiObject.actionMore().exists());
    }

}
