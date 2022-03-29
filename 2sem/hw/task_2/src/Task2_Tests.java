import org.junit.*;

public class Task2_Tests extends Assert {

    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    @Test
    public void BubbleSort_OnlyOneNumber_ArrayIsNotChanged(){
        Integer[] arr = {0};
        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        bubbleSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {0}, arr);
    }

    @Test
    public void BubbleSort_FourSameNumbers_ArrayIsNotChanged(){
        Integer[] arr = {0,0,0,0};
        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        bubbleSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {0,0,0,0}, arr);
    }

    @Test
    public void BubbleSort_OnlyNegativeNumbers_ArrayIsSorted(){
        Integer[] arr = {-23,-5,-100,-14};
        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        bubbleSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {-100,-23,-14,-5}, arr);
    }

    @Test
    public void BubbleSort_NegativeAndPositiveNumbers_ArrayIsSorted(){
        Integer[] arr = {-23,5,100,-14};
        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        bubbleSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {-23,-14, 5, 100}, arr);
    }

    @Test
    public void insertionSort_OnlyOneNumber_ArrayIsNotChanged(){
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] arr = {0};
        insertionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{0}, arr);
    }

    @Test
    public void insertionSort_FourSameNumbers_ArrayIsNotChanged(){
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] arr = {0,0,0,0};
        insertionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{0,0,0,0}, arr);
    }

    @Test
    public void insertionSort_OnlyNegativeNumbers_ArrayIsSorted(){
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] arr = {-24,-100,-15,-3};
        insertionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{-100,-24,-15,-3}, arr);
    }

    @Test
    public void insertionSort_NegativeAndPositiveNumbers_ArrayIsSorted(){
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] arr = {24,-100,15,-3};
        insertionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{-100,-3,15,24}, arr);
    }

    @Test
    public void selectionSort_OnlyOneNumber_ArrayIsNotChanged(){
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        Integer[] arr = {0};
        selectionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{0}, arr);
    }

    @Test
    public void selectionSort_FourSameNumbers_ArrayIsNotChanged(){
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        Integer[] arr = {0,0,0,0};
        selectionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{0,0,0,0}, arr);
    }
    @Test
    public void selectionSort_OnlyNegativeNumbers_ArrayIsSorted(){
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        Integer[] arr = {-24,-100,-5,-15};
        selectionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{-100,-24,-15,-5}, arr);
    }

    @Test
    public void selectionSort_NegativeAndPositiveNumbers_ArrayIsSorted(){
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        Integer[] arr = {-24,100,-5,15};
        selectionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{-24,-5,15,100}, arr);
    }
}
