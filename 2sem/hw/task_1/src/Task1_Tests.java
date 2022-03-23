import org.junit.*;

public class Task1_Tests extends Assert {
    private int getIntDataValue(ListNode<Integer> item) {
        return ((Node<Integer>) item).getData();
    }
    @Test
    public void createList_createListWithNothing_ListIsEmpty(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertTrue(list.isEmpty());
    }
    @Test
    public void createArray_createArrayWithNothing_SizeEqualsDefaultSize(){
        int defaultSize = 1024;
        DynamicArray<Integer> array = new DynamicArray<>();
        assertTrue(defaultSize == array.getSize());
    }
    @Test
    public void createArray_createArrayWithSize100_SizeEquals100(){
        int size = 100;
        DynamicArray<Integer> array = new DynamicArray<>(size);
        assertTrue(size == array.getSize());
    }
    @Test
    public void resize_NewSizeIsBiggerThenZero_SizeEqualsNewSize(){
        int size = 245;
        DynamicArray<Integer> array = new DynamicArray<>(1);
        array.resize(size);
        assertTrue(size == array.getSize());
    }
    @Test
    public void get_GettingIndexTheNumberOfSize_OutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(35);
        try {
            array.get(35);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue("Index out of bounds" == e.getMessage());
        }
    }
    @Test
    public void set_GettingIndexTheNumberOfSize_OutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(17);
        try {
            array.set(17, 123);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue("Index out of bounds" == e.getMessage());
        }
    }
    @Test
    public void set_IndexEqualsZeroValueEqualsOne_ValueIsSet(){
        int index = 0;
        int value = 1;
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(index, value);
        assertTrue(value == array.get(index));
    }
    @Test
    public void set_IndexEqualsThreeValueEqualsThree_ValueIsSet(){
        int index = 3;
        int value = 3;
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(index, value);
        assertTrue(value == array.get(index));
    }
    @Test
    public void set_IndexEqualsFourValueEqualsZero_ValueIsSet(){
        int index = 4;
        int value = 0;
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(index, value);
        assertTrue(value == array.get(index));
    }
    @Test
    public void insert_IndexEqualsZeroValue1EqualsOneValue2EqualsTwo_Value2IsInserted() {
        int index = 0;
        int value1 = 1;
        int value2 = 2;
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(index, value1);
        array.insert(index, value2);
        assertTrue(value2 == array.get(index));
    }
    @Test
    public void insert_IndexEqualsThreeValue1EqualsOneValue2EqualsOne_Value2IsInserted() {
        int index = 3;
        int value1 = 1;
        int value2 = 1;
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(index, value1);
        array.insert(index, value2);
        assertTrue(value2 == array.get(index));
    }
    @Test
    public void insert_GettingIndexTheNumberOfSize_OutOfBalance(){
        DynamicArray<Integer> array = new DynamicArray<>(1241);
        try {
            array.insert(1241, 1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue("Index out of bounds" == e.getMessage());
        }
    }
    @Test
    public void pushBack_ValueEqualsThree_ValueIsPushedToTheBack() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.pushBack(3);
        assertTrue(3 == array.get(10).intValue());
    }
    @Test
    public void popBack_SizeEqualsZero_MessageIsThrown() {
        try {
            DynamicArray<Integer> array = new DynamicArray<>(0);
            array.popBack();
            fail();
        } catch (Exception e) {
            assertEquals("Array is empty", e.getMessage());
        }
    }
    @Test
    public void remove_RemovingFromNonExistentIndex_OutOfBounds() {
        try {
            DynamicArray<Integer> array = new DynamicArray<>(10);
            array.remove(10);
            fail();
        } catch (Exception e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    @Test
    public void createNode_CreateNodeWithDataOnly_NextEqualsNull(){
        Node<Integer> node = new Node <>(34);
        assertEquals(null, node.getNext());
    }
    @Test
    public void createNode_CreateNodeWithDataOnly_PrevEqualsNull(){
        Node<Integer> node = new Node <>(34);
        assertEquals(null, node.getPrev());
    }
    @Test
    public void pushFront_PushFrontToEmptyList_DataIsPushed() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(0);
        Node<Integer> Head = (Node<Integer>) list.getHead();
        Node<Integer> Tail = (Node<Integer>) list.getTail();
        assertEquals(0, Head.getData().intValue());
        assertEquals(0, Tail.getData().intValue());
    }
    @Test
    public void pushFront_PushFrontToNotEmptyList_DataIsPushed() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(0);
        list.pushFront(1);
        list.pushFront(2);
        assertEquals(1, getIntDataValue(list.get(1)));
    }
    @Test
    public void pushBack_PushBackToEmptyList_DataIsPushed() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(0);
        Node<Integer> Head = (Node<Integer>) list.getHead();
        Node<Integer> Tail = (Node<Integer>) list.getTail();
        assertEquals(0, Head.getData().intValue());
        assertEquals(0, Tail.getData().intValue());
    }
    @Test
    public void pushBack_PushBackToNotEmptyList_DataIsPushed() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(0);
        list.pushBack(1);
        list.pushBack(2);
        Node<Integer> Head = (Node<Integer>) list.getHead();
        Node<Integer> Tail = (Node<Integer>) list.getTail();
        assertEquals(0, Head.getData().intValue());
        assertEquals(2, Tail.getData().intValue());
    }
    @Test
    public void createList_CreateListWithSomething_ListIsNotEmpty(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(23);
        assertFalse(list.isEmpty());
    }
    @Test
    public void remove_RemoveItemFromList_ListIsEmpty(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> Node = (Node<Integer>) list.pushBack(23);
        list.remove(Node);
        assertTrue(list.isEmpty());
    }
    @Test
    public void remove_RemoveItemFromList_ItemsAreMoved(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> Item1 = (Node<Integer>) list.pushBack(0);
        Node<Integer> Item2 = (Node<Integer>) list.pushBack(1);
        Node<Integer> Item3 = (Node<Integer>) list.pushBack(2);
        list.remove(Item1);
        Node<Integer> Head = (Node<Integer>) list.getHead();
        Node<Integer> Tail = (Node<Integer>) list.getTail();
        assertEquals(1, Head.getData().intValue());
        assertEquals(2, Tail.getData().intValue());
    }
    @Test
    public void get_GetIndexMoreThenSize_OutOfBounds(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(0);
        try {
            list.get(34);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("index out of bounds", e.getMessage());
        }
    }
    @Test
    public void get_GetIndexAsSize_OutOfBounds(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(0);
        try {
            list.get(1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("index out of bounds", e.getMessage());
        }
    }
    @Test
    public void get_GetIndexOfItem_IndexIsGotten(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(0);
        Node<Integer> Item = (Node<Integer>) list.get(0);
        assertEquals(0, Item.getData().intValue());
    }
    @Test
    public void insertListAfter_insertListAfterSecondItem_ItemsOfTheFirstListAreMoved() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(0);
        list1.pushFront(1);
        list1.pushFront(2);
        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(3);
        list2.pushFront(4);
        list2.pushFront(5);
        list1.insertListAfter(list1.get(1), list2);
        assertEquals(0, getIntDataValue(list1.get(0)));
        assertEquals(1, getIntDataValue(list1.get(1)));
        assertEquals(3, getIntDataValue(list1.get(2)));
        assertEquals(4, getIntDataValue(list1.get(3)));
        assertEquals(5, getIntDataValue(list1.get(4)));
        assertEquals(2, getIntDataValue(list1.get(5)));
    }
    @Test
    public void insertList_insertListBeforeFirstItem_AllElementsAreCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(0);
        list1.pushFront(1);
        list1.pushFront(2);
        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(3);
        list2.pushFront(4);
        list2.pushFront(5);
        list1.insertListBefore(list1.get(0), list2);
        assertEquals(3, getIntDataValue(list1.get(0)));
        assertEquals(4, getIntDataValue(list1.get(1)));
        assertEquals(5, getIntDataValue(list1.get(2)));
        assertEquals(0, getIntDataValue(list1.get(3)));
        assertEquals(1, getIntDataValue(list1.get(4)));
        assertEquals(2, getIntDataValue(list1.get(5)));
    }

}
