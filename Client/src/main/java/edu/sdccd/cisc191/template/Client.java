package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.util.HashMap;

import java.net.*;
import java.io.*;
import java.nio.file.FileSystemNotFoundException;

/**
 * This program opens a connection to a computer specified
 * as the first command-line argument.  If no command-line
 * argument is given, it prompts the user for a computer
 * to connect to.  The connection is made to
 * the port specified by LISTENING_PORT.  The program reads one
 * line of text from the connection and then closes the
 * connection.  It displays the text that it read on
 * standard output.  This program is meant to be used with
 * the server program, DateServer, which sends the current
 * date and time on the computer where the server is running.
 */

public class Client extends Application {


   //Method that prints the Menu in console for user
   public boolean printMenu() {

       // Creates a HashMap that stores key value pairs
       HashMap<String, Double> menu = new HashMap<>();

       menu.put("Burger", 5.99);
       menu.put("Pizza", 7.99);
       menu.put("Coke", 0.99);
       menu.put("Sprite", 0.99);
       System.out.println("===============Menu===============");
       System.out.println(" Burger == $" + menu.get("Burger") + ", Pizza == $" + menu.get("Pizza"));
       System.out.println(" Coke == $" + menu.get("Coke") + ", Sprite == $" + menu.get("Sprite"));
       System.out.println("==================================");
       System.out.println("============Cash Only=============");
       System.out.println("==================================");
       return true;
   }

    // Method that contains all contents of the stage, and starts it
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Creates buttons for events later on

        Button showMenu;

        Button burgerFood;

        Button pizzaFood;

        Button cokeDrink;

        Button spriteDrink;


        //Create radio button
        RadioButton dineIn;
        RadioButton takeOut;


        // Sets stage name title
        primaryStage.setTitle("Food Menu");

        // Creates button objects for event handling, and also labels the buttons in the parameter
        showMenu = new Button("Show Menu");
        burgerFood = new Button("Purchase Burger");
        pizzaFood = new Button("Purchase Pizza");
        cokeDrink = new Button("Purchase Coke");
        spriteDrink = new Button("Purchase Sprite");

        //Initialize radio buttons
        dineIn = new RadioButton("Dine-In");
        takeOut = new RadioButton ("Take Out");


        //Creates objects from specified classes
        Burger b = new Burger();
        Pizza p = new Pizza();
        Coke c = new Coke();
        Sprite s = new Sprite();

        // Saves Objects in Disk
        try (FileOutputStream fs = new FileOutputStream("objects.txt")) {
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(b);
            os.writeObject(p);
            os.writeObject(c);
            os.writeObject(s);
            os.close();
        } catch (FileSystemNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Creates button objects for event handling, and also labels the buttons in the parameter
        showMenu.setOnAction( e -> printMenu());
        burgerFood.setOnAction ( e -> b.payInCash());
        pizzaFood.setOnAction ( e -> p.payInCash());
        cokeDrink.setOnAction ( e -> c.payInCash());
        spriteDrink.setOnAction ( e -> s.payInCash());


        //Created VBox object
        VBox foodLeft = new VBox();
        // Takes children(button) into the VBox
        foodLeft.getChildren().addAll(burgerFood, pizzaFood, dineIn, takeOut);

        //Creates another VBox object
        VBox drinkRight = new VBox();
        // Takes children(button) into the VBox
        drinkRight.getChildren().addAll(cokeDrink, spriteDrink);


        // Creates BorderPane Object to place buttons in the specified place
        BorderPane borderPane = new BorderPane();
        //Sets the set of buttons in object foodLeft on the Left hand side
        borderPane.setLeft(foodLeft);
        //Sets the set of buttons in object drinkRight  on the right hand side
        borderPane.setRight(drinkRight);
        // Sets the showMenu button on the center
        borderPane.setCenter(showMenu);

        // Creates a scene where all the buttons are placed
        Scene scene = new Scene(borderPane, 400, 250);
        primaryStage.setScene(scene);
        // Displays the stage to its users
        primaryStage.show();

    }

    // Main Code Method
    public static void main(String[] args) throws Exception {
        // Launches javafx Program
        launch(args);

        //Creates connection to Server
        Socket socket = new Socket("localhost", 4999);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Finished Using the Menu, Thank you!");
        printWriter.flush();

        // Reads files saved from disk
        try (FileInputStream fi = new FileInputStream("objects.txt")) {
            ObjectInputStream os = new ObjectInputStream(fi);

            Burger b1 = (Burger)os.readObject();
            Pizza p1 = (Pizza)os.readObject();
            Coke c1 = (Coke)os.readObject();
            Sprite s1 = (Sprite)os.readObject();
            System.out.println(b1.foodChose());
            System.out.println(p1.foodChose());
            System.out.println(c1.drinkChose());
            System.out.println(s1.drinkChose());

            os.close();

        } catch (FileSystemNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}

