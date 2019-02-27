import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HildiStart {

    public static void main(String[] args) {

        Path target, targetPath;

        if (args.length != 0) {
            targetPath = Paths.get(args[0]);
            if (targetPath.isAbsolute()) {
                target = targetPath;
            } else {
                target = getCurrentDirectory().resolve(targetPath);
            }
        } else {
            target = getCurrentDirectory();
        }

        printAllFilesAtDir(target);
    }

    private static Path getCurrentDirectory() {
        return Paths.get(System.getProperty("user.dir"));
    }

    private static void printAllFilesAtDir(Path dir) {

        File[] stream = dir.toFile().listFiles();

        if (stream != null) {
            for (File file : stream) {
                if (!file.isHidden()) {
                    System.out.print(file.getName() + " ");
                }
            }
        }
    }
}
