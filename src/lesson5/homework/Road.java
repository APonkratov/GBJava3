package lesson5.homework;

public class Road extends Stage {

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car car, int stagePos, int stageCount, long startTime) {
        try {
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000);

            long stageFinishTime = System.currentTimeMillis() - startTime;
            System.out.println(car.getName() + " закончил этап: " + description
                    + ", за время, сек = " + ((float)(stageFinishTime) / 1000));

            if (stagePos == stageCount && !MainClass.gotWinner) {
                MainClass.gotWinner = true;
                System.out.println(car.getName() + " WIN!!!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
