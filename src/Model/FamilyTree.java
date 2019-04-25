/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.HashMap;
/**
 *
 * @author Куддус
 */
public class FamilyTree {
 public HashMap<Person,LinkedList<Person>> map;
 private Person start;
 
 
 public FamilyTree()
 {
    map = new HashMap();    
 }
 public void add(Person Dad,LinkedList<Person> people)
 {
     if(map.size() == 0)
     {
         start = Dad;
         start.setLevel(1);
     }
     map.put(Dad, people);
 }
 public int size()
 {
     return map.size();
 }
 public Person GetStart()
 {
     return start;
 }
 public Person Search(Person tmp)
 {
     if(start == null)
     return null;    
     LinkedList<Person> ser ;
     ArrayDeque<Person>  Queue=  new ArrayDeque();
     Queue.add(start);
     while(!Queue.isEmpty()){
     ser = map.get(Queue.pollFirst());
     if(ser != null)
     {
         for(int i = 0;i < ser.size();i++)
         {
             if(tmp.equals(ser.get(i)))
                 return ser.get(i);
             else
             Queue.addLast(ser.get(i));
         }
     }
 }
     return null;
}
}