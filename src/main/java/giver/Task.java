package giver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person( 5  , "Мухомор"),
                new Person( 6  , "Доброжир "),
                new Person( 7  , "Иркаил "),
                new Person( 8  , "Серафим"),
                new Person( 9  , "Агниил "),
                new Person( 15 , "Мерилл "),
                new Person( 14 , "Агафий "),
                new Person( 13 , "Рёрик  "),
                new Person( 50 , "Святополк"),
                new Person( 2  , "Баркадий"),
                new Person( 1  , "Аркадий")
        );

        int ids[] = new int[] {10,1,12,13,14,15};

        order(persons, ids);
        System.out.println(persons);
    }
// З List операції заміни та перестановки були б дуже затратними, тому вирішив створити новий LinkedList.
// Проходжу циклом по даному List<Person>. Якщо id не вказано то елемент додається вкінець LinkedList,
// якщо вказано - на відповідне місце. У програмі враховується що id приймає унікальні значення.
    public static void order(List<Person> persons, int[] ids) {
        if (persons.size() ==1) return;
        LinkedList<Person> people = new LinkedList<>();
        ArrayList<Integer> listIndex = new ArrayList<>(ids.length);
        int count;
        int i = 0;
        while (i < persons.size() && listIndex.size() != ids.length) {
            sec:
            {
                for (int j = 0; j < ids.length; j++) {
                    count = 0;
                    Person currentPerson = persons.get(i);
                    if (currentPerson.getId() == ids[j]) {
                        for (Integer index : listIndex) {
                            if (j > index) count++;
                        }
                        people.add(count, currentPerson);
                        listIndex.add(j);
                        break sec;
                    }
                }
                people.addLast(persons.get(i));
            }
            i++;
        }
        for (int j = 0; j <people.size() ; j++) {
            persons.set(j, people.get(j));
        }
    }

}
