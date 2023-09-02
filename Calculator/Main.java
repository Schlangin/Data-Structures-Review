package Calculator;
public class Main {
    public static void main(String[] args) {
        String entry = "(5+3)+(5+4)";
        PostFixCalculator pfc = new PostFixCalculator(entry);

        System.out.println(pfc.convertToPostFix(entry));




    }
}