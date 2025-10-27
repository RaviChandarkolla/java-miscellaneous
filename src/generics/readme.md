# Java Generics

Generics in Java refer to the feature that allows classes, interfaces, and methods to operate on types specified as parameters, instead of specific concrete types. Simply put, generics let you write type-safe, reusable code that can work with different data types while catching type errors at compile time.

What generics mean in Java:

1) They enable you to define parameterized types using type variables (like '<T>).

2) Instead of writing a separate class or method for every data type, you write a single generic class or method that works with any type.

3) The actual type gets specified when creating an instance or calling a method (called type instantiation).

4) Generics provide compile-time type safety and eliminate the need for explicit casting.

Key Takeaways:
1) Generics improve code reusability by supporting any reference type.

2) They enhance type safety by catching errors at compile time.

3) They reduce casting clutter and improve readability.

5) Widely used in Java Collections and APIs.


```
// Generic class with type parameter T
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println(stringBox.get());  // Output: Hello Generics

        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println(intBox.get());    // Output: 123
    }
}
```
***
# Java generics bound type parameter

In Java generics, a bounded type parameter allows you to restrict the types that can be used as arguments for a generic type parameter. This restriction is established using the extends keyword to specify an upper bound, meaning the type parameter can only be a subclass (or the class itself) of the specified bound.

Purpose of Bounded Type Parameters:
1) To ensure that the generic type parameter is limited to a certain class hierarchy.

2) To enable access to methods of the upper bound class inside the generic class or method.

3) To improve type safety by preventing invalid types and catching errors at compile time.

```declarative
// Generic class where T must be a subclass of Number
class Box<T extends Number> {
    private T value;
    
    public Box(T value) {
        this.value = value;
    }
    
    public double doubleValue() {
        return value.doubleValue(); // Safe to call because T extends Number
    }
}

public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(123);
        System.out.println("Value as double: " + intBox.doubleValue());

        Box<Double> doubleBox = new Box<>(45.67);
        System.out.println("Value as double: " + doubleBox.doubleValue());

        // Box<String> stringBox = new Box<>("Hello"); // Compile-time error: String is not a subclass of Number
    }
}
``` 
Key points:
1) T extends Number means any subclass of Number (like Integer, Double, Float) is allowed.

2) You can call any method defined in Number safely on T.

3) Passing unrelated types outside the bound (like String) will cause compile-time errors.

4) You can also specify multiple bounds like <T extends ClassA & InterfaceB> but only one class and multiple interfaces.

5) This feature enhances type safety and flexibility in generic programming by allowing controlled, safe use of types.

6) Java Generics supports multiple bounds also, i.e <T extends A & B & C>. In this case, A can be an interface or class. If A is class then B and C should be an interface. We can’t have more than one class in multiple bounds.

***

# Java generic subtyping

In Java, generic classes and subtyping work a bit differently compared to regular class inheritance.

Key Points:
1) If S is a subtype of T, it does not imply that `GenericClass<S>` is a subtype of GenericClass<T>.

2) For example, even though Integer is a subtype of Number, List<Integer> is NOT a subtype of List<Number>.
   
3) This is because generic classes are invariant in their type parameter by default.

Subtyping With Generic Classes:
You can subtype a generic class by extending or implementing it, but the relationship between the type parameters matters:

```
class MyList<T> { /* ... */ }

class MySpecializedList<T> extends MyList<T> { /* ... */ }

```

Example

```declarative
List<Number> numbers = new ArrayList<>();
List<Integer> integers = new ArrayList<>();

// numbers = integers; // Compile error! List<Integer> is NOT a List<Number>

// But:
ArrayList<String> arrayList = new ArrayList<>();
List<String> list = arrayList;  // This is valid because ArrayList<String> IS-A List<String>

```

To allow covariance (read-only access), use wildcards:

```declarative
List<? extends Number> nums = new ArrayList<Integer>();

```
This means nums can be a list of any subtype of Number.

Summary:
1) Generic classes are not covariant by default w.r.t. their type parameters.

2) `GenericClass<S>` is not a subtype of GenericClass<T> even if S is a subtype of T.

3) Subtyping applies normally to the raw generic class but type parameters must match exactly.

4) Use wildcards (? extends T or ? super T) to work around this limitation when necessary.

This characteristic helps maintain type safety in Java generics.

***