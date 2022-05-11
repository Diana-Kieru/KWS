//package module;
//
//import org.example.module.Sightings;
//import org.junit.Rule;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//
//public class SightingTest {
//    @Rule
//    public DatabaseRule databaseRule = new DatabaseRule();
//
//    public Sightings setupSighting(){
//        return new Sightings(1,"zone A","Alpha");
//    }
//    @Test
//    public void sighting_instantiatesCorrectly_true(){
//        Sightings animal = setupSighting();
//        assertEquals(true,animal instanceof Sightings);
//    }
//
//    @Test
//    public void sighting_instantiatesWithAnimalId_String(){
//        Sightings animal = setupSighting();
//        assertEquals(1,animal.getAnimalId());
//    }
//
//    @Test
//    public void sighting_instantiatesWithLocation_String(){
//        Sightings animal = setupSighting();
//        assertEquals("zone A",animal.getLocation());
//    }
//
//    @Test
//    public void sighting_instantiatesWithRangerName_String(){
//        Sightings animal = setupSighting();
//        assertEquals("Alpha",animal.getRangerName());
//    }
//
//    @Test
//    public void equals_returnsTrueIfAnimalIdAreSame_true() {
//        Sightings animal = setupSighting();
//        Sightings anotherAnimal = new Sightings(1,"zone A","Alpha");
//        assertTrue(animal.equals(anotherAnimal));
//    }
//
//    @Test
//    public void save_successfullyAddsSightingToDatabase_List() {
//        Sightings animal = setupSighting();
//        animal.save();
//        assertTrue(Sightings.all().get(0).equals(animal));
//    }
//
//    @Test
//    public void save_assignsIdToSighting() {
//        Sightings animal = setupSighting();
//        animal.save();
//        Sightings savedAnimal = Sightings.all().get(0);
//        assertEquals(savedAnimal.getId(), animal.getId());
//    }
//
//    @Test
//    public void all_returnsAllInstancesOfSighting_true() {
//        Sightings firstAnimal = setupSighting();
//        firstAnimal.save();
//        Sightings anotherAnimal = new Sightings(1,"zone A","Alpha");
//        anotherAnimal.save();
//        assertEquals(true, Sightings.all().get(0).equals(firstAnimal));
//        assertEquals(true, Sightings.all().get(1).equals(anotherAnimal));
//    }
//
//    @Test
//    public void find_returnsSightingWithSameId_secondAnimal() {
//        Sightings firstAnimal = setupSighting();
//        firstAnimal.save();
//        Sightings anotherAnimal = new Sightings(1,"zone A","Alpha");
//        anotherAnimal.save();
//        assertEquals(Sightings.find(anotherAnimal.getId()), anotherAnimal);
//    }
//
//}