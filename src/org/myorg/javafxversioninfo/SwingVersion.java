/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.javafxversioninfo;

import com.sun.javafx.runtime.VersionInfo;
import java.awt.BorderLayout;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author tomo
 */
public class SwingVersion {
    public SwingVersion(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGui();
            }
        });
    }
    private static void initAndShowGui() {
        JFrame jFrame = new JFrame("test");
        final JFXPanel jfxPanel = new JFXPanel();
        jfxPanel.setPreferredSize(new java.awt.Dimension(500, 180));
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(500, 200);
        // JavaFX version by Swing
        String javaFxVer = VersionInfo.getRuntimeVersion();
        JLabel jLabel = new JLabel("JavaFX version(by Swing) is " + javaFxVer);
        jFrame.add(jLabel, BorderLayout.NORTH);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(jfxPanel);
            }
        });
        jFrame.add(jfxPanel, BorderLayout.CENTER);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static void initFX(JFXPanel fxpanel){
        Scene scene = createScene();
        fxpanel.setScene(scene);
    }
    private static Scene createScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        // *** for row size
        ColumnConstraints col1 = new ColumnConstraints(250);
        grid.getColumnConstraints().add(col1);
        // Title label
        InnerShadow is = new InnerShadow();
        is.setOffsetX(0.1f);
        is.setOffsetY(0.1f);
        Text scenetitle = new Text("JavaFX Version Display");        
        scenetitle.setEffect(is);
        scenetitle.setFill(Color.AQUA);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 36));
        grid.add(scenetitle, 0, 0, 2, 1);
        // JavaFX version info
        Label l1 = new Label("Version from VersionInfo is ");
        l1.setFont(Font.font(null, FontWeight.NORMAL, 18));
        grid.add(l1, 0, 1);
        final Text t1 = new Text(VersionInfo.getRuntimeVersion());
        t1.setFont(Font.font(null, FontWeight.BOLD, 18));
        grid.add(t1, 1, 1);
        // JavaFX version info
        Label l2 = new Label("Version from property is ");
        l2.setFont(Font.font(null, FontWeight.NORMAL, 18));
        grid.add(l2, 0, 2);
        final Text t2 = new Text(System.getProperty("javafx.runtime.version"));
        t2.setFont(Font.font(null, FontWeight.BOLD, 18));
        grid.add(t2, 1, 2);
        // Java version info
        Label l3 = new Label("Java Version is ");
        l3.setFont(Font.font(null, FontWeight.NORMAL, 18));
        grid.add(l3, 0, 3);
        final Text t3 = new Text(System.getProperty("java.version"));
        t3.setFont(Font.font(null, FontWeight.BOLD, 18));
        grid.add(t3, 1, 3);
        return new Scene(grid, Color.ALICEBLUE);        
    }

    public static void main(String[] args) {
        new SwingVersion();
    }
}
