package core;

import javax.print.attribute.standard.MediaSize;

public class TestInfo {

    private static String
            TIMESTAMP,
            SUITE,
            ID,
            NAME,
            STATUS;


    public void reset() {
        TIMESTAMP = null;
        SUITE = null;
        ID = null;
        NAME = null;
        STATUS = null;
    }

    public TestInfo temestamp(String value) {
        TIMESTAMP = value;
        return this;
    }

    public TestInfo suite(String value) {
        SUITE = value;
        return this;
    }

    public TestInfo id(String value) {
        ID = value;
        return this;
    }

    public TestInfo name(String value) {
        NAME = value;
        return this;
    }

    public TestInfo status(String value) {
        STATUS = value;
        return this;
    }


    public static String timestamp() {
        return TIMESTAMP;
    }

    public static String suite() {
        return SUITE;
    }

    public static String id() {
        return ID;
    }

    public static String name() {
        return NAME;
    }

    public static String status() {
        return STATUS;
    }

    public static void printResults() {
        MyLogger.log.info("Test ID: " + id());
        MyLogger.log.info("Test Name: " + name());
        MyLogger.log.info("Test Suite: " + suite());
    }

}
