package ua.hildi.ls;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Serhii Hildi on 05.03.19.
 */
public class HildiStartTest {

    /*
        Проверки. Если:
            - нет аргументов
            - есть флаг
            - есть другой флаг
            - есть флаг, но нет аргументов
            - если есть аргумент, но нет флага
            - передан абосютный путь к файлу
            - передан абосютный путь к папке
            - передан путь к файлу
            - передан путь к папке
            - пробуем спуститься на директорию ниже
            - передан null
            - передано отрицательное значение
     */

//    @Test
//    public void name() {
        // given
        // setup test data

        // when
        // invoke service(method) under test


        // then
        // assert that result is expected
        // Assert.assertEquals("result must be equal to true", true, result);
//    }

    @Test
    public void shouldShowHiddenDirMustReturnTrueIfSpecificArgumentIsPresent() {

        String[] args = {"hilde", "-a", "balumba"};

        boolean result = HildiStart.shouldShowHiddenDir(args);

        Assert.assertTrue("result must be equal to true", result);
    }

    @Test
    public void shouldShowHiddenDirMustReturnFalseIfSpecificArgumentIsMissing() {

        String[] args = {"hilde", "/user/home", "balumba"};

        boolean result = HildiStart.shouldShowHiddenDir(args);

        Assert.assertFalse("result must be equal to false", result);
    }

    @Test
    public void shouldReturnNullIfArgumentsIsMissing() {

        String[] args = {};

        String result = HildiStart.getArgsWhenDoesNotAFlagAtList(args);

        Assert.assertNull("result must be equal to null", result);
    }

    @Test
    public void shouldReturnFirstArgumentIfThatNotEqualsSpecificArgument() {

        String[] args = {"123", "456", "789"};

        String result = HildiStart.getArgsWhenDoesNotAFlagAtList(args);

        Assert.assertEquals("result must be equal to array first element", args[0], result);
    }

    @Test
    public void shouldNotThrowExceptionArgsIsNull() {
        // given
        String[] args = null;

        // when
        HildiStart.shouldShowHiddenDir(args);

        // then
        /// test pass if no exceptions were thrown
    }
}
