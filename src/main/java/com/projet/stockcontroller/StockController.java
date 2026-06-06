package com.projet.stockcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
@RequestMapping("/api/v1")
public class StockController {

    // Random déclaré une seule fois au niveau de la classe
    private static final Random RANDOM = new Random();

    // CORRECTION 1 : Complexité cyclomatique réduite
    @GetMapping("/risk-index")
    public String calculateRisk(@RequestParam int lvl) {
        if (lvl <= 0 || lvl >= 50) return "High";
        if (lvl < 10) return lvl % 2 == 0 ? "Low-B" : "Low-A";
        return "Medium";
    }

    // CORRECTION 2 : Performance optimisée
    @GetMapping("/process-data")
    public double[] heavyProcessing(
            @RequestParam(defaultValue = "100") int limit) {
        int size = Math.min(limit, 10000);
        double[] results = new double[size];
        for (int i = 0; i < size; i++) {
            results[i] = RANDOM.nextDouble() * i * i;
        }
        return results;
    }
}
