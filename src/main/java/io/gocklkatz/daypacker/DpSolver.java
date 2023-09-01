package io.gocklkatz.daypacker;

import java.util.Comparator;
import java.util.List;

public class DpSolver {

    public DpAlgorithm dpAlgorithm;

    public DpSolver(DpAlgorithm dpAlgorithm) {
        this.dpAlgorithm = dpAlgorithm;
    }

    public Result solve(List<Food> foods, int maxCost, Comparator<Food> comp) {
        return dpAlgorithm.solve(foods, maxCost, comp);
    }

    public void setDpAlgorithm(DpAlgorithm dpAlgorithm) {
        this.dpAlgorithm = dpAlgorithm;
    }
}
