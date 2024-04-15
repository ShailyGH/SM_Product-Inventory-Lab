package services;

import models.Sneaker;
import models.Whiskey;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Integer;

public class WhiskeyService
{
    private static int nextId = 1;
    private ArrayList<Whiskey> inventory = new ArrayList<>();

    public WhiskeyService()
    {
        loadDataCSV();
    }

    public Whiskey create()
    {
        Whiskey createdWhiskey = new Whiskey(nextId++, "", "", 10.5f, 10, 99.99f);
        inventory.add(createdWhiskey);
        writeDataCSV();
        return createdWhiskey;
    }

    public Whiskey create(String name, String brand, float volume, int quantity, float price) {

        Whiskey createdWhiskey = new Whiskey(nextId++, name, brand, volume, quantity, price);
        inventory.add(createdWhiskey);

        writeDataCSV();
        return createdWhiskey;
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
            writeDataCSV();
        }
        return deleteFlag;
    }

    public void writeDataCSV() {
        try
        {
           // String csvFile = "/Users/shail/Desktop/Whiskey.csv";
            String csvFile = "/Users/shaily/Desktop/Whiskey.csv";
            FileWriter writer = new FileWriter(csvFile); //(1)
            CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

            for (Whiskey w : inventory) {
                List<String> list = new ArrayList<>(); // (3)
                list.add(String.valueOf(w.getId()));
                list.add(w.getName());
                list.add(w.getBrand());
                list.add(String.valueOf(w.getVolume()));
                list.add(String.valueOf(w.getQty()));
                list.add(String.valueOf(w.getPrice()));

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
           // File file = new File("/Users/shail/Desktop/", "Whiskey.csv");
            File file = new File("/Users/shaily/Desktop/", "Whiskey.csv");
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
                String[] whiskey = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(whiskey[0]);
                String name = whiskey[1];
                String brand = whiskey[2];
                float volume = Float.parseFloat(whiskey[3]);
                int qty = Integer.parseInt(whiskey[4]);
                float price = Float.parseFloat(whiskey[5]);

                // (5)
                inventory.add(new Whiskey(id, name, brand, volume, qty, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
