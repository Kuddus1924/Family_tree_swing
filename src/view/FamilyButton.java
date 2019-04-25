/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JButton;
import Model.*;

/**
 *
 * @author Куддус
 */
public class FamilyButton extends JButton {
    private Person name;
   public FamilyButton(String button,Person g)
    {
        super(button);
        
        name = g;
    }
    Person GetPerson()
    {
        return name;
    }
            
}
