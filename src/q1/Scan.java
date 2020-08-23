package q1;

import java.util.List;

class Scan extends SchedulingAlgorithm {
    //1 means forward and -1 mean backward
    private int direction = 1;

    Scan(List<Integer> requests, int head) {
        super(requests, head);
    }

    @Override
    int getMovement() {
        boolean firstVisited = false;
        boolean lastVisited = false;

        int sum = 0;
        int head = getHead();
        int lastSeen = getHead();
        System.out.print(lastSeen);
        while (!firstVisited || !lastVisited) {
            if (head == Main.MIN) {
                firstVisited = true;
                direction = 1;

                sum += visitARequest(head, lastSeen);
                lastSeen = head;
            } else if (head == Main.MAX - 1) {
                lastVisited = true;
                direction = -1;
                sum += visitARequest(head, lastSeen);
                lastSeen = head;
            } else if (getRequests().contains(head)) {
                sum += visitARequest(head, lastSeen);
                lastSeen = head;
            }

            head += direction;
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