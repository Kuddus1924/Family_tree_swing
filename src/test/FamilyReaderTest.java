/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Model.Person;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Model.Person;
import io.FamilyReader;

/**
 *
 * @author Куддус
 */
public class FamilyReaderTest extends Assert{
    @Test
    public void testGet_Person()
    {
        Person p = new Person("Kuddus","Abdulzhamilov","1997","2070");
        p.SetDay("10.04", "10.04");
        Person test = FamilyReader.Get_Person("Kuddus AbDulzhamilov 10 04 1997 10 04 1997");
        assertEquals();
    }
}
