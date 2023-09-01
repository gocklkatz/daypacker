package io.gocklkatz.daypacker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DpAlgorithmFlexibleGreedy implements DpAlgorithm {
    @Override
    public Result solve(List<Food> foods, int maxCost, Comparator<Food> comp) {

        foods.sort(comp.reversed());

        int totalBenefit = 0;
        int totalCost = 0;

        List<Food> resultList = new ArrayList<>();
        for(Food food : foods) {
            if(totalCost + food.cost() <= maxCost) {
                resultList.add(food);
                totalCost += food.cost();
                totalBenefit += food.benefit();
            }
        }

        Result result = new Result();
        result.setFoods(resultList);
        result.setTotalBenefit(totalBenefit);
        result.setTotalCost(totalCost);
        return result;
    }
}
