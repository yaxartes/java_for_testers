package ru.stqa.addressbook.common;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class Common {

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

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}
