/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import  java.util.ArrayList;

/**
 *
 * @author Куддус
 */
public class Person {
    public String name;
    public String surname;
    public String name_dad;
    public String Start;
    public String End;
    public String day_st;
    public String day_end;
    public Person dad;
    public Person Partner;
    public int size_ch;
    public int level;
    public Person(String N,String S,String start,String end)
    {
        name = N;
        surname = S;
        Start = start;
        End = end;
    }
    public void set_Partner(Person part)
    {
        Partner = part;
    }
    public void set_Dad(Person Des)
    {
        dad = Des;
    }
    public Person get_Dad()
    {
        return dad;
    }
    public String Get_name()
    {
        return (name +" " + surname + '\n'+ "(" + Start + "-"+ End+ ")");
    }
    public String Get_nameP()
    {
        return (name.charAt(0) +" " + surname.charAt(0) +"(" + Start + "-"+ End+ ")");
    }
    public String Get_namePartner()
    {
        return Partner.Get_name();
    }
    public boolean equals(Object obj)
    {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if(!(obj instanceof Person))
		return false;
        Person j = (Person) obj;
        if(j.Start.equals(Start)) 
        {
            if(j.name.equals(name))
            {
                if(j.End.equals(End))
                {
            return true;
                }
            }
        }
            return false;
        
    }
    public int hashCode()
    {
        return (End.hashCode() * name.hashCode());
    }
    public String toString()
    {
        StringBuilder build = new StringBuilder();
        build.append("Name: ").append(name).append(" ").append(surname).append('\n');
        build.append(Start).append(" - ").append(End).append('\n');
        return build.toString();
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int i)
    {
        level = i;
    }
    public void SetDay(String st,String End)
    {
        day_st = st;
        day_end = End; 
    }
}
