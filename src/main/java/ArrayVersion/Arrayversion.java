package ArrayVersion;//importing in-built modules
import java.io.*;
import java.util.*;
//Defining class
public class Arrayversion {
    //Initializing Variables
    public static int numCommand = 0;
    public static int exit = 0;
    public static int burgerStocks = 50;
    public static int queueNum = 0;
    public static int rowNum = 0;
    //Initializing Arrays
    private static String[] queue1 = {"X", "X", " ", " ", " "};
    private static String[] queue2 = {"X", "X", "X", " ", " "};
    private static String[] queue3 = {"X", "X", "X", "X", "X"};
    private static String[] nameQueue1 = new String[0];
    private static String[] nameQueue2 = new String[0];
    private static String[] nameQueue3 = new String[0];
    private static String[] totalNames = new  String[0];
    //Initializing main method
    public static void main(String[] args) {
        //Initializing Scanner
        Scanner scanner = new Scanner(System.in);
        //Printing User Command Manual
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
        //Main program Menu
        while (exit == 0) {
            //Low stock burger Warning
            if(burgerStocks < 10){
                System.out.println("Warning: Burgers in-stock less than 10");
            }

            //Method to inspect the behavior of the Customers aligning
            systemChecking();
            //Printing and getting the input
            System.out.println("Enter the command: ");
            String Command = scanner.nextLine();
            //Try and catch block to identify if the input is Integer or  String
            try {
                numCommand = Integer.parseInt(Command);
            } catch(NumberFormatException e) {
                ; //This will pass to avoid confusions with the user
            }

            //Checking the input and performing the relevant functionalities
            //Command for viewing the queue
            if (Command.equals("VFQ") || numCommand == 100) {
                viewAllQues();
            }
            //Command for viewing empty queue
            if (Command.equals("VEQ") || numCommand == 101){
                emptyQueues();
            }
            //Command for adding a Customer to the back of the line
            if (Command.equals("ACQ")|| numCommand == 102) {
                System.out.println("Enter Queue number: ");
                queueNum = scanner.nextInt();

                scanner.nextLine();

                System.out.println("Enter the name of the customer:");
                String tempName = scanner.nextLine();
                if(queueNum == 1){
                    String[] tempArray = Arrays.copyOf(nameQueue1,nameQueue1.length+1);
                    tempArray[tempArray.length-1] = tempName;
                    nameQueue1 = tempArray;
                }else if(queueNum == 2){
                    String[] tempArray = Arrays.copyOf(nameQueue2,nameQueue2.length+1);
                    tempArray[tempArray.length-1] = tempName;
                    nameQueue2 = tempArray;
                }else if(queueNum == 3){
                    String[] tempArray = Arrays.copyOf(nameQueue3,nameQueue3.length+1);
                    tempArray[tempArray.length-1] = tempName;
                    nameQueue3 = tempArray;
                }
                addCustomer(queueNum);
                viewAllQues();

            }
            //Command for removing a Customer from a unique position
            if(Command.equals("RCQ") || numCommand == 103){
                System.out.println("Enter the Queue of the Customer: ");
                queueNum = scanner.nextInt();
                System.out.println("Enter Position number of the Customer: ");
                rowNum = scanner.nextInt();
                scanner.nextLine();
                removeCustomer(queueNum, rowNum);
            }
            //Command for removing a served Customer
            if(Command.equals("PCQ") || numCommand == 104) {
                System.out.println("Enter the Queue of Customer: ");
                queueNum = scanner.nextInt();
                scanner.nextLine();
                removeServedCustomer(queueNum);
            }
            //Command to order Customer Names in the alphabetical order
            if(Command.equals("VCS") || numCommand == 105){
                alphabeticalOrder();
            }
            //Command for saving the current program data
            if(Command.equals("SPD") || numCommand == 106){
                storeProgramData();
            }
            //Command for loading program data
            if(Command.equals("LPD") || numCommand == 107){
                loadProgramData();
            }
            //Command for viewing burger stock
            if(Command.equals("STK") || numCommand == 108){
                System.out.println("Burgers in-stock: "+ burgerStocks);
            }
            //Command for restocking burgers
            if(Command.equals("AFS") || numCommand == 109){
                System.out.println("Enter the number of burgers adding to the stock: ");
                int burgers = scanner.nextInt();
                scanner.nextLine();
                burgerRestock(burgers);
            }
            //Command for exiting the program
            if(Command.equals("EXT") || numCommand == 999){
                System.out.println("Successfully exited the program");
                exit = 1;
            }
        }


    }

    //method to display the program data/queue
    private static void viewAllQues() {
        System.out.println("************" + "\n  CASHIER" + "\n************");
        for (int i = 0; i < 5; i++) {
            System.out.println("  " + queue1[i] + "  " + queue2[i] + "  " + queue3[i]);
        }
    }
    //method to display empty queues
    private static void emptyQueues(){
        //Initializing temporary arrays
        String[] tempQueue1 = Arrays.copyOf(queue1,queue1.length);
        String[] tempQueue2 = Arrays.copyOf(queue2,queue2.length);
        String[] tempQueue3 = Arrays.copyOf(queue3,queue3.length);
        //Assigning blanks for filled spots for better visibility
        for (int i = 0; i < 5; i++){
            if (queue1[i].equals("O")){
                tempQueue1[i] = " ";
            }
            if (queue2[i].equals("O")){
                tempQueue2[i] = " ";
            }
            if (queue3[i].equals("O")){
                tempQueue3[i] = " ";
            }
        }
        //printing the empty queue
        System.out.println("************" + "\n  CASHIER" + "\n************");
        for (int i = 0; i < 5; i++) {
            System.out.println("  " + tempQueue1[i] + "  " + tempQueue2[i] + "  " + tempQueue3[i]);
        }
    }

    //System to add a Customer to the back of the queue
    private static void addCustomer(int queue){
        //Adding O to last empty position of the queue while checking for X
        if (queue == 1) {
            for (int i = 0; i < 5; i++) {
                if (queue1[i].equals("X")) {
                    queue1[i] = "O";
                    System.out.println("Customer has been added");
                    break;
                }
            }
        } else if (queue == 2) {
            for (int i = 0; i < 5; i++) {
                if (queue2[i].equals("X")) {
                    queue2[i] = "O";
                    System.out.println("Customer has been added");
                    break;
                }
            }
        } else if (queue == 3) {
            for (int i = 0; i < 5; i++) {
                if (queue3[i].equals("X")) {
                    queue3[i] = "O";
                    System.out.println("Customer has been added");
                    break;
                }
            }
        } else {
            System.out.println("Entered value is incorrect!");
        }
    }

    //System to remove Customers from a specific position
    private static void removeCustomer(int queue, int row) {
        row = row - 1;
        if (queue == 1) {
            if (queue1[row].equals("O")) {
                queue1[row] = "X";

                String[] tempArray = new String[nameQueue1.length-1];
                int tempArrayIndex = 0;
                for(int i = 0; i < nameQueue1.length;i++) {
                    if (row != i) {
                        tempArray[tempArrayIndex] = nameQueue1[i];
                        tempArrayIndex++;
                    }
                }
                nameQueue1 = tempArray;
            }else {
                //if there is already X in the first position the queue is empty
                System.out.println("Queue is empty!");
            }
        }else if(queue == 2){
            if(queue2[row].equals("O")){
                queue2[row] = "X";

                String[] tempArray = new String[nameQueue2.length-1];
                int tempArrayIndex = 0;
                for(int i = 0; i < nameQueue2.length;i++) {
                    if (row != i) {
                        tempArray[tempArrayIndex] = nameQueue2[i];
                        tempArrayIndex++;
                    }
                }
                nameQueue2 = tempArray;
            }else {
                //if there is already X in the first position the queue is empty
                System.out.println("Queue is empty!");
            }
        }else if(queue == 3){
            if(queue3[row].equals("O")){
                queue3[row] = "X";

                String[] tempArray = new String[nameQueue3.length-1];
                int tempArrayIndex = 0;
                for(int i = 0; i < nameQueue3.length;i++) {
                    if (row != i) {
                        tempArray[tempArrayIndex] = nameQueue3[i];
                        tempArrayIndex++;
                    }
                }
                nameQueue3 = tempArray;
            }else {
                //if there is already X in the first position the queue is empty
                System.out.println("Queue is empty!");
            }
        }
    }
    //System to remove served customer
    private static void removeServedCustomer(int queue){
        if(queue == 1){
            queue1[0] = "X";
            //Using a temporary array to remove the first Customer in the queue
            String[] tempArray = new String[nameQueue1.length-1];
            int tempArrayIndex = 0;
            for(int i = 0; i < nameQueue1.length;i++){
                if (i != 0){
                    tempArray[tempArrayIndex] = nameQueue1[i];
                    tempArrayIndex++;
                    //Assigning the temporary array to the original array
                    nameQueue1 = tempArray;
                }
            }
            //Removing Burger from the stock
            burgerStocks = burgerStocks - 5;
        }

        if(queue == 2){
            queue2[0] = "X";
            //Using a temporary array to remove the first Customer in the queue
            String[] tempArray = new String[nameQueue2.length-1];
            int tempArrayIndex = 0;
            for(int i = 0; i < nameQueue2.length;i++){
                if (i != 0){
                    tempArray[tempArrayIndex] = nameQueue2[i];
                    tempArrayIndex++;
                    //Assigning the temporary array to the original array
                    nameQueue2 = tempArray;
                }
            }
            //Removing Burger from the stock
            burgerStocks = burgerStocks - 5;
        }
        if(queue == 3){
            queue3[0] = "X";
            //Using a temporary array to remove the first Customer in the queue
            String[] tempArray = new String[nameQueue3.length-1];
            int tempArrayIndex = 0;
            for(int i = 0; i < nameQueue3.length;i++){
                if (i != 0){
                    tempArray[tempArrayIndex] = nameQueue3[i];
                    tempArrayIndex++;
                    //Assigning the temporary array to the original array
                    nameQueue3 = tempArray;
                }
            }
            //Removing Burger from the stock
            burgerStocks = burgerStocks - 5;
        }
    }
    //Method to store program Data
    private static void storeProgramData(){
        //joining all the names into one array
        int length = nameQueue1.length + nameQueue2.length + nameQueue3.length;//Incrementing the array length
        String[] totalNames = new  String[length];
        int index = 0;
        System.arraycopy(nameQueue1,0,totalNames,index,nameQueue1.length);//Combining two arrays
        index+=nameQueue1.length;
        System.arraycopy(nameQueue2,0,totalNames,index,nameQueue2.length);//Combining two arrays
        index+=nameQueue2.length;
        System.arraycopy(nameQueue3,0,totalNames,index,nameQueue3.length);//Combining two arrays
        try{
            //Creating a file
            File file = new File("ProgramData.txt");
            Boolean fileCreated = file.createNewFile();

            //Checking if the file already exist
            if(fileCreated){
                System.out.println("File was Created Successfully");
            }else if (file.exists()){
                System.out.println("File already exists");
            }

            //Writing the current data using loop to a text file
            FileWriter filewriter = new FileWriter("ProgramData.txt");
            filewriter.write("************" + "\n  CASHIER" + "\n************" + "\n");
            //Writing the queue 1 to file
            filewriter.write("Data for queue 1: \n");
            for (int i = 0; i < 5; i++) {
                filewriter.write(queue1[i]);

                if (i < queue1.length - 1) {
                    filewriter.write(",");
                }else if(i == queue1.length-1){
                    filewriter.write("\n");
                }
            }
            //Writing the queue 2 to file
            filewriter.write("Data for queue 2: \n");
            for (int i = 0; i < 5; i++) {
                filewriter.write(queue2[i]);

                if (i < queue2.length - 1) {
                    filewriter.write(",");
                } else if (i == queue2.length-1){
                    filewriter.write("\n");
                }
            }
            //Writing the queue 3 to file
            filewriter.write("Data for queue 3: \n");
            for (int i = 0; i < 5; i++) {
                filewriter.write(queue3[i]);

                if (i < queue3.length - 1) {
                    filewriter.write(",");
                } else if (i == queue3.length-1){
                    filewriter.write("\n");
                }
            }
            //Writing the Customer names into text file
            filewriter.write("Customer Data: \n");
            for(int i = 0; i < totalNames.length;i++){
                filewriter.write(totalNames[i]);

                if (i < totalNames.length - 1) {
                    filewriter.write(",");
                }
            }
            //Closing file writer
            filewriter.close();

        }catch (IOException e){
            System.out.println(e);
        }
    }
    //Method to add Burgers to the stock
    private static void burgerRestock(int burgers){
        //if burgers entered and current stock is below 50 the stock will be added
        if ( burgers < burgerStocks && burgerStocks < 50){
            burgerStocks = burgerStocks + burgers;
        }else{
            //A warning will print
            System.out.println("Please enter a value below below current burger stock" + burgerStocks + ":");
        }
    }

    //Method to load program data
    private static void loadProgramData() {
        try {
            File file = new File("ProgramData.txt");
            Scanner fileScanner = new Scanner(file);
            String fileLine;
            int lineCount = 0;
            while (fileScanner.hasNext()) {
                fileLine = fileScanner.nextLine();

                // Taking the data from every element before a ","
                if (lineCount == 4) {
                    queue1 = fileLine.split(",");
                } else if (lineCount == 6) {
                    queue2 = fileLine.split(",");
                } else if (lineCount == 8) {
                    queue3 = fileLine.split(",");
                }
                if(lineCount == 10){
                    totalNames = fileLine.split(",");
                }
                lineCount++;

            }
            fileScanner.close();
            System.out.println("Data has been successfully added to the program");


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Method to sort Customer names in Alphabetical order
    private static void alphabeticalOrder() {
        //Joining the all the names to one array
        int length = nameQueue1.length + nameQueue2.length + nameQueue3.length; //Incrementing the array length
        String[] totalNames = new  String[length];
        int index = 0;
        System.arraycopy(nameQueue1,0,totalNames,index,nameQueue1.length);//Combining two arrays
        index+=nameQueue1.length;
        System.arraycopy(nameQueue2,0,totalNames,index,nameQueue2.length);//Combining two arrays
        index+=nameQueue2.length;
        System.arraycopy(nameQueue3,0,totalNames,index,nameQueue3.length);//Combining two arrays
        //Making the Customer names to lowercase
        for (int i = 0;i < totalNames.length;i++){
            totalNames[i] = totalNames[i].toLowerCase();

        }
        //Sorting the names using first letter
        char firstChar;
        char secondChar;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < totalNames.length - 1; i++) {
                firstChar = totalNames[i].charAt(0);
                secondChar = totalNames[i + 1].charAt(0);
                if (secondChar < firstChar) {
                    String tempName = totalNames[i];
                    totalNames[i] = totalNames[i + 1];
                    totalNames[i + 1] = tempName;
                    sorted = false;
                }
            }
        }
        //Printing the sorted Customer names
        System.out.println(Arrays.toString(totalNames));
    }



    //Method to monitor the behavior of the Customers
    private static void systemChecking(){
        for(int i = 4; i >= 1; i--){
            //if there is  X before a 0, it swipes the values
            if (queue1[i].equals("O") && queue1[i-1].equals("X")){
                queue1[i-1] = "O";
                queue1[i] = "X";
            }
            if (queue2[i].equals("O") && queue2[i-1].equals("X")){
                queue2[i-1] = "O";
                queue2[i] = "X";
            }
            if (queue3[i].equals("O") && queue3[i-1].equals("X")){
                queue3[i-1] = "O";
                queue3[i] = "X";
            }
        }
    }

}
