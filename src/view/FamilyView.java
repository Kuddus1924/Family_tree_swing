/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import Model.*;
import io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayDeque;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * нарисовать линии и поправить вывод потомков,
 * @author Куддус
 */
public class FamilyView extends JFrame {

    public String name;
    private LinkedList<FamilyButton> [] list;
    JFrame Tree;
    /**
     * Creates new form FamilyView
     */
    public FamilyView(String file) {
       name  = file;
       list = new LinkedList[50];
        Tree = new JFrame("Древо");
        Tree.setVisible(true);
        Tree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Tree.setSize(1300, 730);
        //initComponents();
    }
    public void Work()
    {
        FamilyTree family = new FamilyTree();
        FamilyReader reader = new FamilyReader(family);
        try
        {    
        reader.read(name);
        ArrayDeque<Person>  Queue=  new ArrayDeque();
        Queue.addFirst(family.GetStart());
        Person tmp;
        int Level = 0;
        FamilyButton button;
        list[Level] =  new LinkedList();
        LinkedList<Person> lists;
        while (!Queue.isEmpty()) {
            tmp = Queue.pollFirst();
            button = new FamilyButton(tmp.Get_nameP(),tmp);
            if(tmp.getLevel() - 1 > Level)
            {
                Level++;
                list[Level] =  new LinkedList();
            }
            list[Level].add(button);
            lists = family.map.get(tmp);
            if(lists != null)
            {
            for(int i = 0;i < lists.size();i++)
            {
                Queue.addLast(lists.get(i));
            }
            }
         }
   }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    public void build()
    {
        int i = 0;
        
        Graphics gr;
      
        JPanel panel = new JPanel();
        panel.setVisible(true);
        panel.setSize(1300, 700);
        panel.setLayout(null);
        int Length;
         Tree.setContentPane(panel);
         gr = panel.getGraphics();
         gr.setColor(Color.red);
        FamilyButton Tmp;
        while(list[i] != null)
        {
            Length = 1300 /  (list[i].size()+1);
            for(int j = 0;j < list[i].size();j++ )
            {
                Tmp = list[i].get(j);
                Tmp.setSize(115, 20);
                Tmp.setLocation((j+1)*Length,700 - (i+1)*40);
                Action ac = new Action(Tmp.GetPerson());
                Tmp.addActionListener(ac);
                panel.add(Tmp);
                if(i != 0)
                {
                    for(int z = 0; z< list[i - 1].size();z++ )
                    {
                        if(Tmp.GetPerson().get_Dad().equals(list[i-1].get(z).GetPerson()))
                        {
                           
                              
                              int x = Tmp.getX();
                              int y = Tmp.getY();
                              int y1 = list[i-1].get(z).getX();
                               int x1 = list[i-1].get(z).getY();
                             gr.drawLine(Tmp.getX(),Tmp.getY(),list[i-1].get(z).getX() ,list[i-1].get(z).getY());
                             
                             
                        }
                    }
                }
            }
            i++;
                
        }
        panel.paintComponents(gr);
    }
    private class Action implements ActionListener{//реализуем интерфейс отвечающий за события
    private Person people;
    public Action(Person p){
        people = p;
    }
    public void actionPerformed(ActionEvent event){//реакция на нажатие кнопки
      PersonInfo p = new PersonInfo(people)  ;
      p.work();
    }
    }
}