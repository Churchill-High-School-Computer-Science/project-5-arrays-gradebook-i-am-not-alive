public class Gradebook {

    String[] labels = { "Last", "First", "Test1", "Test2", "Quiz1", "Quiz2", "Homework1", "Homework2", "Homework3",
            "Homework4", "Homework5", "Homework6", "Homework7", "Homework8", "Homework9", "Homework10" };

    String[][] book;

    public Gradebook(String[][] b) {
        if (b.length > 0 && b[0].length == 16) {
            book = b;
        }

        else {
            System.out.println("Gradebook is not the right size. Ensure that formatting is correct.");
            book = new String[1][16];
        }
    }

    public boolean changeGrade(String lastName, String assnName, int newGrade) {
        // Your code here
        int nameIndex = -1;
        for(int i = 0; i <labels.length; i++){
            if (labels[i].equals(assnName)){
                nameIndex = i;
                break;
            }
        }
        if (nameIndex == -1) 
        return false;
        for (int i = 0; i < book.length; i++){
            if (book[i][0].equals(lastName)){
                book[i][nameIndex] = String.valueOf(newGrade);
                return true;
            }
        }
        return false;
    }

    public double findAssignmentAverage(String assnName) {
        // Your code here
        int nameIndex = -1;
        for (int i = 0; i < labels.length; i++){
            if (labels[i].equals(assnName)){
                nameIndex = i;
                break;
            }
        }
        if(nameIndex == -1) return -1;

        double total = 0;
        int count = 0;
        for (int i = 0; i < book.length; i++){
            
                total += Double.parseDouble(book[i][nameIndex]);
                count ++;
            } 
            return total / count;
        
    }

    public double findStudentAverage(String lastName) {
        // Your code here
        int studentIndex = -1;
        for (int i = 0; i < book.length; i++) {
            if (book[i][0].equals(lastName)) {
                studentIndex = i;
                break;
            }
        }
        if (studentIndex == -1) return -1;

        double testTotal = 0, quizTotal = 0, hwTotal = 0;
        int testCount = 2, quizCount = 2, hwCount = 10;

        for (int i = 2; i <= 3; i++) {
            testTotal += Double.parseDouble(book[studentIndex][i]);
        }
        for (int i = 4; i <= 5; i++) {
            quizTotal += Double.parseDouble(book[studentIndex][i]);
        }
        for (int i = 6; i <= 15; i++) {
            hwTotal += Double.parseDouble(book[studentIndex][i]);
        }

        double testAvg = testTotal / testCount;
        double quizAvg = quizTotal / quizCount;
        double hwAvg = hwTotal / hwCount;

        return (testAvg * 0.3) + (quizAvg * 0.3) + (hwAvg * 0.4);
    }

    public void printStudentInfo(String lastName) 
    {
        // Your code here
        int studentIndex = -1;
        for (int i = 0; i < book.length; i++) 
        {
            if (book[i][0].equals(lastName)) 
            {
                studentIndex = i;
                break;
            }
        }
        if (studentIndex == -1) 
        
        {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Name: " + book[studentIndex][1] + " " + book[studentIndex][0]);
        for (int i = 2; i < labels.length; i++) 
        {
            System.out.println(labels[i] + ": " + book[studentIndex][i]);
        }

    }
}
