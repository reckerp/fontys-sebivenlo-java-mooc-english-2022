import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class UI {
    private RecipeController controller;
    private Scanner scanner;

    public UI(RecipeController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("File to read:");
        String fileName = scanner.nextLine();
        readFile(fileName);


        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                System.out.println("Recipes:");
                for (Recipe receipe : this.controller.getRecipes()) {
                    System.out.println(receipe);
                }
            }

            if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String name = scanner.nextLine();
                System.out.println("Recipes:");
                for (Recipe receipe : this.controller.findRecipesByName(name)) {
                    System.out.println(receipe);
                }
            }

            if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int maxTime = Integer.valueOf(scanner.nextLine());
                System.out.println("Recipes:");
                for (Recipe receipe : this.controller.findRecipesByTime(maxTime)) {
                    System.out.println(receipe);
                }
            }

            if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String ingredient = scanner.nextLine();
                System.out.println("Recipes:");
                for (Recipe receipe : this.controller.findRecipesByIngredient(ingredient)) {
                    System.out.println(receipe);
                }
            }
        }
    }

    public void readFile(String fileName) {
        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {

            ArrayList<String> fileLines = new ArrayList<>(); //create arraylist of the lines of the file
              //arraylist for the ingredneits of a Recipe 

            while (fileScanner.hasNextLine()) { //keeps looping entil end of the file

                String line = fileScanner.nextLine();

                if (line.trim().isEmpty() || !fileScanner.hasNextLine()) {  //when it comes to a blank line or the end of the file it 
                    // stops and and starts assign the lines/ArrayList to variables 
                    String name = fileLines.get(0);                         // simply the first two as Name and Time and then the rest to another list called ingredient list
                    int time = Integer.valueOf(fileLines.get(1));
                     ArrayList<String> ingredientList = new ArrayList<>();     //didn';t look into it too much but i had issues moving this else where and emptying the list beleow
                        
                    for (int i = 2; i < fileLines.size(); i++) {   //starts ingrendents after the first two lines
                        ingredientList.add(fileLines.get(i));

                    }
                    controller.addRecipe(name, time, ingredientList);     // creates an object and adds it to the Recipebook object which is an arrayList of object
                                                                                      
                    fileLines.removeAll(fileLines);                                   
                                             
                } else {

                    fileLines.add(line);
                }

            }

            fileScanner.close();

        } catch (Exception e) {

            System.out.println("Error reading file " + e.getMessage());
        }
    }

}
