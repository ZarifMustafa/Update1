package com.example.demo4;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import static com.example.demo4.Global.global;

public class ScoreController implements Initializable {
    public Label scorecard;
    public void initialize(URL url, ResourceBundle resourceBundle){
        scorecard.setText(String.valueOf(global.score*10));

    }
}
