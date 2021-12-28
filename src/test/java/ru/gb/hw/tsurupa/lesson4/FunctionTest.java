package ru.gb.hw.tsurupa.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {
    @BeforeAll // запускается 1 раз перед всеми тестами сайта, обычно в нем размещаются предусловия (Например создается Веб-драйвер)
    static void beforeMethod() {
        System.out.println("Метод выполнится 1 раз перед каждым тестом");
    }

    @BeforeEach // выполняется перед каждым тестом (Например инициализируется драйвер)
    void  beforeEachMethod () {
        System.out.println("Выполняется перед каждым тестом");
    }
    @Test
    @DisplayName("Позитивная проверка непростого числа")
    void givenPrimeNumberWhenCheckIsNotPrimeThenTrueSimple() {
        boolean result = Functions.isNumberPrime(4);
        Assertions.assertFalse(result); //Проверяем, что метод вернет false
    }

    @Test
    @DisplayName("Позитивная проверка непростого числа")
    void givenPrimeNumberWhenCheckIsPrimeThenTrueSimple() {
        boolean result = Functions.isNumberPrime(7);
        Assertions.assertTrue(result); //Проверяем, что метод вернет true
    }

    @ParameterizedTest //параметризованный тест
    @ValueSource(ints = {1, 3, 11}) //тестовые данные (в виде целочисленных значений).
    // Тест запустится столько раз, сколько у нас есть тестовых значений, каждый раз подставляя вместо number числа из списка
    @DisplayName("Позитивная проверка простого числа (параметризованный тест)")
    void givenPrimeNumberWhenCheckIsPrimeThenTrue(int number) {
        boolean result = Functions.isNumberPrime(1);
        Assertions.assertTrue(result); //Проверяем, что метод вернет true
    }

    @ParameterizedTest // тест, где вместе со списком входных данных будем передавать результат проверки (true/false)
    @CsvSource({"1, true", "3, true", "6, false"}) //перадача пары значений
    @DisplayName("Позитивная проверка непростого/простого числа (параметризованный тест)")
    void givenPrimeNumber(int number, boolean result) {
        Assertions.assertEquals(result, Functions.isNumberPrime(number));
    }

    @ParameterizedTest
    @MethodSource("catsDataProvider")
    void testCat(Cat cat, boolean result) {
        System.out.println(cat);
        System.out.println(result);
    }

    private static Stream<Arguments> catsDataProvider(){// Метод, который предоставляет (генерирует) тестовые данные.
        // Такие методы принято называть DataProvide
    return Stream.of(Arguments.arguments(new Cat("Black", 6), true),
        Arguments.arguments(new Cat("White", 6), false));
    //данные, которые мы хотим передать в наш тестовый метод
    }

    @Test
    void catsAge() {
        Assertions.assertEquals(new Cat("White", 6), new Cat("Black", 6));
    }

    @Test
    void firstTest() {
        boolean result = Functions.isPolindrome("123321");
        assertThat(result).isTrue();
    }

    @Test
    void secondTest() {
        List<String> testCollection = new ArrayList<>(Arrays.asList("test1,", "test2", "test3"));
        assertThat(testCollection).containsAnyOf("test2", "test1");
        assertThat(5).isGreaterThan(3).isLessThan(8);
    }

    @AfterEach
    void afterEach() {
        System.out.println("Метод выполнится после каждого теста");   // Например, закрытие браузера, чистка куки
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Выполнится 1 раз после всех тестов");
    }
//1:15:30
}
