package ru.stqa.mantis.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Properties;

public class ApplicationManager {
    private WebDriver driver;

    private String browser;

    private Properties properties;

    private SessionHelper sessionHelper;

    public void init(String browser, Properties properties) {
        this.browser = browser;
        this.properties = properties;
    }

    public WebDriver driver() {
        if (driver == null) {
            if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if ("safari".equals(browser)) {
                driver = new SafariDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown Browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
        }
        return driver;
    }

    public SessionHelper session() {
        if (sessionHelper == null) {
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
    }
}
