package com.noelcurtis.integration;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import com.noelcurtis.adder.TriangleAdder;
import java.util.List;

/**
 * User: noelcurtis
 * Date: 3/16/12
 * Time: 8:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class TriangleAdderTest {

    @Test
    public void testParseFile(){
        try{
            List<List<String>> numberLists = TriangleAdder.getInstance().parseFile("data/test1.txt");
            assert numberLists.size() == 4;
        }catch (Exception ex){
            Assert.fail(ex.toString());
        }
    }

    @Test
    public void testParseLargerFile(){
        try{
            List<List<String>> numberLists = TriangleAdder.getInstance().parseFile("data/test2.txt");
            assert numberLists.size() == 100;
        }catch (Exception ex){
            Assert.fail(ex.toString());
        }
    }

    @Test
    public void testFindLargestSum(){
        try{
            TriangleAdder.getInstance().parseFile("data/test1.txt");
            assert TriangleAdder.getInstance().findLargestSum() == 27;
        }catch (Exception ex){
            Assert.fail(ex.toString());
        }
    }

    @Ignore
    @Test
    public void testFindLargestSumLargerInput(){
        try{
            TriangleAdder.getInstance().parseFile("data/test2.txt");
            System.out.println(TriangleAdder.getInstance().findLargestSum());
        }catch (Exception ex){
            Assert.fail(ex.toString());
        }
    }
}
