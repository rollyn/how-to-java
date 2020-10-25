public class ConditionalApp {

    public static void main(String[] args) {
        int a = 10;
        int b = -1;

        if (a > 0 && b < 0) {
            System.out.println("TRUE");
        }
        if (a < 0 && b > 0) {
            System.out.println("TRUE");
        }
        if (a > 0 && b > 0) {
            System.out.println("FALSE");
        }

    }
}
