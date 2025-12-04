package sealedclasses;

public non-sealed class Bird extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Tweet");
    }
}