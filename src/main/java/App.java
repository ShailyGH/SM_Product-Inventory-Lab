import services.SneakerService;

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

        int choice = Console.getInput("Main Menu", menuItems);

        switch (choice)
        {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}
