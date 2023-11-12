package com.example.semster1assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import static com.example.semster1assignment1.main.BakedGoodList;

public class ViewingController {

    @FXML
    public TextField searchBar;

    @FXML
    public ListView listViewAll;

    public void switchToDisplayCase(ActionEvent event) {
        main.primaryStage.setScene(main.scene1);
    }

    public void loadAll(){                                                                                                //use loadAll to run the update method for the View All Jewellery Items List
        UpdateViewingListView();
    }

    public void UpdateViewingListView() {                                                                                 //updates the View all items list using a nested loop
        listViewAll.getItems().clear();                                                                                   //clear anything in the list before adding anything
        FunkyList<BakedGood>.FunkyNode<BakedGood> tempBG = BakedGoodList.head;
        while (tempBG != null) {                                                                                          //calls displaycaselist runs through it and when its not null(finds a case) moves onto the next part of the loop
            listViewAll.getItems().add(tempBG.getContents().goodName+" = Good Name");
            FunkyList<Recipe>.FunkyNode<Recipe> tempR = tempBG.getContents().recipeList.head;
            while (tempR != null) {
                listViewAll.getItems().add("\t" + tempR.getContents().ingredient1+" = Ingredient One");
                listViewAll.getItems().add("\t" + tempR.getContents().ingredient2+" = Ingredient Two");
                listViewAll.getItems().add("\t" + tempR.getContents().ingredient3+" = Ingredient Three");
                FunkyList<Ingredient>.FunkyNode<Ingredient> tempI = tempR.getContents().ingredientList.head;
                while (tempI != null) {
                    listViewAll.getItems().add("\t\t" +tempI.getContents());
                    tempI = tempI.next;
                }
                tempR = tempR.next;
            }
            tempBG = tempBG.next;
        }
    }

    public void searchLists(ActionEvent event) {
        listViewAll.getItems().clear();
        searching();
    }

    public void searching() {
        listViewAll.getItems().clear();
        FunkyList<BakedGood>.FunkyNode<BakedGood> tempBG = BakedGoodList.head;
        while (tempBG != null) {
            FunkyList<Recipe>.FunkyNode<Recipe> tempR = tempBG.getContents().recipeList.head;
            while (tempR != null) {
                FunkyList<Ingredient>.FunkyNode<Ingredient> tempI = tempR.getContents().ingredientList.head;
                while (tempI != null) {
                    if(tempI.getContents().getName().contains(searchBar.getText()))                                    //if the text in the search bar matches a gender of jewellery in the jewellery item linked list
                    {
                        listViewAll.getItems().add(tempI.getContents());                                                               //then it will add it to the listview
                    }
                    else{
                        if(tempI.getContents().getDescription().contains(searchBar.getText())){
                            listViewAll.getItems().add(tempI.getContents());
                        }
                        else{
                            if (tempI.getContents().getDescription().contains(searchBar.getText())){
                                listViewAll.getItems().add(tempI.getContents());
                            }
                        }
                    }
                    tempI = tempI.next;
                }
                tempR = tempR.next;
            }
            tempBG = tempBG.next;
        }
    }

    public void getAllPrices(ActionEvent event) {

        listViewAll.getItems().clear();

        int total=0;

        FunkyList<BakedGood>.FunkyNode<BakedGood> tempBG = BakedGoodList.head;
        while (tempBG != null) {
            int bgtotal =0;
            listViewAll.getItems().add(tempBG.getContents().goodName+" = Good Name");
            FunkyList<Recipe>.FunkyNode<Recipe> tempR = tempBG.getContents().recipeList.head;

            while (tempR != null) {
                int rtotal =0;
                listViewAll.getItems().add("\t" + tempR.getContents().quantity+" = Quantity");
                FunkyList<Ingredient>.FunkyNode<Ingredient> tempI = tempR.getContents().ingredientList.head;
                while (tempI != null) {
                    listViewAll.getItems().add("\t\t" + tempI.getContents());
                    bgtotal +=Integer.parseInt(tempI.getContents().getCalories());
                    rtotal +=Integer.parseInt(tempI.getContents().getCalories());
                    total+=Integer.parseInt(tempI.getContents().getCalories());
                    tempI = tempI.next;
                    listViewAll.getItems().add(tempR.getContents().quantity+": Current Recipe's Total = "+rtotal);
                }
                tempR = tempR.next;
                listViewAll.getItems().add(tempBG.getContents().goodName+": Current Goods's Total = "+ bgtotal);
            }
            tempBG = tempBG.next;

            listViewAll.getItems().add("Total Calories = "+total);
        }



    }

    public void switchToGoods(ActionEvent event) {
        main.primaryStage.setScene(main.scene1);
    }
}

