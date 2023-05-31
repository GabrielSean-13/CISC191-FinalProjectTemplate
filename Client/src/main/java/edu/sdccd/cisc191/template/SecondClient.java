package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.util.Arrays;


import java.net.*;
import java.io.*;



// Second Client JavaFX
public class SecondClient extends Application {


    //Method that prints the Menu in console for user
    public boolean printMenu() {
        //Convert a for loop over an 2D array into Stream API.
        String [][] arrayTwo = {{" Burger == $5.99", " Pizza == $7.99"},{" Coke == $0.99", " Sprite == $0.99"}};
        Arrays.stream(arrayTwo).map(a -> String.join(" ", a))
                .forEach(System.out::println);
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

        // Sets stage name title
        primaryStage.setTitle("Food Menu");

        // Creates button objects for event handling, and also labels the buttons in the parameter
        showMenu = new Button("Show Menu");
        burgerFood = new Button("Purchase Burger");
        pizzaFood = new Button("Purchase Pizza");
        cokeDrink = new Button("Purchase Coke");
        spriteDrink = new Button("Purchase Sprite");

        //Creates objects from specified classes
        Burger b = new Burger();
        Pizza p = new Pizza();
        Coke c = new Coke();
        Sprite s = new Sprite();


        // Creates button objects for event handling, and also labels the buttons in the parameter
        showMenu.setOnAction( e -> printMenu());
        burgerFood.setOnAction ( e -> b.payInCash());;
        pizzaFood.setOnAction ( e -> p.payInCash());
        cokeDrink.setOnAction ( e -> c.payInCash());
        spriteDrink.setOnAction ( e -> s.payInCash());


        //Created VBox object
        VBox foodLeft = new VBox();
        // Takes children(button) into the VBox
        foodLeft.getChildren().addAll(burgerFood, pizzaFood);
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
        Scene scene = new Scene(borderPane, 300, 250);
        primaryStage.setScene(scene);
        // Displays the stage to its users
        primaryStage.show();

    }

    // Main Code Method
    public static void main(String[] args) throws Exception {
        // Launches second javafx Program
        launch(args);

        //Creates connection to Server
        Socket socket = new Socket("localhost", 8080);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("I have finished using the Menu, Thank you very much!");
        printWriter.flush();


    }
}


