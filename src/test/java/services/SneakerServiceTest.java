package services;

import models.Sneaker;
import org.junit.*;

public class SneakerServiceTest
{
    @Test
    public void createTest(){

        int expectedId = 1;
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        float expectedSize = 10.5f;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedId, expectedName, expectedBrand,
                expectedSport, expectedSize, expectedQty, expectedPrice);

        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        float actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQty();
        float actualPrice = testSneaker.getPrice();

        Assert.assertEquals(expectedId, actualId);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedSport, actualSport);
        Assert.assertEquals(expectedSize, actualSize, 0.01);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice, 0.01);
    }

    @Test
    public void findSneakerTest()
    {
        SneakerService sneakerService = new SneakerService();
        sneakerService.create();
        sneakerService.create();
        sneakerService.create();
        sneakerService.create();

        Sneaker sneaker1 = sneakerService.findSneaker(2);
        Sneaker sneaker2 = sneakerService.findSneaker(4);

        Assert.assertEquals(sneaker1.getId(), 2);
        Assert.assertEquals(sneaker2.getId(), 4);
    }

    @Test
    public void findSneakerAllTest()
    {
        SneakerService sneakerService = new SneakerService();
        Sneaker sn1 = sneakerService.create();
        Sneaker sn2 = sneakerService.create();
        Sneaker sn3 = sneakerService.create();
        Sneaker sn4 = sneakerService.create();

        Sneaker[] sneakers = new Sneaker[] {sn1, sn2, sn3, sn4};

        Assert.assertEquals(4, sneakerService.findAll().length);
    }

    @Test
    public void removeSneakerTest()
    {
        SneakerService sneakerService = new SneakerService();
        Sneaker sn1 = sneakerService.create();
        Sneaker sn2 = sneakerService.create();
        Sneaker sn3 = sneakerService.create();
        Sneaker sn4 = sneakerService.create();
        Sneaker sn5 = sneakerService.create();

        Sneaker[] sneakers = new Sneaker[] {sn1, sn2, sn3, sn4, sn5};

        Assert.assertEquals(5, sneakerService.findAll().length);
        sneakerService.delete(3);
        Assert.assertEquals(4, sneakerService.findAll().length);
    }

}
