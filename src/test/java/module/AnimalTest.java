package module;

import org.example.module.Animal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    public Animal setUpAnimal(){
        return new Animal("elephant");
    }

    @Test
    public void animal_instantiatesCorrectly_true(){
        Animal animal = setUpAnimal();
        assertEquals(true,animal instanceof Animal);
    }

    @Test
    public void animal_instantiatesWithName_String(){
        Animal animal = setUpAnimal();
        assertEquals("elephant",animal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameAreSame_true() {
        Animal testAnimal = setUpAnimal();
        Animal anotherAnimal = new Animal("elephant");
        assertTrue(testAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_successfullyAddsAnimalToDatabase_List() {
        Animal animal = setUpAnimal();
        animal.save();
        assertTrue(Animal.all().get(0).equals(animal));
    }

    @Test
    public void save_assignsIdToAnimal() {
        Animal animal = setUpAnimal();
        animal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(savedAnimal.getId(), animal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal = setUpAnimal();
        firstAnimal.save();
        Animal secondAnimal = new Animal("lion");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = setUpAnimal();
        firstAnimal.save();
        Animal secondAnimal = new Animal("lion");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }
}

