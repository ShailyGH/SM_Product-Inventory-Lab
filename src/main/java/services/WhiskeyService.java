package services;

import models.Whiskey;

import java.util.ArrayList;

public class WhiskeyService
{
    private static int nextId = 1;
    private ArrayList<Whiskey> inventory = new ArrayList<>();

    public Whiskey create()
    {
        Whiskey createdWhiskey = new Whiskey(nextId++, "", "", 10.5f, 10, 99.99f);
        inventory.add(createdWhiskey);
        //saveData();
        return createdWhiskey;
    }

    public Whiskey create(int id, String name, String brand, float volume, int quantity, float price) {

        Whiskey createdWhiskey = new Whiskey(id, name, brand, volume, quantity, price);
        inventory.add(createdWhiskey);

        //saveData();
        return createdWhiskey;
    }

    public void saveData()
    {

    }

    //read
    public Whiskey findWhiskey(int id) {
        // should take an int and return an object with that id, if exists
        for (Whiskey whiskey : inventory)
        {
            if(whiskey.getId() == id)
            {
                return whiskey;
            }
        }
        return null;
    }

    //read all
    public Whiskey[] findAll() {
        // should return a basic array copy of the ArrayList
        return inventory.toArray(new Whiskey[inventory.size()]);

    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false

        boolean deleteFlag = this.inventory.remove(findWhiskey(id));
        if(deleteFlag)
        {
            saveData();
        }
        return deleteFlag;
    }
}
