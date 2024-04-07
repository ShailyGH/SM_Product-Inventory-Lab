package services;

import models.Sneaker;

import java.util.ArrayList;

public class SneakerService
{
    private static int nextId = 1;  // (1)

    private ArrayList<Sneaker> inventory = new ArrayList<>();  // (2)


    public Sneaker create(String name, String brand, String sport, float size, int quantity, float price) {

        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);
        inventory.add(createdSneaker);

        //saveData();
        return createdSneaker;

    }

}
