
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Klass M2ng on mängu läbiviiv klass, kus on parameetrid m2ngija ja vastane, kes üksteise vastu võitlevad ning
 * parameetrid lv, nimed ja nimeluger, mida kasutatakse mängu kulgemise jälgimiseks ning õigeaegselt mängu lõpetamiseks.
 * Lisaks on ka parameeter logi, kuhu mängu jooksul kogunenud info talletatakse.
 */

public class  M2ng extends Application {
    private Karakter m2ngija;
    private Vastane vastane;
    private int lv = 1;
    private String[] nimed;
    private int nimeluger;
    private KirjutaLogi logi;

    public M2ng( Karakter m2ngija, Vastane vastane, String[] nimed, int nimeluger, KirjutaLogi logi) {
        this.m2ngija = m2ngija;
        this.vastane = vastane;
        this.nimed = nimed;
        this.nimeluger = nimeluger;
        this.logi = logi;

    }

    /**
     * Meetod Damage genereerib suvalise arvu vahemikus 1-10 mida Karakter ja Vastane kasutavad enda rünnaku tugevuse
     * tähistamiseks.
     * @return  Tagastab suvalise arvu vahemikus 1-10.
     */
    public static double Damage(){
        int min = 1;
        int max = 10;
        return (int)(Math.random() * (max - min + 1) + min);
    }

    /**
     * Meetod start viib läbi mängu peamist osa graafilielt, milleks on kahe tegelase vahel toimuv võitlus.
     * Selleks kasutatakse antud parameetreid ning meetodit Damage. Mäng kestab seni, kuni on kas vastaseid,
     * kellega võidelda või mängija kaotab.
     * Meetod Damage'i tagastatud arv korrutatakse mängija ja vastase enda tugevuse kordajatega, mis muutuvad peale igat
     * tsüklit (vastasel iga tsükkel ühtlaselt ning mängijal olenevalt kasutaja valikutest).
     * @throws InterruptedException juhul, kui uut levelit ei saa alustada.
     */

    public void start(Stage primaryStage) throws InterruptedException {
        Group juur2 = new Group();
        Scene scene2 = new Scene(juur2, 600,600);
        StackPane sp2 = new StackPane();
        Canvas louend = new Canvas(600, 600);
        louend.widthProperty().bind(scene2.widthProperty());
        louend.heightProperty().bind(scene2.heightProperty());

        //Läbiv taustapilt ning ekraani ja lõuendi suuruste ühilduvus
        BackgroundImage bg = new BackgroundImage(new Image("assets/mets.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bground = new Background(bg);
        sp2.setBackground(bground);

        sp2.setPrefHeight(600);
        sp2.setPrefWidth(600);

        sp2.getChildren().add(louend);
        juur2.getChildren().add(sp2);
        Timeline timeline = new Timeline();

        //Kui kasutaja sulgeb akna, lisame viimased teadaolevad andmed logifaili, kuid neid ei kuvata.
        primaryStage.setOnCloseRequest(e -> {
            logi.sissekanne("M2ngija sulges m2ngu ise.");
            logi.sissekanne("M2ngija level: " + lv);
            logi.sissekanne("M2ngija tugevus: " + m2ngija.getCurrentStrength());
            primaryStage.close();
        });

        primaryStage.setScene(scene2);
        primaryStage.show();

        //Vaatame kas meil on veel vastaseid, kellega võidelda.
        if (nimeluger < nimed.length) {
            int m2ngijaElud = m2ngija.getCurrentHealth();
            int vastaseElud = vastane.getCurrentHealth();
            Font font = Font.font("Calibri", FontWeight.BOLD, 30);
            Label l1 = new Label("");
            l1.setFont(font);
            l1.setTextFill(Color.WHITE);
            sp2.getChildren().add(l1);
            Image vpilt = new Image("assets/default.png");
            ImageView pilt = new ImageView(vpilt);
            sp2.getChildren().add(pilt);
            pilt.setTranslateY(100);

            //Tutvustav tekst ja pilt vastasest
            KeyValue t1 = new KeyValue(l1.textProperty(), m2ngija.getNimi() + " kohtas metsas ohtlikku looma " + vastane.getNimi() + "!");
            KeyValue t2 = new KeyValue(l1.textProperty(), m2ngija.getNimi() + " VS " + vastane.getNimi());
            KeyValue t3 = new KeyValue(l1.textProperty(), "");
            KeyFrame k1 = new KeyFrame(Duration.ZERO, t1);
            KeyFrame k2 = new KeyFrame(Duration.seconds(2), t2);
            KeyFrame k3 = new KeyFrame(Duration.seconds(4), t3);
            timeline.getKeyFrames().addAll(k1, k2, k3);
            timeline.getKeyFrames().add(new KeyFrame(Duration.ZERO, actionEvent -> {
                //Vastase pildi otsimine kaustast, olenevalt vastase nimest.
                Image temp = new Image("assets/"+ vastane.getNimi() + ".jpg");
                pilt.setImage(temp);
                //Kuna kasutatud pildid olid eri suurustes, sätestasin ma nende suuruse programmis ühtlaseks,
                //et ei tekiks probleeme tekstinähtavusega.
                pilt.setFitHeight(100);
                pilt.setFitWidth(100);
            }));
            Timeline timeline2 = new Timeline();
            //Põhiline mängutsükkel - võitlus kasutaja karakteri ja vastase vahel.
            while (vastaseElud > 0 & m2ngijaElud > 0) {
                m2ngijaElud -= (int) Damage() * vastane.getCurrentStrength();
                KeyValue t4 = new KeyValue(l1.textProperty(), m2ngija.getNimi() + " HP: " + m2ngijaElud);
                if (m2ngijaElud <= 0) {
                    l1.setTextFill(Color.WHITE);
                    pilt.setImage(vpilt);
                    KeyValue t7 = new KeyValue(l1.textProperty(), m2ngija.getNimi() + " kaotas...");
                    logi.sissekanne("M2ngija kaotas vastasele " + nimed[nimeluger]);
                    logi.sissekanne("M2ngija level: " + lv);
                    logi.sissekanne("M2ngija tugevus: " + m2ngija.getCurrentStrength());
                    KeyValue t8 = new KeyValue(l1.textProperty(), "");
                    KeyFrame k7 = new KeyFrame(Duration.ZERO, t7);
                    KeyFrame k8 = new KeyFrame(Duration.seconds(3), t8);
                    timeline2.getKeyFrames().addAll(k7,k8);
                    //Kaotuse puhul kuvame kõige lõpus kogu logifaili salvestatud info.
                    for(int i = 0;i < loe("logifail.txt").size();i++){
                        timeline2.getKeyFrames().add(new KeyFrame(Duration.seconds(4+i),new KeyValue(l1.textProperty(),loe("logifail.txt").get(i))));
                    }
                    timeline2.getKeyFrames().add(new KeyFrame(Duration.seconds(4+loe("logifail.txt").size()), actionEvent -> primaryStage.close()));
                    timeline2.play();
                    break;
                }
                vastaseElud -= (int) Damage() * m2ngija.getCurrentStrength();
                KeyValue t5 = new KeyValue(l1.textProperty(), vastane.getNimi() + " HP: " + vastaseElud);
                KeyValue t6 = new KeyValue(l1.textProperty(), "");
                KeyFrame k4 = new KeyFrame(Duration.seconds(6), t4);
                KeyFrame k5 = new KeyFrame(Duration.seconds(8), t5);
                KeyFrame k6 = new KeyFrame(Duration.seconds(10), t6);
                timeline.getKeyFrames().addAll(k4, k5, k6);
            }
            //Lisame logifaili just võidetud vastase nime.
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(11), actionEvent -> {
                logi.sissekanne(nimed[nimeluger]);
               //Kutsume esile meetodi lvup, et muuta vastast ja kasutaja karakteri atribuute, olenevalt sellest, mida
               //kasutaja valis.
               int otsus = lvup();
               if(otsus == -1){
                   //Kui kasutaja sulgeb siin faasis programmi, lisame viimased teadaolevad andmed logifaili,
                   //aga logifaili andmeid ei kuvata.
                   logi.sissekanne("M2ngija sulges m2ngu ise.");
                   logi.sissekanne("M2ngija level: " + lv);
                   logi.sissekanne("M2ngija tugevus: " + m2ngija.getCurrentStrength());
                   primaryStage.close();
               }
                //Kui kasutaja karakter on elus ja on võitnud kõiki olemasolevaid vastaseid, saab mäng läbi ja
                //teda õnnitletakse. Logifaili lisatakse andmed ja need kuvatakse.
                if (nimeluger == nimed.length) {
                    pilt.setImage(vpilt);
                    KeyValue t7 = new KeyValue(l1.textProperty(), "Palju õnne! " + m2ngija.getNimi() + " saavutas võidu looduse üle ja saab naasta linna.");
                    logi.sissekanne("M2ngija voitis koiki vastaseid!");
                    logi.sissekanne("M2ngija level: " + lv);
                    logi.sissekanne("M2ngija tugevus: " + m2ngija.getCurrentStrength());
                    KeyValue t8 = new KeyValue(l1.textProperty(), "");
                    KeyFrame k7 = new KeyFrame(Duration.ZERO, t7);
                    KeyFrame k8 = new KeyFrame(Duration.seconds(3), t8);
                    timeline2.getKeyFrames().addAll(k7, k8);
                    for(int i = 0;i < loe("logifail.txt").size();i++){
                        timeline2.getKeyFrames().add(new KeyFrame(Duration.seconds(4+i),new KeyValue(l1.textProperty(),loe("logifail.txt").get(i))));
                    }
                    timeline2.getKeyFrames().add(new KeyFrame(Duration.seconds(4+ loe("logifail.txt").size()), actionEvent2 -> primaryStage.close()));
                    timeline2.play();
                }
                //Kui kasutaja karakter on elus, kuid pole veel kõiki vastaseid võitnud, käivitatakse
                //uus versioon mängust (nö uus level) uue vastasega.
                M2ng uusLevel = new M2ng(m2ngija,vastane,nimed,nimeluger,logi);
                try {
                    uusLevel.start(primaryStage);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
            timeline.playFrom(Duration.ZERO);
        }

    }

    /**
     * Meetod lvup laseb kasutajal valida kas suurendada oma karakteri tugevust või elujõudu. Mitte kumbagi valides,
     * või dialoogiakna sulgedes mäng katkeb.
     * @return Tagastab mängule kas 0 või -1. -1 puhul mäng katkestatakse ning logifaili lisatakse sellepuhul ka kirje.
     */
    public int lvup(){
        String valik = JOptionPane.showInputDialog(null, "Kui soovid tõsta tugevust, sisesta STR, kui elusid siis HP. Akna sulgemisel programm lõpetab töö.", "Valik", JOptionPane.QUESTION_MESSAGE);
        if (Objects.equals(valik, "STR")) {
            m2ngija.strengthUp(lv);
        } else if (Objects.equals(valik, "HP")) {
            m2ngija.healthUp(lv);
        } else {
            return -1;
        }
        lv++;
        nimeluger++;
        vastane.healthUp(lv);
        vastane.strengthUp(lv);
        vastane.setNimi(nimed[nimeluger]);

        return 0;
    }

    /**
     * Meetod loe loeb antud failist andmed ning paneb need sõnelisti.
     * @param fail - antud faili failinimi sõnena.
     * @return Tagastab sõnelisti failisisuga.
     */
    public static List<String> loe(String fail){
        List<String> tekst = new ArrayList<>();
        try {
            File file = new File(fail);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String andmed = scanner.nextLine();
                tekst.add(andmed);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return tekst;
    }


}
