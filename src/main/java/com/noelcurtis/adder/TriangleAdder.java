package com.noelcurtis.adder;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import com.noelcurtis.tree.*;

/**
 * Created by IntelliJ IDEA.
 * User: noelcurtis
 * Date: 3/15/12
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TriangleAdder {
    private static TriangleAdder sharedInstance = new TriangleAdder();

    
    public static TriangleAdder getInstance() {
        return sharedInstance;
    }

    private TriangleAdder() {
    }
    
    public int getLargestSumForTriangle(String fileName){
        // parse the file
        // build the tree
        // get calculate sum on the tree
        return 1;
    }

    /**
     * Use to parse a file in the format
     * 5
     * 9  6
     * 4   6  8
     * 0   7  1   5
     * @param fileName : name of file to parse
     * @return : List of numbers
     * @throws Exception
     */
    public List<List<String>> parseFile(String fileName)throws Exception{
        try{
            List<List<String>> numberLists = new ArrayList<List<String>>();

            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(fileName);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                String[] lineSplit = strLine.split(" ");
                List<String> numbers = Arrays.asList(lineSplit);
                numberLists.add(numbers);
            }
            //Close the input stream
            in.close();
            return numberLists;
        }catch (Exception ex){
            throw ex;
        }
    }

    public Tree buildTree(List<List<String>> numberLists)throws Exception{
        try{
            Tree<Integer> newTree = new Tree<Integer>();
            Node<Integer> rootNode = new Node<Integer>();
            // Create a root node
            rootNode.setData(Integer.parseInt(numberLists.get(0).get(0)));
            newTree.setRootElement(rootNode);
            // Create a list to keep track of any new nodes created
            List<AbstractMap.SimpleEntry<Node<Integer>, Integer>> newNodes = new ArrayList<AbstractMap.SimpleEntry<Node<Integer>, Integer>>();
            AbstractMap.SimpleEntry<Node<Integer>, Integer> newNode  = new AbstractMap.SimpleEntry(rootNode, 0);
            newNodes.add(newNode);
            for(int i=1; i< numberLists.size(); i++){
                System.out.println(i);
                List<AbstractMap.SimpleEntry<Node<Integer>, Integer>> createdNodes = new ArrayList<AbstractMap.SimpleEntry<Node<Integer>, Integer>>();
                for(AbstractMap.SimpleEntry<Node<Integer>, Integer> currentNode : newNodes){
                    Node<Integer> node = currentNode.getKey();
                    int nodePosition = currentNode.getValue();

                    Node<Integer> childNode1 = new Node<Integer>(Integer.parseInt(numberLists.get(i).get(nodePosition)));
                    Node<Integer> childNode2 = new Node<Integer>(Integer.parseInt(numberLists.get(i).get(nodePosition+1)));
                    node.addChild(childNode1);
                    node.addChild(childNode2);
                    createdNodes.add(new AbstractMap.SimpleEntry(childNode1, nodePosition));
                    createdNodes.add(new AbstractMap.SimpleEntry(childNode2, nodePosition+1));
                }
                newNodes = createdNodes;
            }
            return newTree;
        }catch (Exception ex){
            throw ex;
        }
    }
}
