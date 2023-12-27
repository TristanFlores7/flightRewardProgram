/**
 * Class for holding data for each passenger object.
 * Holds methods made to be performed on passenger objects.
 */
public class Passenger{
    /**
     * Integer value to hold value of passenger ID.
     */
    public int ID;
    /**
     * Boolean value to hold value value of multiplier. Defaults to false.
     */
    public boolean multiplier = false;
    /**
     * Boolean value that says whether passenger flight was cancelled. Defaults to false.
     */
    public boolean canceled = false;
    /**
     * Integer value used to remember whether a passenger has complained.
     * Defaults to '0', meaning no passenger complaints.
     */
    public int complainMemory = 0;
    /**
     * String that writes what tier the passenger object belongs to. Defaults to 'No Flights'.
     */
    public String tier = "No Flights";
    /**
     * Creates new private tier object for every new passenger.
     */
    private Tier passTier = new NoTier();

    /**
     * Constructor method.
     * @param ID
     */
    Passenger(int ID) {
        this.ID = ID;
    }

    /**
     * Calls passenger objects ID.
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * Calls tier object to add flight and add cancelled flight if boolean parameter is true.
     * Calculates whether the passenger should be upgraded/downgraded to another tier.
     * @param isCanceled
     */
    public void addFlight(boolean isCanceled) {
        /**
         * local value of whether the passengers flight was cancelled.
         */
        canceled = isCanceled;
        /**
         * Checks whether passenger belongs to new tier object.
         * First checks if passenger qualifies for tier.
         * Next checks if passenger already belongs to a tier.
         * If passenger does not already belong to said tier, a new tier object of said tier is created.
         */
        if((passTier.getCanceledFlights() >= 100) && (multiplier)) {
            if(!tier.equals("Super Executive Platinum")){
                passTier = new SuperExecutivePlatinum(getFlights(), getCanceledFlights());
                tier = "Super Executive Platinum";
            }
        } else if (passTier.getCanceledFlights() >= 100) {
            if(!tier.equals("Executive Platinum")){
                passTier = new ExecutivePlatinum(getFlights(), getCanceledFlights());
                tier = "Executive Platinum";
            }
        } else if ((passTier.getCanceledFlights() >= 50) && (multiplier)){
            if(!tier.equals("Platinum Pro")){
                passTier = new PlatinumPro(getFlights(), getCanceledFlights());
                tier = "Platinum Pro";
            }
        } else if (passTier.getCanceledFlights() >= 50) {
            if(!tier.equals("Platinum")) {
                passTier = new Platinum(getFlights(), getCanceledFlights());
                tier = "Platinum";
            }
        } else if (passTier.getCanceledFlights() >= 25) {
            if(!tier.equals("Gold")){
                passTier = new Gold(getFlights(), getCanceledFlights());
                tier = "Gold";
            }
        } else if (!tier.equals("No tier")){
            passTier = new NoTier();
            tier = "No tier";
        }
        /**
         * Calls 'addFlight' method of passengers specified tier object.
         */
        passTier.addFlight(canceled);
    }

    /**
     * Gets tier passenger belongs to.
     * @return
     */
    public String getTier(){
        return tier;
    }

    /**
     * Gets the number of flights the passenger has had.
     * @return
     */
    public int getFlights(){
        return passTier.getFlights();
    }

    /**
     * Gets the number of cancelled flights the passenger has had.
     * @return
     */
    public int getCanceledFlights(){
        return passTier.getCanceledFlights();
    }

    /**
     * Prints passengers cancelled flights.
     */
    public void printCanceledFlights(){
        System.out.println("Canceled Flights: " + getCanceledFlights());
    }

    /**
     * Gets passengers multiplier value.
     * @return
     */
    public boolean hasMultiplier(){
        return multiplier;
    }

    /**
     * Records whether the passenger complains after a flight being cancelled.
     * Increments complainMemory variable if passenger complains.
     * Calculates whether passenger qualifies for multiplier.
     * @param complaint
     * @return
     */
    public boolean passengerComplain(boolean complaint){
        if(complaint){
            complainMemory++;
        }
        if(complainMemory >= 1){
            multiplier = false;
        }else if (complainMemory == 0 && getCanceledFlights() >= 50){
            multiplier = true;
        }
        return multiplier;
    }

    /**
     * Prints passengers multiplier status.
     */
    public void printMultiplier(){
        System.out.println("Multiplier: " + hasMultiplier());
    }

    /**
     * Gets passengers reward miles.
     * @return
     */
    public int getMiles(){
        return passTier.getMiles();
    }

    /**
     * Prints passengers reward miles.
     */
    public void printMiles(){
        System.out.println("Miles earned: " + this.getMiles());
    }

    /**
     * Prints passengers tier.
     */
    public void printTier(){
        System.out.println("Tier: " + getTier());
    }
}