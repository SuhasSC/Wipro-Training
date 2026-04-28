import java.util.Scanner;

public class AssignmentPrograms {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ============================================
        // 1. Sum of first N numbers
        // ============================================
        System.out.println("1. Sum of first N numbers");
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        int sum = 0;

        // Loop from 1 to N
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        System.out.println("Sum = " + sum);
        System.out.println("--------------------------------");

        // ============================================
        // 2. Factorial using loop
        // ============================================
        System.out.println("2. Factorial");
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int fact = 1;

        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }

        System.out.println("Factorial = " + fact);
        System.out.println("--------------------------------");

        // ============================================
        // 3. Find maximum element in array
        // ============================================
        System.out.println("3. Maximum element in array");

        int[] arr1 = { 10, 25, 5, 40, 15 };

        int max = arr1[0];

        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > max) {
                max = arr1[i];
            }
        }

        System.out.println("Maximum = " + max);
        System.out.println("--------------------------------");

        // ============================================
        // 4. Sum of array elements
        // ============================================
        System.out.println("4. Sum of array elements");

        int[] arr2 = { 5, 10, 15, 20 };

        int sumArray = 0;

        for (int i = 0; i < arr2.length; i++) {
            sumArray = sumArray + arr2[i];
        }

        System.out.println("Sum = " + sumArray);
        System.out.println("--------------------------------");

        // ============================================
        // 5. Reverse an array
        // ============================================
        System.out.println("5. Reverse array");

        int[] arr3 = { 1, 2, 3, 4, 5 };

        System.out.print("Reversed: ");

        for (int i = arr3.length - 1; i >= 0; i--) {
            System.out.print(arr3[i] + " ");
        }

        System.out.println();
        System.out.println("--------------------------------");

        // ============================================
        // 6. Largest of 3 numbers
        // ============================================
        System.out.println("6. Largest of 3 numbers");

        int a = 10, b = 25, c = 15;

        int largest = a;

        if (b > largest) {
            largest = b;
        }

        if (c > largest) {
            largest = c;
        }

        System.out.println("Largest = " + largest);
        System.out.println("--------------------------------");

        // ============================================
        // 7. Count even numbers in array
        // ============================================
        System.out.println("7. Count even numbers");

        int[] arr4 = { 2, 5, 8, 11, 14 };

        int count = 0;

        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] % 2 == 0) {
                count++;
            }
        }

        System.out.println("Even count = " + count);
        System.out.println("--------------------------------");

        // ============================================
        // 8. Multiplication table (1 to 10)
        // ============================================
        System.out.println("8. Multiplication Table");

        System.out.print("Enter number: ");
        int tableNum = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(tableNum + " x " + i + " = " + (tableNum * i));
        }

        System.out.println("--------------------------------");

        // ============================================
        // 9. Linear Search
        // ============================================
        System.out.println("9. Linear Search");

        int[] arr5 = { 10, 20, 30, 40, 50 };

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] == key) {
                System.out.println("Element found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }

        System.out.println("--------------------------------");

        // ============================================
        // 10. Simple Calculator using switch
        // ============================================
        System.out.println("10. Calculator");

        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println("Result = " + (x + y));
                break;

            case '-':
                System.out.println("Result = " + (x - y));
                break;

            case '*':
                System.out.println("Result = " + (x * y));
                break;

            case '/':
                if (y != 0) {
                    System.out.println("Result = " + (x / y));
                } else {
                    System.out.println("Division by zero not allowed");
                }
                break;

            default:
                System.out.println("Invalid operator");
        }

        sc.close();
    }
}
