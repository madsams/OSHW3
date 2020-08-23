package q1;

import java.util.List;

class CScan extends SchedulingAlgorithm {
    CScan(List<Integer> requests, int head) {
        super(requests, head);
    }

    @Override
    int getMovement() {
        int sum = 0;
        int head = getHead();
        int lastSeen = getHead();
        System.out.print(lastSeen);
        while (!getRequests().isEmpty()) {
            if (head == Main.MAX - 1) {
                sum += visitARequest(head, lastSeen);
                lastSeen = head;
                head = 0;
                sum += visitARequest(head, lastSeen);
                lastSeen = head;
            } else if (getRequests().contains(head)) {
                sum += visitARequest(head, lastSeen);
                lastSeen = head;
            }

            head += 1;
        }
        System.out.println();
        return sum;
    }

    private int visitARequest(int head, int lastSeen) {
        int cost = Math.abs(head - lastSeen);
        System.out.print("->" + head + "(" + cost + ")");
        getRequests().remove((Integer) lastSeen);

        return cost;
    }
}