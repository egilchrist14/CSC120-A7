import javax.management.RuntimeErrorException;

/**
 * Create a class Cafe which inherits the methods and attributes of the Building class.
 */
public class Cafe extends Building{
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCream;
    private int nCups;

    /**
     * Builds a new cafe
     * @param name Name of cafe
     * @param address Address of cafe
     * @param nFloors Cafe's amount of floors
     */
    public Cafe(String name, String address, int nFloors){
        super(name, address, nFloors);
        this.nCoffeeOunces = 1000;
        this.nSugarPackets = 1500;
        this.nCream = 500;
        this.nCups = 50;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloads Cafe method, creates cafe with just a name
     * @param name name of cafe
     */
    public Cafe(String name){
        super(name);
        this.nCoffeeOunces = 1000;
        this.nSugarPackets = 1500;
        this.nCream = 500;
        this.nCups = 50;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloaded Cafe method to create cafe without amount of floors
     * @param name name of cafe
     * @param address address of cafe
     */
    public Cafe(String name, String address){
        super(name, address);
        this.nCoffeeOunces = 1000;
        this.nSugarPackets = 1500;
        this.nCream = 500;
        this.nCups = 50;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Allows cafe to sell coffee
     * @param size Coffee size
     * @param nSugarPackets Amount of sugar packets in sold coffee
     * @param nCreams Amount of cream in sold coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (nCoffeeOunces>0){
            this.nCoffeeOunces = nCoffeeOunces - size;
        }
        else if (nSugarPackets>0){
            this.nSugarPackets = nSugarPackets - size;
        }
        else if (nCream>0){
            this.nCream = nCream - size;
        }
        else if (nCups>0){
            this.nCups -=1;
        }
        else restock(size, nSugarPackets, nCreams, nCups);
        System.out.println("Remaining inventory is: " + nCoffeeOunces + " ounces of coffee, " + nSugarPackets + " sugar packets, " + nCream + "creamers and " + nCups + " cups.");
    }

    /**
     * Restocks cafe
     * @param nCoffeeOunces Current amount of coffee 
     * @param nSugarPackets Current amount of sugar
     * @param nCreams Current amount of cream
     * @param nCups Current amount of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if (nCoffeeOunces<=0){
            this.nCoffeeOunces = 1000;
        }
        if (nSugarPackets<=0){
            this.nSugarPackets = 1500;
        }
        if (nCream<=0){
            this.nCream = 500;
        }
        if (nCups<=0){
            this.nCups = 50;
        }
    }    

    /**
    * Shows interactivity options for a certain cafe
    */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goToFloor(n)\n + sellCoffee(int size, int nSugarPackets, int nCreams)\n + restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups)");
    }

    /**
     * Allows movement between possible floors
     * @param floorNum Floor user wants to move to 
     */
    public void goToFloor(int floorNum) {
        System.out.println("This cafe only has one floor.");
    }

    /**
     * Describes new cafe
     * @param args multiple strings passed to method
     */
    public static void main(String[] args) {
        Cafe Emporium = new Cafe("The Emporium", "233 Xenia Ave", 1);
        System.out.println(Emporium);
    }
    
}
