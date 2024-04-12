package services;

import models.Sneaker;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SneakerService {
    private static int nextId = 1;
    private ArrayList<Sneaker> inventory = new ArrayList<>();

    public SneakerService() {
        loadDataCSV();
    }

    public Sneaker create() {
        Sneaker createdSneaker = new Sneaker(nextId++, "", "", "", 10.5f, 10, 99.99f);
        inventory.add(createdSneaker);
        writeDataCSV();
        return createdSneaker;
    }

    public Sneaker create(String name, String brand, String sport, float size, int quantity, float price) {

        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);
        inventory.add(createdSneaker);

        writeDataCSV();
        return createdSneaker;
    }

    //read
    public Sneaker findSneaker(int id) {
        // should take an int and return an object with that id, if exists
        for (Sneaker sneaker : inventory) {
            if (sneaker.getId() == id) {
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
        if (deleteFlag) {
            writeDataCSV();
        }
        return deleteFlag;
    }

    public void writeDataCSV() {
        try
        {
            String csvFile = "/Users/shail/Desktop/Sneaker.csv";
            FileWriter writer = new FileWriter(csvFile); //(1)
            CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

            for (Sneaker s : inventory) {
                List<String> list = new ArrayList<>(); // (3)
                list.add(String.valueOf(s.getId()));
                list.add(s.getName());
                list.add(s.getBrand());
                list.add(s.getSport());
                list.add(String.valueOf(s.getSize()));
                list.add(String.valueOf(s.getQty()));
                list.add(String.valueOf(s.getPrice()));

                CSVUtils.writeLine(writer, list);  // (4)
            }

            // (5)
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void loadDataCSV() {

        try
        {
            // (1)
            File file = new File("/Users/shail/Desktop/", "Sneaker.csv");
            String line = "";
            String csvSplitBy = ",";

            if (!file.isFile() && !file.createNewFile()) {
                throw new IOException("Error creating new file: " + file.getAbsolutePath());
            }
            // (2)
            BufferedReader br = new BufferedReader(new FileReader(file));

            nextId = Integer.parseInt(br.readLine());  // (3)


            while ((line = br.readLine()) != null) {

                // split line with comma
                String[] sneaker = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(sneaker[0]);
                String name = sneaker[1];
                String brand = sneaker[2];
                String sport = sneaker[3];
                float size = Float.parseFloat(sneaker[4]);
                int qty = Integer.parseInt(sneaker[5]);
                float price = Float.parseFloat(sneaker[6]);

                // (5)
                inventory.add(new Sneaker(id, name, brand, sport, size, qty, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
