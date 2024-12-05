import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] data1 = {
                { "Borjigin", "Temüjin", "85.0", "90.0", "80.0", "88.0", "75.0", "80.0", "70.0", "85.0", "90.0", "95.0",
                        "85.0", "78.0", "88.0", "92.0" },
                { "Jadran", "Jamukha", "78.0", "82.0", "85.0", "80.0", "88.0", "90.0", "92.0", "95.0", "85.0", "87.0",
                        "90.0", "93.0", "88.0", "85.0" },
                { "Khereid", "Toghrul", "92.0", "88.0", "91.0", "89.0", "84.0", "86.0", "85.0", "82.0", "88.0", "90.0",
                        "91.0", "89.0", "90.0", "93.0" }
        };

        String[][] data2 = {
                { "Rostov", "Nikolai", "88.0", "92.0", "78.0", "85.0", "80.0", "83.0", "85.0", "90.0", "88.0", "87.0",
                        "85.0", "89.0", "90.0", "86.0" },
                { "Bolkov", "Andrei", "95.0", "87.0", "89.0", "91.0", "93.0", "90.0", "88.0", "85.0", "92.0", "94.0",
                        "89.0", "92.0", "90.0", "93.0" },
                { "Kuragin", "Anatole", "76.0", "80.0", "72.0", "70.0", "78.0", "75.0", "77.0", "74.0", "79.0", "73.0",
                        "81.0", "76.0", "78.0", "72.0" },
                { "Bezukhov", "Pierre", "90.0", "85.0", "82.0", "84.0", "88.0", "87.0", "85.0", "83.0", "86.0", "89.0",
                        "90.0", "91.0", "89.0", "88.0" },
                { "Rostova", "Natasha", "92.0", "89.0", "85.0", "88.0", "90.0", "89.0", "91.0", "88.0", "92.0", "90.0",
                        "88.0", "87.0", "90.0", "91.0" },
                { "Drubetskoy", "Boris", "84.0", "80.0", "78.0", "81.0", "82.0", "79.0", "84.0", "83.0", "85.0", "82.0",
                        "80.0", "86.0", "83.0", "84.0" },
                { "Dolokhov", "Fyodor", "89.0", "85.0", "88.0", "84.0", "83.0", "87.0", "90.0", "85.0", "88.0", "86.0",
                        "84.0", "89.0", "85.0", "86.0" },
                { "Karagin", "Helene", "78.0", "82.0", "80.0", "79.0", "81.0", "80.0", "83.0", "85.0", "84.0", "82.0",
                        "81.0", "79.0", "80.0", "84.0" },
                { "Bolkonsky", "Andrei", "93.0", "89.0", "90.0", "91.0", "88.0", "87.0", "92.0", "89.0", "90.0", "92.0",
                        "93.0", "91.0", "92.0", "89.0" },
                { "Bolkonskaya", "Maria", "85.0", "88.0", "86.0", "84.0", "83.0", "82.0", "87.0", "85.0", "86.0",
                        "88.0", "85.0", "89.0", "88.0", "86.0" }
        };

        Gradebook testBook1 = new Gradebook(data1);
        Gradebook testBook2 = new Gradebook(data2);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nGradebook Menu:");
            System.out.println("1. View student info");
            System.out.println("2. Calculate student average");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: // View student info
                    System.out.print("Enter student's last name: ");
                    String lastNameInfo = scanner.nextLine();
                    testBook1.printStudentInfo(lastNameInfo);
                    testBook2.printStudentInfo(lastNameInfo);
                    break;

                case 2: // Calculate student average
                    System.out.print("Enter student's last name: ");
                    String lastNameAvg = scanner.nextLine();
                    double avg = testBook1.findStudentAverage(lastNameAvg);                    if (avg == -1) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.printf("Weighted average for %s: %.2f\n", lastNameAvg, avg);
                    }
                    break;

                case 3: // Exit
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
