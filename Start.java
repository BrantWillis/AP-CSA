import LinearStructures.ArrayList;
import LinearStructures.LinkedList;

public class Start {
    public static void main(String[] args) {
        LinkedList<String> strArr = new LinkedList<String>();
        ArrayList<Integer> intArr = new ArrayList<Integer>();

        strArr.add("hi");
        strArr.add("yeah");
        strArr.add("brant");
        strArr.add(0,"georgie");
        strArr.add("georgie");
        strArr.add("georgie");

        System.out.println(strArr);

        strArr.set(0, "hello");

        intArr.add(5);
        intArr.add(7);
        intArr.add(0, 1);
        intArr.add(56);
        intArr.add(73);
        intArr.add(84);
        
        System.out.println(intArr);

        intArr.remove(4);



        System.out.println(strArr);
        System.out.println(intArr);

        for(int s: intArr) {
            System.out.println(s);
        }


        

    }
}