/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;
import Model.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import  java.util.ArrayList;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.lang.RuntimeException;
/**
 *
 * @author Куддус
 */
public class FamilyReader {
    private FamilyTree family;
    public FamilyReader(FamilyTree exp)
    {
        family = exp;
    } 
    public void read(String Name_file)throws IOException
    {
        FileInputStream tmp = new FileInputStream(Name_file);
        BufferedReader  reader  = new BufferedReader (new InputStreamReader(tmp));  
        String temp;
        while ((temp = reader.readLine())!= null)
        {
        Person dad = Get_Person(temp);
        if((temp = reader.readLine())== null)
        {
            throw new RuntimeException("Error Get_Children");
        }
        else
        {
        Person partner = Get_Partner(temp);
        dad.set_Partner(partner);
        }
        if((temp = reader.readLine())== null)
        {
            throw new RuntimeException("Error Get_Children");
        }
        else
        {
            if(family.map.isEmpty())
            {
            dad.setLevel(1);
            }
            family.add(dad,Get_Children(temp,dad));
        
        }
        }
        
    }
    
    public static Person Get_Person(String str)
    {
        int start,End;
        String []name = new String[4];
        
            name = str.split(" ");

        Person people = new Person(name[0],name[1], name[4],name[7]);
        people.SetDay(name[2]+"." + name[3] , name[5]+"." + name[6]);
        return people;
    }
     public Person Get_Partner(String str)
    {
        int start,End;
        String []name = new String[4];
        
            name = str.split(" ");

        Person people = new Person(name[0],name[1],name[2], name[3]);
        return people;
    }
    public LinkedList<Person> Get_Children(String str,Person dad)
    {
         LinkedList<String>Descendants = new  LinkedList();
         Person p = family.Search(dad);
         if(p != null)
         {
             dad.setLevel(p.getLevel());
             p.set_Partner(dad.Partner);
            p.SetDay(dad.day_st,dad.day_end);
         }
         for (String retval : str.split(" ")) 
         {
         Descendants.add(retval);
            }
           LinkedList<Person>Desc = new  LinkedList();
           if(Descendants.size() % 4 != 0)
           {
               throw new RuntimeException("Error Get_Children");
           }
           else
           {
               int i = 0;
               while(i != Descendants.size())
               {
                   //int st = Integer.parseInt(Descendants.get(i+2));
                   //int end = Integer.parseInt(Descendants.get(i+3));
                   Person tmp = new Person(Descendants.get(i),Descendants.get(i+1), Descendants.get(i+2),Descendants.get(i+3));
                   tmp.setLevel(dad.getLevel() + 1);
                   tmp.set_Dad(dad);
                   Desc.add(tmp);
                   i +=4;
               }
           }
           dad.size_ch=Desc.size();
           if(p != null)
           {
               p.size_ch = Desc.size();
           }
         return Desc;
    }
        
}
    