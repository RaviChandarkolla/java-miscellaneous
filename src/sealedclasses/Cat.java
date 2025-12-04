package sealedclasses;

public final class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}