package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {

    public SessionHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(String username, String password) {
        type(By.name("username"), username);
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));
    }

    public boolean IsLoggedIn() {
        return isElementPresent(By.cssSelector("span.user-info"));
    }

    public void confirmRegistration(String url) {
        manager.driver().get(url);
    }
}
