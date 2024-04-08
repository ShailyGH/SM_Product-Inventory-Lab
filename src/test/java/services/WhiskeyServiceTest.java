package services;

import models.Sneaker;
import models.Whiskey;
import org.junit.Assert;
import org.junit.Test;

public class WhiskeyServiceTest
{
    private WhiskeyService whiskeyService;

    @Test
    public void createTest(){

        int expectedID = 20;
        String expectedName = "Honey Whiskey";
        String expectedBrand = "Jack Daniels";
        float expectedVolume = 750.5f;
        int expectedQty = 10;
        float expectedPrice = 35.99f;

        WhiskeyService whiskeyService = new WhiskeyService();
        Whiskey testwhiskey = whiskeyService.create(expectedID, expectedName, expectedBrand,
                expectedVolume, expectedQty, expectedPrice);

        int actualId = testwhiskey.getId();
        String actualName = testwhiskey.getName();
        String actualBrand = testwhiskey.getBrand();
        float actualVolume = testwhiskey.getVolume();
        int actualQty = testwhiskey.getQty();
        float actualPrice = testwhiskey.getPrice();

        Assert.assertEquals(expectedID, actualId);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedVolume, actualVolume, 0.01);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice, 0.01);
    }

    @Test
    public void findWhiskeyTest()
    {
        WhiskeyService whiskeyService = new WhiskeyService();

        whiskeyService.create();
        whiskeyService.create();
        whiskeyService.create();
        whiskeyService.create();

        Whiskey whiskey1 = whiskeyService.findWhiskey(2);
        Whiskey whiskey2 = whiskeyService.findWhiskey(4);

        Assert.assertEquals(whiskey1.getId(), 2);
        Assert.assertEquals(whiskey2.getId(), 4);
    }

    @Test
    public void findAllWhiskeyTest()
    {
        WhiskeyService whiskeyService = new WhiskeyService();

        Whiskey whiskey1 = whiskeyService.create();
        Whiskey whiskey2 = whiskeyService.create();
        Whiskey whiskey3 = whiskeyService.create();
        Whiskey whiskey4 = whiskeyService.create();

        Whiskey[] whiskies = new Whiskey[] {whiskey1, whiskey2, whiskey3, whiskey4};

        Assert.assertEquals(whiskey2, whiskeyService.findWhiskey(2));
        Assert.assertEquals(4, whiskeyService.findAll().length);
    }

    @Test
    public void removeWhiskeyTest()
    {
        WhiskeyService whiskeyService = new WhiskeyService();

        whiskeyService.create();
        whiskeyService.create();
        whiskeyService.create();
        whiskeyService.create();

        whiskeyService.delete(2);

        Assert.assertEquals(3, whiskeyService.findAll().length);
    }
}
