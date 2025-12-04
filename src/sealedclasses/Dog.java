package sealedclasses;

public final class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}
