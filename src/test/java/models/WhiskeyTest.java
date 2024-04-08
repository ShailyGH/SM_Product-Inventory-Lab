package models;

import org.junit.Assert;
import org.junit.Test;

public class WhiskeyTest
{
    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setName(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getName());
    }

    @Test
    public void setIDTest() {
        // given (1)
        int expected = 99;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setId(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getId());
    }

    @Test
    public void setBrandTest() {
        // given (1)
        String expected = "Jack Daniel";

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setBrand(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getBrand());
    }

    @Test
    public void setVolumeTest() {
        // given (1)
        float expected = 750.5f;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setVolume(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getVolume(), 0.01);
    }

    @Test
    public void setQtyTest() {
        // given (1)
        int expected = 20;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setQty(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getQty());
    }

    @Test
    public void setPriceTest() {
        // given (1)
        float expected = 35.99f;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setPrice(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getPrice(), 0.01);
    }


    @Test // (1)
    public void constructorTest(){

        // (2)
        int expectedId = 6;
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennnis";
        float expectedSize = 10.5f;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (3)
        Sneaker testSneaker = new Sneaker(expectedId, expectedName, expectedBrand,
                expectedSport, expectedSize, expectedQty,expectedPrice);

        // (4)
        Assert.assertEquals(expectedId, testSneaker.getId());
        Assert.assertEquals(expectedName, testSneaker.getName());
        Assert.assertEquals(expectedBrand, testSneaker.getBrand());
        Assert.assertEquals(expectedSport, testSneaker.getSport());
        Assert.assertEquals(expectedSize, testSneaker.getSize(), 0.01);
        Assert.assertEquals(expectedQty, testSneaker.getQty());
        Assert.assertEquals(expectedPrice, testSneaker.getPrice(), 0.01);
    }

}
