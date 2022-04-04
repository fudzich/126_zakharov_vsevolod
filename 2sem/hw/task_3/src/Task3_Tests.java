import org.junit.*;

public class Task3_Tests extends Assert {
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    @Test
    public void HeapSort_FourSameNumbers_ArrayIsNotChanged(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 1, 1, 1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1, 1}, data);
    }

    @Test
    public void HeapSort_OnlyNegativeNumbers_ArrayIsSorted(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {-1, -34, -5, -10};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-34, -10, -5, -1}, data);
    }

    @Test
    public void HeapSort_AlreadySortedArray_ArrayIsNotChanged(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {-1, 0, 1, 2, 3};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1, 2, 3}, data);
    }

    @Test
    public void HeapSort_OnlyPositiveNumbers_ArrayIsSorted(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {34, 5, 10, 15, 25, 45};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{5, 10, 15, 25, 34, 45}, data);
    }

    @Test
    public void HeapSort_ArrayWithReappearingNumbers_ArrayIsSorted(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {34, 5, 10, 15, 25, 45, 34, 5, 20, 666};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{5, 5, 10, 15, 20, 25, 34, 34, 45, 666}, data);
    }

    @Test
    public void HeapSort_ArrayWithPositiveAndNegativeNumbers_ArrayIsSorted(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {-34, 5, -10, 15, -25, 45};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-34, -25, -10, 5, 15, 45}, data);
    }

    @Test
    public void MergeSort_FourSameNumbers_ArrayIsNotChanged(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 1, 1, 1};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1, 1}, data);
    }

    @Test
    public void MergeSort_OnlyNegativeNumbers_ArrayIsSorted(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {-1, -34, -5, -10};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-34, -10, -5, -1}, data);
    }

    @Test
    public void MergeSort_AlreadySortedArray_ArrayIsNotChanged(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {-1, 0, 1, 2, 3};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1, 2, 3}, data);
    }

    @Test
    public void MergeSort_OnlyPositiveNumbers_ArrayIsSorted(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {34, 5, 10, 15, 25, 45};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{5, 10, 15, 25, 34, 45}, data);
    }

    @Test
    public void MergeSort_ArrayWithPositiveAndNegativeNumbers_ArrayIsSorted(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = { 5, 34, -10};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-10, 5, 34}, data);
    }

    @Test
    public void QuickSort_FourSameNumbers_ArrayIsNotChanged(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 1, 1, 1};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1, 1}, data);
    }

    @Test
    public void QuickSort_OnlyNegativeNumbers_ArrayIsSorted(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {-1, -34, -5, -10};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-34, -10, -5, -1}, data);
    }

    @Test
    public void QuickSort_AlreadySortedArray_ArrayIsNotChanged(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {-1, 0, 1, 2, 3};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1, 2, 3}, data);
    }

    @Test
    public void QuickSort_OnlyPositiveNumbers_ArrayIsSorted() {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {87, 15, 16, 25, 10, 0, 45, 23, 34, 17};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 10, 15, 16, 17, 23, 25, 34, 45, 87}, data);
    }

    @Test
    public void QuickSort_ArrayWithPositiveAndNegativeNumbers_ArrayIsSorted(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {-34, 5, -10, 15, -25, 45};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-34, -25, -10, 5, 15, 45}, data);
    }
}
