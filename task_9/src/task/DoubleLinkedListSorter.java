package task;

public class DoubleLinkedListSorter {
    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {
        int size = list.getSize();
        for(int i = 0; i < size; i++) {

            DoubleLinkedListItem min =  list.getFirst();
            DoubleLinkedListItem cur = list.getFirst();

            for(int j = 0; j < size - i; j++) {

                if(cur.getData().compareTo(min.getData()) < 0){ min = cur; }
                cur = cur.getNext();
            }
            list.remove(min);
            list.insertAfter(list.getLast(), (T)min.getData());
        }
    }
}
