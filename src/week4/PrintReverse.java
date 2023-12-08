package week4;

public class PrintReverse {


//class Result {

    /*
     * Complete the 'reversePrint' function below.
     *
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        List<Integer> l = new ArrayList<>();
        while(llist != null){
            l.add(llist.data);
            llist = llist.next;
        }
        for(int i = l.size() - 1; i >= 0; i--){
            System.out.println(l.get(i));
        }
    }

//}


}
