package ru.gb.hw.tsurupa.lesson4;

public class Box {
    private Integer ballsCount;


    public Box() {
        this.ballsCount = 0;
    }

    public Integer getBallsCount() {
        return ballsCount;
    }

    public void shuffleBalls() throws Exception {
       if (ballsCount <= 0) throw new Exception("Нельзя встряхнуть пустую коробку");
    }

    public void addBall() {
        ballsCount++;
    }

    public void removeBalls() throws Exception {
        if (ballsCount == 0) throw new Exception("коробка пустая");
        ballsCount--;
    }
}
