package designpatterns.creational.singleton;

// This is the best, most thread-safe, and serialization-safe way to create singletons
// The drawback is that the enum type is somewhat inflexible (for example, it does not allow lazy initialization).
// The constants defined within an enum are implicitly static and final, meaning their values cannot be changed after declaration.
enum Singleton {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void show() {
        System.out.println("Singleton value is: " + value);
    }
}

public class EnumSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.setValue(42);
        singleton.show();  // Output: Singleton value is: 42

        // Access the same instance elsewhere
        Singleton anotherRef = Singleton.INSTANCE;
        anotherRef.show(); // Output: Singleton value is: 42
    }
}

