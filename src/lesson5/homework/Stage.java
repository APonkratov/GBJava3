package lesson5.homework;

public abstract class Stage {
    protected int length;
    protected String description;

    public abstract void go(Car car, int stagePos, int stageCount, long startTime);
}
