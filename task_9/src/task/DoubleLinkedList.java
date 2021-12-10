package task;

public class DoubleLinkedList<T extends Comparable<T>> {

    private int size;
    private DoubleLinkedListItem first;
    private DoubleLinkedListItem last;

    public DoubleLinkedList(){
        size = 0;
    }

    public int getSize(){
        return  size;
    }
    public DoubleLinkedListItem getFirst(){
        return  first;
    }
    public DoubleLinkedListItem getLast(){
        return last;
    }

    public DoubleLinkedListItem findFirstItem(T data){
        DoubleLinkedListItem item = first;
        while(item.getData() != data){
            item = item.getNext();
        }
        return item;
    }
    public  DoubleLinkedListItem findLastItem(T data){
        DoubleLinkedListItem item = last;
        while(item.getData() != data){
            item = item.getPrev();
        }
        return item;
    }
    public  void insertAfter(DoubleLinkedListItem item, T data){
        DoubleLinkedListItem item2 = new DoubleLinkedListItem(data);
        if(item == null && size == 0){
            first = item2;
            last = item2;
        }
        else if(item == null && size != 0){
            insertBefore(first,data);
            size--;
        }
        else if(item.getNext() == null){
            item.setNext(item2);
            item2.setPrev(item);
            last = item2;
        }
        else{
            item2.setNext(item.getNext());
            item2.setPrev(item);
            item.getNext().setPrev(item2);
            item.setNext(item2);
        }
        size++;
    }
    public void insertBefore(DoubleLinkedListItem item, T data){
        DoubleLinkedListItem item2 = new DoubleLinkedListItem(data);
        if(item == null && size == 0){
            first = item2;
            last = item2;
        }
        else if(item == null && size != 0){
            insertAfter(last,data);
            size--;
        }
        else if(item.getPrev() == null){
            item.setPrev(item2);
            item2.setNext(item);
            first = item2;
        }
        else{
            item2.setPrev(item.getPrev());
            item2.setNext(item);
            item.getPrev().setNext(item2);
            item.setPrev(item2);
        }
        size++;
    }
    public void remove(DoubleLinkedListItem item){
        if((item.getNext() == null) && (item.getPrev() == null)){
            last = null;
            first = null;
        }
        else if(item.getNext() == null){
            item.getPrev().setNext(null);
            last = item.getPrev();
        }
        else if(item.getPrev() == null){
            item.getNext().setPrev(null);
            first = item.getNext();
        }
        else{
            item.getNext().setPrev(item.getPrev());
            item.getPrev().setNext(item.getNext());
            item.setNext(null);
            item.setPrev(null);
        }
        size--;
    }
}
