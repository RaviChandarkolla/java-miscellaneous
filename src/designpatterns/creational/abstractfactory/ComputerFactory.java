package designpatterns.creational.abstractfactory;

// Abstract Factory design pattern provides approach to code for interface rather than implementation.
// Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products, for example we can add another sub-class Laptop and a factory LaptopFactory.
// Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.
public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
