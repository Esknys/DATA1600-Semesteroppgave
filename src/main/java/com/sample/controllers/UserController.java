package com.sample.controllers;

import com.sample.car.*;
import com.sample.file.CarFormatter;
import com.sample.file.FileReader;
import com.sample.file.FileSaver;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserController {

    @FXML
    public void initialize() {
        System.out.println("Initialized");

        //fyller arrays for testing
        engineArrayList.add(electric);
        engineArrayList.add(diesel);

        gearboxArrayList.add(manual);
        gearboxArrayList.add(automatic);

        paintjobArrayList.add(paint1);
        paintjobArrayList.add(paint2);

    }

    //konstruerer deler pga mangel av innlastning fra fil
    private Engine electric = new Engine("Electroman", "Electric", 500, 200000);
    private Engine diesel = new Engine("Diesel 200x", "Diesel", 200, 150000);

    private Gearbox manual = new Gearbox("Oldschool", 30000, "Manual transmission");
    private Gearbox automatic = new Gearbox("Super auto shifter", 40000, "Automatic transmission");

    private Paintjob paint1 = new Paintjob("White cream", 10000, "White", "Metallic");
    private Paintjob paint2 = new Paintjob("Night black", 15000, "Black", "Metallic");

    private ArrayList<Engine> engineArrayList = new ArrayList<>();
    private ArrayList<Gearbox> gearboxArrayList = new ArrayList<>();
    private ArrayList<Paintjob> paintjobArrayList = new ArrayList<>();

    //ENUM
    private enum PartType {
        OVERVEIW,
        ENGINE,
        GEARBOX,
        PAINTJOB
    }

    PartType currentPartType = PartType.OVERVEIW;


    Car testCar = new Car(diesel, manual, paint1);
    Car currentConfiguringCar = new Car(null, null, null);

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Label LblTitle;

    @FXML
    private ButtonBar UIButtonbar;

    @FXML
    private Button BtnSaveCar;

    @FXML
    private Button BtnOverviewScene;

    @FXML
    private Button BtnEngineScene;

    @FXML
    private Button BtnGearboxScene;

    @FXML
    private Button BtnPaintjobScene;

    @FXML
    private Button BtnShowCars;

    @FXML
    private TableView<?> tableViewCars;

    @FXML
    private Label lblSelectPart;

    //Groups the parts so you can only select one at the time
    ToggleGroup tg = new ToggleGroup();

    @FXML
    private TilePane PartSelectorTilePane;

    @FXML
    private Button btnAddToConfiguration;

    @FXML
    void SaveCar(ActionEvent event) {

        try {
            File file = new File("carregister.txt");

            String formatted = CarFormatter.formatCar(currentConfiguringCar);

            FileSaver.save(formatted, file);
        } catch (IOException io) {

        }

    }

    @FXML
    void ShowCars(ActionEvent event) {
/*
        File file = new File("carregister.txt");


        FileReader fileReader = new FileReader();


        ObservableList<Car> cars = fileReader.readCars(file);

        fileReader.attachTableView(tableViewCars, cars);

 */
    }

        @FXML
        void AddSelectedPart (ActionEvent event){
            String selectedPartUUID = (String) tg.getSelectedToggle().getUserData();
            Part selectedPart = findPartInPartArrayLists(selectedPartUUID);

            switch (currentPartType) {
                case OVERVEIW:
                    break;

                case ENGINE:
                    currentConfiguringCar.setEngine((Engine) selectedPart);
                    break;

                case GEARBOX:
                    currentConfiguringCar.setGearbox((Gearbox) selectedPart);
                    break;

                case PAINTJOB:
                    currentConfiguringCar.setPaintjob((Paintjob) selectedPart);
            }

        }

        @FXML
        void showOverviewScene (ActionEvent event){

            currentPartType = PartType.OVERVEIW;
            updateTitleAndWidowButtons();

            clearRadioButtonTilePane();
        }

        @FXML
        void showEngineScene (ActionEvent event){

            currentPartType = PartType.ENGINE;
            updateTitleAndWidowButtons();

            clearRadioButtonTilePane();
            fillRadioButtonTilePaneWithParts(engineArrayList);

        }

        @FXML
        void showGearboxScene (ActionEvent event){

            currentPartType = PartType.GEARBOX;
            updateTitleAndWidowButtons();

            clearRadioButtonTilePane();
            fillRadioButtonTilePaneWithParts(gearboxArrayList);
        }

        @FXML
        void showPaintjobScene (ActionEvent event){

            currentPartType = PartType.PAINTJOB;
            updateTitleAndWidowButtons();

            clearRadioButtonTilePane();
            fillRadioButtonTilePaneWithParts(paintjobArrayList);
        }

   public void fillRadioButtonTilePaneWithParts(ArrayList<? extends Part> partArrayList) {
        for (Part p : partArrayList) {
            RadioButton radioButton = new RadioButton();
            radioButton.setText(p.getName() + "\n" + p.getPriceFormatted() + ",-");
            radioButton.setPadding(new Insets(5, 25, 25, 5));
            radioButton.setUserData(p.getUUIDString());
            //må få lagt inn en id ellerno til hver radiobutton, så jeg kan hente ut hvilken del som er valg senere...
            radioButton.setToggleGroup(tg);
            PartSelectorTilePane.getChildren().add(radioButton);
        }
    }

    public void clearRadioButtonTilePane(){
        PartSelectorTilePane.getChildren().clear();
    }
    //bare for testing
    public void fillArrayListsWithParts() {
        engineArrayList.add(electric);
        engineArrayList.add(diesel);

        gearboxArrayList.add(manual);
        gearboxArrayList.add(automatic);

        paintjobArrayList.add(paint1);
        paintjobArrayList.add(paint2);

        System.out.println(testCar);

    }

    public void clearArrayListWithParts() {
        engineArrayList.clear();
        gearboxArrayList.clear();
        paintjobArrayList.clear();

    }

    public Part findPartInPartArrayLists(String UUIDString) {
        Part returningPart = null;
        for (Part p : engineArrayList) {
            if (p.getUUIDString() == UUIDString) {
                returningPart = p;
            }
        }
        for (Part p : gearboxArrayList) {
            if (p.getUUIDString() == UUIDString) {
                returningPart = p;
            }
        }
        for (Part p : paintjobArrayList) {
            if (p.getUUIDString() == UUIDString) {
                returningPart = p;
            }
        }

        return returningPart;
    }

    public void enableAllSceneButtons() {
        BtnOverviewScene.setDisable(false);
        BtnEngineScene.setDisable(false);
        BtnGearboxScene.setDisable(false);
        BtnPaintjobScene.setDisable(false);
        btnAddToConfiguration.setVisible(true);

    }

    public void setTitle(String title) {
        LblTitle.setText(title);
    }

    public void updateTitleAndWidowButtons() {
        switch(currentPartType) {
            case OVERVEIW:
                setTitle("Overview");
                enableAllSceneButtons();
                BtnOverviewScene.setDisable(true);
                btnAddToConfiguration.setVisible(false);
                break;

            case ENGINE:
                setTitle("Engine");
                enableAllSceneButtons();
                BtnEngineScene.setDisable(true);
                break;

            case GEARBOX:
                setTitle("Gearbox");
                enableAllSceneButtons();
                BtnGearboxScene.setDisable(true);
                break;

            case PAINTJOB:
                setTitle("Paintjob");
                enableAllSceneButtons();
                BtnPaintjobScene.setDisable(true);
                break;
        }
    }

}
