
import java.util.Scanner;
import java.util.ArrayList;

public class Libfunc   {

    protected String name = "batu";
    protected String password = "105k";
    protected String username;
    protected String userpassword;
    // protected int userBookLimit = 3;
    protected int userBookNumber = 0;
    //6  protected int totalBookNumber;
    protected int choice;
    protected String booknameuserwant;
    protected String userConfirmPassword;
    protected String newpassword;
    protected int givebackchoice;
    protected int numberofbooksinhome = 3;

    protected ArrayList<String> dinamicArray = new ArrayList<>();
    protected ArrayList<String> userArray = new ArrayList<>();
    protected ArrayList<String> userhomeArray = new ArrayList<>();


    Scanner scan = new Scanner(System.in);
    void loginscreen(){
        do {
            System.out.println("Welcome to the library system, enter your name;");
            username = scan.next();
            System.out.println("Enter your password");
            userpassword = scan.next();
            if (!(name.equals(username) && password.equals(userpassword))) {
                System.out.println("You entered your password or name incorrectly, please log in again.");
            }
        } while (!(name.equals(username) && password.equals(userpassword)));
        System.out.println("Login successful. Welcome to the library system!\n");
    }

    void changepassword(){
        System.out.println("For privacy, please enter your current password again to change");
        userConfirmPassword = scan.next();
        if(userConfirmPassword.equals(password))
        {
            System.out.println("Thanks to confirm your password, you can decide a new password (make sure that must be different from previous password.)");
            newpassword = scan.next();
            if(!userConfirmPassword.equals(newpassword))
            {
                password = newpassword;
                System.out.println("You changed your password successfully, log in again");
                loginscreen();
            }

            else{
                System.out.println("Password must be different from your previous password");
                System.out.println("You are returning to main menu\n");
                }
        }

        else{
            System.out.println("Incorrect, returning to menu");
        }
    }

    void exit(){
        System.out.println("Exit is being processing,have a nice day");
    }
}
