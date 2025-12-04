package lambdas;

import java.time.LocalTime;
import java.util.function.Supplier;

public class SupplierLambdaExample {
    public static void main(String[] args) {
//        Supplier<LocalTime> timeSupplier = () -> java.time.LocalTime.now();
        Supplier<LocalTime> timeSupplier = LocalTime::now;
        System.out.println(timeSupplier.get());
    }
}
