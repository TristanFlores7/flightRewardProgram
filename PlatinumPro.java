/**
 * Subclass of Tier class.
 * Holds data and methods for passengers of the Platinum Pro Tier.
 */
public class PlatinumPro extends Tier{
    /**
     * Value of earned miles. Dafaults to zero.
     */
    public int miles = 0;
    /**
     * Constructor method.
     * Gets data from passengers previous tier.
     * @param flights
     * @param canceledFlights
     */
    PlatinumPro(int flights, int canceledFlights){
        this.flights = flights;
        this.canceledFlights = canceledFlights;
    }
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
     * Gets earned miles with multiplier.
     * @return
     */
    @Override
    public int getMiles() {
        miles = getCanceledFlights() * 2000;
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