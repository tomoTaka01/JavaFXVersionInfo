/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.javafxversioninfo;

import com.sun.javafx.runtime.VersionInfo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author tomo
 */
public class JavaFXVersionDisplay extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        // *** for row size
        ColumnConstraints col1 = new ColumnConstraints(250);
        grid.getColumnConstraints().add(col1);
        // Title
        InnerShadow is = new InnerShadow();
        is.setOffsetX(0.1f);
        is.setOffsetY(0.1f);
        Text scenetitle = new Text("JavaFX Version Display");        
        scenetitle.setEffect(is);
        scenetitle.setFill(Color.AQUA);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 36));
        grid.add(scenetitle, 0, 0, 2, 1);
        // JavaFX version
        Label l1 = new Label("Version from VersionInfo is ");
        l1.setFont(Font.font(null, FontWeight.NORMAL, 18));
        grid.add(l1, 0, 1);
        final Text t1 = new Text(VersionInfo.getRuntimeVersion());
        t1.setFont(Font.font(null, FontWeight.BOLD, 18));
        grid.add(t1, 1, 1);
        // JavaFX version
        Label l2 = new Label("Version from property is ");
        l2.setFont(Font.font(null, FontWeight.NORMAL, 18));
        grid.add(l2, 0, 2);
        t1.setFont(Font.font(null, FontWeight.BOLD, 18));
        final Text t2 = new Text(System.getProperty("javafx.runtime.version"));
        t2.setFont(Font.font(null, FontWeight.BOLD, 18));
        grid.add(t2, 1, 2);
        // Java version
        Label l3 = new Label("Java Version is ");
        l3.setFont(Font.font(null, FontWeight.NORMAL, 18));
        grid.add(l3, 0, 3);
        final Text t3 = new Text(System.getProperty("java.version"));
        t3.setFont(Font.font(null, FontWeight.BOLD, 18));
        grid.add(t3, 1, 3);
        
        Scene scene = new Scene(grid, 500, 200, Color.ALICEBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Version Info");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
