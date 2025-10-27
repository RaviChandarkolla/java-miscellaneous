package generics;

public class GenericsType<T> {

    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {
        GenericsType<String> type = new GenericsType<>();
        type.set("Pankaj"); //valid
        System.out.println(type.get());

        GenericsType type1 = new GenericsType(); //raw type
        type1.set("Pankaj"); //valid
        System.out.println(type1.get());
        type1.set(10); //valid and autoboxing support
        System.out.println(type1.get());

        GenericsType<String> type2 = new GenericsType<>();
        type2.set("Ravi");
        System.out.println(type2.get());
    }
}