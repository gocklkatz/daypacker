package io.gocklkatz.daypacker;

import java.util.Comparator;
import java.util.List;

public interface DpAlgorithm {

    Result solve(List<Food> foods, int maxCost, Comparator<Food> comp);
}
