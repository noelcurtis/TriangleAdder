package com.noelcurtis.adder;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
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
    private List<List<String>> numberLists;
    private long largestSum;

    /**
     * Use to parse a file in the format
     * 5
     * 9  6
     * 4  6  8
     * 0  7  1   5
     * @param fileName : name of file to parse
     * @return : List of numbers
     * @throws Exception
     */
    public List<List<String>> parseFile(String fileName)throws Exception{

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
        this.numberLists = numberLists;
        return numberLists;
    }

    /**
     * Use to find the largest sum from Top to Bottom in the triangle of numbers.
     * @return
     */
    public Long findLargestSum(){
        this.largestSum = 0;
        this.findLargestSum(new NodeData(Long.parseLong(this.numberLists.get(0).get(0)), Long.parseLong(this.numberLists.get(0).get(0)), 0, 0));
        return this.largestSum;
    }

    private void findLargestSum(NodeData node){
        if(node.getLevelInTree() < this.numberLists.size() - 1){
            // create new nodes if there is numbers in the list
            int currentDepth = node.getLevelInTree();
            int currentPosition = node.getPositionInList();
            long numberForChild1 = Long.parseLong(this.numberLists.get(currentDepth + 1).get(currentPosition));
            long numberForChild2 = Long.parseLong(this.numberLists.get(currentDepth + 1).get(currentPosition + 1));
            NodeData child1 = new NodeData(numberForChild1, node.getSumAtNode() + numberForChild1, currentPosition, currentDepth + 1);
            NodeData child2 = new NodeData(numberForChild2, node.getSumAtNode() + numberForChild2, currentPosition +1, currentDepth + 1);
            findLargestSum(child1);
            findLargestSum(child2);
        }else{
            if(node.getSumAtNode() > this.largestSum){
                this.largestSum = node.getSumAtNode();
                System.out.println(this.largestSum);
            }
        }
    }

}
