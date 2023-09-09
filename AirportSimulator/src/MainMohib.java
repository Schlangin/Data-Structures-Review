import java.util.Scanner;

public class MainMohib {
    public static void main(String[] args) {
        LinkedQueue<Plane> takeoffQueue = new LinkedQueue<>();
        PriorityQueue<Plane> pqueue = new PriorityQueue<>();
        int percentChanceTakeOff = 0;
        int percentChanceShowUpToLand = 0;
        int iterations = 0;
        boolean runWayStatus = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("input the percent chance a plane will show up to take off each iteration");
        percentChanceTakeOff = scan.nextInt();
        System.out.println("input the percent chance a plane will show up to land each iteration");
        percentChanceShowUpToLand = scan.nextInt();
        System.out.println("input how many minutes you want the simulation to run");
        iterations = scan.nextInt();


    }
}
