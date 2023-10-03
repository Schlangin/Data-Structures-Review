public class Main {
    public static void main(String[] args) {
        int[] arr = {5,10,15,2,3,8,7,12};
        displayArray(arr,0,arr.length - 1);

        LinkedList list = new LinkedList();
        list.addToEnd("Hello");
        list.addToEnd("GoodBye");
        list.addToEnd("How are you");
        list.display();
        System.out.println(displayRowOfCharacters("*" , 5));

    }
    public static String displayRowOfCharacters(String character , int numOfIterations){
        String line = "";
        if(numOfIterations < 1){
            throw new IllegalStateException("NO NEGATIVE NUMBERS ALLOWED");
        }
        if(numOfIterations == 1){
            return line + character;
        }
        if(numOfIterations != 1){
            line = character + displayRowOfCharacters(character, numOfIterations - 1);
        }
        return line;
    }

    public static int sumOf(int n){
        int sum;
        if(n < 1){
            throw new IllegalArgumentException("Do not pass a negative value or 0 to the sumOf method!");
        }
        if(n == 1){
            sum = 1;
        }else{
            sum = n + sumOf(n - 1);
        }
        return sum;
    }
    public static void displayArray(int[] array,int first ,int last){
        if(first == last){
            System.out.println(array[first] + " ");
        }else{
            int mid = (first + last) / 2;
            displayArray(array, first, mid);    // left subarray
            displayArray(array, mid + 1 , last);    //right subarray
        }
    }

}