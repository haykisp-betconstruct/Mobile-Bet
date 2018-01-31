package api.interfaces;

public interface Application {

    void forceStop();

    void clearData();

    Object open();

    String packageId();

    String activityID();

}
