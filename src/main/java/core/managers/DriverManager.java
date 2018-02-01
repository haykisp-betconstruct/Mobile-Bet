package core.managers;

import api.android.Android;
import core.ADB;
import core.MyLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverManager {

    private static String nodeJS = "/usr/local/node-v8.9.4-linux-x64/bin/node";
    private static String appiumJS = "/usr/local/node-v8.9.4-linux-x64/bin/appium";
    private static DriverService service;
    private static String deviceID;

    private static HashMap<String, URL> hosts;
    private static String unlockPackage = "io.appium.unlock";

    private static DesiredCapabilities getCaps(String deviceID) {
        MyLogger.log.info("Creating drivercaps for device: " + deviceID);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceID);
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "/usr/local/node-v8.9.4-linux-x64/lib/node_modules/appium/node_modules/appium-unlock/bin/unlock_apk-debug.apk");
        caps.setCapability("appPackage", "com.betconstruct.bookie");
        caps.setCapability("appActivity", "com.betconstruct.bookie.activities.SplashActivity");
        if (deviceID.equals("BH905T5H06")) {
            caps.setCapability("appPackage", "com.sonyericsson.home");
            caps.setCapability("appActivity", "com.sonymobile.home.HomeActivity");
        }
        return caps;
    }

    private static URL host(String deviceID) throws MalformedURLException {
        if (hosts == null) {
            hosts = new HashMap<>();
            hosts.put(deviceID, new URL("http://0.0.0.0:4723/wd/hub"));
//            hosts.put("aaaa", new URL("http://0.0.0.0:4723/wd/hub"));
        }
        return hosts.get(deviceID);
    }

    private static ArrayList<String> getAvailableDevices() {
        MyLogger.log.info("Checking for available devices");
        ArrayList<String> availableDevices = new ArrayList<>();
        ArrayList connectedDevices = ADB.getConnectedDevices();
        for (Object connectedDevice : connectedDevices) {
            String device = connectedDevice.toString();
            ArrayList apps = new ADB(device).getInstalledPackages();
            if (!apps.contains(unlockPackage)) availableDevices.add(device);
            else
                MyLogger.log.info("Device: " + device + " has " + unlockPackage + " installed, assuming it is under testing");
        }
        if (availableDevices.size() == 0)
            throw new RuntimeException("Not a single device is available for testing at this time. Or " + unlockPackage + " is not removed");
        return availableDevices;
    }


    private static DriverService createService() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodeJS))
                .withAppiumJS(new File(appiumJS))
                .withIPAddress(host(deviceID).toString().split(":")[1].replace("//", ""))
                .usingPort(Integer.parseInt(host(deviceID).toString().split(":")[2].replace("/wd/hub", "")))
                .build();
        return service;
    }


    public static void createDriver() throws MalformedURLException {
        ArrayList<String> devices = getAvailableDevices();
        for (String device : devices) {
            try {
                deviceID = device;
                MyLogger.log.info("Trying to create new driver for " + device);
                createService().start();
                Android.driver = new AndroidDriver((host(device)), getCaps(device));
                Android.adb = new ADB(device);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void killDriver() {
        if (Android.driver != null) {
            MyLogger.log.info("Killing Android Driver");
            Android.driver.closeApp();
            Android.driver.quit();
            Android.adb.uninstallApp(unlockPackage);
            service.stop();

        } else MyLogger.log.info("Android driver is not initialized, nothing to kill");
    }


}
