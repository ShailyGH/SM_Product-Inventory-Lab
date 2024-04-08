import models.Sneaker;
import services.SneakerService;
import services.WhiskeyService;

public class App
{
    private SneakerService sneakerService = new SneakerService(); // (1)
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

                break;
            case 2:
                //WhiskeyService.create();
                break;
            default:
                break;
        }
    }
    public void viewProductMenu()
    {
        String[] menuItems = new String[]{"View Sneaker", "View Whiskey", "Exit"};

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
    }
}
