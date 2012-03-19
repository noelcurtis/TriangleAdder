package com.noelcurtis.adder;

/**
 * User: noelcurtis
 * Date: 3/16/12
 * Time: 10:29 AM
 */
public class NodeData {

    private long sumAtNode;
    private long number;
    private int positionInList;
    private int levelInTree;

    public NodeData(long number, long sumAtNode, int positionInList, int levelInTree){
        this.sumAtNode = sumAtNode;
        this.number = number;
        this.positionInList = positionInList;
        this.levelInTree = levelInTree;
    }

    public long getSumAtNode() {
        return sumAtNode;
    }

    public void setSumAtNode(Long sumAtNode) {
        this.sumAtNode = sumAtNode;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
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
        return Long.toString(this.number) +":"+ Long.toString(this.sumAtNode);
    }
}
