import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import models.Sneaker;
import models.Whiskey;
import services.SneakerService;
import services.WhiskeyService;

public class App
{
    private SneakerService sneakerService = new SneakerService();
    private WhiskeyService whiskeyService = new WhiskeyService();

    public static void main(String... args)
    {
        App application = new App(); // (2)
        application.init();  // (3)
    }
    public void init(){
        // (4)
        // application logic here
        // call methods to take user input and interface with services
        Console.printWelcome();
        displayMenu();
    }

    public void displayMenu()
    {
        String[] menuItems = new String[]{"Add product", "View product", "Update product", "Delete product", "Reports", "Exit"};

        int choice = Console.getInput("Inventory Manager Main Menu", menuItems);

        switch (choice)
        {
            case 1:
                addProductMenu();
                break;
            case 2:
                viewProductMenu();
                break;
            case 3:
                updateProductMenu();
                break;
            case 4:
                deleteProductMenu();
                break;
            case 5:
                reportsMenu();
                break;
            case 6:
                break;
        }
    }

    public void addProductMenu()
    {
        String[] menuItems = new String[]{"Add Sneaker", "Add Whiskey", "Exit"};

        int choice = Console.getInput("Add Product Menu", menuItems);

        switch (choice)
        {
            case 1:
                sneakerService.create();
                System.out.println("A new sneaker has been added to the inventory. Press Enter to continue...");
                Console.getInput();
                break;
            case 2:
                whiskeyService.create();
                System.out.println("A new Whiskey has been added to the inventory. Press Enter to continue...");
                Console.getInput();
                break;
            default:
                break;
        }
    }
    public void viewProductMenu()
    {
        String[] menuItems = new String[]{"View Sneaker", "View Whiskey", "Exit"};

        int choice = Console.getInput("View Product Menu", menuItems);

        switch (choice)
        {
            case 1:
                if(sneakerService.findAll().length >= 1)
                {
                    System.out.println("Choose a sneaker ID to view");
                    System.out.println(sneakerService.findSneaker(Console.getInteger()).toString());
                    Console.getInput();
                }
                else
                {
                    System.out.println("There is no sneakers in the inventory");
                }
                System.out.println("Press Enter to continue...");
                Console.getInput();
                break;
            case 2:
                if(whiskeyService.findAll().length >= 1)
                {
                    System.out.println("Choose a whiskey ID to view");
                    System.out.println(whiskeyService.findWhiskey(Console.getInteger()).toString());
                    Console.getInput();
                }
                else
                {
                    System.out.println("There is no whiskey in the inventory");
                }
                System.out.println("Press Enter to continue...");
                Console.getInput();
                break;
            default:
                break;
        }
    }
    public void updateProductMenu()
    {
        String[] menuItems = new String[]{"Update Sneaker", "Update Whiskey", "Exit"};
    }
    public void deleteProductMenu()
    {
        String[] menuItems = new String[]{"Delete Sneaker", "Delete Whiskey", "Exit"};
    }
    public void reportsMenu()
    {
        String[] menuItems = new String[]{"View Sneaker Report", "View Whiskey Report", "Exit"};

        int choice = Console.getInput("Product Reports Menu", menuItems);

        switch (choice)
        {
            case 1:
                if(sneakerService.findAll().length >= 1)
                {
                    System.out.println("Total number of sneakers in inventory: " + sneakerService.findAll().length);
                    for (Sneaker sneaker : sneakerService.findAll())
                    {
                        System.out.println(sneaker.toString());
                    }
                    System.out.println("Press Enter to continue...");
                }
                else
                {
                    System.out.println("There is no sneakers in the inventory");
                }
                break;
            case 2:
                if(whiskeyService.findAll().length >= 1)
                {
                    System.out.println("Total number of whiskey in inventory: " + whiskeyService.findAll().length);
                    for (Whiskey whiskey : whiskeyService.findAll())
                    {
                        System.out.println(whiskey.toString());
                    }
                    System.out.println("Press Enter to continue...");
                }
                else
                {
                    System.out.println("There is no whiskey in the inventory");
                }
                break;
            default:
                break;
        }
    }
}
