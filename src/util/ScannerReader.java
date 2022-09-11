package util;

import java.util.Scanner;

public class ScannerReader {
    private final Scanner scanner;

    public ScannerReader() {
        this.scanner = new Scanner(System.in);
    }

    public void nextAnyButton() {
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public int nextInt() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public void close() {
        scanner.close();
    }
}
