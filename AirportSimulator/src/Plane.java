import java.util.Comparator;
import java.util.Random;
public class Plane implements Comparable<Plane> {
    private boolean runWayStatus = false;// added
    private int remainingFuel;
    private int timeInQueue; // added
    private int transactionTime;
    private int startingFuel;
    Plane(){
        Random rand = new Random();
        int min = 5;
        int max = 15;
        int min1 = 1;
        int max1 = 3;
        remainingFuel = rand.nextInt(11) + min;
        transactionTime = rand.nextInt(max1 - min1 + 1) + min1;
        startingFuel = remainingFuel;

    }
    public void setRemainingFuel(int anEntry){
        remainingFuel = anEntry;
    }
    public int getRemainingFuel(){
        return remainingFuel;
    }
    public void setTimeInQueue(int anEntry){
        timeInQueue = anEntry;
    }
    public int getTimeInQueue(){
        return timeInQueue;
    }
    public void setTransactionTime(int anEntry){
        transactionTime = anEntry;
    }
    public int getTransactionTime(){
        return transactionTime;
    }
    public boolean getRunWayStatus(){
        return runWayStatus;
    }
    public void setRunWayStatus(boolean entry){
        runWayStatus = entry;
    }
    public void setStartingFuel(int anEntry){
        startingFuel = anEntry;
    }
    public int getStartingFuel(){
        return startingFuel;
    }
    public int compareTo(Plane o) {
        return Integer.compare(this.remainingFuel, o.remainingFuel);
    }
}
