package com.projet.stockcontroller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StockControllerTest {

    private final StockController controller = new StockController();

    @Test
    void testCalculateRisk_LowB() {
        assertEquals("Low-B", controller.calculateRisk(4));
    }

    @Test
    void testCalculateRisk_LowA() {
        assertEquals("Low-A", controller.calculateRisk(3));
    }

    @Test
    void testCalculateRisk_Medium() {
        assertEquals("Medium", controller.calculateRisk(20));
    }

    @Test
    void testCalculateRisk_High() {
        assertEquals("High", controller.calculateRisk(-1));
    }

    @Test
    void testHeavyProcessing_defaultSize() {
        double[] result = controller.heavyProcessing(100);
        assertEquals(100, result.length);
    }

    @Test
    void testHeavyProcessing_maxLimit() {
        double[] result = controller.heavyProcessing(99999);
        assertEquals(10000, result.length);
    }
}
