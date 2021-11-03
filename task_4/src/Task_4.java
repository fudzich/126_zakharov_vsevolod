import java.util.ArrayList;
import java.util.Arrays;

public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        int[] array= new int [size];
        array[0] = a0;
        int a = a0;
        for(int i=1; i < size; i++)
        {
            a=a+d;
            array[i] = a;
        }
        return array;
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        //return null;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        int[] array= new int [size];
        if( size == 1)
        {
            array[0] = 1;
            return array;
        }
        else
        {
            array[0] = 1;
            array[1] = 1;
            for(int i=2; i < size; i++)
            {
                int i2;
                int sum = 0;
                for(i2 = (i-1); i2 >= 0; i2--)
                {
                    sum = sum + array[i2];
                }
                array [i] = sum;
            }
            return array;
        }
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        //return null;
    }

    @Override
    public int[] subtask_3_arrays(int size) {
        int [] fib = new int[size];
        if (size == 1)
        {
            fib[0] = 0;
            return fib;
        }
        else
        {
            fib[0] = 0;
            fib[1] = 1;
            for(int i = 2; i < size ;i++)
            {
                fib [i] = fib[i-1] + fib[i-2];
            }
            return fib;
        }
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        //return null;
    }

    @Override
    public int subtask_4_arrays(int[] data) {
        int length = data.length;
        int max = data[0];
        for(int i = 1; i < length; i++)
        {
            if(data[i] > max)
            {
                max = data[i];
            }
        }
        return max;
        // Для данного массива вычислить максимальный элемент
        //return 0;
    }

    @Override
    public int subtask_5_arrays(int[] data, int k) {
        int length = data.length;
        int ok = 0;
        for(int i = 1; i < length; i++)
        {
            if(data[i] % k ==0)
            {
                ok = data[i];
                break;
            }
        }
        int max = ok;
        for(int i = 1; i < length; i++)
        {
            if((data[i] > max) && (data[i] % k ==0))
            {
                max = data[i];
            }
        }
        return max;
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        //return 0;
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] sort = new int[length1 + length2];
        int count = 0;
        for(int i = 0; i<length1; i++) {
            sort[i] = arr1[i];
            count++;
        }
        for(int j = 0;j<length2;j++) {
            sort[count++] = arr2[j];
        }
        Arrays.sort(sort);
        return sort;
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.
        //return null;
    }

    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] sort = new int[length1 + length2];
        int count = 0;
        for(int i = 0; i<length1; i++) {
            sort[i] = arr1[i];
            count++;
        }
        for(int j = 0;j<length2;j++) {
            sort[count++] = arr2[j];
        }
        Arrays.sort(sort);
        return sort;
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению
        //return null;
    }

}
