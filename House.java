import java.util.ArrayList;
import javax.management.RuntimeErrorException;
/**
 * Create a class House which inherits the methods and attributes of the Building class.
 */
public class House extends Building{

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  public int hasResidents;
  private boolean hasElevator;

  /**
     * Builds a new house
     * @param name Name of house
     * @param address Address of house
     * @param nFloors House's amount of floors
     * @param hasDiningRoom Whether or not house has a dining room
     */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /**
     * Builds a new house with just a name and address
     * @param name Name of house
     * @param address Address of house
     */
  public House(String name, String address) {
    super(name, address);
    System.out.println("You have built a house: 🏠");
    this.residents = new ArrayList<String>();
  }

  /**
     * Builds a new house with just a name
     * @param name Name of house
     */
  public House(String name) {
    super(name);
    System.out.println("You have built a house: 🏠");
    this.residents = new ArrayList<String>();
  }

  /**
   * Identifies whether a house has a dining hall or not
   * @return true is the house has a dining hall; false if not
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /**
   * How many residents are in the house
   * @return the number of residents
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * Moves a new student into the house
   * @param name Name of new resident
   */
  public void moveIn(String name){
    this.residents.add(name);
  }

  /**
   * Moves a student out of the house
   * @param name Name of student moving out
   * @return the name of the student that has moved out
   */
  public String moveOut(String name){
    this.residents.remove(name);
    return name;
  }

  /**
   * Identifies whether a students lives in the house
   * @param person The student
   * @return true if the student lives there; false if not
   */
  public boolean isResident(String person){
    return residents.contains(person);
  }

  /**
   * Describes the house
   */
  public String toString(){
    String description = super.toString();
    description += " There are currently " + this.residents.size() + " residents in this house.";
    description += " This house:";
    if (this.hasDiningRoom){
      description += " has";
    } else{
      description += " does not have";
    }
    description += " a dining room and";
    if (this.hasElevator){
      description += " has";
    } else{
      description += " does not have";
    }
    description += " an elevator.";
    return description;
  }

  /**
   * Shows interactivity options for a certain house
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveOut(name)\n + moveIn(name)\n + isResident(person)\n + nResidents()\n + hasDiningRoom()");
}

/**
* Allows movement between possible floors
* @param floorNum Floor user wants to move to 
*/
  public void goToFloor(int floorNum, boolean hasElevator) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (hasElevator == false) {
      throw new RuntimeException("This house does not have an elevator. You must take the stairs to another floor.");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  /**
   * Whether or not the house has an elevator
   */
  public boolean hasElevator(){
    return this.hasElevator;
  }

  /**
     * Describes new house
     * @param args multiple strings passed to method
     */
  public static void main(String[] args) {
    House comstock = new House("Comstock", "1 Mandelle Road", 3, true, true);
    System.out.println(comstock);
  }
  
}