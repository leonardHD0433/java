import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void dispHomeMenu()
    {
        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        System.out.println("**************************");
        System.out.println("1. Login as Head Librarian");
        System.out.println("2. Login as Librarian");
        System.out.println("3. Exit\n");
    }

    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    
    public static void main(String[] args) throws IOException, InterruptedException
    {
        HeadLibrarian headLibrarian = new HeadLibrarian();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loginMenuChoice = 0;
        String readString, readUserName, readPassword;
        clearScreen();
        dispHomeMenu();

        do 
        {
            readString = reader.readLine();
            if (readString.equals("1") || readString.equals("2") || readString.equals("3"))
            {
                loginMenuChoice = Integer.parseInt(readString);
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
                TimeUnit.SECONDS.sleep(1);
                clearScreen();
                dispHomeMenu();
            }
        } while (!(readString.equals("1") || readString.equals("2") || readString.equals("3")));

        switch (loginMenuChoice)
        {
            case 1:
            System.out.println("Head Librarian Login"); 
            System.out.println("\nUsername: ");
            readUserName = reader.readLine();
            System.out.println("\nPassword: ");
            readPassword = reader.readLine();
            headLibrarian.login(readUserName, readPassword);

            break;
            case 2:
                System.out.println("Login as Librarian"); break;
            case 3:
                System.out.println("Exit"); break;
        }
        
    }
}
