public class Main {
    public static void main(String[] args) {
        MyHashTable<String , Integer> table = new MyHashTable<>();
        table.add("Bob", 555);
        table.add("joe", 424);
        table.add("poe", 514);
        table.add("moe", 626);
        table.add("loe", 624);
        table.printEntries();
        table.remove("");
        System.out.println(table.getValue("Bob"));
    }
}