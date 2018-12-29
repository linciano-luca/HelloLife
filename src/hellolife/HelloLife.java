/*
A beautiful poem about life by S. Esenin
*/
package hellolife;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Luca
 */
public class HelloLife extends Application {
    
    @Override
    public void start(Stage stage) {
        String poem
                = "\n"
                + "Жизнь — обман с чарующей тоскою,\n"
                + "Оттого так и сильна она,\n"
                + "Что своею грубою рукою\n"
                + "Роковые пишет письмена.\n\n"
                + "Я всегда, когда глаза закрою,\n"
                + "Говорю: «Лишь сердце потревожь,\n"
                + "Жизнь — обман, но и она порою\n"
                + "Украшает радостями ложь.\n\n"
                + "Обратись лицом к седому небу,\n"
                + "По луне гадая о судьбе,\n"
                + "Успокойся, смертный, и не требуй\n"
                + "Правды той, что не нужна тебе».\n\n"
                + "Хорошо в черёмуховой вьюге\n"
                + "Думать так, что эта жизнь — стезя\n"
                + "Пусть обманут легкие подруги,\n"
                + "Пусть изменят легкие друзья.\n\n"
                + "Пусть меня ласкают нежным словом,\n"
                + "Пусть острее бритвы злой язык, —\n"
                + "Я живу давно на все готовым,\n"
                + "Ко всему безжалостно привык.\n\n"
                + "Холодят мне душу эти выси,\n"
                + "Нет тепла от звёздного огня.\n"
                + "Те, кого любил я, отреклися,\n"
                + "Кем я жил — забыли про меня.\n\n"
                + "Но и все ж, теснимый и гонимый,\n"
                + "Я, смотря с улыбкой на зарю,\n"
                + "На земле, мне близкой и любимой,\n"
                + "Эту жизнь за все благодарю.\n\n"
                + "17 Августа 1925\n"
                + "В декабре, 1925 г. Есенина не стало...\n";

        // Reference to the Text
        Text textRef = new Text(poem);
        textRef.setLayoutY(100);
        textRef.setTextOrigin(VPos.TOP);
        textRef.setTextAlignment(TextAlignment.JUSTIFY);
        textRef.setWrappingWidth(500);
        textRef.setFill(Color.rgb(255, 0, 0));
        textRef.setFont(Font.font("SansSerif", FontWeight.NORMAL, 20));

        // Provides the animated scrolling behavior for the text
        TranslateTransition transTransition = new TranslateTransition(new Duration(80000), textRef);
        transTransition.setToY(-820);
        transTransition.setInterpolator(Interpolator.LINEAR);
        transTransition.setCycleCount(Timeline.INDEFINITE);
        
        // Create an ImageView containing the Image
        // The image is loaded from internet and of course can be changed
        Image image = new Image("https://s3-eu-west-1.amazonaws.com/radiovocedellasperanza.it/wp-content/uploads/2018/02/EDITORIALE--Il-valore-della-vita.png");
        ImageView iv = new ImageView(image);
       
        // Create a ScrollPane containing the text
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(50);
        scrollPane.setLayoutY(180);
        scrollPane.setPrefWidth(400);
        scrollPane.setPrefHeight(100);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPannable(true);
        scrollPane.setContent(textRef);      
        
        // Add a button to scroll down
        
        Button myButton = new Button("Scroll down");
        myButton.setLayoutX(50);
        myButton.setLayoutY(300);
        
        myButton.setOnAction(e->{
            // Start the text animation
            transTransition.play();
        });
        
        // Combine ImageView and scrollPane
        // The dimensions of the scene are the same of the image
        Group root = new Group(iv, scrollPane, myButton);
        Scene scene = new Scene(root, 900, 600);

        stage.setScene(scene);
        stage.setTitle("Привет, жизнь!");
        stage.show();

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
