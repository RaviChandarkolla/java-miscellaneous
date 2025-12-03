public class Miscs {
    public static void main(String[] args) {
        int i = 2;
        int j = 4;
        System.out.println(i/3);
        System.out.println(j/3);

        int k = 3;
        System.out.println(k/3);
        System.out.println(k%3);

        int number = -123;
        String str = Integer.toString(number);
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println(reversed);
    }
}
