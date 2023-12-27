/**
 * Default tier object.
 * Creates abstract methods for inheritors to implement.
 */
public abstract class Tier{
    /**
     * Number of flights. Defaults to 0.
     */
    public int flights = 0;
    /**
     * Number of cancelled flights. Defaults to 0.
     */
    public int canceledFlights = 0;
    /**
     * Boolean value that holds whether flight was cancelled. Defaults to false.
     */
    public boolean canceled = false;

    /**
     * Abstract method to get earned miles. Implemented in inherited classes.
     * @return
     */
    public abstract int getMiles();
    /**
     * Abstract method to get cancelled flights. Implemented in inherited classes.
     * @return
     */
    public abstract int getCanceledFlights();
    /**
     * Abstract method to get total flights. Implemented in inherited classes.
     * @return
     */
    public abstract int getFlights();

    /**
     * Abstract method to get add flight and potentially a cancelled flight. Implemented in inherited classes.
     * @param isCanceled
     */
    public abstract void addFlight(boolean isCanceled);
}