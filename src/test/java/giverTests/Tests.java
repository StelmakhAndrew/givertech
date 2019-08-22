package giverTests;

import giver.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static giver.Task.order;

public class Tests {

    @Test
    public void checkForEmptyPersonsIds(){
        List<Person> persons = Arrays.asList();
        int size = persons.size();
        int[] ids = new int[]{};
        order(persons, ids);
        Assert.assertEquals(persons.size(),size);
    }

    @Test
    public void checkForEmptyPersons(){
        List<Person> persons = Arrays.asList(
        );
        int size = persons.size();

        int[] ids = new int[]{1,2};
        order(persons, ids);
        Assert.assertEquals(persons.size(),size);
    }

    @Test
    public void checkForEmptyIds(){
        List<Person> persons = Arrays.asList(
                new Person(5, "Мухомор"),
                new Person(6, "Доброжир "),
                new Person(7, "Иркаил "),
                new Person(8, "Серафим"),
                new Person(9, "Агниил "),
                new Person(15, "Мерилл "),
                new Person(14, "Агафий "),
                new Person(13, "Рёрик  "),
                new Person(50, "Святополк"),
                new Person(2, "Баркадий"),
                new Person(1, "Аркадий")
        );

        List<Person> personsClones = new ArrayList<>(persons.size());
        for (Person person : persons) personsClones.add(person.clone());

        int[] ids = new int[]{};
        order(persons, ids);

        for (int i = 0; i <persons.size() ; i++) {
            Assert.assertEquals(persons.get(i),personsClones.get(i));
        }
    }

    @Test
    public void checkForCorrectOrderIdsWithExampleData(){
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

        int pos = -1;
        int count = 0;
        for (Person person : persons) {
            for (int j = 0; j < ids.length; j++) {
                if (person.getId() == ids[j]) {
                    Assert.assertTrue(j > pos);
                    pos = j;
                    count++;
                }
            }
        }
        if (count!=0)
        Assert.assertEquals(persons.get(count-1).getId(), ids[pos]);
    }

    @Test
    public void simpleManualTest(){
        List<Person> personsForTesting = Arrays.asList(
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

        order(personsForTesting, ids);

        List<Person> correctPersons = Arrays.asList(
                new Person( 1  , "Аркадий"),
                new Person( 13 , "Рёрик  "),
                new Person( 14 , "Агафий "),
                new Person( 15 , "Мерилл "),
                new Person( 5  , "Мухомор"),
                new Person( 6  , "Доброжир "),
                new Person( 7  , "Иркаил "),
                new Person( 8  , "Серафим"),
                new Person( 9  , "Агниил "),
                new Person( 50 , "Святополк"),
                new Person( 2  , "Баркадий")
        );

        for (int i = 0; i <personsForTesting.size() ; i++) {
            Assert.assertEquals(personsForTesting.get(i),correctPersons.get(i));
        }
    }
}
