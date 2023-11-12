package com.example.semster1assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController implements Initializable {
    @FXML
    private ChoiceBox<String> rChoiceBox1;
    @FXML
    private ChoiceBox<String> rChoiceBox2;
    @FXML
    private ChoiceBox<String> rChoiceBox3;
    @FXML
    private TextField rTextFieldQuantity;
    @FXML
    public ListView<Recipe> rListView;
    public static RecipeController rcon;
    public BakedGood selectedGood;
    @FXML
    private ChoiceBox<BakedGood> rChoiceBoxPickGood;

    public void updateRListView(BakedGood bg) {
        rListView.getItems().clear();                                                                                   //clears the list first
        FunkyList<Recipe>.FunkyNode<Recipe> temp = bg.recipeList.head;                                    //calls the head of the display tray linked list and calls it temp
        while (temp != null) {                                                                                           //when temp is not null
            rListView.getItems().add(temp.getContents());                                                               //adds the contents of displaytray list to the list
            temp = temp.next;                                                                                            //makes temp the next element in the list
        }
    }

    public void switchToBakedGoods(ActionEvent event) {
        main.primaryStage.setScene(main.scene1);
    }

    public void switchToIngredients(ActionEvent event) {
        main.primaryStage.setScene(main.scene3);                                                                         //switches primary stage to scene 3(Jewellery Item)
        if(rListView.getSelectionModel().getSelectedItem()==null) {                                                     //if a tray is not selected
            IngredientController.icon.iListView.getItems().clear();                                                 //it will clear the jewellery list view of anything in it
        }
        else {
            IngredientController.icon.selectedRecipe =rListView.getSelectionModel().getSelectedItem();                 //otherwise if a tray is selected
            IngredientController.icon.updateIngredientListView(IngredientController.icon.selectedRecipe);                  //the jewellery item list will be updated with the selected tray i.e. you enter the selected tray
        }
    }

    public void addRecipe(MouseEvent mouseEvent) {
        selectedGood.recipeList.add(new Recipe(rChoiceBox1.getSelectionModel().getSelectedItem(),rChoiceBox2.getSelectionModel().getSelectedItem(),rChoiceBox3.getSelectionModel().getSelectedItem(), rTextFieldQuantity.getText()));
        updateRListView(selectedGood);
    }

    public void deleteRecipe(MouseEvent mouseEvent) {
        int selectedRecipe = rListView.getSelectionModel().getSelectedIndex();
        BakedGood bg = rChoiceBoxPickGood.getSelectionModel().getSelectedItem();
        bg.recipeList.delete(selectedRecipe);
        updateRListView(bg);

    }

    public void resetRecipe(ActionEvent event) {
        selectedGood.recipeList.reset();                                                                            //resets the head of the displaytraylist
        updateRListView(selectedGood);
    }

    public void switchToViewing(ActionEvent event) {
        main.primaryStage.setScene(main.scene4);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rcon =this;
        rChoiceBox1.getItems().addAll("Eggs","Flour","Milk","Sugar","Chocolate","Nuts","Fruits");
        rChoiceBox2.getItems().addAll("Eggs","Flour","Milk","Sugar","Chocolate","Nuts","Fruits");
        rChoiceBox3.getItems().addAll("Eggs","Flour","Milk","Sugar","Chocolate","Nuts","Fruits");
    }
}

