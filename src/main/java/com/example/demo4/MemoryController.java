package com.example.demo4;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import static com.example.demo4.Global.global;

public class MemoryController implements Initializable {

    public Label question;
    public RadioButton ans1;
    public ToggleGroup answer;
    public RadioButton ans2;
    public RadioButton ans3;
    public RadioButton ans4;
    public Button Submit;
    public String[] questions;
    public String[][] ans;
    public String[] correctanswers;
    public String correctans;
    public Label correct;
    public Label incorrect;
    public Label ca;
    int id, id1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            //String st=names[0];
            //System.out.println(st);
            //System.out.printf(String.valueOf((Global.getInstance().getMemoryIndex())));
            //File file=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memoryques.txt");
            File quesfiles[];
            quesfiles=new File[6];
            quesfiles[0]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memoryques.txt");
            quesfiles[1]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\iqques.txt");
            quesfiles[2]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\educationques.txt");
            quesfiles[3]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\vocabularyques.txt");
            quesfiles[4]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\gkques.txt");
            quesfiles[5]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\entertainmentques.txt");

            File ansfiles[];
            ansfiles=new File[6];
            ansfiles[0]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memoryans.txt");
            ansfiles[1]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\iqans.txt");
            ansfiles[2]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\educationans.txt");
            ansfiles[3]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\vocabularyans.txt");
            ansfiles[4]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\gkans.txt");
            ansfiles[5]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\entertainmentans.txt");


            File correctansfiles[];
            correctansfiles=new File[6];
            correctansfiles[0]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memorycorrectans.txt");
            correctansfiles[1]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\iqcorrectans.txt");
            correctansfiles[2]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\educationcorrectans.txt");
            correctansfiles[3]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\vocabularycorrectans.txt");
            correctansfiles[4]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\gkcorrectans.txt");
            correctansfiles[5]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\entertainmentcorrectans.txt");
            File currentfile=quesfiles[(Global.getInstance().getMemoryIndex())];
            Scanner sc=new Scanner(currentfile);
            questions=new String[3];
            for(int i=0;i<3;i++){
                questions[i]=sc.nextLine();//input nicchi file theke
            }
            question.setText(questions[0]);
            id=0;

            currentfile=ansfiles[Global.getInstance().getMemoryIndex()];
            sc=new Scanner(currentfile);
            ans=new String[3][4];
            for(int i=0;i<3;i++){
                for (int j = 0; j < 4; j++) {
                    ans[i][j]=sc.nextLine();
                }
                sc.nextLine();
            }
            ans1.setText(ans[0][0]);
            ans2.setText(ans[0][1]);
            ans3.setText(ans[0][2]);
            ans4.setText(ans[0][3]);
            currentfile=correctansfiles[(Global.getInstance().getMemoryIndex())];
            sc=new Scanner(currentfile);
            correctanswers=new String[3];
            for(int i=0;i<3;i++){
                correctanswers[i]=sc.nextLine();
            }
            correctans=correctanswers[0];

            id1=0;
            QuesAns quesans[]=new QuesAns[3];


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public void correctAnsShow()
    {
        global.score+=1;
        if(ans1.isSelected() && correctanswers[id].equals("0")) correct.setVisible(true);
        else if(ans2.isSelected() && correctanswers[id].equals("1")) correct.setVisible(true);
        else if(ans3.isSelected() && correctanswers[id].equals("2")) correct.setVisible(true);
        else if(ans4.isSelected() && correctanswers[id].equals("3")) correct.setVisible(true);
        else{
            incorrect.setVisible(true);
            char ch=correctanswers[id].charAt(0);
            ca.setText("Correct Answer: "+ans[id][ch-'0']);
            ca.setVisible(true);
            global.score--;
        }
        ans1.setDisable(true);
        ans2.setDisable(true);
        ans3.setDisable(true);
        ans4.setDisable(true);
    }
    public void submit_korsi() throws IOException {
        if(id==2){
            FXMLLoader fxmlloader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/totalscore.fxml"));
            Scene scene = new Scene(fxmlloader.load());
            Stage stage=new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            Stage stclose=(Stage)(question.getScene().getWindow());
            stclose.close();
            stage.show();
            return;
        }
        question.setText(questions[++id]);
        //if(id==2) Submit.setMouseTransparent(true);
        correct.setVisible(false);
        incorrect.setVisible(false);
        ans1.setText(ans[++id1][0]);
        ans2.setText(ans[id1][1]);
        ans3.setText(ans[id1][2]);
        ans4.setText(ans[id1][3]);
        ans1.setDisable(false);
        ans2.setDisable(false);
        ans3.setDisable(false);
        ans4.setDisable(false);
        ca.setVisible(false);
        ans1.setSelected(false);
        ans2.setSelected(false);
        ans3.setSelected(false);
        ans4.setSelected(false);
    }
}
