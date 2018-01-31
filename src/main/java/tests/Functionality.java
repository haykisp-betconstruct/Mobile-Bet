package tests;

import api.android.Android;
import api.apps.bookieApp.BookieApp;
import core.managers.TestManager;
import org.junit.Test;

public class Functionality extends TestManager {

    private static BookieApp bookieApp = Android.app.bookieApp;

    @Test
    public void test3() {
        testInfo.id("test3").name("");
        bookieApp.login.writeUsername("hayk.ispiryan@betconstruct.com");
        bookieApp.login.writePassword("~Isp463125");
        Android.driver.hideKeyboard();
        bookieApp.login.tapSignIn();

    }
}
