import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class UtilitiesForSystem 
{
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static FileWriter[] writer = new FileWriter[7];
    private static File file;
    private static ArrayList <String> fileName;

    public static void clearScreen()
    {
        for (int i = 0; i < 10; i++) 
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void selectionErrorMsg() throws InterruptedException
    {
        System.out.println("Invalid Selection. Try again.");
        TimeUnit.MILLISECONDS.sleep(500);
        clearScreen();
    }

    public static boolean allCharacterAreDigits(String str)
    {
        if(!str.isBlank())
        {
            for(int i = 0; i < str.length(); i++)
            {
                if(!Character.isDigit(str.charAt(i)))
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    // This method checks to see if the user input has any digits! - [Shaun]
    public static boolean containsDigits(String input) {
        // Check if the input string contains digits
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true; // Digits found
            }
        }
        return false; // No digits found
    }

    public static void pressEnterToContinue() throws IOException
    { 
        System.out.println("Press any key to continue...");
        reader.readLine();
    }

    public static void fileName()
    {
        fileName = new ArrayList<String>();
        fileName.add("BookTitle.txt");           //0
        fileName.add("BookISBN.txt");            //1
        fileName.add("BookAuthor.txt");          //2
        fileName.add("BookPublisher.txt");       //3
        fileName.add("BookYearPublished.txt");   //4
        fileName.add("BookGenre.txt");           //5
        fileName.add("BookAvailability.txt");    //6
    }

    public static String getFileName(int i)
    {
        return fileName.get(i);
    }

    public static void setFile(int i) throws IOException
    {
        file = new File(getFileName(i));
        writer[i] = new FileWriter(file);
    }

    public static void createFiles() throws IOException, InterruptedException
    {
        System.out.println("Backing up........");
        TimeUnit.MILLISECONDS.sleep(1000);
        for(int i = 0; i < fileName.size(); i++)
        {
            setFile(i);
            try
            {
                if(file.createNewFile())
                {
                    System.out.println("File created: " + file.getName());
                }
                else
                {
                    continue;
                }
            }
            catch(IOException e)
            {
                System.out.println("An error occured.");
                e.printStackTrace();
            }
        }
    }

    public static void deleteFiles() throws IOException
    {
        for(int i = 0; i < fileName.size(); i++)
        {
            setFile(i);
            file.delete();
        }
    }

    public static void writeToFile(int i, String str) throws IOException
    {
        writer[i].write(str + System.lineSeparator());
    }

    public static void closeFile() throws IOException
    {
        for (int i = 0; i < fileName.size(); i++) 
        {
            writer[i].close();
        }   
    }
}
