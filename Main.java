package TypeRacer.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            //grab data
            File file = new File("data.txt");
            Scanner in = new Scanner(file);
            ArrayList<String> data = new ArrayList<>();

            while(in.hasNextLine())
            {
                String[] splitLines = in.nextLine().split("\\n|\\r\\n|\\r");
                Collections.addAll(data, splitLines);
            }
            /*for(int i = 0; i < data.size(); i++)
            {
                System.out.println(data.get(i));
            }*/

            //go to main menu
            menu(data);

            in.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

    }
    public static void menu(ArrayList<String> fileData)
    {
        //initialization
        System.out.println("Welcome to Ian's TypeRacer! Enter \"1\" When Ready");

        Scanner keyB = new Scanner(System.in);
        String userIn = keyB.next();
        if (userIn.equalsIgnoreCase("1"))
        {
            play(fileData);
        }

    }
    public static void play(ArrayList<String> fileData)
    {
        Scanner keyB = new Scanner(System.in);
        int randInt = (int) ((Math.random() * (fileData.size() - 1)));

        System.out.println("\nGet Ready!....");
        wait(5000);
        System.out.println(fileData.get(randInt));


        long startTime = System.currentTimeMillis();
        String userAttempt = keyB.nextLine();

        long elapsedTime = System.currentTimeMillis() - startTime;

        if(userAttempt.equals(fileData.get(randInt)))
        {
            System.out.print("Great Job! Your time was: " + elapsedTime/1000 + " seconds \n");
        }
        else
        {
            System.out.println("You had a Grammar error :( your time was: " + elapsedTime/1000 + " seconds \n");
        }
        wait(2000);
        System.out.println("Would you like to play again? Press \"1\"");
        userAttempt = keyB.nextLine();
        if (userAttempt.equalsIgnoreCase("1"))
        {
            menu(fileData);
        }
        keyB.close();

        //Possible timer implementation
        //long elapsedSeconds = elapsedTime / 1000;
        //long secondsDisplay = elapsedSeconds % 60;
        //long elapsedMinutes = elapsedSeconds / 60;
    }

    //wait method
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}