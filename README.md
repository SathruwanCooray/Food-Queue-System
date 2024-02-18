# Food Queue System

This is a simple Food Queue System designed to manage customer queues efficiently. The system offers two versions: an array-based version and a class-based version. This project was done as 1st year, second semester programming coursework at IIT institution affiliate with University of Westminster.

## Functionality

### Array Version

![Array Version](https://i.imgur.com/FDjRjG1.png)

**Array version user enter the queue number the user want the position the customer.**

1. **View all queues (VFQ - 100):** Display all queues along with their current status.
2. **View all empty queues (VEQ - 101):** Display queues that are currently empty.
3. **Add customer to a queue (ACQ - 102):** Add a customer to the queue of choice. Users can select which queue they wish to join.
4. **Remove a customer from a queue (RCQ - 103):** Remove a customer from a specific queue.
5. **Remove a served customer (PCQ - 104):** Remove the first customer from the queue as they are served.
6. **View Customers Sorted in alphabetical order (VCS - 105):** Display customers in queues sorted alphabetically.
7. **Store program data into file (SPD - 106):** Save the program data to a file for future use.
8. **Load program data from file (LDP - 107):** Load previously stored program data from a file.
9. **View remaining burgers Stock (STK - 108):** Display the remaining stock of burgers.
10. **Add burgers to stock (AFS - 109):** Increase the stock of burgers.
11. **Exit the program (EXT - 999):** Close the program.

### Class Version

![Class Version](https://i.imgur.com/Kp8pdXo.png)

**Class version the customer automatically will be added to the first position of the 1st queue and move up accordinly**

1. **View all queues (VFQ - 100):** Display all queues along with their current status.
2. **View all empty queues (VEQ - 101):** Display queues that are currently empty.
3. **Add customer to a queue (ACQ - 102):** Add a customer to the queue. Customers are automatically added to the appropriate queue based on availability.
4. **Remove a customer from a queue (RCQ - 103):** Remove a customer from a specific queue.
5. **Remove a served customer (PCQ - 104):** Remove the first customer from the queue as they are served.
6. **View Customers Sorted in alphabetical order (VCS - 105):** Display customers in queues sorted alphabetically.
7. **Store program data into file (SPD - 106):** Save the program data to a file for future use.
8. **Load program data from file (LDP - 107):** Load previously stored program data from a file.
9. **View remaining burgers Stock (STK - 108):** Display the remaining stock of burgers.
10. **Add burgers to stock (AFS - 109):** Increase the stock of burgers.
11. **Calculate the income (IFQ - 110):** Calculate the total income generated by the system.
12. **Open the GUI (GUI - 112):** Launch the graphical user interface (GUI) for the Food Queue System.

## Usage

### Array Version

![Example of Using Array Version](https://i.imgur.com/TEPa69w.png)

To use the array-based version of the Food Queue System, follow these steps:

1. Run the program.
2. Choose the desired operation from the provided menu by entering the corresponding code.
3. Follow the prompts to perform the selected operation.

### Class Version

![Food Queue System](https://i.imgur.com/YHcgBFL.png)

To use the class-based version of the Food Queue System, follow these steps:

1. Run the program.
2. Follow the prompts to perform operations. Customers will be automatically added to the appropriate queue based on availability.

## Graphical User Interface (GUI)

GUI is only available for the class version only

![Opening Menu](https://i.imgur.com/ODDizUT.png)

![Customers in queue](https://i.imgur.com/9DHtTJV.png)

*Customers in the queue will be shown here.*

![Customers waiting in the queue](https://i.imgur.com/EePJG31.png)

*Customers waiting in the queue will be shown here.*

![Customer information searching](https://i.imgur.com/klKmtJP.png)

*Customer information can be looked up through the customer searching User-Interface.*

The GUI version of the Food Queue System is developed using JavaFX. To launch the GUI:

1. Run the program.
2. Select the option to open the GUI (code 112).
3. The graphical interface will open, allowing users to interact with the system using buttons and visual cues.

## Note

Ensure that JavaFX is properly configured and installed to run the GUI version of the Food Queue System.

## Author

- Sathruwan Hansith Cooray - 20220659

## License

- This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- Special thanks to IIT institution and University of Westminster
