import LinearStructures.ArrayList;

public class Start {
    public static void main(String[] args) {
        ArrayList<String> strArr = new ArrayList<String>();
        ArrayList<Integer> intArr = new ArrayList<Integer>();

        strArr.add("hi");
        strArr.add("yeah");
        strArr.add(0,"georgie");

        intArr.add(5);
        intArr.add(7);
        intArr.add(0, 1);



        System.out.println(strArr);
        System.out.println(intArr);
    }
}