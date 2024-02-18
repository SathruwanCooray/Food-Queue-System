package classVersion;

import java.io.*;
import java.util.*;

public class Main extends HelloApplication  {
    static int queue1Sales = 0;
    static int queue2Sales = 0;
    static int queue3Sales = 0;
    public static int exit = 0;
    public static FoodQueue arraycopy1;
    public static FoodQueue arraycopy2;
    public static FoodQueue arraycopy3;
    public static FoodQueue arraycopy4;
    public static int burgerCount = 50;
    public static String command;
    public static final int burgerPrice = 650;
    private static String[] displayArray1 = new String[]{"X", "X", " ", " ", " "};
    private static String[] displayArray2 = new String[]{"X", "X", "X", " ", " "};
    private static String[] displayArray3 = new String[]{"X", "X", "X", "X", "X"};

    public static void main(String[] args) {
        // Initializing Scanner
        Scanner scanner = new Scanner(System.in);
        //Creating FoodQueue Objects
        FoodQueue queue1 = new FoodQueue();
        FoodQueue queue2 = new FoodQueue();
        FoodQueue queue3 = new FoodQueue();
        FoodQueue waitingQueue = new FoodQueue();

        arraycopy1 = new FoodQueue();
        arraycopy2 = new FoodQueue();
        arraycopy3 = new FoodQueue();
        arraycopy4 = new FoodQueue();
        //Commands
        System.out.println(
                "100 or VFQ: View all queues" +
                        "\n101 or VEQ: View all empty queues" +
                        "\n102 or ACQ: Add customer to a queue" +
                        "\n103 or RCQ: Remove a customer from a queue" +
                        "\n104 or PCQ: Remove a served customer" +
                        "\n105 or VCS: View Customers Sorted in alphabetical order" +
                        "\n106 or SPD: Store program data into file" +
                        "\n107 or LDP: Load program data from file" +
                        "\n108 or STK: View remaining burgers Stock" +
                        "\n109 or AFS: Add burgers to stock" +
                        "\n999 or EXT: Exit the program"
        );


        while (exit == 0) {

            //Check if queue1 array has elements and update the display Array
            for (int i = 0; i < queue1.getQueueSize(); i++) {
                if (queue1.getCustomers().get(i) != null) {
                    displayArray1[i] = "O";
                }
            }
            //Check if queue2 array has elements and update the display Array
            for (int i = 0; i < queue2.getQueueSize(); i++) {
                if (queue2.getCustomers().get(i) != null) {
                    displayArray2[i] = "O";
                }
            }
            //Check if queue2 array has elements and update the display Array
            for (int i = 0; i < queue3.getQueueSize(); i++) {
                if (queue3.getCustomers().get(i) != null) {
                    displayArray3[i] = "O";
                }
            }

            //Take commands from user
            System.out.println("Enter your Command: ");
            command = scanner.nextLine();


            //Command to print display queues according to correct format
            if (command.equals("VFQ") || command.equals("100")) {
                System.out.println("************\n  CASHIER\n************");
                for (int i = 0; i < 5; ++i) {
                    System.out.println("  " + displayArray1[i] + "  " + displayArray2[i] + "  " + displayArray3[i]);
                }
            }
            //Command to display only queues with empty positions
            if (command.equals("ACQ") || command.equals("101")) {
                //Making temporary arrays to avoid changes of original arrays
                String[] tempDisplayArray1 = Arrays.copyOf(displayArray1, displayArray1.length);
                String[] tempDisplayArray2 = Arrays.copyOf(displayArray2, displayArray2.length);
                String[] tempDisplayArray3 = Arrays.copyOf(displayArray3, displayArray3.length);

                //Using try catch block to avoid Errors
                try {
                    if (queue1.getCustomers().get(0) != null) {
                        for (int i = 0; i < tempDisplayArray1.length; i++) {
                            tempDisplayArray1[i] = " ";
                        }
                    }
                    //if the queue is null it will throw an error for specifying the index
                } catch (IndexOutOfBoundsException e) {
                    for (int i = 0; i < 2; i++) {
                        //the temp array will turn to "x"
                        tempDisplayArray1[i] = "X";
                    }
                }
                try {
                    //if the queue is null it will throw an error for specifying the index
                    if (queue2.getCustomers().get(0) != null) {
                        for (int i = 0; i < tempDisplayArray2.length; i++) {
                            tempDisplayArray2[i] = " ";
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    for (int i = 0; i < 3; i++) {
                        //the temp array will turn to "x"
                        tempDisplayArray2[i] = "X";
                    }
                }
                try {
                    //if the queue is null it will throw an error for specifying the index
                    if (queue3.getCustomers().get(0) != null) {
                        for (int i = 0; i < tempDisplayArray3.length; i++) {
                            tempDisplayArray3[i] = " ";
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    for (int i = 0; i < tempDisplayArray3.length; i++) {
                        //the temp array will turn to "x"
                        tempDisplayArray3[i] = "X";
                    }
                }
                //Printing only the empty arrays with the changes made above for better visibility
                System.out.println("************\n  CASHIER\n************");
                for (int i = 0; i < 5; ++i) {
                    System.out.println("  " + tempDisplayArray1[i] + "  " + tempDisplayArray2[i] + "  " + tempDisplayArray3[i]);
                }
            }

            //Command to add Customer to the queue
            if (command.equals("ACQ") || command.equals("102")) {
                // Customer Details
                System.out.println("Enter First Name: ");
                String firstName = scanner.nextLine();
                System.out.println("Enter Last Name: ");
                String lastName = scanner.nextLine();
                System.out.println("Enter amount of burgers: ");
                int burgers = scanner.nextInt();
                scanner.nextLine();
                //Storing the Customer details in customer1
                Customer customer1 = new Customer(firstName, lastName, burgers);
                //Assigning to the new Customer to the queue with the lowest length
                if (queue1.getQueueSize() < 2) {
                    queue1.addCustomer(customer1);
                } else if (queue2.getQueueSize() < 3) {
                    queue2.addCustomer(customer1);
                } else if (queue3.getQueueSize() < 5) {
                    queue3.addCustomer(customer1);
                } else {
                    //printing all queues are full
                    System.out.println("Error: All queues are full, Added to the waiting queue");
                    waitingQueue.addCustomer(customer1);
                }
            }

            //Command for removing a customer
            if (command.equals("VEQ") || command.equals("103")) {
                //Taking customer details
                System.out.println("Enter the Queue of the Customer: ");
                int queueNum = scanner.nextInt();
                System.out.println("Enter the Position of the Customer: ");
                int rowNum = scanner.nextInt();
                scanner.nextLine();//Cleaning the buffer
                //Checking if the position is marked "O"
                if (queueNum == 1) {
                    queue1.removeCustomer(rowNum);
                    if (waitingQueue.getQueueSize() > 0){
                        queue1.getCustomers().add(waitingQueue.getCustomers().get(0));
                        waitingQueue.removeCustomer(1);
                    }else {
                        //Checking if the position is marked "O"
                        if (displayArray1[rowNum - 1].equals("O")) {
                            //changing it to "X"
                            displayArray1[rowNum - 1] = "X";
                        }
                    }
                }
                if (queueNum == 2) {
                    queue2.removeCustomer(rowNum);
                    if (waitingQueue.getQueueSize() > 0){
                        queue2.getCustomers().add(waitingQueue.getCustomers().get(0));
                        waitingQueue.removeCustomer(1);
                    }else{
                        //Checking if the position is marked "O"
                        if (displayArray2[rowNum - 1].equals("O")) {
                            //changing it to "X"
                            displayArray2[rowNum - 1] = "X";
                        }
                    }

                }
                if (queueNum == 3) {
                    queue3.removeCustomer(rowNum);
                    if (waitingQueue.getQueueSize() > 0){
                        queue3.getCustomers().add(waitingQueue.getCustomers().get(0));
                        waitingQueue.removeCustomer(1);
                    }else {
                        //Checking if the position is marked "O"
                        if (displayArray3[rowNum - 1].equals("O")) {
                            //changing it to "X"
                            displayArray3[rowNum - 1] = "X";
                        }
                    }
                }
                //Method to move the customers behind to front if empty
                systemChecking();
            }
            //Command for removing a served customer
            if (command.equals("PCQ") || command.equals("104")) {
                //Taking customer details
                System.out.println("Enter the Queue number of the Customer:  ");
                int queueNum = scanner.nextInt();
                scanner.nextLine();
                //checking the queue number
                try{
                    if (queueNum == 1) {
                        burgerCount = burgerCount - queue1.getCustomers().get(0).getBurger(); //removing the burger from stock
                        queue1Sales = queue1Sales + queue1.getCustomers().get(0).getBurger();//adding the removed amount to sales
                        queue1.removeServedCustomer();//removing the customer information
                        if(waitingQueue.getQueueSize() > 0){
                            queue1.getCustomers().add(waitingQueue.getCustomers().get(0));
                            waitingQueue.removeCustomer(1);
                        }else{
                            displayArray1[0] = "X"; //changing array to "X"

                        }

                    }
                    //checking the queue number
                    if (queueNum == 2) {
                        displayArray2[0] = "X";//changing array to "X"
                        burgerCount = burgerCount - queue2.getCustomers().get(0).getBurger();//removing the burger from stock
                        queue2Sales = queue2Sales + queue2.getCustomers().get(0).getBurger();//adding the removed amount to sales
                        queue2.removeServedCustomer();//removing the customer information
                        if(waitingQueue.getQueueSize() > 0){
                            queue2.getCustomers().add(waitingQueue.getCustomers().get(0));
                            waitingQueue.removeCustomer(1);
                        }else{
                            displayArray2[0] = "X"; //changing array to "X"
                        }
                    }
                    //checking the queue number
                    if (queueNum == 3) {
                        displayArray3[0] = "X";//changing array to "X"
                        burgerCount = burgerCount - queue3.getCustomers().get(0).getBurger(); //removing the burger from stock
                        queue3Sales = queue3Sales + queue3.getCustomers().get(0).getBurger();//adding the removed amount to sales
                        queue3.removeServedCustomer();//removing the customer information
                        if(waitingQueue.getQueueSize() > 0){
                            queue3.getCustomers().add(waitingQueue.getCustomers().get(0));
                            waitingQueue.removeCustomer(1);
                        }else{
                            displayArray3[0] = "X"; //changing array to "X"
                        }
                    }

                }catch (IndexOutOfBoundsException e){
                    System.out.println(e);
                }
                //Method to move the customers behind to front if empty
                systemChecking();
            }

            //Command for Displaying sorted Customers
            if (command.equals("VCS") || command.equals("105")) {
                //Sorting Customer from each queue
                queue1.sort();
                queue2.sort();
                queue3.sort();

                try {
                    if (queue1.getCustomers().get(0) != null) {
                        System.out.print("Sorted Queue 1 Customers: ");
                        for (int i = 0; i < queue1.getQueueSize(); i++) {
                            Customer customer = queue1.getCustomers().get(i);
                            //Printing customer with sorted names
                            System.out.print(customer.getCustomerFirstName() + " " + customer.getCustomerLastName());
                            //separating names with commas and printing a line after the last element
                            if (i < queue1.getQueueSize() - 1) {
                                System.out.print(",");
                            } else {
                                System.out.println();
                            }
                        }
                    }


                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Sorted Queue 1 Customers: No Customers added");
                }
                try {
                    if (queue2.getCustomers().get(0) != null) {
                        System.out.print("Sorted Queue 2 Customers: ");
                        for (int i = 0; i < queue2.getQueueSize(); i++) {
                            Customer customer = queue2.getCustomers().get(i);
                            //Printing customer with sorted names
                            System.out.print(customer.getCustomerFirstName() + " " + customer.getCustomerLastName());
                            //separating names with commas and printing a line after the last element
                            if (i < queue2.getQueueSize() - 1) {
                                System.out.print(",");
                            } else {
                                System.out.println();
                            }
                        }
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Sorted Queue 2 Customers: No Customers added");
                }
                try {
                    if (queue3.getCustomers().get(0) != null) {
                        System.out.print("Sorted Queue 3 Customers: ");
                        for (int i = 0; i < queue3.getQueueSize(); i++) {
                            Customer customer = queue3.getCustomers().get(i);
                            //Printing customer with sorted names
                            System.out.print(customer.getCustomerFirstName() + " " + customer.getCustomerLastName());
                            //separating names with commas and printing a line after the last element
                            if (i < queue3.getQueueSize() - 1) {
                                System.out.print(",");
                            } else {
                                System.out.println();
                            }
                        }
                    }
                    //using catch to see if there is no customers in the queues
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Sorted Queue 3 Customers: No Customers added");
                }
            }
            //Command for storing customer information
            if (command.equals("SPD") || command.equals("106")) {
                try {
                    //Creating file
                    File file = new File("ProgramClassVersionData.txt");
                    boolean fileCreated = file.exists();
                    if (fileCreated) {
                        System.out.println("File created Successfully");
                    } else if (file.exists()) {
                        System.out.println("File already exists");
                    }
                    //Write the display queues into the file
                    FileWriter filewriter = new FileWriter("ProgramClassVersionData.txt");
                    filewriter.write("************\n  CASHIER\n************\n");
                    filewriter.write("Data for queue 1: \n");

                    //printing the queue 1  in the display array 1 horizontally with commas
                    for (int i = 0; i < 5; ++i) {
                        filewriter.write(displayArray1[i]);
                        if (i != displayArray1.length - 1) {
                            filewriter.write(",");
                        } else {
                            filewriter.write("\n");
                        }
                    }

                    filewriter.write("Data for queue 2: \n");
                    //printing the queue 2  in the display array 2 horizontally with commas
                    for (int i = 0; i < 5; ++i) {
                        filewriter.write(displayArray2[i]);
                        if (i != displayArray2.length - 1) {
                            filewriter.write(",");
                        } else {
                            filewriter.write("\n");
                        }
                    }

                    filewriter.write("Data for queue 3: \n");
                    //printing the queue 3  in the display array 3 horizontally with commas
                    for (int i = 0; i < 5; ++i) {
                        filewriter.write(displayArray3[i]);
                        if (i != displayArray3.length - 1) {
                            filewriter.write(",");
                        } else {
                            filewriter.write("\n");
                        }
                    }
                    //Write the first name,last name and burger amount of queue 1
                    for (int i = 0;i < queue1.getQueueSize();i++){
                        filewriter.write("-Queue 1\n");
                        filewriter.write(queue1.getCustomers().get(i).getCustomerFirstName() + "\n");
                        filewriter.write(queue1.getCustomers().get(i).getCustomerLastName() + "\n");
                        filewriter.write(queue1.getCustomers().get(i).getBurger() + "\n");
                    }
                    //Write the first name,last name and burger amount of queue 1
                    for (int i = 0;i < queue2.getQueueSize();i++){
                        filewriter.write("-Queue 2\n");
                        filewriter.write(queue2.getCustomers().get(i).getCustomerFirstName() + "\n");
                        filewriter.write(queue2.getCustomers().get(i).getCustomerLastName() + "\n");
                        filewriter.write(queue2.getCustomers().get(i).getBurger() + "\n");
                    }
                    //Write the first name,last name and burger amount of queue 1
                    for (int i = 0;i < queue3.getQueueSize();i++){
                        filewriter.write("-Queue 2\n");
                        filewriter.write(queue3.getCustomers().get(i).getCustomerFirstName() + "\n");
                        filewriter.write(queue3.getCustomers().get(i).getCustomerLastName() + "\n");
                        filewriter.write(queue3.getCustomers().get(i).getBurger()+ "\n");
                    }

                    //Closing the file writer
                    filewriter.close();

                } catch (IOException e) {
                    System.out.println(e);
                }
            }
            if (command.equals("LPD") || command.equals("107")) {
                //Removing the all the customer details from queue1
                for (int i = 0; i < queue1.getQueueSize(); i++) {
                    queue1.getCustomers().remove(i);
                }
                //Removing the all the customer details from queue1
                for (int i = 0; i < queue2.getQueueSize(); i++) {
                    queue2.getCustomers().remove(i);
                }
                //Removing the all the customer details from queue1
                for (int i = 0; i < queue3.getQueueSize(); i++) {
                    queue3.getCustomers().remove(i);
                }
                try {
                    //define text file location
                    String filePath = "ProgramClassVersionData.txt";
                    //Create new objects
                    FileReader fileReader = new FileReader(filePath);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);


                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        // if line start with Queue
                        if (line.startsWith("-Queue")) {
                            //Take the values into the respective variables
                            String firstName = bufferedReader.readLine();
                            String lastName = bufferedReader.readLine();
                            int burgerValue = Integer.parseInt(bufferedReader.readLine());
                            //make a new customer object and assign the values
                            Customer customer2 = new Customer(firstName,lastName,burgerValue);
                            //Add the values to the queues appropriately
                            if (queue1.getQueueSize() < 2) {
                                queue1.addCustomer(customer2);
                            } else if (queue2.getQueueSize() < 3) {
                                queue2.addCustomer(customer2);
                            } else {
                                queue3.addCustomer(customer2);
                            }
                        }
                    }
                    //close the buffered-reader
                    bufferedReader.close();

                } catch (IOException e) {
                    System.out.println(e);
                }
                //let the user know the data has been loaded successfully
                System.out.println("Data has been loaded Successfully");
            }
                //Command for viewing the current stock of burgers
            if (command.equals("STK") || command.equals("108")) {
                System.out.println("The current burger stock is " + burgerCount);
            }
            //Command for adding new stock of burgers
            if (command.equals("AFS") || command.equals("109")) {
                //asking user for the new stock
                System.out.println("Enter the number of burgers: ");
                int burgers = scanner.nextInt();
                //the user given stock should be less than the 50 and the stock limit which is 50
                if (burgers < burgerCount && burgerCount < 50) {
                    burgerCount += burgers;
                } else {
                    System.out.println("Please enter a value below below current burger stock: ");
                }
            }

            //Command for exiting the program
            if (command.equals("EXT") || command.equals("999")) {
                exit = 1;
            }

            //Command for calculating income of each queue
            if (command.equals("IFQ") || command.equals("110")) {
                int queue1Income;
                int queue2Income;
                int queue3Income;

                //Calculating each queue income
                queue1Income = burgerPrice * queue1Sales;
                queue2Income = burgerPrice * queue2Sales;
                queue3Income = burgerPrice * queue3Sales;

                //Printing income of each queue
                System.out.println("Queue 1 income is Rs." + queue1Income);
                System.out.println("Queue 2 income is Rs." + queue2Income);
                System.out.println("Queue 3 income is Rs." + queue3Income);
            }
            if (command.equals("GUI") || command.equals("112")){
                //Make a copy of queue 1
                for (Customer customer: queue1.getCustomers()){
                    arraycopy1.addCustomer(new Customer(customer.getCustomerFirstName(), customer.getCustomerLastName(), customer.getBurger()));
                }
                //Make a copy of queue 2
                for (Customer customer: queue2.getCustomers()){
                    arraycopy2.addCustomer(new Customer(customer.getCustomerFirstName(), customer.getCustomerLastName(), customer.getBurger()));
                }
                //Make a copy of queue 3
                for (Customer customer: queue3.getCustomers()){
                    arraycopy3.addCustomer(new Customer(customer.getCustomerFirstName(), customer.getCustomerLastName(), customer.getBurger()));
                }
                //Make a copy of waiting queue
                for (Customer customer: waitingQueue.getCustomers()){
                    arraycopy4.addCustomer(new Customer(customer.getCustomerFirstName(), customer.getCustomerLastName(), customer.getBurger()));
                }
                //launch the GUI
                launch(args);
            }
        }
    }
    //Method to move the customers behind forward if customer in-front is removed
    private static void systemChecking() {
        for (int i = 4; i >= 1; --i) {
            if (displayArray1[i].equals("O") && displayArray1[i - 1].equals("X")) {
                displayArray1[i - 1] = "O";
                displayArray1[i] = "X";
            }

            if (displayArray2[i].equals("O") && displayArray2[i - 1].equals("X")) {
                displayArray2[i - 1] = "O";
                displayArray2[i] = "X";
            }

            if (displayArray3[i].equals("O") && displayArray3[i - 1].equals("X")) {
                displayArray3[i - 1] = "O";
                displayArray3[i] = "X";
            }
        }
    }
}




