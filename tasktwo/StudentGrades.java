package tasktwo;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = totalMarks / (double) numSubjects;

        // Display individual subject grades
        System.out.println("\nGrades for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i] + " - " + getGrade(marks[i]));
        }

        // Display overall results
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Overall Grade: " + getGrade(averagePercentage));
    }

    // Method to determine grade based on marks/average percentage
    private static String getGrade(double percentage) {
        if (percentage >= 91 && percentage <= 100) {
            return "O (Outstanding)";
        } else if (percentage >= 81 && percentage <= 90) {
            return "A+ (Excellent)";
        } else if (percentage >= 71 && percentage <= 80) {
            return "A (Very Good)";
        } else if (percentage >= 61 && percentage <= 70) {
            return "B+ (Good)";
        } else if (percentage >= 56 && percentage <= 60) {
            return "B (Average)";
        } else if (percentage >= 50 && percentage <= 55) {
            return "C (Satisfactory)";
        } else {
            return "RA (Fail)";
        }
    }
}
