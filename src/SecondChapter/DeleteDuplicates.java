package SecondChapter;

import Utils.LinkedListNode;
import Utils.LinkedListUtils;

import java.util.HashSet;

/**
 * Created by Tommaso on 09/07/2018.
 *
 */
public class DeleteDuplicates {

    private LinkedListNode head = new LinkedListNode(0);
    private LinkedListUtils list = new LinkedListUtils(this.head);

    public static void main(String[] args) {
        DeleteDuplicates a = new DeleteDuplicates();
        a.head = a.list.initializeList();
        a.list.printList(a.head);
        a.deleteDuplicates(a.head);
        System.out.println("");
        a.list.printList(a.head);
    }

    private void deleteDuplicates(LinkedListNode n) {

        HashSet<Integer> set = new HashSet<>();
        while (n != null) {
            if (set.contains(n.data)) {
                n.prev.next = n.next;
                if (n.next != null) {
                    n.next.prev = n.prev;
                }
            } else {
                set.add(n.data);
            }
            n = n.next;
        }

    }
}
