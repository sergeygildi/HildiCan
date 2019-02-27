package ua.hildi.ls;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HildiStart {

    public static void main(String[] args) {

        Path targetPath;

        if (args.length > 0) {

            if (args[0].equals("-a")) {

                // When argument with a flag.
                if (args.length == 2) {
                    targetPath = Paths.get(args[1]);
                    Path path = checkDirectory(targetPath);
                    printAllFilesAtDir(path, true);
                } else {
                    // When we don't have second arg. Only flag.
                    printAllFilesAtDir(getCurrentDirectory(), true);
                }

            } else {
                // When argument without flag.
                targetPath = Paths.get(args[0]);
                Path path = checkDirectory(targetPath);
                printAllFilesAtDir(path, false);
            }
            // Without arguments.
        } else {
            printAllFilesAtDir(getCurrentDirectory(), false);
        }
    }

    private static Path checkDirectory(Path targetPath) {
            return getCurrentDirectory().resolve(targetPath);
    }

    private static Path getCurrentDirectory() {
        return Paths.get(System.getProperty("user.dir"));
    }

    private static void printAllFilesAtDir(Path dir, boolean showHiddenDir) {

        File[] fileArray = dir.toFile().listFiles();

        if (fileArray == null) {
            return;
        }

        for (File file : fileArray) {
            if (showHiddenDir || !file.isHidden()) {
                System.out.print(file.getName() + " ");
            }
        }
    }
}