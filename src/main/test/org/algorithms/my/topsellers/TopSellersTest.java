package org.algorithms.my.topsellers;

import org.algorithms.collections.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TopSellersTest {

    private final TopSellers topSellers = new TopSellers();


    @Test
    void test1() {
        List<Pair<String, Integer>> result = topSellers.getTopSellersV1(new Selling[]{
                new Selling("Arny", "Canada", "gate", 23),
                new Selling("Arny", "Canada", "car", 145),
                new Selling("Boris", "Spain", "gate", 27),
                new Selling("Omar", "Canada", "gate", 24)
        }, 2);


        assertNotNull(result);

        assertEquals(2, result.size());
        Pair<String, Integer> top1 = result.getFirst();
        assertEquals("Arny", top1.getKey());
        assertEquals(168, top1.getValue());

        Pair<String, Integer> top2 = result.get(1);
        assertEquals("Boris", top2.getKey());
        assertEquals(27, top2.getValue());

    }


    @Test
    void test2() {
        List<Pair<String, Integer>> result = topSellers.getTopSellers(new Selling[]{
                new Selling("Arny", "Canada", "gate", 23),
                new Selling("Arny", "Canada", "car", 145),
                new Selling("Boris", "Spain", "gate", 27),
                new Selling("Omar", "Canada", "gate", 24)
        }, 2);


        assertNotNull(result);

        assertEquals(2, result.size());
        Pair<String, Integer> top1 = result.getFirst();
        assertEquals("Arny", top1.getKey());
        assertEquals(168, top1.getValue());

        Pair<String, Integer> top2 = result.get(1);
        assertEquals("Boris", top2.getKey());
        assertEquals(27, top2.getValue());

    }

}