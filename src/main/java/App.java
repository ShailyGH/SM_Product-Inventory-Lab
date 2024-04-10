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

        int choice = Console.getInput("\nInventory Manager Main Menu", menuItems);


        switch (choice)
        {
            case 1:
                addProductMenu();
                displayMenu();
                break;
            case 2:
                viewProductMenu();
                displayMenu();
                break;
            case 3:
                updateProductMenu();
                displayMenu();
                break;
            case 4:
                deleteProductMenu();
                displayMenu();
                break;
            case 5:
                reportsMenu();
                displayMenu();
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
                System.out.println(sneakerService.findSneaker(sneakerService.findAll().length) + " has been added to the inventory");
                break;
            case 2:
                whiskeyService.create();
                System.out.println(whiskeyService.findWhiskey(whiskeyService.findAll().length) + " has been added to the inventory");
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
                    System.out.println("Choose a sneaker ID to view - enter an ID between 1 and " + sneakerService.findAll().length);
                    System.out.println(sneakerService.findSneaker(Console.getInteger()));
                }
                else
                {
                    System.out.println("There is no sneakers in the inventory");
                }

                break;
            case 2:
                if(whiskeyService.findAll().length >= 1)
                {
                    System.out.println("Choose a whiskey ID to view - enter an ID between 1 and " + whiskeyService.findAll().length);
                    System.out.println(whiskeyService.findWhiskey(Console.getInteger()));
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

    public void updateProductMenu()
    {
        String[] menuItems = new String[]{"Update Sneaker", "Update Whiskey", "Exit"};

        int choice = Console.getInput("Update Product Menu", menuItems);
        int updateProductSelection;

        switch (choice)
        {
            case 1:
                if(sneakerService.findAll().length >= 1)
                {
                    System.out.println("Choose a sneaker ID to update from the list below");

                    for (Sneaker sneaker: sneakerService.findAll())
                    {
                        System.out.println(sneaker.toString());
                    }
                    updateProductSelection = Console.getInteger();
                    System.out.println(sneakerService.findSneaker(updateProductSelection));
                    sneakerService.delete(updateProductSelection);
                    sneakerService.create();
                    System.out.println("Sneaker updated...");
                }
                else
                {
                    System.out.println("There is no sneakers in the inventory");
                }
                break;
            case 2:
                if(whiskeyService.findAll().length >= 1)
                {
                    System.out.println("Choose a whiskey ID to update from the list below");

                    for (Whiskey whiskey: whiskeyService.findAll())
                    {
                        System.out.println(whiskey.toString());
                    }
                    updateProductSelection = Console.getInteger();
                    System.out.println(whiskeyService.findWhiskey(updateProductSelection));
                    whiskeyService.delete(updateProductSelection);
                    whiskeyService.create();
                    System.out.println("Whiskey updated...");
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

    public void deleteProductMenu()
    {
        String[] menuItems = new String[]{"Delete Sneaker", "Delete Whiskey", "Exit"};

        int choice = Console.getInput("Delete Product Menu", menuItems);
        int deleteProductSelection;

        switch (choice)
        {
            case 1:
                if(sneakerService.findAll().length >= 1)
                {
                    System.out.println("Choose a sneaker ID to delete from the list below");

                    for (int i = 1; i <= sneakerService.findAll().length ; i++)
                    {
                        System.out.println(i + " - "+ sneakerService.findSneaker(i).toString());
                    }
                    deleteProductSelection = Console.getInteger();
                    System.out.println("Deleted " + sneakerService.findSneaker(deleteProductSelection));
                    sneakerService.delete(deleteProductSelection);
                }
                else
                {
                    System.out.println("There is no sneakers in the inventory");
                }
                break;
            case 2:
                if(whiskeyService.findAll().length >= 1)
                {
                    System.out.println("Choose a whiskey ID to delete from the list below");

                    for (int i = 1; i <= whiskeyService.findAll().length ; i++)
                    {
                        System.out.println(i + " - "+ whiskeyService.findWhiskey(i).toString());
                    }
                    deleteProductSelection = Console.getInteger();
                    System.out.println("Deleted " + whiskeyService.findWhiskey(deleteProductSelection));
                    whiskeyService.delete(deleteProductSelection);
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
