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
1) If S is a subtype of T, it does not imply that `GenericClass<S>` is a subtype of `GenericClass<T>`.

2) For example, even though Integer is a subtype of Number, `List<Integer>` is NOT a subtype of `List<Number>`.
   
3) This is because generic classes are invariant in their type parameter by default.

Subtyping With Generic Classes:
You can subtype a generic class by extending or implementing it, but the relationship between the type parameters matters:

```
class MyList<T> { /* ... */ }

class MySpecializedList<T> extends MyList<T> { /* ... */ }

```

Here, `MySpecializedList<T>` is a subtype of `MyList<T>` only if the type T matches between them.



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

2) `GenericClass<S>` is not a subtype of `GenericClass<T>` even if S is a subtype of T.

3) Subtyping applies normally to the raw generic class but type parameters must match exactly.

4) Use wildcards (? extends T or ? super T) to work around this limitation when necessary.

This characteristic helps maintain type safety in Java generics.

***

# Upper bound, lower bound wild cards and wild card capture

In Java generics, wildcards provide flexibility when using parameterized types, especially for subtyping relationships. There are three key concepts related to wildcards: upper bounded wildcards, lower bounded wildcards, and wildcard capture. Here is a detailed explanation with examples:

## Upper Bounded Wildcards `(<? extends T>)` 
      1) Syntax: `List<? extends Number>`

      2) It means the list can hold elements of any type that is a subclass (or the class itself) of T.

      3) Used mainly when you want to read from a generic structure but not write (except null).

      4) Ensures type safety by restricting the upper bound.

```declarative
public static double sum(List<? extends Number> list) {
double sum = 0.0;
for (Number n : list) {
sum += n.doubleValue();
}
return sum;
}

List<Integer> ints = Arrays.asList(1, 2, 3);
List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);

System.out.println(sum(ints));    // Outputs 6.0
System.out.println(sum(doubles)); // Outputs 6.6

```
1) You can pass List<Integer>, List<Double>, or List<Number> to this method.

2) You cannot add elements to list inside the method because you don't know the exact subtype.

## Lower Bounded Wildcards `(<? Super T>)` 

1) Syntax: `List<? super Integer>`

2) It means the list can hold elements of type T or any of its supertypes.

3) Used mainly when you want to write to a generic structure safely.

4) Allows adding elements of type T or its subclasses.

Example:

```declarative
public static void addNumbers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}

List<Number> numberList = new ArrayList<>();
addNumbers(numberList);  // Works

List<Object> objectList = new ArrayList<>();
addNumbers(objectList);  // Also works

```
1) You can safely add Integer values to lists of Number, Object, or Integer.

2) You cannot safely read elements as Integer without casting because the list might be of type Object.

## WildCard capture

1) When you have a method that uses wildcards, sometimes you need to capture the unknown type to operate on it.
2) When a generic method has a parameter with a wildcard like List<?>, the compiler doesn't know the exact type and restricts certain operations (like set).
3) Wildcard capture is done by introducing a helper method that uses a type parameter to "capture" the wildcard type.
4) This lets you manipulate generic structures with wildcards in a type-safe way.

```declarative
public static void copy(List<?> src, List<?> dest) {
    copyHelper(src, dest); // capture the wildcard via helper
}

private static <T> void copyHelper(List<T> src, List<T> dest) {
    for (T t : src) {
        dest.add(t);
    }
}

```
1) Here, copyHelper captures the unknown wildcard type ? and uses a type parameter T.
2) This pattern is widely applicable in frameworks, utility libraries, and APIs where generic types are passed with unknown parameter types.
***