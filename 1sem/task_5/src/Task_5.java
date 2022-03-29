import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        ArrayList <Integer> List = new ArrayList<>();
        for(int i = 0; i < data.size(); i++)
        {
            int temp = data.get(i);
            if(( temp % k ==0) && (temp % n != 0))
            {
                List.add(temp);
            }
        }
        return List;
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        //return null;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        ArrayList<Integer> List1 = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                List1.add(i);
            }
        }
        ArrayList<Integer> FinalList = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            FinalList.add(List1.get(i));
        }

        return FinalList;
        //return List1;
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        //return null;

    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        HashSet<Integer> Answer = new HashSet<>();
        for (Integer a: s1)
        {
            for (Integer b: s2)
            {
                if( b == a)
                {
                    Answer.add(a);
                }
            }
        }
        return  Answer;
        // найдите пересечение множеств s1 и s2
        //return null;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        HashSet<Integer> Answer = new HashSet<>();
        for (Integer str: s1)
        {
            Answer.add(str);
        }
        for (Integer str: s2)
        {
            Answer.add(str);
        }
        return Answer;
        // найдите объединение множеств s1 и s2
        //return null;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        HashSet<Integer> Answer = new HashSet<>();
        for (Integer a: s2)
        {
            if(!s1.contains(a))
            {
                Answer.add(a);
            }
        }
        return  Answer;
        // найдите дополнение множества s1 до множества s2
        //return null;
    }
    public boolean Check (HashSet<Integer> kto, HashSet<Integer> kogo)
    {
        boolean fully = true;
        for(Integer a: kto )
        {
            if (!kogo.contains(a))
            {
                fully= false;
            }
        }
        return fully;
    }
    public HashSet<Integer> Vivod (HashSet<Integer> list, HashSet<Integer> a, HashSet<Integer> b)
    {
        for(Integer str: a)
        {
            if(!b.contains(str))
            {
                list.add(str);
            }
        }
        return list;
    }
    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        HashSet<Integer> Answer = new HashSet<>();
        if(Check(s1,s2) == true)
        {
            Vivod(Answer, s2, s1);
        }
        else if (Check(s2,s1) == true)
        {
            Vivod(Answer, s1, s2);
        }
        return null;
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        //return null;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        return null;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        HashMap<String, Double> Answer = new HashMap<>();
        Answer.put("mean",data.get(0));
        Answer.put("max",data.get(0));
        Answer.put("min",data.get(0));
        double counter=0;
        for( int i = 0; i < data.size(); i++)
        {
            if(data.get(i) > Answer.get("max"))
            {
                Answer.put("max", data.get(i));
            }
            if(data.get(i) < Answer.get("min"))
            {
                Answer.put("min", data.get(i));
            }
            counter= counter + data.get(i);
        }
        counter = counter/ data.size();
        Answer.put("mean",counter);
        return Answer;
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        //return null;
    }
}