package q1;

import java.util.List;

abstract class SchedulingAlgorithm {
    List<Integer> getRequests() {
        return requests;
    }

    int getHead() {
        return head;
    }

    private List<Integer> requests;
    private int head;

    SchedulingAlgorithm(List<Integer> requests, int head) {
        this.requests = requests;
        this.head = head;
    }

    abstract int getMovement();
}