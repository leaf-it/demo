package com.cotyledon.expression.BaseExpression;

public class IsBooleanExpression extends CompareExpression {

    @Override
    public boolean excute(String value) {
        return compareValue.equals(value);
    }

}
