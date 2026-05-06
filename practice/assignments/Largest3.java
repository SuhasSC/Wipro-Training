public class Largest3 {
    public static void main(String[] args) {

        int a = 10, b = 25, c = 15;

        int largest = a;

        if(b > largest) {
            largest = b;
        }

        if(c > largest) {
            largest = c;
        }

        System.out.println("Largest = " + largest);
    }
}
