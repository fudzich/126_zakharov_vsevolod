public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        int counter = 0;
        if (n1 < n2) {
            for (int i = n1; i <= n2; i++) {
                if ((i % a == 0) && (i % b != 0)) {
                    counter++;
                }
            }
            return counter;
        }
        else if (n1 > n2)
        {
            for (int i = n2; i <= n1; i++) {
                if ((i % a == 0) && (i % b != 0)) {
                    counter++;
                }
            }
            return counter;
        }
        else
        {
            if ((n1 % a == 0) && (n1 % b != 0)) {
                counter++;
            }
            return counter;
        }
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        //return 0;
    }

    @Override
    public int subtask_2_for(int num) {
        int k = 1;
        int b = 0;
        while (b < num)
        {
            b = b + k;
            k++;
        }
        return (k-1);
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        //return 0;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        int a1 = num;
        int sum = a1;
        for( int i = 1; i < cnt; i++)
        {
            int a2 = a1 * d + 1;
            a1 = a2;
            sum = sum + a2;
        }
        return sum;
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        //return 0;
    }

    @Override
    public int subtask_4_for(int n) {
        int s = 1;
        int factorial = 1;
        for (int i = 2; i <= n; i++)
        {
            factorial = factorial * i;
            s = s + factorial;
        }
        return s;
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        //return 0;
    }
}
