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

    private static Path dir;

    public static void main(String[] args) {

        if(!ArrayUtils.isNotEmpty(args) && args.length == 0) {
            getFileList();
        } else {
            getFileList(args);
        }
    }

    private static void getFileList(){
        dir = Paths.get("./").normalize();
        printAllFilesAtDir(dir);
    }

    private static void getFileList(String[] args){
        dir = Paths.get("./" + args).normalize();
        printAllFilesAtDir(dir);
    }

    private static void printAllFilesAtDir(Path dir) {
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
