/**
 * Default tier for new passengers.
 * Implements methods from Tier class.
 */
public class NoTier extends Tier {
    /**
     * Initializes total flights to zero.
     */
    public int flights = 0;
    /**
     * Initializes cancelled flights to zero.
     */
    public int canceledFlights = 0;
    /**
     * Initializes earned miles to zero.
     */
    public int miles = 0;

    /**
     * Implements tier addFlight method.
     * Adds flight. Adds cancelled flight boolean parameter is true.
     * @param isCanceled
     */
    @Override
    public void addFlight(boolean isCanceled){
        flights++;
        canceled = isCanceled;
        if (canceled) {
            canceledFlights++;
        }
    }

    /**
     * Implements tier getFlights method.
     * Gets total flights.
     * @return
     */
    @Override
    public int getFlights(){
        return flights;
    }

    /**
     * Implements tier getMiles method.
     * Gets earned miles with no multiplier.
     * @return
     */
    @Override
    public int getMiles() {
        miles = getCanceledFlights() * 1000;
        return miles;
    }
    /**
     * Implements tier getCancelledFlights method.
     * Gets cancelled flights.
     * @return
     */
    @Override
    public int getCanceledFlights(){
        return canceledFlights;
    }
}