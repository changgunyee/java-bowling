package bowling.domain;

import bowling.domain.frame.NormalFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfPlayerTest {

    private GameOfPlayer gameOfPlayer;
    private NormalFrame normalFrame;

    @BeforeEach
    void setUp() {
        gameOfPlayer = new GameOfPlayer(new Player("pob"));
        normalFrame = new NormalFrame(0);
    }

    @Test
    @DisplayName("게임 종료")
    void isGameEnd_true() {
        IntStream.range(0, 12).forEach(i -> gameOfPlayer.playFrame(10, normalFrame));

        assertThat(gameOfPlayer.isGameEnd()).isTrue();
    }


    @Test
    @DisplayName("게임 종료 실패")
    void isGameEnd_false() {
        IntStream.range(0, 11).forEach(i -> gameOfPlayer.playFrame(10, normalFrame));

        assertThat(gameOfPlayer.isGameEnd()).isFalse();
    }
}