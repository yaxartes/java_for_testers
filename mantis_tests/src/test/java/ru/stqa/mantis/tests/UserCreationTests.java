package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.Common;
import ru.stqa.mantis.model.DeveloperMailUser;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;

public class UserCreationTests extends TestBase {
    DeveloperMailUser mailUser;

    @Test
    void canCreateNewUser() {
        mailUser = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", mailUser.name());
        UserData newUser = new UserData().withName(mailUser.name())
                .withEmail(email)
                .withPassword("password");
        app.users().createUser(newUser);

        var message = app.developerMail().receive(mailUser, Duration.ofSeconds(10));
        var url = Common.extractUrlFromText(message);

        //перейти по ссылке
        app.session().confirmRegistration(url);
        app.users().setPassword(newUser);

        //проверить вход под новым пользователем
        app.http().login(newUser.name(), newUser.password());
        Assertions.assertTrue(app.http().IsLoggedIn());
    }

    @AfterEach
    void deleteMailUser() {
        app.developerMail().deleteUser(mailUser);
    }
}
