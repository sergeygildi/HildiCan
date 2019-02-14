package com.company;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class HildiStart {

    private static Scanner sc;
    private String ls = "ls";

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        String line = sc.nextLine();

        while(line != null) {
            if (line.equals("ls")){
                getFileList();
//            } else if (line.equals("ls -l")) {
            }
            line = sc.nextLine();
        }
    }

    private static void getFileList(){
        String path = "";
        Path dir = Paths.get(path);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*")) {
            for (Path file : stream) {
                System.out.print(file + " ");
            }
        } catch(IOException e1) {
            System.out.println("Carl, we have a problem!");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HildiStart main = (HildiStart) o;
        return Objects.equals(ls, main.ls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ls);
    }
}