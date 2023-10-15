package assignmentmanager;

import ui.ConsoleColors;
import ui.UI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Manager {
    Random random;
    ArrayList<Assignment> assignments;
    ArrayList<Assignment> sortedAssignments;
    LocalDateTime min;
    Assignment minimum;
    boolean isLeapYear;
    int year;
    int month;
    int day;

    private void initVar() {
        random = new Random();
        assignments = new ArrayList<>();
        sortedAssignments = new ArrayList<>();
    }

    public static void main(String[] args) {
        new Manager().run();
    }

    // Run method
    private void run() {
        initVar();

        createRandomAssignment();

        // Finds the earliest deadline in each iteration, removes it from 'assignments' ArrayList, and adds it to 'sortedAssignments' ArrayList.
        // Keeps doing this until 'assignments' is empty
       while (!assignments.isEmpty()) {
            min = LocalDateTime.MAX;
            minimum = null;
            for (int i = 0; i < assignments.size(); i++) {
                if (assignments.get(i).getDeadline().isBefore(min)) {
                    min = assignments.get(i).getDeadline();
                    minimum = assignments.get(i);
                }
            }
            assignments.remove(minimum);
            sortedAssignments.add(minimum);
        }

       printSortedAssignments();
    }
    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Creates 10.000 random assignments
    private void createRandomAssignment() {
        for (int i = 0; i < 10000; i++) {
            assignments.add(new Assignment(randomDate(), randomSubject(), randomTask(), randomPage()));
        }
    }

    // Random subject
    private String randomSubject() {
        String subject = "";
        int randomNumber = random.nextInt(4);

        switch (randomNumber) {
            case 0 -> subject = "Programming";
            case 1 -> subject = "System development";
            case 2 -> subject = "Organization";
            case 3 -> subject = "Technology";
        }
        return subject;
    }

    // Random task
    private String randomTask() {
        String task = "";
        int randomNumber = random.nextInt(5);

        switch (randomNumber) {
            case 0 -> task = "Solve assignment";
            case 1 -> task = "Solve challenge";
            case 2 -> task = "Study curriculum";
            case 3 -> task = "Prepare presentation";
            case 4 -> task = "Project work";
        }
        return task;
    }

    // Random page number
    private int randomPage() {
        return random.nextInt(1000) + 1;
    }

    // Prints sorted assignments
    private void printSortedAssignments() {
        for (int i = 0; i < sortedAssignments.size(); i++) {
            UI.print(ConsoleColors.YELLOW + sortedAssignments.get(i).getDeadline() + ConsoleColors.RESET + ": ");
            printColoredSubject(i);
            UI.print(sortedAssignments.get(i).getTask() + ", ");
            UI.print("page, " + sortedAssignments.get(i).getPage());
            UI.println("");
        }
    }

    // Prints color-coded subject
    private void printColoredSubject(int i) {
        String coloredSubject = "";
        switch (sortedAssignments.get(i).getSubject()) {
            case "Programming" -> coloredSubject = ConsoleColors.GREEN + "Programming" + ConsoleColors.RESET;
            case "System development" -> coloredSubject = ConsoleColors.RED + "System development" + ConsoleColors.RESET;
            case "Organization" -> coloredSubject = ConsoleColors.BLUE_BRIGHT + "Organization" + ConsoleColors.RESET;
            case "Technology" -> coloredSubject = ConsoleColors.CYAN + "Technology" + ConsoleColors.RESET;
        }
        UI.print(coloredSubject + ": ");
    }


    //-----RANDOM DATES-----\\
    // Random date
    private LocalDateTime randomDate() {
        return LocalDateTime.of(randomYear(), randomMonth(), randomDay(), randomHour(), randomMinute());
    }

    // Random year
    private int randomYear() {
        int randomNumber = random.nextInt(2);
        switch (randomNumber) {
            case 0 -> year = 2023;
            case 1 -> year = 2024;
        }
        isLeapYear = year % 4 == 0; // If 'randomYear' % 4 == 0, then isLeapYear = true, else it's false

        return year;
    }

    // Random month
    private int randomMonth() {
        return month = random.nextInt(12) + 1;
    }

    // Random day
    private int randomDay() {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12  -> day = random.nextInt(31) + 1;
            case 2 -> day = random.nextInt(28) + 1;
            case 4, 6, 9, 11 -> day = random.nextInt(30) + 1;
        }
        if (isLeapYear && month == 2) // If it's a leap year, and it's February, then get a random number between 1-29
            day = random.nextInt(29) + 1;

        return day;
    }

    // Random hour between 8-15
    private int randomHour() {
        int randomHour = random.nextInt(8);
        int hour = 0;
        switch (randomHour) {
            case 0 -> hour = 8;
            case 1 -> hour = 9;
            case 2 -> hour = 10;
            case 3 -> hour = 11;
            case 4 -> hour = 12;
            case 5 -> hour = 13;
            case 6 -> hour = 14;
            case 7 -> hour = 15;
        }
        return hour;
    }

    // Random minute (0, 15, 30, or 45)
    private int randomMinute() {
        int randomMinute = random.nextInt(4);
        int minute = 0;
        switch (randomMinute) {
            case 1 -> minute = 15;
            case 2 -> minute = 30;
            case 3 -> minute = 45;
        }
        return minute;
    }
}
