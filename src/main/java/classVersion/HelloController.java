package classVersion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class HelloController  {
    @FXML
    private Button viewCustomers;
    @FXML
    private Button searchCustomers;
    @FXML
    private Button waitingCustomers;
    @FXML
    private Button backButton;
    @FXML
    private Label label01;
    @FXML
    private Label label02;
    @FXML
    private Label label03;
    @FXML
    private Label label04;
    @FXML
    private Label label05;
    @FXML
    private Label label06;
    @FXML
    private Label label07;
    @FXML
    private Label label08;
    @FXML
    private Label label09;
    @FXML
    private Label label010;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label14;
    @FXML
    private Label label15;
    @FXML
    private Label label16;
    @FXML
    private Label label17;
    @FXML
    private Label label18;
    @FXML
    private Label label19;
    @FXML
    private Label label110;
    @FXML
    private Label label21;
    @FXML
    private Label label22;
    @FXML
    private Label label23;
    @FXML
    private Label label24;
    @FXML
    private Label label25;
    @FXML
    private Label label26;
    @FXML
    private Label label27;
    @FXML
    private Label label28;
    @FXML
    private Label label29;
    @FXML
    private Label label210;
    @FXML
    private Button viewCustomersRefresh;
    @FXML
    private Label waitingCustomerLabel01;
    @FXML
    private Label waitingCustomerLabel02;
    @FXML
    private Label waitingCustomerLabel03;
    @FXML
    private Label waitingCustomerLabel04;
    @FXML
    private Label waitingCustomerLabel05;
    @FXML
    private Label waitingCustomerLabel06;
    @FXML
    private Label waitingCustomerLabel11;
    @FXML
    private Label waitingCustomerLabel12;
    @FXML
    private Label waitingCustomerLabel13;
    @FXML
    private Label waitingCustomerLabel14;
    @FXML
    private Label waitingCustomerLabel15;
    @FXML
    private Label waitingCustomerLabel16;
    @FXML
    private Label waitingCustomerLabel21;
    @FXML
    private Label waitingCustomerLabel22;
    @FXML
    private Label waitingCustomerLabel23;
    @FXML
    private Label waitingCustomerLabel24;
    @FXML
    private Label waitingCustomerLabel25;
    @FXML
    private Label waitingCustomerLabel26;
    @FXML
    private Button waitingCustomersRefresh;
    @FXML
    private Button searchCustomersButton;
    @FXML
    private TextField searchCustomersTextField;
    @FXML
    private Label searchingFirstName;
    @FXML
    private Label searchingLastName;
    @FXML
    private Label searchingBurgerCount;




    @FXML
    public void viewCustomersQueues() throws IOException {
        Stage stage = (Stage) viewCustomers.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ViewCustomers.fxml")));
        primaryStage.setTitle("View Customers");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    @FXML
    public void viewSearchCustomer() throws IOException {
        Stage stage = (Stage) searchCustomers.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SearchCustomers.fxml")));
        primaryStage.setTitle("Search Customers");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();

    }

    @FXML
    public void viewWaiting() throws IOException {
        Stage stage = (Stage) waitingCustomers.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ViewWaitingCustomers.fxml")));
        primaryStage.setTitle("View Waiting Customers");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    @FXML
    public void backButtonWorking() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    public void updatingViewCustomerLabels(){
        try{
            label01.setText(Main.arraycopy1.getCustomers().get(0).getCustomerFirstName());
            label11.setText(Main.arraycopy1.getCustomers().get(0).getCustomerLastName());
            label21.setText(Integer.toString(Main.arraycopy1.getCustomers().get(0).getBurger()));

            label02.setText(Main.arraycopy1.getCustomers().get(1).getCustomerFirstName());
            label12.setText(Main.arraycopy1.getCustomers().get(1).getCustomerLastName());
            label22.setText(Integer.toString(Main.arraycopy1.getCustomers().get(1).getBurger()));

            label03.setText(Main.arraycopy2.getCustomers().get(0).getCustomerFirstName());
            label13.setText(Main.arraycopy2.getCustomers().get(0).getCustomerLastName());
            label23.setText(Integer.toString(Main.arraycopy2.getCustomers().get(0).getBurger()));

            label04.setText(Main.arraycopy2.getCustomers().get(1).getCustomerFirstName());
            label14.setText(Main.arraycopy2.getCustomers().get(1).getCustomerLastName());
            label24.setText(Integer.toString(Main.arraycopy2.getCustomers().get(1).getBurger()));

            label05.setText(Main.arraycopy2.getCustomers().get(2).getCustomerFirstName());
            label15.setText(Main.arraycopy2.getCustomers().get(2).getCustomerLastName());
            label25.setText(Integer.toString(Main.arraycopy2.getCustomers().get(2).getBurger()));

            label06.setText(Main.arraycopy3.getCustomers().get(0).getCustomerFirstName());
            label16.setText(Main.arraycopy3.getCustomers().get(0).getCustomerLastName());
            label26.setText(Integer.toString(Main.arraycopy3.getCustomers().get(0).getBurger()));

            label07.setText(Main.arraycopy3.getCustomers().get(1).getCustomerFirstName());
            label17.setText(Main.arraycopy3.getCustomers().get(1).getCustomerLastName());
            label27.setText(Integer.toString(Main.arraycopy3.getCustomers().get(1).getBurger()));

            label08.setText(Main.arraycopy3.getCustomers().get(2).getCustomerFirstName());
            label18.setText(Main.arraycopy3.getCustomers().get(2).getCustomerLastName());
            label28.setText(Integer.toString(Main.arraycopy3.getCustomers().get(2).getBurger()));

            label09.setText(Main.arraycopy3.getCustomers().get(3).getCustomerFirstName());
            label19.setText(Main.arraycopy3.getCustomers().get(3).getCustomerLastName());
            label29.setText(Integer.toString(Main.arraycopy3.getCustomers().get(3).getBurger()));

            label010.setText(Main.arraycopy3.getCustomers().get(4).getCustomerFirstName());
            label110.setText(Main.arraycopy3.getCustomers().get(4).getCustomerLastName());
            label210.setText(Integer.toString(Main.arraycopy3.getCustomers().get(4).getBurger()));

        }catch (Exception e){
            System.out.println("Refreshed the Current Customers");

        }
    }
    public void viewWaitingCustomerLabels(){
        try{
            waitingCustomerLabel01.setText(Main.arraycopy4.getCustomers().get(0).getCustomerFirstName());
            waitingCustomerLabel11.setText(Main.arraycopy4.getCustomers().get(0).getCustomerLastName());
            waitingCustomerLabel21.setText(Integer.toString(Main.arraycopy4.getCustomers().get(0).getBurger()));

            waitingCustomerLabel02.setText(Main.arraycopy4.getCustomers().get(1).getCustomerFirstName());
            waitingCustomerLabel12.setText(Main.arraycopy4.getCustomers().get(1).getCustomerLastName());
            waitingCustomerLabel22.setText(Integer.toString(Main.arraycopy4.getCustomers().get(1).getBurger()));

            waitingCustomerLabel03.setText(Main.arraycopy4.getCustomers().get(2).getCustomerFirstName());
            waitingCustomerLabel13.setText(Main.arraycopy4.getCustomers().get(2).getCustomerLastName());
            waitingCustomerLabel23.setText(Integer.toString(Main.arraycopy4.getCustomers().get(2).getBurger()));

            waitingCustomerLabel04.setText(Main.arraycopy4.getCustomers().get(3).getCustomerFirstName());
            waitingCustomerLabel14.setText(Main.arraycopy4.getCustomers().get(3).getCustomerLastName());
            waitingCustomerLabel24.setText(Integer.toString(Main.arraycopy4.getCustomers().get(3).getBurger()));

            waitingCustomerLabel05.setText(Main.arraycopy4.getCustomers().get(4).getCustomerFirstName());
            waitingCustomerLabel15.setText(Main.arraycopy4.getCustomers().get(4).getCustomerLastName());
            waitingCustomerLabel25.setText(Integer.toString(Main.arraycopy4.getCustomers().get(4).getBurger()));

            waitingCustomerLabel06.setText(Main.arraycopy4.getCustomers().get(5).getCustomerFirstName());
            waitingCustomerLabel16.setText(Main.arraycopy4.getCustomers().get(5).getCustomerLastName());
            waitingCustomerLabel26.setText(Integer.toString(Main.arraycopy4.getCustomers().get(5).getBurger()));

        }catch (Exception e){
            System.out.println("Refreshed Waiting Customers");

        }
    }
    public void searchCustomers(){
        String firstName = searchCustomersTextField.getText();
        for (int i = 0; i < Main.arraycopy1.getQueueSize();i++){
            if (Main.arraycopy1.getCustomers().get(i).getCustomerFirstName().equals(firstName)){
                searchingFirstName.setText(Main.arraycopy1.getCustomers().get(i).getCustomerFirstName());
                searchingLastName.setText(Main.arraycopy1.getCustomers().get(i).getCustomerLastName());
                searchingBurgerCount.setText(Integer.toString(Main.arraycopy1.getCustomers().get(i).getBurger()));
            }
        }
        for (int i = 0; i < Main.arraycopy2.getQueueSize();i++){
            if (Main.arraycopy2.getCustomers().get(i).getCustomerFirstName().equals(firstName)){
                searchingFirstName.setText(Main.arraycopy2.getCustomers().get(i).getCustomerFirstName());
                searchingLastName.setText(Main.arraycopy2.getCustomers().get(i).getCustomerLastName());
                searchingBurgerCount.setText(Integer.toString(Main.arraycopy2.getCustomers().get(i).getBurger()));
            }

        }
        for (int i = 0; i < Main.arraycopy3.getQueueSize();i++){
            if (Main.arraycopy3.getCustomers().get(i).getCustomerFirstName().equals(firstName)){
                searchingFirstName.setText(Main.arraycopy3.getCustomers().get(i).getCustomerFirstName());
                searchingLastName.setText(Main.arraycopy3.getCustomers().get(i).getCustomerLastName());
                searchingBurgerCount.setText(Integer.toString(Main.arraycopy3.getCustomers().get(i).getBurger()));
            }

        }
        for (int i = 0; i < Main.arraycopy4.getQueueSize();i++){
            if (Main.arraycopy4.getCustomers().get(i).getCustomerFirstName().equals(firstName)){
                searchingFirstName.setText(Main.arraycopy4.getCustomers().get(i).getCustomerFirstName());
                searchingLastName.setText(Main.arraycopy4.getCustomers().get(i).getCustomerLastName());
                searchingBurgerCount.setText(Integer.toString(Main.arraycopy4.getCustomers().get(i).getBurger()));
            }
        }

    }

}
