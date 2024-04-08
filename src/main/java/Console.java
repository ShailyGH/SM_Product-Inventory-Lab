import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;

public class Console
{
    public static void printWelcome(){
        System.out.println("\n" +
                "**************************************************\n" +
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***          ZipCo Inventory Manager           ***\n" +
                "**************************************************\n\n");
    }

    public static String getInput ()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getInput(String header, String[] options)
    {
        String printOptions = header + "\n";

        for (int i = 0; i < options.length; i++){
            printOptions += String.format("%d. %s", i+1, options[i]) + "\n";
        }

        System.out.println(printOptions);

        return Console.getSelection(options.length);
    }

    public static Integer getSelection(int maxChoices) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (true)
        {
            if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= maxChoices)
            {
                break;
            }
            else
            {
                System.out.println("Please choose a number between between 1 and " + maxChoices);
                input = scanner.nextLine();
            }
        }
        return Integer.valueOf(input);
    }

    public static Integer getInteger()
    {
        String input = getInput();
        return Integer.valueOf(input);

    }
}
