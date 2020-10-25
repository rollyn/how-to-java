public class TemperatureWithMethod {

    public static void main(String[] args) {

        float fahrenheit = 10;
        float celsius = (fahrenheit - 32) * 5/9;

        displayResult(celsius);
    }

    static void displayResult(float celsius) {
        System.out.println("Celsius: "+celsius);
    }
}
