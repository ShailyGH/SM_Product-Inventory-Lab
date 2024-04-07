package models;

import org.junit.*;

public class SneakerTest
{
    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setName(expected);

        // then (3)
        Assert.assertEquals(expected, testSneaker.getName());
    }

    @Test
    public void setIDTest() {
        // given (1)
        int expected = 99;

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setId(expected);

        // then (3)
        Assert.assertEquals(expected, testSneaker.getId());
    }

    @Test
    public void setBrandTest() {
        // given (1)
        String expected = "On";

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setBrand(expected);

        // then (3)
        Assert.assertEquals(expected, testSneaker.getBrand());
    }

    @Test
    public void setSportTest() {
        // given (1)
        String expected = "Lacrosse";

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setSport(expected);

        // then (3)
        Assert.assertEquals(expected, testSneaker.getSport());
    }

    @Test
    public void setSizeTest() {
        // given (1)
        float expected = 10.5f;

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setSize(expected);

        // then (3)
        Assert.assertEquals(expected, testSneaker.getSize(), 0.01);
    }

    @Test
    public void setQtyTest() {
        // given (1)
        int expected = 20;

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setQty(expected);

        // then (3)
        Assert.assertEquals(expected, testSneaker.getQty());
    }

    @Test
    public void setPriceTest() {
        // given (1)
        float expected = 99.99f;

        // when (2)
        Sneaker testSneaker = new Sneaker();
        testSneaker.setPrice(expected);

        // then (3)
        Assert.assertEquals(expected, testSneaker.getPrice(), 0.01);
    }

}

