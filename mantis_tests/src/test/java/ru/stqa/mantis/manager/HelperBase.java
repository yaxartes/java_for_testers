package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.nio.file.Paths;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void click(By locator) {
        manager.driver().findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver().findElement(locator).clear();
        manager.driver().findElement(locator).sendKeys(text);
    }

    protected boolean isElementPresent(By locator) {
        try {
            manager.driver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void attach(By locator, String file) {
        manager.driver().findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }
}
