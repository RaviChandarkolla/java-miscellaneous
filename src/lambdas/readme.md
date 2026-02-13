Lambdas work only with Functional Interfaces.
Functional Interface: An interface with exactly ONE abstract method.

Examples:

Runnable

Comparator

Callable

Consumer

Function

Predicate

Examples
```
@FunctionalInterface
interface MyInterface {
void sayHello();
}
```
```
MyInterface obj = () -> System.out.println("Hi");
```
