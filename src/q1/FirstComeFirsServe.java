package q1;

import java.util.List;

public class FirstComeFirsServe extends SchedulingAlgorithm {
    FirstComeFirsServe(List<Integer> requests, int head) {
        super(requests, head);
    }

    @Override
    public int getMovement() {
        int sum=0;
        int iHead = getHead();
        System.out.print(iHead);
        for (Integer request : getRequests()) {
            int cost = Math.abs(iHead - request);
            sum += cost;
            iHead = request;
            System.out.print("->"+iHead+"("+cost+")");
        }
        System.out.println();
        return sum;
    }

}
