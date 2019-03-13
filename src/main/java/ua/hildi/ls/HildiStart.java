package ua.hildi.ls;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

class HildiStart {

    public static void main(String[] args) {
        ls(args);
    }

    private static void ls(String[] args) {
        boolean showHiddenFilesAndDirs = shouldShowHiddenFilesAndDirs(args);
        String target = getFirstArraysArgumentOrNull(args);
        Path targetPath = getResolvedPathIfArgumentNotNull(target);
        File[] fileToPrint = getFileToPrint(targetPath);
        print(fileToPrint, showHiddenFilesAndDirs);
    }

    static String print(File[] file, boolean showHiddenFilesAndDirs) {
        if (file == null) {
            return null;
        }

        StringBuilder argument = new StringBuilder();
        for (File files : file) {
            if (showHiddenFilesAndDirs || !files.isHidden()) {
                argument.append(files.getName()).append(" ");
            }
        }
        System.out.println(argument);

        return argument.toString();
    }

    static File[] getFileToPrint(Path path) {
        File targetFile = path.toFile();

        File[] filesToPrint;
        if (!targetFile.isFile()) {
            filesToPrint = targetFile.listFiles();
        } else {
            filesToPrint = new File[]{targetFile};
        }

        return filesToPrint;
    }

    static Path getResolvedPathIfArgumentNotNull(String target) {
        if (target != null) {
            return getPath(Paths.get(target));
        }
        return getCurrentDirectory();
    }

    static String getFirstArraysArgumentOrNull(String[] args) {
        for (String argumentList: args) {
            if (!argumentList.equals("-a")) {
                return argumentList;
            }
        }
        return null;
    }

    static boolean shouldShowHiddenFilesAndDirs(String[] args) {
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

    static Path getPath(Path targetPath) {
        return getCurrentDirectory().resolve(targetPath);
    }

    static Path getCurrentDirectory() {
        return Paths.get(System.getProperty("user.dir"));
    }
}