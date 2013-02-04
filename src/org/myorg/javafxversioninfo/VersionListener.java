/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.javafxversioninfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
    category = "File",
id = "org.myorg.javafxversioninfo.VersionListener")
@ActionRegistration(
    iconBase = "org/myorg/javafxversioninfo/version.png",
displayName = "#CTL_VersionListener")
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_VersionListener=JavaFXVersion")
public final class VersionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingVersion swingVersion = new SwingVersion();
        swingVersion.main(null);
//        Application.launch(JavaFXVersionDisplay.class);
    }
}
