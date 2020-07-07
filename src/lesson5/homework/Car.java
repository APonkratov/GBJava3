package lesson5.homework;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private final Race race;
    private final int speed;
    private final String name;
    private final CountDownLatch countDownLatchReady;
    private final CountDownLatch countDownLatchFinish;
    private static final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch countDownLatchReady, CountDownLatch countDownLatchFinish) {
        this.race = race;
        this.speed = speed;
        this.countDownLatchReady = countDownLatchReady;
        this.countDownLatchFinish = countDownLatchFinish;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            countDownLatch.countDown();
            countDownLatchReady.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long startTime = System.currentTimeMillis();
        int stagesCount = race.getStages().size();

        for (int i = 0; i < stagesCount; i++) {
            race.getStages().get(i).go(this, i + 1, stagesCount, startTime);
        }

        countDownLatchFinish.countDown();
    }
}
