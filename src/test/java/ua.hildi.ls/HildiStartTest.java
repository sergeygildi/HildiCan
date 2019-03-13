package ua.hildi.ls;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Serhii Hildi on 05.03.19.
 */
public class HildiStartTest {

    @Test
    public void shouldShowHiddenDirMustReturnTrueIfSpecificArgumentIsPresent() {

        String[] args = {"hilde", "-a", "balumba"};

        boolean result = HildiStart.shouldShowHiddenFilesAndDirs(args);

        Assert.assertTrue("result must be equal to true", result);
    }

    @Test
    public void shouldReturnFalseIfArgsIsNull() {

        String[] args = null;

        boolean result = HildiStart.shouldShowHiddenFilesAndDirs(args);

        Assert.assertFalse("result must be equal to false", result);
    }

    @Test
    public void shouldReturnFalseIfArrayIsEmpty() {

        String[] args = {};

        boolean result = HildiStart.shouldShowHiddenFilesAndDirs(args);

        Assert.assertFalse("result must be equal to false", result);
    }

    @Test
    public void shouldReturnFalseIfArgsIsNotASpecificArgument() {

        String[] args = {"2", "weq", "-b"};

        boolean result = HildiStart.shouldShowHiddenFilesAndDirs(args);

        Assert.assertFalse("result must be equal to false", result);
    }

    @Test
    public void shouldShowHiddenDirMustReturnFalseIfSpecificArgumentIsMissing() {

        String[] args = {"hilde", "/user/home", "balumba"};

        boolean result = HildiStart.shouldShowHiddenFilesAndDirs(args);

        Assert.assertFalse("result must be equal to false", result);
    }

    @Test
    public void testPassIfArgsIsRelativePath() {

        String[] args = {"target"};
        Path path = HildiStart.getCurrentDirectory().resolve(Paths.get(args[0]));
        Path result = HildiStart.getPath(path);

        Path expected = Paths.get(System.getProperty("user.dir") + File.separator + args[0]);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testPassIfArgsIsAbsolutePath() {

        String[] args = {"/target"};
        Path path = HildiStart.getCurrentDirectory().resolve(Paths.get(args[0]));
        Path result = HildiStart.getPath(path);

        Path expected = Paths.get(args[0]);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnResolvedDirectoryPathIfArgumentNotNull() {

        String[] args = {"/target"};

        String target = HildiStart.getFirstArraysArgumentOrNull(args);
        Path correctPath = HildiStart.getResolvedPathIfArgumentNotNull(target);
        Path result = HildiStart.getCurrentDirectory().resolve(correctPath);

        Path expected = Paths.get(args[0]);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnNullIfArgumentsIsMissing() {

        String[] args = {};

        String result = HildiStart.getFirstArraysArgumentOrNull(args);

        Assert.assertNull("result must be equal to null", result);
    }

    @Test
    public void shouldReturnCurrentPathIfTargetArgsIsNull() {

        Path result = HildiStart.getResolvedPathIfArgumentNotNull(null);

        Path expectedPath = Paths.get(System.getProperty("user.dir"));

        Assert.assertEquals(expectedPath, result);
    }

    @Test
    public void shouldReturnNullWhenFileArrayIsNull() {

        File[] file = null;

        String result = HildiStart.print(file, false);

        Assert.assertNull("result must be equal to false", result);
    }

    @Test
    public void shouldReturnFirstArgumentIfThatNotEqualsSpecificArgument() {

        String[] args = {"123", "456", "789"};

        String result = HildiStart.getFirstArraysArgumentOrNull(args);

        Assert.assertEquals("result must be equal to array first element", args[0], result);
    }

    @Test
    public void shouldReturnArgumentOfString() {

        String[] args = {"-a", "target"};

        boolean showHiddenFilesAndDirs = HildiStart.shouldShowHiddenFilesAndDirs(args);
        String target = HildiStart.getFirstArraysArgumentOrNull(args);
        Path targetPath = HildiStart.getResolvedPathIfArgumentNotNull(target);
        File[] fileToPrint = HildiStart.getFileToPrint(targetPath);
        String result = HildiStart.print(fileToPrint, showHiddenFilesAndDirs);

        Assert.assertNotNull("result must be equal to true", result);
    }

    @Test
    public void shouldNotThrowExceptionArgsIsNull() {
        // given
        String[] args = {};

        // when
        HildiStart.shouldShowHiddenFilesAndDirs(args);

        // then
        /// test pass if no exceptions were thrown
    }
}
