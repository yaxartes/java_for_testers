package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.Common;

import java.time.Duration;

public class MailTests extends TestBase {

    @Test
    void canReceiveEmail() {
        var messages = app.mail().receive("user1@localhost", "password", Duration.ofSeconds(60));
        Assertions.assertEquals(1, messages.size());
        System.out.println(messages);
    }

    @Test
    void canDrainInbox() {
        app.mail().drain("user1@localhost", "password");
    }

    @Test
    void canExtractUrl() {
        var messages = app.mail().receive("user2@localhost", "password", Duration.ofSeconds(60));
        var text = Common.extractUrlFromText(messages.get(0).content());
        System.out.println(text);
    }
}
