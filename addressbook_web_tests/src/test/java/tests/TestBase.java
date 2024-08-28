package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestBase {
    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "chrome"));
    }

    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        return result;
    }

    public static String randomPhone(int n) {
        var rnd = new Random();
        var result = "";
        if (n != 0) {
            result = result + "+7";

            for (int i = 0; i < 10; i++) {
                result = result + (char) ('1' + rnd.nextInt(9));
            }
        }
        return result;
    }
}
