package module;

import org.example.module.EndangeredAnimal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    public EndangeredAnimal setUpEndangeredAnimal(){
        return new EndangeredAnimal("elephant","weak","young");
    }

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true(){
        EndangeredAnimal animal = setUpEndangeredAnimal();
        assertEquals(true,animal instanceof EndangeredAnimal);
    }

    @Test
    public void endangeredAnimal_instantiatesWithName_String(){
        EndangeredAnimal animal = setUpEndangeredAnimal();
        assertEquals("elephant",animal.getName());
    }

    @Test
    public void endangeredAnimal_instantiatesWithHealth_String(){
        EndangeredAnimal animal = setUpEndangeredAnimal();
        assertEquals("weak",animal.getHealth());
    }

    @Test
    public void endangeredAnimal_instantiatesWithAge_String(){
        EndangeredAnimal animal = setUpEndangeredAnimal();
        assertEquals("young",animal.getAge());
    }

    @Test
    public void equals_returnsTrueIfNameAreSame_true() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("lion","okay","newborn");
        EndangeredAnimal anotherAnimal = new EndangeredAnimal("lion","okay","newborn");
        assertTrue(testAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_successfullyAddsEndangeredAnimalToDatabase_List() {
        EndangeredAnimal animal = setUpEndangeredAnimal();
        animal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(animal));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal animal = setUpEndangeredAnimal();
        animal.save();
        EndangeredAnimal savedAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedAnimal.getId(), animal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        EndangeredAnimal firstAnimal = setUpEndangeredAnimal();
        firstAnimal.save();
        EndangeredAnimal secondAnimal = EndangeredAnimal.all().get(0);
        secondAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        EndangeredAnimal firstAnimal = setUpEndangeredAnimal();
        firstAnimal.save();
        EndangeredAnimal secondAnimal = EndangeredAnimal.all().get(0);
        secondAnimal.save();
        assertEquals(EndangeredAnimal.find(secondAnimal.getId()), secondAnimal);
    }

}
