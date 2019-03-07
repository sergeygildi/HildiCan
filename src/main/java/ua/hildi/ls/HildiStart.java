package ua.hildi.ls;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

class HildiStart {

    public static void main(String[] args) {

        boolean showHiddenDir = shouldShowHiddenDir(args);
        String target = getBackArgsListWhenItDoesNotHaveAFlag(args);
        Path targetPath = getCorrectPath(target);

        printAllFilesAtDir(targetPath, showHiddenDir, target);
    }

    private static Path getCorrectPath(String target) {
        if (target == null) {
            return getCurrentDirectory();
        } return getResolvedDirectoryPathOrCurrentDirectory(Paths.get(target));
    }

    private static String getBackArgsListWhenItDoesNotHaveAFlag(String[] args) {
        for (String argumentList: args) {
            if (!argumentList.equals("-a")) {
                return argumentList;
            }
        }
        // TODO fix this bag
        return "";
    }

    private static boolean shouldShowHiddenDir(String[] args) {
        for (String argumentList : args) {
            if (argumentList.equals("-a")) {
                return true;
            }
        }
        return false;
    }

    private static Path getResolvedDirectoryPathOrCurrentDirectory(Path targetPath) {
            return getCurrentDirectory().resolve(targetPath);
    }

    private static Path getCurrentDirectory() {
        return Paths.get(System.getProperty("user.dir"));
    }

    private static void printAllFilesAtDir(Path path, boolean showHiddenDir, String target) {

        if (target == null){
            return;
        }

        File[] fileArray = path.toFile().listFiles();
        boolean isThatAFile = new File(target).isFile();

        if (isThatAFile) {
            System.out.print(path.getFileName());
        }

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