package com.cotyledon.expression.BaseExpression;

public class LikeBooleanExpression extends CompareExpression {
    @Override
    public boolean excute(String value) {
        return value.contains(this.compareValue);
    }
}
