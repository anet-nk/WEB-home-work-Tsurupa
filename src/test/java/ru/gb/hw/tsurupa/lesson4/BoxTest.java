package ru.gb.hw.tsurupa.lesson4;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BoxTest {
    Box box;

    @Nested
     class WhenIsEmpty {
        @BeforeEach
        void createBox() {
            box = new Box();
        }

        @Test
        void addBallTest() {
            box.addBall();
            assertThat(box.getBallsCount()).isEqualTo(1);
        }

        @Test
        void exceptionWhenTryShufflwEmptyBox() {
            Assertions.assertThrows(Exception.class, () -> box.shuffleBalls());
            assertThatExceptionOfType(Exception.class).isThrownBy(() -> box.shuffleBalls());
        }

        @Nested
        class WhenWithBalls {
            @BeforeEach
            void addBall() {
                box.addBall();
            }

            @Test
            void removeBallTest() throws Exception {
                box.removeBalls();
                assertThat(box.getBallsCount()).isEqualTo(0);
            }
        }

    }


}
