package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.model.User;

public class UserHelper extends HelperBase {
    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createUser(User user) {
        openManageUsersPage();
        initNewUserCreation();
        fillUserCreationForm(user);
        submitUserCreation();
    }

    public void setPassword(User user) {
        type(By.name("password"), user.password());
        type(By.name("password_confirm"), user.password());
        click(By.cssSelector("button[type='submit']"));
    }

    private void submitUserCreation() {
        click(By.cssSelector("input[type='submit']"));
    }

    private void fillUserCreationForm(User user) {
        type(By.name("username"), user.name());
        type(By.name("realname"), user.name());
        type(By.name("email"), user.email());
    }

    private void initNewUserCreation() {
        click(By.linkText("Create New Account"));
    }

    private void openManageUsersPage() {
        click(By.xpath("//span[text() = ' Manage ']/ancestor::a"));
        click(By.linkText("Manage Users"));
    }
}
