package tests;

import api.android.Android;
import api.apps.bookieApp.BookieApp;
import core.managers.TestManager;
import org.junit.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Login extends TestManager {

    private static BookieApp bookieApp = Android.app.bookieApp;

    @Before
    public void before() {
        testInfo.reset();
        time = new SimpleDateFormat("HH:mm:ss      dd/MM/yyyy").format(Calendar.getInstance().getTime());
        startTime = System.currentTimeMillis();
        testInfo.suite("Login");

        bookieApp.open();
        bookieApp.start.waitToLoad(30);
        bookieApp.start.tapGetStarted();
        bookieApp.welcome.waitToLoad(30);
        bookieApp.welcome.tapSignIn();
        bookieApp.login.waitToLoad(30);
    }

    @After
    public void after() {
        bookieApp.forceStop();
//        bookieApp.clearData();
    }

    @Test
    public void test1() {
        testInfo.name("Login Screen Loading");

        Assert.assertTrue(bookieApp.login.uiObject.textWelcome().exists());
        Assert.assertTrue(bookieApp.login.uiObject.textSignInToStart().exists());
        Assert.assertTrue(bookieApp.login.uiObject.fieldUsername().exists());
        Assert.assertTrue(bookieApp.login.uiObject.fieldUsername().isClickable());
        Assert.assertTrue(bookieApp.login.uiObject.fieldPassword().exists());
        Assert.assertTrue(bookieApp.login.uiObject.fieldPassword().isClickable());
        Assert.assertTrue(bookieApp.login.uiObject.buttonTogglePassword().exists());
        Assert.assertTrue(bookieApp.login.uiObject.buttonTogglePassword().isClickable());
        Assert.assertTrue(bookieApp.login.uiObject.buttonTogglePassword().isCheckable());
        Assert.assertTrue(bookieApp.login.uiObject.textForgotPassword().exists());
        Assert.assertTrue(bookieApp.login.uiObject.textClickHere().exists());
        Assert.assertTrue(bookieApp.login.uiObject.buttonSignIn().exists());
        Assert.assertTrue(bookieApp.login.uiObject.buttonSignIn().isClickable());
        Assert.assertTrue(bookieApp.login.uiObject.buttonCreateAccount().exists());
        Assert.assertTrue(bookieApp.login.uiObject.buttonCreateAccount().isClickable());
    }

    @Test
    public void test2() {
        testInfo.name("Valid username and empty password");

        bookieApp.login.writeUsername("testbeta");
        Assert.assertEquals(bookieApp.login.uiObject.fieldUsername().getText(), "testbeta");
        Android.driver.hideKeyboard();
        bookieApp.login.uiObject.buttonSignIn().waitToAppear(15);
        bookieApp.login.tapSignIn();
        Assert.assertTrue(bookieApp.login.uiObject.errorPassword().exists());
        Assert.assertEquals("Password must be minimum of 6 characters", bookieApp.login.uiObject.errorPassword().getText());
    }

    @Test
    public void test3() {
        testInfo.name("Valid username and invalid password");

        bookieApp.login.writeUsername("testbeta");
        Assert.assertEquals(bookieApp.login.uiObject.fieldUsername().getText(), "testbeta");
        bookieApp.login.writePassword("invalid");
        Android.driver.hideKeyboard();
        bookieApp.login.uiObject.buttonSignIn().waitToAppear(15);
        bookieApp.login.tapSignIn();
        Assert.assertEquals("Invalid username or password.", bookieApp.login.uiObject.textSignInDialogText().getText());
        Assert.assertTrue(bookieApp.login.uiObject.buttonSignInDialogTryAgain().exists());
        bookieApp.login.tapTryAgain();
        bookieApp.login.waitToLoad(1);
    }
}
