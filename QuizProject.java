package phoneactivity;

import java.util.Random;
import java.util.Scanner;

public class QuizProject {

    Double logIn;
    String username;
    String password;
    String[] quest;
    String[][] options;
    String[] correctAnwers;
    Scanner scanner;
    Double score;

    public QuizProject() {
        score = 0.0;
        scanner = new Scanner(System.in);
        quest = new String[]{"When Did Nigeria Gain Independence ?", "How many contries are in Africa ?",
            "How many States are in Nigeria ?", "What is a Computer?", "Is Europe a continent ?",
            "Simplify (45+23)/2", "45 is greater than 78 ?", "Simplify 22+65+14= ",
            "Simplify (56985-36525)", "Simplify 4002/2", "Simplify 45*6"};

        options = new String[][]{{"a. 1961", "b. 1962", "c. 1963", "d. 1960"},
        {"a. 54", "b. 58", "c. 55", "d. 56"},
        {"a. 30", "b. 45", "c. 37", "d. 36"},
        {"a. computer is a car", "b. computer is a toy", "c. Computer is an electronic device that process information and stores data", "d. computer is a vehicle"},
        {"a. True", "b. False "},
        {"a. 34", "b. 25", "c. 37", "d. 35"},
        {"a. True", "b. False "},
        {"a. 109", "b. 101", "c. 98", "d. 99"},
        {"a. 14524", "b. 20460", "c. 30017", "d. 56325"},
        {"a. 2001", "b. 5632", "c. 1010", "d. 1524"},
        {"a. 340", "b. 250", "c. 370", "d. 270"}};

        correctAnwers = new String[]{"d. 1960", "b. 58", "d. 36", "c. Computer is an electronic device that process information and stores data",
            "a. True", "a. 34", "a. False", "b. 101", "b. 20460", "a. 2001", "a. 340"};

    }

    public void showMenu() {

        System.out.println("      WELCOME ");

        //takes the users login details
        System.out.println("");
        System.out.println("     MENU    ");
        System.out.println("Press 1 For Admin");
        System.out.println("Press 2 For User");
        System.out.println("Press 3 to Exit Application");

        int option;
        String cho;

        option = scanner.nextInt();

        do {
            switch (option) {

                case 1:
                    Admin();
                    break;
                case 2:
                    User();
                    break;
                case 3:
                    exitQuiz();
                    System.out.println("Application Exited");

                    break;

            }
            System.out.println("Do you want to Continue ? y/n  ");
            cho = scanner.nextLine();
        } while (cho.equalsIgnoreCase("y"));
        User();

    }

    public void SetQuiz() {
        System.out.println("Press Continue to set Quiz");

    }

    protected void LogIn() {

        String conti = "";

        Scanner wish = new Scanner(System.in);

        Scanner loginDetails = new Scanner(System.in);

        System.out.println("Enter Your Username");
        username = loginDetails.nextLine().toLowerCase();
        System.out.println("Enter Your Password");
        password = loginDetails.next().toLowerCase();
        //
        //  validates user password and username
        if ("adesina".equals(username)) {
            if ("bolaji".equals(password)) {
                System.out.println(" Welcome ");
                Questions();
            }
        } else {
            System.out.println("Incorrect Username/Password");
            System.out.println();

            System.out.println("Try again ?");
            do {
                LogIn();
                conti = wish.next();

            } while (!"y".equals(conti));
            {
                exitQuiz();
                System.out.println("Quiz exited");
            }

        }

    }

    public void Admin() {
        //LogIn();

        Scanner loginDetails = new Scanner(System.in);

        System.out.println("Enter Your Username");
        username = loginDetails.nextLine().toLowerCase();
        System.out.println("Enter Your Password");
        password = loginDetails.next().toLowerCase();
        //
        //  validates user password and username
        if ("adesina".equals(username)) {
            if ("bolaji".equals(password)) {
                System.out.println(" Welcome ");
                Questions();
            }
        } else {
            System.out.println("Incorrect Username/Password");
            System.out.println();

            System.out.println("Try again ?");

            int click;
            System.out.println("Click 1 to Set Question");
            System.out.println("Click 2 to take Dummy Test");
            click = scanner.nextInt();

            //helps the admin to choose to set Questions or take Dummy test
            switch (click) {

                case 1:
                    SetQuiz();
                    break;
                case 2:
                    User();
                    break;
                default:

            }
        }
    }

    public void User() {

        System.out.println("Enter Your Username");
        username = scanner.next();

        int choice;

        System.out.println("Read the Instructions Carefully Before You Start the"
                + " Test");

        System.out.println("");
        System.out.println("-----INSTRUCTIONS------");
        System.out.println("1. Attempt all questions");
        System.out.println("2. Choose from the options the best answer for the question");
        System.out.println("3. Each question carries equal mark");
        System.out.println("4. Ensure you Submit your Answer before logging out ");

        System.out.println("");
        System.out.println(" Press 1 to Start the Test");
        System.out.println(" Press 2 to Exit Application");

        choice = scanner.nextInt();
        System.out.println("Enter Choice: ");
        if (choice == 1) {
            Questions();
        } else {

            exitQuiz();
            System.out.println("Quiz Exited");

        }

    }

    public void Questions() {

        Random word = new Random();
        //int  rand = word.nextInt(quest.length);
        int queIndex = 0;
        int queNum = 0;

        do {
            String queOption[] = options[queIndex];
            queNum++;
            System.out.println(queNum + ". " + quest[queIndex]);

            for (int i = 0; i < queOption.length; i++) {
                System.out.println(queOption[i]);
            }
            System.out.println("Enter Your Answer (a,b,c,d): ");

            String uAnswer = scanner.next();
            checkAnswer(queIndex, uAnswer);
            //pull next question
            queIndex++;
        } while (queIndex != quest.length);
        {
            System.out.println(username + " Your Score is=" + score);
            retake();
        }

    }

    public void retake() {
        String retake = "y";
        retake = scanner.next();
        if ("y".equals(retake)) {
            showMenu();
        } else {
            exitQuiz();

        }

    }

    public void checkAnswer(int queIndex, String ans) {
        int answerIndex = 0;
        switch (ans.toLowerCase()) {
            case "a":
                answerIndex = 0;
                break;
            case "b":
                answerIndex = 1;
                break;
            case "c":
                answerIndex = 2;
                break;
            case "d":
                answerIndex = 3;
                break;
            default:

        }
        String ansTxt = options[queIndex][answerIndex];
        //check anwser
        String correctAns = correctAnwers[queIndex];
        //  System.out.println("Qustion :" + queIndex + " cAnswer :" + correctAns + " userA:" + ansTxt);
        if (correctAns.equals(ansTxt)) {

            score++;

        }

    }

    private void exitQuiz() {
        System.out.println("Application Exited");
        System.exit(0);

    }

    public static void main(String[] args) {
        QuizProject newQuiz = new QuizProject();
        newQuiz.showMenu();
    }

}
