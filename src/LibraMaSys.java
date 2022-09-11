import app.App;

public class LibraMaSys {
    public static final String APP_NAME_AND_VERSION = "LibraMaSys v0.4";

    public static void main(String[] args) {
        App app = new App(APP_NAME_AND_VERSION);
        app.loop();
    }
}
