package com.cotyledon.expression.relation;

import com.cotyledon.expression.BaseExpression.CompareExpression;

import java.util.Set;
import java.util.function.BiFunction;

//其含有同一级别的关系
public class ExpressionRelation {
    public final static String OR = "or";
    public final static String AND = "and";
    private CompareExpression compareExpression;
    private String relationFlag;

    public CompareExpression getCompareExpression() {
        return compareExpression;
    }

    public void setCompareExpression(CompareExpression compareExpression) {
        this.compareExpression = compareExpression;
    }

    public String getRelationFlag() {
        return relationFlag;
    }

    public void setRelationFlag(String relationFlag) {
        this.relationFlag = relationFlag;
    }

}
