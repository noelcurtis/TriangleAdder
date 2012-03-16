package com.noelcurtis.adder;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import com.noelcurtis.tree.*;

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
    private int largestSum;

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

    public Tree buildTree(List<List<String>> numberLists){
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

    }

    public int getLargestSum(){
        this.largestSum = 0;
        this.findLargestSum(new NodeData(Integer.parseInt(this.numberLists.get(0).get(0)), Integer.parseInt(this.numberLists.get(0).get(0)), 0, 0));
        return this.largestSum;
    }

    private void findLargestSum(NodeData node){
        if(node.getLevelInTree() < this.numberLists.size() - 1){
            // create new nodes if there is jams in the list
            int currentDepth = node.getLevelInTree();
            int currentPosition = node.getPositionInList();
            int currentNumber = node.getNumber();
            int numberForChild1 = Integer.parseInt(this.numberLists.get(currentDepth + 1).get(currentPosition));
            int numberForChild2 = Integer.parseInt(this.numberLists.get(currentDepth + 1).get(currentPosition + 1));
            NodeData child1 = new NodeData(numberForChild1, node.getSumAtNode() + numberForChild1, currentPosition, currentDepth + 1);
            NodeData child2 = new NodeData(numberForChild2, node.getSumAtNode() + numberForChild2, currentPosition +1, currentDepth + 1);
            findLargestSum(child1);
            findLargestSum(child2);
        }else{
            if(node.getSumAtNode() > this.largestSum){
                this.largestSum = node.getSumAtNode();
            }
        }
    }

    public Tree<NodeData> createTree(){
        this.largestSum = 0;
        Tree<NodeData> newTree = new Tree<NodeData>();
        Node<NodeData> rootNode = new Node<NodeData>();
        rootNode.setData(new NodeData(Integer.parseInt(this.numberLists.get(0).get(0)), Integer.parseInt(this.numberLists.get(0).get(0)), 0, 0));
        newTree.setRootElement(rootNode);

        this.createTree(rootNode);
        return newTree;
    }

    private void createTree(Node<NodeData> node){
        if(node.getData().getLevelInTree() < this.numberLists.size() - 1){
            // create new nodes if there is jams in the list
            int currentDepth = node.getData().getLevelInTree();
            int currentPosition = node.getData().getPositionInList();
            int currentNumber = node.getData().getNumber();
            int numberForChild1 = Integer.parseInt(this.numberLists.get(currentDepth + 1).get(currentPosition));
            int numberForChild2 = Integer.parseInt(this.numberLists.get(currentDepth + 1).get(currentPosition + 1));
            Node<NodeData> child1 = new Node<NodeData>(new NodeData(numberForChild1, node.getData().getSumAtNode() + numberForChild1, currentPosition, currentDepth + 1));
            Node<NodeData> child2 = new Node<NodeData>(new NodeData(numberForChild2, node.getData().getSumAtNode() + numberForChild2, currentPosition +1, currentDepth + 1));
            node.addChild(child1);
            node.addChild(child2);
            createTree(child1);
            createTree(child2);
        }else{
            if(node.getData().getSumAtNode() > this.largestSum){
                this.largestSum = node.getData().getSumAtNode();
                System.out.println(this.largestSum);
            }
        }
    }



}
