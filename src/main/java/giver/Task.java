package giver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task {

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
