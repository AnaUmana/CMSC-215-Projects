/*
 * Author: Ana Umana
 * CMSC 215 Project 1
 * Date: 08/24/25
 * 
 * The Player class will store the players name, height and age and be immutable
 */

 public final class Player {
    private final String name;
    private final Height height;
    private final int age;

    public Player(String name, Height height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    //Now establish getters with no setters method
    public String getName() {
        return name;
    }

    public Height getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    //finally initalize toString
     @Override
    public String toString() {
        return "Name: " + name + " Height: " + height.toString() + " Age: " + age;
    }
 }