package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.Common;
import ru.stqa.mantis.model.User;

import java.time.Duration;

public class UserRegistrationTests extends TestBase {
    @Test
    void canRegisterNewUser() {
        //создать email
        User newUser = new User().withName(Common.randomString(7))
                .withEmail(String.format("%s@localhost", Common.randomString(6)))
                .withPassword("password");
        app.jamesCli().addUser(newUser.email(), newUser.password());

        //создать пользователя mantis
        app.session().login(app.property("web.usernameAdmin"), app.property("web.passwordAdmin"));
        app.users().createUser(newUser);

        //получить письмо со ссылкой
        var messages = app.mail().receive(newUser.email(), newUser.password(), Duration.ofSeconds(20));
        var url = Common.extractUrlFromText(messages.get(0).content());

        //перейти по ссылке
        app.session().confirmRegistration(url);
        app.users().setPassword(newUser);

        //проверить вход под новым пользователем
        app.http().login(newUser.name(), newUser.password());
        Assertions.assertTrue(app.http().IsLoggedIn());
    }
}
