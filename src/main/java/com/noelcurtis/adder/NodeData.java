package com.noelcurtis.adder;

/**
 * User: noelcurtis
 * Date: 3/16/12
 * Time: 10:29 AM
 */
public class NodeData {

    private int sumAtNode;
    private int number;
    private int positionInList;
    private int levelInTree;

    public NodeData(int number, int sumAtNode, int positionInList, int levelInTree){
        this.sumAtNode = sumAtNode;
        this.number = number;
        this.positionInList = positionInList;
        this.levelInTree = levelInTree;
    }

    public int getSumAtNode() {
        return sumAtNode;
    }

    public void setSumAtNode(int sumAtNode) {
        this.sumAtNode = sumAtNode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPositionInList() {
        return positionInList;
    }

    public void setPositionInList(int positionInList) {
        this.positionInList = positionInList;
    }

    public int getLevelInTree() {
        return levelInTree;
    }

    public void setLevelInTree(int levelInTree) {
        this.levelInTree = levelInTree;
    }

    public String toString(){
//        return "Number: "+ this.number + " Sum: " + this.sumAtNode + " Position: "+ this.positionInList;
//        return Integer.toString(this.number);
        return Integer.toString(this.number) +":"+ Integer.toString(this.sumAtNode);
    }
}
