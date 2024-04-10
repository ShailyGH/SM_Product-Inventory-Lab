import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import models.Sneaker;
import models.Whiskey;
import services.SneakerService;
import services.WhiskeyService;

import static java.lang.Thread.sleep;

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
                Sneaker newSneaker = sneakerService.create();
                System.out.println(sneakerService.findSneaker(newSneaker.getId()) + " has been added to the inventory");
                break;
            case 2:
                Whiskey newWhiskey = whiskeyService.create();
                System.out.println(whiskeyService.findWhiskey(newWhiskey.getId()) + " has been added to the inventory");
                break;
            default:
                break;
        }
    }

    public void viewProductMenu()
    {
        String[] menuItems = new String[]{"View Sneaker", "View Whiskey", "Exit"};

        int choice = Console.getInput("View Product Menu", menuItems);
        int count = 1;
        switch (choice)
        {
            case 1:
                if(sneakerService.findAll().length >= 1)
                {
                    System.out.println("Choose a sneaker ID to view - enter an ID between 1 and " + sneakerService.findAll().length);
                    //System.out.println(sneakerService.findSneaker(Console.getInteger()));
                    for (Sneaker sneaker : sneakerService.findAll()) {
                        if (Console.getInteger() == count)
                        {
                            System.out.println(sneakerService.findSneaker(sneaker.getId()));
                        }
                        count++;
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
                    System.out.println("Choose a whiskey ID to view - enter an ID between 1 and " + whiskeyService.findAll().length);
                    System.out.println(whiskeyService.findWhiskey(Console.getInteger()));
                    for (Whiskey whiskey : whiskeyService.findAll()) {
                        if (Console.getInteger() == count)
                        {
                            System.out.println(whiskeyService.findWhiskey(whiskey.getId()));
                        }
                        count++;
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

    public void updateProductMenu()
    {
        String[] menuItems = new String[]{"Update Sneaker", "Update Whiskey", "Exit"};

        int choice = Console.getInput("Update Product Menu", menuItems);
        int updateProductSelection;
        int count = 1;
        switch (choice)
        {
            case 1:
                if(sneakerService.findAll().length >= 1)
                {
                    System.out.println("Choose a sneaker ID to update from the list below");
                    for (Sneaker sneaker : sneakerService.findAll())
                    {
                        System.out.println(count + " - " + sneaker.toString());
                        count ++;
                    }
                    updateProductSelection = Console.getInteger();
                    count = 1;
                    for (Sneaker sneaker : sneakerService.findAll()) {
                        if (updateProductSelection == count)
                        {
                            System.out.println(sneakerService.findSneaker(sneaker.getId()) + " has been removed from the inventory");
                            sneakerService.delete(sneaker.getId());
                        }
                        count++;
                    }
                    Sneaker newSneaker = sneakerService.create();
                    System.out.println(sneakerService.findSneaker(newSneaker.getId()) + " has been added to the inventory");
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
                    for (Whiskey whiskey : whiskeyService.findAll())
                    {
                        System.out.println(count + " - " + whiskey.toString());
                        count++;
                    }
                    updateProductSelection = Console.getInteger();
                    count = 1;
                    for (Whiskey whiskey : whiskeyService.findAll()) {
                        if (updateProductSelection == count)
                        {
                            System.out.println(whiskeyService.findWhiskey(whiskey.getId()) + " has been removed from the inventory");
                            whiskeyService.delete(whiskey.getId());
                        }
                        count++;
                    }
                    Whiskey newWhiskey = whiskeyService.create();
                    System.out.println(whiskeyService.findWhiskey(newWhiskey.getId()) + " has been added to the inventory");
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
        int count = 1;

        switch (choice)
        {
            case 1:
                if(sneakerService.findAll().length >= 1)
                {
                    System.out.println("Choose a sneaker ID to delete from the list below");
                    for (Sneaker sneaker : sneakerService.findAll())
                    {
                        System.out.println(count + " - " + sneaker.toString());
                        count ++;
                    }
                    deleteProductSelection = Console.getInteger();
                    count = 1;
                    for (Sneaker sneaker : sneakerService.findAll()) {
                        if (deleteProductSelection == count)
                        {
                            System.out.println(sneakerService.findSneaker(sneaker.getId()) + " has been removed from the inventory");
                            sneakerService.delete(sneaker.getId());
                        }
                        count++;
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
                    System.out.println("Choose a whiskey ID to delete from the list below");
                    for (Whiskey whiskey : whiskeyService.findAll())
                    {
                        System.out.println(count + " - " + whiskey.toString());
                        count++;
                    }
                    deleteProductSelection = Console.getInteger();
                    count = 1;
                    for (Whiskey whiskey : whiskeyService.findAll()) {
                        if (deleteProductSelection == count)
                        {
                            System.out.println(whiskeyService.findWhiskey(whiskey.getId()) + " has been removed from the inventory");
                            whiskeyService.delete(whiskey.getId());
                        }
                        count++;
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
