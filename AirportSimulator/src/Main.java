import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int averageTimeSpentWaitingTakeOff = 0; // done
        int averageTimeSpentWaitingLanding = 0; // done
        int longestTimeSpentWaitingTakeoff = 0; // done
        int longestTimeSpentWaitingLanding = 0; // done
        int planesCrashed = 0; // done
        int totalPlanesTookOff = 0; // done
        int totalPlanesLanded = 0;  // done



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



        for (int i = 0; i < iterations; i++) {
            Random rand = new Random(); // plane landing sequence
            int randomNumber = rand.nextInt(100) + 1;
            int randomNumber2 = rand.nextInt(100) + 1;
            if(randomNumber <= percentChanceTakeOff){ // adds plane if random number between 1-100 falls below % chance given
                Plane plane = new Plane();
                takeoffQueue.enqueue(plane); // correct
            }
            if(randomNumber2 <= percentChanceShowUpToLand ){ // adds plane if random number between 1-100 falls below % chance given
                Plane plane1 = new Plane();
                pqueue.enqueue(plane1,plane1.getRemainingFuel()); // correct
            }
            if(runWayStatus == false && !pqueue.isEmpty()){ // Sets runway for landing
                pqueue.peek().setRunWayStatus(true);
                runWayStatus = true; // correct
            }
            if(!pqueue.isEmpty() && pqueue.peek().getTransactionTime() == 0){
                if(pqueue.peek().getTimeInQueue() > pqueue.peek().getStartingFuel()){
                    planesCrashed++;
                }else{
                    averageTimeSpentWaitingLanding = averageTimeSpentWaitingLanding + pqueue.peek().getTimeInQueue();
                }
                if(pqueue.peek().getTimeInQueue() > longestTimeSpentWaitingLanding){
                    longestTimeSpentWaitingLanding = pqueue.peek().getTimeInQueue();
                }
                pqueue.dequeue();
                totalPlanesLanded++;
                runWayStatus = false;
            }else{
                if(!pqueue.isEmpty()){
                    pqueue.peek().setTransactionTime(pqueue.peek().getTransactionTime() - 1);
                }
            }
            if(pqueue.isEmpty() && !takeoffQueue.isEmpty() && runWayStatus == false){ // priority takeoffQueue is empty and runway is empty plane will aboard the runway
                takeoffQueue.peek().setRunWayStatus(true);
                runWayStatus = true;
            }
            else if(!takeoffQueue.isEmpty() && takeoffQueue.peek().getRunWayStatus() == true && runWayStatus == true){ // checks if plane is on the runway and transaction time is complete then takeoff.
                if(takeoffQueue.peek().getTransactionTime() == 0){
                    averageTimeSpentWaitingTakeOff = averageTimeSpentWaitingTakeOff + takeoffQueue.peek().getTimeInQueue();
                    if(takeoffQueue.peek().getTimeInQueue() > longestTimeSpentWaitingTakeoff){
                        longestTimeSpentWaitingTakeoff = takeoffQueue.peek().getTimeInQueue();
                    }
                    takeoffQueue.dequeue();
                    totalPlanesTookOff++;
                    runWayStatus = false;
                }else{
                    takeoffQueue.peek().setTransactionTime(takeoffQueue.peek().getTransactionTime() - 1);
                }
            }
            for (int j = 0; j < takeoffQueue.size(); j++) { // Every iteration sets every adds +1 to timeInQueue
                Plane temp = takeoffQueue.peek();
                takeoffQueue.dequeue();
                temp.setTimeInQueue(temp.getTimeInQueue() + 1);
                takeoffQueue.enqueue(temp);
            }
            for (int j = 0; j < pqueue.size(); j++) { // Every iteration sets every adds +1 to timeInQueue
                Plane temp = pqueue.peek();
                pqueue.dequeue();
                temp.setTimeInQueue(temp.getTimeInQueue() + 1);
                pqueue.enqueue(temp,temp.getRemainingFuel());
            }
        }
        if (totalPlanesLanded != 0 && planesCrashed != 0) {
            averageTimeSpentWaitingLanding = averageTimeSpentWaitingLanding / (totalPlanesLanded - planesCrashed);
        }
        if (totalPlanesTookOff != 0) {
            averageTimeSpentWaitingTakeOff = averageTimeSpentWaitingTakeOff / totalPlanesTookOff;
        }

        System.out.println("Percent chance a plane will show up to take off each iteration: " + percentChanceTakeOff);
        System.out.println("Percent chance a plane will show up to land each iteration: " + percentChanceShowUpToLand);
        System.out.println("Number of minutes the simulation will run: " + iterations);

        System.out.println("Average time spent waiting for takeoff: " + averageTimeSpentWaitingTakeOff);
        System.out.println("Average time spent waiting for landing: " + averageTimeSpentWaitingLanding);
        System.out.println("Longest time spent waiting for takeoff: " + longestTimeSpentWaitingTakeoff);
        System.out.println("Longest time spent waiting for landing: " + longestTimeSpentWaitingLanding);
        System.out.println("Number of planes that crashed: " + planesCrashed);
        System.out.println("Total planes took off: " + totalPlanesTookOff);
        System.out.println("Total planes landed: " + totalPlanesLanded);
    }
}