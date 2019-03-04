import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HildiStart {

    private static Path target;

    public static void main(String[] args) {

        Path targetPath;

        if (args.length > 0) {

            if (args[0].equals("-a")) {

                /** When argument with a flag. */
                if (args.length == 2) {
                    targetPath = Paths.get(args[1]);
                    Path path = checkDirectory(targetPath);
                    printAllFilesAtDir(path, true);
                } else {
                /** When we don't have second arg. Only flag. */
                    printAllFilesAtDir(getCurrentDirectory(), true);
                }

            } else {
                /** When argument without flag. */
                targetPath = Paths.get(args[0]);
                Path path = checkDirectory(targetPath);
                printAllFilesAtDir(path, false);
            }
            /** Without arguments. */
        } else {
            printAllFilesAtDir(getCurrentDirectory(), false);
        }
    }

    private static Path checkDirectory(Path targetPath) {
        if (targetPath.isAbsolute()) {
            return target = targetPath;
        } else {
            return target = getCurrentDirectory().resolve(targetPath);
        }
    }

    private static Path getCurrentDirectory() {
        return Paths.get(System.getProperty("user.dir"));
    }

    private static void printAllFilesAtDir(Path dir, boolean showHiddenDir) {

        File[] stream = dir.toFile().listFiles();

        if (stream != null) {
            for (File file : stream) {
                if (!showHiddenDir) {
                    if (!file.isHidden()){
                        System.out.print(file.getName() + " ");
                    }
                } else {
                    System.out.print(file.getName() + " ");
                }
            }
        }
    }
}
