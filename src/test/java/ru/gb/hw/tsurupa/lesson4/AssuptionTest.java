package ru.gb.hw.tsurupa.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssuptionTest { //проверяет предусловие
    @Test
    void assuptionTest() {
        Assumptions.assumeTrue(1 == 2); //предусловие
        Assertions.assertTrue(1 == 1); //проверка
    }

    @Test
    void softAssertionTest() {
       Assertions.assertAll( //Assertions позволяет пройтись по всем проверкам, даже если первая упадет,
                            // последующие выполнятся, и в отчет попадет инфа о каждом падении
               () -> Assertions.assertTrue(false),
               () -> Assertions.assertTrue(false),
               () -> Assertions.assertTrue(true)
       );
    }
}
