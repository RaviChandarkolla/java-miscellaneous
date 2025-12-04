package sealedclasses;

public sealed class Animal permits Dog, Cat, Bird {
    public void makeSound() {
        System.out.println("animal");
    }
}
