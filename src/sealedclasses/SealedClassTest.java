package sealedclasses;

public class SealedClassTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        Animal cat = new Cat();
        cat.makeSound();

        Animal dog = new Dog();
        dog.makeSound();

        Animal bird = new Bird();
        bird.makeSound();

        Animal crow = new Crow();
        crow.makeSound();


    }
}
