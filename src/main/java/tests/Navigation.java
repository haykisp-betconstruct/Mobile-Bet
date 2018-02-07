package tests;

import api.android.Android;
import api.apps.bookieApp.BookieApp;
import core.managers.TestManager;
import org.junit.*;

public class Navigation extends TestManager {

    private static BookieApp bookieApp = Android.app.bookieApp;

    @BeforeClass
    public static void beforeClass() {
        testInfo.suite("Navigation");
    }

    @Before
    public void before() {
        bookieApp.open();
        bookieApp.start.waitToLoad(15);
    }

    @After
    public void after() {
        bookieApp.forceStop();
    }

    @Test
    public void test1() {
        testInfo.name("TestCase1");

        Assert.assertTrue(bookieApp.start.uiObject.buttonSignIn().exists());
        Assert.assertTrue(bookieApp.start.uiObject.buttonCreateAccount().exists());
        Assert.assertTrue(bookieApp.start.uiObject.slide().exists());
        Assert.assertTrue(bookieApp.start.uiObject.slider().exists());
    }

    @Test
    public void test2() {
        bookieApp.start.tapSignIn();
        bookieApp.login.waitToLoad(15);
        testInfo.name("TestCase2");
        Assert.assertTrue(bookieApp.login.uiObject.fieldUsername().exists());
        Assert.assertTrue(bookieApp.login.uiObject.fieldPassword().exists());
        Assert.assertTrue(bookieApp.login.uiObject.buttonForgotPassword().exists());
        Assert.assertTrue(bookieApp.login.uiObject.buttonSignIn().exists());
        Assert.assertTrue(bookieApp.login.uiObject.buttonCreateAccount().exists());
        bookieApp.login.writeUsername("testbeta");
        bookieApp.login.writePassword("Isp463125");
    }
}
