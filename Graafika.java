import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Graafika extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        //Peaklass


        //Vastased
        String[] nimed = new String[]{"Rott","Rästikud","Metskass","Ahv","Ilves","Raisakotkas","Hundikari","Lõvi"};
        /**
        System.out.println("Antud nimi: " + karakteriNimi);
        Thread.sleep(1000);
        System.out.println(karakteriNimi + " on ära eksinud tsivilisatsioonist kaugesse kohta. Aita tal sealt põgeneda" +
                "ja tagasi linna minna!");
        Thread.sleep(1000);

         **/

        //Graafiline v2ljund
        Group juur = new Group();
        Scene scene = new Scene(juur);
        primaryStage.setScene(scene);
        StackPane sp = new StackPane();
        ResizableCanvas louend = new ResizableCanvas();
        sp.getChildren().add(louend);
        juur.getChildren().add(sp);

        louend.widthProperty().bind(scene.widthProperty());
        louend.heightProperty().bind(scene.heightProperty());


        BackgroundImage bg = new BackgroundImage(new Image("mets.jpg"),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bground = new Background(bg);
        sp.setBackground(bground);
        sp.setPrefHeight(600);
        sp.setPrefWidth(600);



        Font font = Font.font("Calibri", FontWeight.BOLD,30);
        //Tutvustus
        String tutvustus = "                Teretulemast põrgusse!" + "\n" +
                "Alustamiseks andke oma inimesele nimi.";

        //Tutvustava teksti kuvamine
        Label tutv = new Label(tutvustus);
        tutv.setFont(font);
        tutv.setTextFill(Color.WHITE);
        tutv.setTranslateY(-160);

        //Aitav tekst
        Label label1 = new Label("Andke oma karakterile nimi: ");
        label1.setTextFill(Color.WHITE);
        label1.setTranslateY(-40);
        label1.setTranslateX(180);

        //Tekstilahter nime sisestamiseks
        TextField nimi = new TextField();
        nimi.setMaxWidth(150);
        nimi.setTranslateX(180);

        //Karakterile nime andmine ja mangu alustamine
        Button nupp = new Button("Anna nimi");
        nupp.setTranslateY(50);
        nupp.setTranslateX(220);

        Group algus = new Group(tutv,label1,nimi,nupp);
        sp.getChildren().add(algus);

        String[] karakteriNimi = {""};
        nupp.setOnAction(e -> {
            karakteriNimi[0] = (nimi.getText());
            algus.getChildren().clear();});


        Karakter m2ngija = new Karakter(karakteriNimi[0],30,1.0);
        Vastane vastane = new Vastane(nimed[0],10,0.8);

        M2ng test = new M2ng(m2ngija,vastane,nimed);

        primaryStage.show();


    }
}
