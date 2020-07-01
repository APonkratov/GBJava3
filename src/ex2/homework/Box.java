package ex2.homework;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private final List<Fruit> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public boolean compare(Box box) {
        return getWeight() == box.getWeight();
    }

    public float getWeight() {
        float weight = 0;

        for (Fruit element: fruits) {
            weight += element.getWeight();
        }
        return weight;
    }

    public void addFruit(Fruit fruit) {
        if (fruits.isEmpty() ||
                fruits.get(0).getClass() == fruit.getClass()) {
            fruits.add(fruit);
        } else {
            System.out.println("This box is not compatible for this fruit");
        }
    }
}

interface Fruit {
    float getWeight();
}

class Apple implements Fruit{
    private final float weight;

    public Apple() {
        super();
        weight = 1.0f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}

class Orange implements Fruit{
    private final float weight;

    public Orange() {
        super();
        weight = 1.5f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}

class Test {
    public static void main(String[] args) {
        Box appleBox = new Box();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box orangeBox = new Box();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Apple box weight is " + appleBox.getWeight());
        System.out.println("Orange box weight is " + orangeBox.getWeight());

        if (appleBox.compare(orangeBox)) {
            System.out.println("Boxes have the same weight");
        } else {
            System.out.println("Boxes have different weights");
        }

        Box multiBox = new Box();
        multiBox.addFruit(new Apple());
        multiBox.addFruit(new Orange());
    }
}