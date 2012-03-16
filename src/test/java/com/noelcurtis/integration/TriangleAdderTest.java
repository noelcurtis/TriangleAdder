package com.noelcurtis.integration;

import com.noelcurtis.tree.Node;
import com.noelcurtis.tree.Tree;
import org.junit.Assert;
import org.junit.Test;
import com.noelcurtis.adder.TriangleAdder;

import java.util.AbstractMap;
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
    public void simpleEntity(){
        AbstractMap.SimpleEntry<Integer, Integer> newNode  = new AbstractMap.SimpleEntry(0, 0);
        System.out.print(newNode);
    }

    @Test
    public void testBuildTree(){
        try{
        List<List<String>> numberLists = TriangleAdder.getInstance().parseFile("data/test1.txt");
        Tree<Integer> newTree = TriangleAdder.getInstance().buildTree(numberLists);
        System.out.println(newTree.toString());
        }catch (Exception ex){
            Assert.fail(ex.toString());
        }
    }

    @Test
    public void testBuildLargeTree(){
        try{
            List<List<String>> numberLists = TriangleAdder.getInstance().parseFile("data/test2.txt");
            Tree<Integer> newTree = TriangleAdder.getInstance().buildTree(numberLists);
        }catch (Exception ex){
            Assert.fail(ex.toString());
        }
    }
}
