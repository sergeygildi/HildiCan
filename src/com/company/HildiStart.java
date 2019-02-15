package com.company;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HildiStart {

    /** TODO Task1                done
        Запилить помник           done
        Почистить репозиторий     done
        Зарефакторить код         done
     **/

    public static void main(String[] args) {

        if(!ArrayUtils.isNotEmpty(args) && args.length == 0) {
            getFileList();
        } else {
            getFileList(args);
        }
    }

    private static void getFileList(){
        Path dir = Paths.get("./").normalize();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*")) {
            for (Path file : stream) {
                System.out.print(file + " ");
            }
        } catch(IOException e1) {
            System.out.println("Carl, we have a problem!");
        }
        System.out.println();
    }

    private static void getFileList(String[] args){
        Path dir = Paths.get("./" + args).normalize();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*")) {
            for (Path file : stream) {
                System.out.print(file + " ");
            }
        } catch(IOException e1) {
            System.out.println("Carl, we have a problem!");
        }
        System.out.println();
    }
}
