package io.gocklkatz.daypacker;

public class Food {

    private String name;
    private int value;
    private int calories;

    public Food(String name, int value, int calories) {
        this.name = name;
        this.value = value;
        this.calories = calories;
    }

    public int benefit() {
        return getValue();
    }

    public int cost() {
        return getCalories();
    }

    public double density() {
        return benefit() * 1.0 / cost();
    }

    // ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", calories=" + calories +
                ", density=" + density() +
                '}';
    }
}
