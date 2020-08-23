package q1;

import java.util.LinkedList;
import java.util.List;

public class ShortestSeekTimeFirst extends SchedulingAlgorithm {
    ShortestSeekTimeFirst(List<Integer> requests, int head) {
        super(new LinkedList<>(requests), head);
    }

    @Override
    public int getMovement() {
        int sum = 0;
        int iHead = getHead();
        System.out.print(iHead);
        while (!getRequests().isEmpty()) {
            int next = getNextShortestSeekTime(iHead);
            int cost = getCost(iHead, next);
            sum += cost;
            iHead = getRequests().get(next);
            System.out.print("->" + iHead + "(" + cost + ")");
            getRequests().remove(next);
        }
        System.out.println();
        return sum;
    }

    private int getNextShortestSeekTime(int iHead) {
        int min = 0;
        for (int i = 0; i < getRequests().size(); i++)
            if (getCost(iHead, i) < getCost(iHead, min))
                min = i;
        return min;
    }

    private int getCost(int iHead, int i) {
        return Math.abs(getRequests().get(i) - iHead);
    }
}
