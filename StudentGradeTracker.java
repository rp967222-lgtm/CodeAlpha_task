import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        if (n <= 0) {
            System.out.println("Invalid number of students.");
            sc.close();
            return;
        }

        String[] names = new String[n];
        int[] grades = new int[n];

        int sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            names[i] = sc.nextLine();

            int grade;
            while (true) {
                System.out.print("Enter grade (0-100): ");
                grade = sc.nextInt();

                if (grade >= 0 && grade <= 100) {
                    break;
                }
                System.out.println("Invalid grade. Try again.");
            }
            sc.nextLine(); // clear buffer

            grades[i] = grade;
            sum += grade;

            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
        }

        double average = (double) sum / n;

        System.out.println("\n===== STUDENT GRADE REPORT =====");
        for (int i = 0; i < n; i++) {
            System.out.println(names[i] + " : " + grades[i]);
        }

        System.out.println("--------------------------------");
        System.out.println("Average Score : " + average);
        System.out.println("Highest Score : " + highest);
        System.out.println("Lowest Score  : " + lowest);

        sc.close();
    } // closes main

} // closes class
