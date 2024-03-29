import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


//Graafika on antud mängu nn peaklass, kust mäng algselt käivitatakse.
public class Graafika extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage){
        //Mängus osalevad tegelased
        String[] nimed = new String[]{"Rott","Rästikud","Metskass","Ahv","Ilves","Raisakotkas","Hundikari","Lõvi"};
        Karakter m2ngija = new Karakter("test",30,1.0);
        Vastane vastane = new Vastane(nimed[0],10,0.8);


        //Graafiline nn start screen
        Group juur = new Group();
        Scene scene = new Scene(juur,600,600);
        StackPane sp = new StackPane();
        Canvas louend = new Canvas(600,600);
        sp.getChildren().add(louend);
        juur.getChildren().add(sp);

        louend.widthProperty().bind(scene.widthProperty());
        louend.heightProperty().bind(scene.heightProperty());

        //Läbiva taustapildi lisamine
        BackgroundImage bg = new BackgroundImage(new Image("assets/mets.jpg"),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bground = new Background(bg);
        sp.setBackground(bground);
        sp.setPrefHeight(600);
        sp.setPrefWidth(600);



        Font font = Font.font("Calibri", FontWeight.BOLD,30);

        String tutvustus = "                Teretulemast põrgusse!" + "\n" +
                "Alustamiseks andke oma inimesele nimi.";

        //Tutvustava teksti kuvamine
        Label tutv = new Label(tutvustus);
        tutv.setFont(font);
        tutv.setTextFill(Color.WHITE);
        tutv.setTranslateY(-160);
        tutv.setWrapText(true);

        //Aitav tekst
        Label label1 = new Label("Andke oma karakterile nimi: ");
        label1.setTextFill(Color.WHITE);
        label1.setTranslateY(-40);
        label1.setTranslateX(180);

        //Tekstilahter nime sisestamiseks
        TextField nimi = new TextField();
        nimi.setMaxWidth(150);
        nimi.setTranslateX(180);

        //Karakterile nime andmine ja mängu alustamine
        Button nupp = new Button("Anna nimi ja alusta m2ngu");
        nupp.setTranslateY(50);
        nupp.setTranslateX(180);

        Group algus = new Group(tutv,label1,nimi,nupp);
        sp.getChildren().add(algus);




        //Graafiliste komponentide kuvamine
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline timeline = new Timeline();
        //Nupu vajutamisel kinnitatakse nimi ja käivitatakse mäng
        nupp.setOnAction(e -> {
            //Tegelasele antakse kasutaja valitud nimi
            m2ngija.setNimi(nimi.getText());
            //Uue logi alustamine
            KirjutaLogi logi = new KirjutaLogi();
            logi.sissekanne("M2ngija: " + m2ngija.getNimi());
            logi.sissekanne("Voidetud vastased: ");
            M2ng test = new M2ng(m2ngija,vastane,nimed,0,logi);
            //Mängu huvitavamaks teev tekst
            KeyValue yks = new KeyValue(tutv.textProperty(),"Antud nimi: " + m2ngija.getNimi());
            KeyValue kaks = new KeyValue(tutv.textProperty(), m2ngija.getNimi() + " on ära eksinud tsivilisatsioonist"+"\n"+ "kaugesse kohta. Aita tal sealt põgeneda" +
                    "\n" +"ja tagasi linna minna!");
            KeyFrame one = new KeyFrame(Duration.ZERO, yks);
            KeyFrame two = new KeyFrame(Duration.seconds(3),kaks);
            timeline.getKeyFrames().addAll(one,two);
            //Mängu ajaks peidame nupu, tekstivälja ja infovälja ära
            timeline.getKeyFrames().add(new KeyFrame(Duration.ZERO, actionEvent -> {nupp.setVisible(false);
            nimi.setVisible(false); label1.setVisible(false);}));
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5), actionEvent -> {
                try {
                    //Alustame mängu
                test.start(primaryStage);
            } catch (InterruptedException ex) {
                    System.out.println("Interruption error.");
            }}));
            timeline.play();
            });
    }


}
