package io.gocklkatz.daypacker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DpSolverTest {

    @Test
    void solveKnapsackComplete() {
        List<Food> foods = buildMenu();

        DpSolver solver = new DpSolver(new DpAlgorithmCompleteEnumeration());

        //Max sum(benefit), sum(cost)<750, complete enumeration
        Result resultBenefit = solver.solve(foods, 750, Comparator.comparingInt(Food::benefit));
        printOutResult(resultBenefit);
        assertEquals(353, resultBenefit.getTotalBenefit());
        assertEquals(685, resultBenefit.getTotalCost());
    }

    @Test
    void solveKnapsackGreedy() {
        List<Food> foods = buildMenu();

        DpSolver solver = new DpSolver(new DpAlgorithmFlexibleGreedy());

        //Max sum(benefit), sum(cost)<750, greedy by benefit descending
        Result resultBenefit = solver.solve(foods, 750, Comparator.comparingInt(Food::benefit));
        printOutResult(resultBenefit);
        assertEquals(284, resultBenefit.getTotalBenefit());
        assertEquals(735, resultBenefit.getTotalCost());

        //Max sum(benefit), sum(cost)<750, greedy by cost ascending
        Result resultCost = solver.solve(foods, 750, Comparator.comparingInt(Food::cost).reversed());
        printOutResult(resultCost);
        assertEquals(318, resultCost.getTotalBenefit());
        assertEquals(717, resultCost.getTotalCost());

        //Max sum(benefit), sum(cost)<750, greedy by density descending
        Result resultDensity = solver.solve(foods, 750, Comparator.comparingDouble(Food::density));
        printOutResult(resultDensity);
        assertEquals(318, resultDensity.getTotalBenefit());
        assertEquals(717, resultDensity.getTotalCost());
    }

    private List<Food> buildMenu() {
        List<Food> foods = new ArrayList<>();

        foods.add(new Food("Wine", 89, 123));
        foods.add(new Food("Beer", 90, 154));
        foods.add(new Food("Pizza", 95, 258));
        foods.add(new Food("Burger", 100, 354));
        foods.add(new Food("Fries", 90, 365));
        foods.add(new Food("Cola", 79, 150));
        foods.add(new Food("Apple", 50, 95));
        foods.add(new Food("Donut", 10, 195));

        return foods;
    }

    private void printOutResult(Result result) {
        System.out.println("Result:");
        result.getFoods().forEach(System.out::println);
        System.out.println("Total benefit: " + result.getTotalBenefit());
        System.out.println("Total cost: " + result.getTotalCost());
        System.out.println("---");
    }
}
