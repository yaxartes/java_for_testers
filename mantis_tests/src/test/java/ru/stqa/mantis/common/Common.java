package ru.stqa.mantis.common;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Common {

    public static String randomString(int n) {
        var rnd = new Random();
        Supplier<Integer> randomNumber = () -> rnd.nextInt(26);
        return Stream.generate(randomNumber)
                .limit(n).map(i -> 'a' + i)
                .map(Character::toString)
                .collect(Collectors.joining());
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

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}
