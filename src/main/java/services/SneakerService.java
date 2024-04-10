package services;

import models.Sneaker;

import java.util.ArrayList;

public class SneakerService
{
    private static int nextId = 1;
    private ArrayList<Sneaker> inventory = new ArrayList<>();

    public Sneaker create()
    {
        Sneaker createdSneaker = new Sneaker(nextId++, "", "", "", 10.5f, 10, 99.99f);
        inventory.add(createdSneaker);
        //saveData();
        return createdSneaker;
    }

    public Sneaker create(int id,String name, String brand, String sport, float size, int quantity, float price) {

        Sneaker createdSneaker = new Sneaker(id, name, brand, sport, size, quantity, price);
        inventory.add(createdSneaker);

        //saveData();
        return createdSneaker;
    }

    public void saveData()
    {

    }

    //read
    public Sneaker findSneaker(int id) {
        // should take an int and return an object with that id, if exists
        for (Sneaker sneaker : inventory)
        {
            if(sneaker.getId() == id)
            {
                return sneaker;
            }
        }
        return null;
    }

    //read all
    public Sneaker[] findAll() {
        // should return a basic array copy of the ArrayList
        return inventory.toArray(new Sneaker[inventory.size()]);

    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false

        boolean deleteFlag = this.inventory.remove(findSneaker(id));
        if(deleteFlag)
        {
            saveData();
        }
        return deleteFlag;
    }

}
