package com.cotyledon.expression.test;

import com.cotyledon.JsonUtil;
import com.cotyledon.expression.BooleanExpression;
import com.cotyledon.expression.BooleanExpressionNode;
import com.cotyledon.expression.ExpressionConstants;

public class BooleanExpressionNodeTest {
    public static void main(String [] args){
        BooleanExpression isExpression = new BooleanExpression("11","211",BooleanExpression.IS);
        BooleanExpression likeExpression = new BooleanExpression("11","211",BooleanExpression.LIKE);
        //第一层
        BooleanExpressionNode firstBooleanExpressionNode = new BooleanExpressionNode();
        firstBooleanExpressionNode.setCurrentBooleanExpression(likeExpression);
        //第二层
        BooleanExpressionNode secondExpressionNode = new BooleanExpressionNode();
        secondExpressionNode.setCurrentBooleanExpression(isExpression);
        secondExpressionNode.setNextOperator(ExpressionConstants.AND);
        secondExpressionNode.setNextBooleanExpressionNode(firstBooleanExpressionNode);
        //第三层
        BooleanExpressionNode thirdBooleanExpressionNode = new BooleanExpressionNode();
        thirdBooleanExpressionNode.setCurrentBooleanExpression(likeExpression);
        thirdBooleanExpressionNode.setNextBooleanExpressionNode(secondExpressionNode);
        thirdBooleanExpressionNode.setNextOperator(ExpressionConstants.OR);

        //第四层
        BooleanExpressionNode forthBooleanExpressionNode = new BooleanExpressionNode();
        forthBooleanExpressionNode.setCurrentBooleanExpression(likeExpression);
        forthBooleanExpressionNode.setNextBooleanExpressionNode(thirdBooleanExpressionNode);
        forthBooleanExpressionNode.setNextOperator(ExpressionConstants.OR);
        //第五层
        BooleanExpressionNode fivthBooleanExpressionNode = new BooleanExpressionNode();
//        fivthBooleanExpressionNode.setCurrentBooleanExpression(likeExpression);
        fivthBooleanExpressionNode.setNextBooleanExpressionNode(forthBooleanExpressionNode);
        fivthBooleanExpressionNode.setNextOperator(ExpressionConstants.OR);



        System.out.println(fivthBooleanExpressionNode.execute());
        String testString = null;
        try {
            testString = JsonUtil.ToJson(fivthBooleanExpressionNode);
            System.out.println(JsonUtil.ToJson(fivthBooleanExpressionNode));
        } catch (JsonUtil.JsonException e) {
            e.printStackTrace();
        }
        try {
            BooleanExpressionNode testNode = JsonUtil.FromJson(testString,BooleanExpressionNode.class);
            System.out.println(testNode.execute());
        } catch (JsonUtil.JsonException e) {
            e.printStackTrace();
        }
    }
}
