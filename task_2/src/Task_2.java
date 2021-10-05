public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num)
    {
        int i = 2;
        int double_i = i*i;
        while(double_i <= num)
        {
            i++;
            double_i = i*i;
        }
        i--;
        double_i = i*i;
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        return double_i;
    }

    @Override
    public int subtask_2_while(int num)
    {

        int p = 1;
        int k = 1;
        while (k <= num)
        {
            p=2*p + 6;
            k++;
        }
        return p;
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num
        //return 0;
    }

    @Override
    public boolean subtask_3_while(int num, int base)
    {
        int basa = base;
        while(base < num)
        {
            base = base * basa;
        }
        if(base == num)
        {
            return true;
        }
        else
        {
            return false;
        }
        // Проверить, является ли число num натуральной степенью числа base

    }

    @Override
    public int subtask_4_while(int start, int end)
    {
        int counter = 0;
        while( start > end)
        {
            if( (start % 2 == 0) && ((start/2) >= end) )
            {
                start = start / 2;
                counter ++;
            }
            else
            {
                start = start - 1;
                counter ++;
            }
        }
        return counter;
        // Вычислить, за какое минимальное число операций
        // вычесть 1
        // поделить на 2
        // число start можно превратить в end. Гарантируется, что start >= end >= 1
        //return 0;
    }
}
