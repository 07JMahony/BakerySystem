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

public class IngredientController implements Initializable {

    @FXML
    public TextField iTextFieldName;
    @FXML
    public TextField iTextFieldDescription;
    @FXML
    private TextField iTextFieldCalories;
    public ChoiceBox<Recipe> iChoiceBoxPickRecipe;
    @FXML
    public ListView<Ingredient> iListView;
    public static IngredientController icon;
    public Recipe selectedRecipe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        icon = this;
    }



    public void updateIngredientListView(Recipe r) {
        iListView.getItems().clear();                                                                                   //clears the list first
        FunkyList<Ingredient>.FunkyNode<Ingredient> temp = r.ingredientList.head;                                    //calls the head of the display tray linked list and calls it temp
        while (temp != null) {                                                                                           //when temp is not null
            iListView.getItems().add(temp.getContents());                                                               //adds the contents of displaytray list to the list
            temp = temp.next;                                                                                            //makes temp the next element in the list
        }
    }

    public void AddIngredient(MouseEvent mouseEvent) {
        selectedRecipe.ingredientList.add(new Ingredient(iTextFieldName.getText(), iTextFieldDescription.getText(),iTextFieldCalories.getText()));
        updateIngredientListView(selectedRecipe);
    }

    public void removeIngredient(ActionEvent event) {
        int selectedRecipe = iListView.getSelectionModel().getSelectedIndex();
        Recipe r = iChoiceBoxPickRecipe.getSelectionModel().getSelectedItem();
        r.ingredientList.delete(selectedRecipe);
        updateIngredientListView(r);
    }

    public void resetIngredient(ActionEvent event) {
        selectedRecipe.ingredientList.reset();
        updateIngredientListView(selectedRecipe);
    }

    public void switchToGoods(ActionEvent event) {
        main.primaryStage.setScene(main.scene4);

    }

    public void switchToRecipes(ActionEvent event) {
        main.primaryStage.setScene(main.scene2);
    }
}

