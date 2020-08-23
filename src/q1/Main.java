package q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int MAX = 5000;
    static int MIN = 0;
    private static int REQUEST_NUM = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < REQUEST_NUM; i++) {
            int newRandomNumber = random.nextInt(MAX);
            randomList.add(newRandomNumber);
        }


        System.out.println("Choose the algorithm:");
        System.out.println("\t1. FCFS");
        System.out.println("\t2. SSTF");
        System.out.println("\t3. SCAN");
        System.out.println("\t4. C-SCAN");
        System.out.println("\t5. Look");
        System.out.println("\t6. C-Look");
        int algorithmId = scanner.nextInt();
        System.out.print("Where is your head: ");
        int head = scanner.nextInt();
        System.out.println("Generated requests: " + randomList);
        SchedulingAlgorithm schedulingAlgorithm = getAlgorithm(randomList, head, algorithmId);
        System.out.println(schedulingAlgorithm != null ? schedulingAlgorithm.getMovement() : "Your number was wrong");
    }

    private static SchedulingAlgorithm getAlgorithm(List<Integer> requests, int head, int algorithmId) {
        switch (algorithmId) {
            case 1:
                return new FirstComeFirsServe(requests, head);
            case 2:
                return new ShortestSeekTimeFirst(requests, head);
            case 3:
                return new Scan(requests, head);
            case 4:
                return new CScan(requests, head);
            case 5:
                return new Look(requests, head);
            case 6:
                return new CLook(requests, head);
            default:
                return null;
        }
    }
}
