/**
 * Main class for performing input stream scanning and passenger object calling and creation.
 * Output prompt functions performed in this class as well.
 */

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
    /**
     * Main method for implementing program.
     * @param args
     */
    public static void main(String[] args){
        /**
         * initializes input stream.
         */
        FileInputStream flightData = null;
        /**
         * try-catch block for IOException.
         */
        try{
            flightData = new FileInputStream("flight-data.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
        /**
         * initializes scanner to input stream.
         */
        Scanner scnr;
        scnr = new Scanner(flightData);
        /**
         * Creates arraylist for passenger objects.
         */
        ArrayList<Passenger> passList = new ArrayList<>();
        /**
         * while loop for scanning each line of data.
         */
        while(scnr.hasNextLine()){
            /**
             * temporary int variable to hold file's next integer read.
             */
            int temp = scnr.nextInt();
            /**
             * boolean variable used to test whether integer read from file has been read before.
             */
            boolean tester = false;
            /**
             * int value initialized to zero which is used to call element from passenger arraylist.
             */
            int element = 0;
            /**
             * boolean value for whether the flights are cancelled. Defaults to false.
             */
            boolean isCanceled = false;
            /**
             * boolean value for whether the passenger complains. Defaults to false.
             */
            boolean complained = false;

            /**
             * loop for checking each element in the existing arraylist to see if the passenger object already exists.
             */
            for(int i = 0; i < passList.size(); i++){
                if(passList.get(i).getID() == temp) {
                    tester = true;
                    if(tester){
                        element = i;
                        break;
                    }
                }
            }
            /**
             * Creates new passenger object if the passenger ID was not found at any element in the arraylist
             * Calls 'addFLight' passenger method which adds a flight and cancelled flight if the flight was cancelled.
             */
            if (!tester){
                Passenger X = new Passenger(temp);
                passList.add(X);
                isCanceled = scnr.next().equals("Y");
                passList.get(passList.indexOf(X)).addFlight(isCanceled);
                /**
                 * finds whether the passenger complained if the flight was cancelled.
                 */
                if(isCanceled){
                    complained = scnr.next().equals("Y");
                    passList.get(passList.indexOf(X)).passengerComplain(complained);
                }
            }
            /**
             * Calls existing passenger object using 'element' variable and finds whether the flight was cancelled.
             * Calls 'addFLight' passenger method which adds a flight and cancelled flight if the flight was cancelled.
             */
            else{
                isCanceled = scnr.next().equals("Y");

                passList.get(element).addFlight(isCanceled);
                /**
                 * finds whether the passenger complained if the flight was cancelled.
                 */
                if(isCanceled){
                    complained = scnr.next().equals("Y");
                    passList.get(element).passengerComplain(complained);
                }
            }
        }
        /**
         * Creates scanner for user input.
         */
        Scanner userInput = new Scanner(System.in);
        /**
         * Creates integer variable to hold user input ID.
         */
        int userID;
        /**
         * Creates integer value to hold element of arraylist. Assumes a non-existing element value of '-1'.
         */
        int userElement = -1;
        /**
         * Outputs prompt for user.
         */
        do{
            System.out.println("Please enter a passenger ID");
            System.out.println("Or enter -1 to exit program");
            System.out.print("Passenger ID: ");
            /**
             * Scans users next integer input.
             */
            userID = userInput.nextInt();
            /**
             * Searches arraylist for user's input ID.
             */
            for(int i = 0; i < passList.size(); i++){
                if(passList.get(i).getID() == userID) {
                        userElement = i;
                        break;
                }else{
                    userElement = -1;
                }
            }
            /**
             * Prompts user to give valid ID if invalid ID was given.
             */
            if(userElement == -1){
                System.out.println("Invalid passenger ID");
            }
            /**
             * Outputs passenger data if valid passenger ID was given.
             */
            else{
                passList.get(userElement).printTier();
                passList.get(userElement).printMiles();
                passList.get(userElement).printCanceledFlights();
                passList.get(userElement).printMultiplier();
            }
            /**
             * Gives user way of ending the program.
             */
        }while(userID != -1);
        /**
         * Program end.
         */
        System.out.println("Thank you!");
    }
}