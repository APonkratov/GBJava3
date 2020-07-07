package lesson5.homework;

import java.util.concurrent.Semaphore;
public class Tunnel extends Stage {

    private static final Semaphore semaphore = new Semaphore(MainClass.CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car car, int stagePos, int stageCount, long startTime) {
        try {
            try {
                System.out.println(car.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(car.getName() + " начал этап: " + description);
                Thread.sleep(length / car.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                long stageFinishTime = System.currentTimeMillis() - startTime;
                System.out.println(car.getName() + " закончил этап: " + description
                        + ", за время, сек = " + ((float)(stageFinishTime) / 1000));
                semaphore.release();
                if (stagePos == stageCount && !MainClass.gotWinner) {
                    MainClass.gotWinner = true;
                    System.out.println(car.getName() + " WIN!!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
