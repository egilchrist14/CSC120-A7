import java.util.Hashtable;
import javax.management.RuntimeErrorException;

/**
 * Create a class Library which inherits the methods and attributes of the Building class.
 */
public class Library extends Building{
    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;
    
    /**
     * Builds a new library
     * @param name Name of library
     * @param address Address of library
     * @param nFloors Cafe's amount of library
     * @param hasElevator Whether or not library has an elevator
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
    }

    /**
     * Builds a new library without specifying amount of floors
     * @param name Name of library
     * @param address Address of library
     */
    public Library(String name, String address) {
      super(name, address);
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<String, Boolean>();
    }

    /**
     * Builds a new library with just a name
     * @param name Name of library
     */
    public Library(String name) {
      super(name);
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<String, Boolean>();
    }

    /**
     * Adds a book to library
     * @param title Name of book
     */
    public void addTitle(String title){
      collection.put(title, true);
    }

    /**
     * Removes a book to library
     * @param title Name of book
     */
    public String removeTitle(String title){
      collection.remove(title, false);
      return title;
    }

    /**
     * Checks out a book from library
     * @param title Name of book
     */
    public void checkOut(String title){
      collection.replace(title, true);
    }

    /**
     * Returns a book to library
     * @param title Name of book
     */
    public void returnBook(String title){
      collection.replace(title, true);
    }

    /**
     * Whether or not library contains book
     * @param title title of book 
     */
    public boolean containsTitle(String title){
      return collection.containsKey(title);
    }

    /**
     * Whether or not a book is available
     * @param title title of book 
     */
    public boolean isAvailable(String title){
      return collection.containsKey(title);
    }

    /**
     * Prints books in library
     */
    public void printCollection(){
      System.out.println("Library: " + collection);
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
        throw new RuntimeException("This library does not have an elevator. You must take the stairs to another floor.");
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
    * Shows interactivity options for a certain library
    */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(title)\n + printCollection()");
  }

    /**
     * Describes new library
     * @param args multiple strings passed to method
     */
    public static void main(String[] args) {
      Library greene = new Library("Greene County Public Library", "415 Xenia Ave", 1, false);
      System.out.println(greene);
    }
  }