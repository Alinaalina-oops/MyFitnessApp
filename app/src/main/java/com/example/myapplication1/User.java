package com.example.myapplication1;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    public int Id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0 && weight < 300)
             this.weight = weight;
    }


    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0 && height < 300)
            this.height = height;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 100)
             this.age = age;
    }

    public boolean isMale;

    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return  name +
                "," + weight +
                "," + height +
                "," + age +
                "," + isMale +
                "," + level +
                "," + Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return weight == user.weight && height == user.height && age == user.age && isMale == user.isMale &&
                Objects.equals(name, user.name) && Objects.equals(level, user.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, height, age, isMale, level);
    }
}
