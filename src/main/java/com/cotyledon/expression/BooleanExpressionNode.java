package com.cotyledon.expression;

import com.cotyledon.JsonUtil;

import java.util.List;
import java.util.function.BiFunction;

public class BooleanExpressionNode {
    private String nextOperator;
    private BooleanExpressionNode nextBooleanExpressionNode;
    private BooleanExpression currentBooleanExpression;
    private static Boolean currentRst ;
    public BooleanExpressionNode(){}
    public BooleanExpressionNode(String nextOperator, BooleanExpressionNode nextBooleanExpressionNode, BooleanExpression currentBooleanExpression) {
        this.nextOperator = nextOperator;
        this.nextBooleanExpressionNode = nextBooleanExpressionNode;
        this.currentBooleanExpression = currentBooleanExpression;
    }

    public String getNextOperator() {
        return nextOperator;
    }

    public void setNextOperator(String nextOperator) {
        this.nextOperator = nextOperator;
    }
    public  Boolean  execute (){
        if(this.currentBooleanExpression!=null){
            currentRst = currentBooleanExpression.execute();
        }
        if(this.nextBooleanExpressionNode!=null) {
            currentRst = dealRalation(this.nextOperator, currentRst, nextBooleanExpressionNode.execute());
        }
        return  currentRst;
    }
    private  Boolean dealRalation(String operator,Boolean curRst,Boolean nextRst){
        switch (operator){
           case ExpressionConstants.AND : return  Boolean.logicalAnd(curRst==null?Boolean.TRUE:curRst,nextRst);
           case ExpressionConstants.OR:return Boolean.logicalOr(curRst==null?Boolean.FALSE:curRst,nextRst);
           default:return curRst;
        }
    }

    public BooleanExpressionNode getNextBooleanExpressionNode() {
        return nextBooleanExpressionNode;
    }

    public void setNextBooleanExpressionNode(BooleanExpressionNode nextBooleanExpressionNode) {
        this.nextBooleanExpressionNode = nextBooleanExpressionNode;
    }

    public BooleanExpression getCurrentBooleanExpression() {
        return currentBooleanExpression;
    }

    public void setCurrentBooleanExpression(BooleanExpression currentBooleanExpression) {
        this.currentBooleanExpression = currentBooleanExpression;
    }

    public static Boolean getCurrentRst() {
        return currentRst;
    }

    public static void setCurrentRst(Boolean currentRst) {
        BooleanExpressionNode.currentRst = currentRst;
    }



}

