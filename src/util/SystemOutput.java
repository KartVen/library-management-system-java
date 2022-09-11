package util;

import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.util.Objects;

public class SystemOutput implements Output {

    @Override
    public void print(Object value) {
        System.out.print(value);
    }

    @Override
    public void println(Object value) {
        System.out.printf("%s%n", value);
    }

    @Override
    public void nextLine() {
        System.out.printf("%n");
    }


    @Override
    public void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
