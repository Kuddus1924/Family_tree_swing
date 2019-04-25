/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.Person;
import java.awt.*;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Куддус
 */
public  class PersonInfo  {
    private Person tmp;
    public PersonInfo(Person button)
    {
        tmp = button;
    }
    public void work()
    {
       JFrame Tree = new JFrame("Информация");
        Tree.setVisible(true);
        Tree.setSize(400, 700);
        Tree.setLayout(new GridLayout(6, 1));
        JLabel Name = new JLabel("Name: " + tmp.name + '\n');
        JLabel SurName = new JLabel("Surname: " + tmp.surname);
        JLabel Start;
        if(tmp.day_end != null) 
        {
         Start = new JLabel("(" +  tmp.day_st + "."+tmp.Start + "-" +  tmp.day_end + "."+tmp.End + ")");
        }
        else
        {
          Start = new JLabel("(" +tmp.Start + "-" +tmp.End + ")");
        }
         JLabel dad = new JLabel("Partner:" + tmp.Partner);
         JLabel image = new JLabel(new ImageIcon("man.png"));
        JLabel ch = new JLabel("Children:" + tmp.size_ch);
         Tree.add(image);
        Tree.add(Name);
        Tree.add(ch);
        Tree.add(SurName);
        Tree.add(Start);
        Tree.add(dad);
    }
    
}

