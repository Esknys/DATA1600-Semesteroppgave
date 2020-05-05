package com.sample.controllers;

import com.sample.car.*;
import com.sample.file.CarFormatter;
import com.sample.file.FileReader;
import com.sample.file.FileSaver;
import com.sample.file.InvalidCarFormatException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class SluttbrukerController {

    //konstruerer deler pga mangel av innlastning fra fil
    private Engine electric = new Engine("Electroman", "Electric", 500, 200000);
    private Engine diesel = new Engine("Diesel 200x","Diesel", 200, 150000);

    private Gearbox manual = new Gearbox("Oldschool",30000, "Manual transmission");
    private Gearbox automatic = new Gearbox("Super auto shifter", 40000, "Automatic transmission");

    private Paintjob paint1 = new Paintjob("White cream", 10000, "White", "Metallic");
    private Paintjob paint2 = new Paintjob("Night black", 15000, "Black", "Metallic");

    private ArrayList<Engine> engineArrayList = new ArrayList<>();
    private ArrayList<Gearbox> gearboxArrayList = new ArrayList<>();
    private ArrayList<Paintjob> paintjobArrayList = new ArrayList<>();

    Car testCar1 = new Car(diesel, manual, paint1);
    Car testCar2 = new Car(electric, automatic, paint2);

    private ArrayList<Car> carArrayList = new ArrayList<>();

    //ENUM
    private enum PartType {
        OVERVEIW,
        ENGINE,
        GEARBOX,
        PAINTJOB
    }

    PartType currentPartType = PartType.OVERVEIW;

    //Groups the parts so you can only select one at the time
    ToggleGroup partToggleGroup = new ToggleGroup();
    ToggleGroup carToggleGroup = new ToggleGroup();

    Car currentConfiguringCar = new Car(electric, manual, paint1);

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Label LblTitle;

    @FXML
    private ButtonBar UIButtonbar;

    @FXML
    private ButtonBar btnBarCarConfigs;

    @FXML
    private Button BtnOverviewScene;

    @FXML
    private Button BtnEngineScene;

    @FXML
    private Button BtnGearboxScene;

    @FXML
    private Button BtnPaintjobScene;

    @FXML
    private Label lblSelectPart;

    @FXML
    private Label lblPartInfoTitle;

    @FXML
    private Label lblPartInfo;

    @FXML
    private TilePane PartSelectorTilePane;

    @FXML
    private Button btnAddToConfiguration;

    @FXML
    private Label lblCurrentConfiguration;

    @FXML
    public void initialize() {
        //fyller arrays for testing



        engineArrayList.add(electric);
        engineArrayList.add(diesel);

        gearboxArrayList.add(manual);
        gearboxArrayList.add(automatic);

        paintjobArrayList.add(paint1);
        paintjobArrayList.add(paint2);

        carArrayList.add(testCar1);
        carArrayList.add(testCar2);


        //Legger til funksjonen updateCurretPartInfo som Listner til togglegroupen, så info om delene oppdateres
        partToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (partToggleGroup.getSelectedToggle() != null) {
                    updateCurrentPartInfo(partToggleGroup.getSelectedToggle().getUserData().toString());
                }

            }
        });

        carToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (carToggleGroup.getSelectedToggle() != null) {
                    updateCurrentCarInfo(carToggleGroup.getSelectedToggle().getUserData().toString());
                }

            }
        });


        currentPartType = PartType.OVERVEIW;
        updateTitleAndWidowButtons();
        fillRadioButtonTilePaneWithCarConfigurations(carArrayList);



        System.out.println("Initialized");

    }

    @FXML
    void AddSelectedPart(ActionEvent event) {
        if (partToggleGroup.getSelectedToggle() != null) {
            String selectedPartUUID = (String) partToggleGroup.getSelectedToggle().getUserData();
            Part selectedPart = findPartInPartArrayLists(selectedPartUUID);

            switch(currentPartType) {
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
                    break;
            }

        }
        updateCurrentConfiguration();

    }

    @FXML
    void newCar(ActionEvent event) {

    }

    @FXML
    void selectCar(ActionEvent event) {
        currentConfiguringCar = findCarInCarArrayList(carToggleGroup.getSelectedToggle().getUserData().toString());
        updateCurrentConfiguration();
    }

    @FXML
    void saveConfiguration(ActionEvent event) throws IOException {

        FileReader fileReader = new FileReader();
        File file = new File("carregister.txt");

       try {

           String formatted = CarFormatter.formatCar(currentConfiguringCar);

           FileSaver.save(formatted, file);

           ArrayList<Car> cars = fileReader.readCars(file);

           for (Car car : cars) {

               carArrayList.add(car);


           }

       } catch(IOException ioe) {

           throw new InvalidCarFormatException("Feil bilformat");

       }

    }

    public void updateCurrentConfiguration() {
        lblCurrentConfiguration.setText(currentConfiguringCar.toString());
    }

    @FXML
    void showOverviewScene(ActionEvent event) {

        currentPartType = PartType.OVERVEIW;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithCarConfigurations(carArrayList);


    }

    @FXML
    void showEngineScene(ActionEvent event) {

        currentPartType = PartType.ENGINE;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithParts(engineArrayList);

    }

    @FXML
    void showGearboxScene(ActionEvent event) {

        currentPartType = PartType.GEARBOX;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithParts(gearboxArrayList);
    }

    @FXML
    void showPaintjobScene(ActionEvent event) {

        currentPartType = PartType.PAINTJOB;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithParts(paintjobArrayList);
    }

    public void fillRadioButtonTilePaneWithParts(ArrayList<? extends Part> partArrayList) {

        for (Part p : partArrayList) {
            RadioButton radioButton = new RadioButton();
            radioButton.setText(p.getName() + "\n" + p.getPriceFormatted() + ",-");
            radioButton.setPadding(new Insets(5, 25, 5, 25));
            radioButton.setUserData(p.getUUIDString());
            radioButton.setToggleGroup(partToggleGroup);

            PartSelectorTilePane.getChildren().add(radioButton);
        }


    }

    public void fillRadioButtonTilePaneWithCarConfigurations(ArrayList<Car> carArrayList) {

        for (Car c : carArrayList) {
            RadioButton radioButton = new RadioButton();
            radioButton.setText(c.getPriceFormatted() + ",-" + "\n" + c.getEngine().getName() + "\n" + c.getGearbox().getName() + "\n" + c.getPaintjob().getName());
            radioButton.setPadding(new Insets(5, 25, 5, 25));
            radioButton.setUserData(c.getUUIDString());

            radioButton.setToggleGroup(carToggleGroup);

            PartSelectorTilePane.getChildren().add(radioButton);
        }


    }

    public void updateCurrentPartInfo(String UUID) {

        Part currentPart = findPartInPartArrayLists(UUID);

        lblPartInfo.setText(currentPart.toStringFormatted());
    }

    public void updateCurrentCarInfo(String UUID) {

        Car currentCar = findCarInCarArrayList(UUID);

        lblPartInfo.setText(currentCar.toString());
    }

    public void clearCurrentPartInfo() {
        lblPartInfo.setText("");
    }

    public void clearRadioButtonTilePane(){
        PartSelectorTilePane.getChildren().clear();
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

    public Car findCarInCarArrayList(String UUIDString) {
        Car returningCar = null;
        for (Car c : carArrayList) {
            if (c.getUUIDString() == UUIDString) {
                returningCar = c;
            }
        }
        return returningCar;
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
                clearCurrentPartInfo();
                lblSelectPart.setText("Select car configuration");
                lblPartInfoTitle.setText("Car info");
                btnBarCarConfigs.setVisible(true);
                break;

            case ENGINE:
                setTitle("Engine");
                enableAllSceneButtons();
                BtnEngineScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Select part");
                lblPartInfoTitle.setText("Part info");
                btnBarCarConfigs.setVisible(false);


                break;

            case GEARBOX:
                setTitle("Gearbox");
                enableAllSceneButtons();
                BtnGearboxScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Select part");
                lblPartInfoTitle.setText("Part info");
                btnBarCarConfigs.setVisible(false);


                break;

            case PAINTJOB:
                setTitle("Paintjob");
                enableAllSceneButtons();
                BtnPaintjobScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Select part");
                lblPartInfoTitle.setText("Part info");
                btnBarCarConfigs.setVisible(false);


                break;
        }
    }

}
