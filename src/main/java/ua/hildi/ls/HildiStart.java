package ua.hildi.ls;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

class HildiStart {

    public static void main(String[] args) {

        boolean showHiddenDir = shouldShowHiddenDir(args);
        String target = getArgsWhenDoesNotAFlagAtList(args);
        Path targetPath = getCorrectPath(target);

        printAllFilesAtDir(targetPath, showHiddenDir);
    }

    static Path getCorrectPath(String target) {
        if (target == null) {
            return getCurrentDirectory();
        } return getResolvedDirectoryPathOrCurrentDirectory(Paths.get(target));
    }

    static String getArgsWhenDoesNotAFlagAtList(String[] args) {
        for (String argumentList: args) {
            if (!argumentList.equals("-a")) {
                return argumentList;
            }
        }
        return null;
    }

    static boolean shouldShowHiddenDir(String[] args) {
        if (args == null) {
            return false;
        }
        for (String argumentList : args) {
            if (argumentList.equals("-a")) {
                return true;
            }
        }
        return false;
    }

    static Path getResolvedDirectoryPathOrCurrentDirectory(Path targetPath) {
        return getCurrentDirectory().resolve(targetPath);
    }

    static Path getCurrentDirectory() {
        return Paths.get(System.getProperty("user.dir"));
    }

     private static void printAllFilesAtDir(Path path, boolean showHiddenDir) {

        File targetFile = path.toFile();

        File[] filesToPrint;
        if (!targetFile.isFile()) {
            filesToPrint = targetFile.listFiles();
        } else {
            filesToPrint = new File[]{targetFile};
        }

        if (filesToPrint == null) {
            return;
        }

        for (File file : filesToPrint) {
            if (showHiddenDir || !file.isHidden()) {
                System.out.print(file.getName() + " ");
            }
        }
    }
}