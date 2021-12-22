package com.example.addressbook;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelloControllerOtherLabs {

    @FXML
    void openOtherLabs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OtherLabs.fxml"));
        Scene scene = new Scene(root, 800, 800);
        Stage stage = new Stage();

        stage.setTitle("Other labs");
        // Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        // stage.getIcons().add(icon);
        //stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }

    @FXML
    private CheckBox ChBSklad;

    @FXML
    private CheckBox ChBSDruz;

    @FXML
    private CheckBox ChBPogod;

    @FXML
    private CheckBox ChBGnuch;

    @FXML
    private Label LbTrueAnswer;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label lblChoiceBox;

    @FXML
    private Label lblcomboBox;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton RadioBtnCode;

    @FXML
    private RadioButton RadioBtnProp;

    @FXML
    private RadioButton RadioBtnLay;

    @FXML
    private RadioButton RadioBtnHier;

    @FXML
    private Label lblRadioButton;

    @FXML
    private Label labelDate;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private HBox hBox;

    @FXML
    private Slider mySlider;

    @FXML
    private Label labelSlider;

    @FXML
    void getDate(ActionEvent event) {
        LocalDate localDate = datePicker.getValue();
        String dateF = localDate.format(DateTimeFormatter.ofPattern("dd.MM.YY."));
        labelDate.setText(dateF);

    }

    @FXML
    void changeBackground(ActionEvent event) {
        Color myColor = colorPicker.getValue();
        hBox.setBackground(new Background(new BackgroundFill(myColor, null, null)));

    }

    private ToggleGroup radiotoggleGroup;

    int score;

    public void initialize(){

        LbTrueAnswer.setText("");

        lblChoiceBox.setText("");
        choiceBox.getItems().addAll("Правильно","Неправильно");

        lblcomboBox.setText("");
        comboBox.getItems().addAll("BorderPane", "AnchorPane","Vbox", "Hbox");

        lblRadioButton.setText("");
        radiotoggleGroup = new ToggleGroup();
        this.RadioBtnProp.setToggleGroup(radiotoggleGroup);
        this.RadioBtnLay.setToggleGroup(radiotoggleGroup);
        this.RadioBtnHier.setToggleGroup(radiotoggleGroup);
        this.RadioBtnCode.setToggleGroup(radiotoggleGroup);


        score = (int) mySlider.getValue();
        labelSlider.setText(score + " балів");

        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                score = (int) mySlider.getValue();
                labelSlider.setText(score + " балів");

            }
        });

    }

    @FXML
    void checkBoxAnswer(ActionEvent event) {
        String string = "Ваша відповідь: ";
        if (ChBPogod.isSelected()) string += "\nПогодженість";
        if (ChBSklad.isSelected()) string += "\nГнучкість";
        if (ChBSDruz.isSelected()) string += "\nДружність";
        if (ChBGnuch.isSelected()) string += "\nСкладність";

        LbTrueAnswer.setText(string);
    }

    @FXML
    void choiceBoxAnswer(ActionEvent event) {
        lblChoiceBox.setText("Відповідь: " + choiceBox.getValue().toString());

    }

    @FXML
    void comboBoxPressed(ActionEvent event) {
        lblcomboBox.setText("Відповідь: " + comboBox.getValue().toString());

    }


    @FXML
    void RadioAnswer(ActionEvent event){
        if(this.radiotoggleGroup.getSelectedToggle().equals(this.RadioBtnCode))
            lblRadioButton.setText("Відповідь: Code");
        if(this.radiotoggleGroup.getSelectedToggle().equals(this.RadioBtnProp))
            lblRadioButton.setText("Відповідь: Properties");
        if(this.radiotoggleGroup.getSelectedToggle().equals(this.RadioBtnLay))
            lblRadioButton.setText("Відповідь: Layout");
        if(this.radiotoggleGroup.getSelectedToggle().equals(this.RadioBtnHier))
            lblRadioButton.setText(("Відповідь: Hierarchy"));
    }
}